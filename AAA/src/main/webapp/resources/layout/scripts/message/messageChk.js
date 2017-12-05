$(function () {
	var id = $('[ name="user_id"]').val();
	 $('[data-toggle="popover"]').popover()
	 $('table').on('popover','[data-toggle="popover"]',function(){})
	 $('#messageListmodal').on('click','a',function(){
		// alert('ddd');
		 $(this).popover('show');
	 })
	msgcnt(id);
	
	 var r_authority = $('.type_select').attr('href');
	console.log(r_authority);
	 //메세지 목록 조회
	 $('#msg').on('click', function() {
		 var cri= '?page=1&keyword=null&searchType=null';
		 recieveList(id,cri,r_authority);
	 })
	 
	$('tbody').on('click','a',function(event){
		var msg_target = $(this).parent().prevAll('[name="msg_id"]');
		update_ck(id,msg_target);
	})
	
	$('table').on('click','.send_btn',function(){
		var sender = $(this).parent().prevAll('[name="receiver"]').val();
		$('#messageModal').find('.sender').text(sender);
		$('#messageModal').find('[name="sender"]').val(sender);
		console.log(sender);
		
		var receiver = $(this).parent().parent().find('[name="sender"]').attr('value');
		$('#messageModal').find('.receiver').text(receiver);
		$('#messageModal').find('[name="receiver"]').val(receiver);
		console.log(receiver);
		
		$('#messageForm').find('[name="type_id"]').val(6);
	})
	$('.pagination').on('click','li a', function(event){
		event.preventDefault();
		
		cri = $(this).attr('href');
		
		recieveList(id,cri,r_authority);
	})

	//검색 유형 선택
	$('.search-panel .dropdown-menu').find('a').on('click',function(e) {
		e.preventDefault();
		$(this).parent().parent().find('a').removeClass('selected');
		$(this).addClass('selected');
		var concept = $(this).text();
		
		console.log(concept);
		
		$('.search-panel span#search_concept').text(concept);
	});
	 
	 //검색
	 $('#searchBtn').on('click',function(event){
		 var searchType = 	$('.search-panel .dropdown-menu').find('.selected').attr('href');
		 var keyword = $('#search_param').val();
		 
		 var cri ={
				"keyword":keyword,
				"searchType":searchType
		 }
		 //makeUrl(1,cri);
		 recieveList(id,makeUrl(1,cri),r_authority);
	 });
	 
	 //카테고리 선택
	 $('.sender-group').find('a').on('click',function(e){
		 e.preventDefault();
		$(this).parent().find('a').removeClass('type_select');
		$(this).addClass('type_select');
		var cri =$('.current').find('a').attr('href');
		recieveList(id,cri,$(this).attr('href'));
	 })
});
function update_ck(id,msg_target){
	var msg_id = $(msg_target).val();
	
	console.log(msg_id);
	
	$.ajax({
		type:'put',
		url:'/message/update_ck',
		headers : {
            "Content-Type" : "application/json",
            "X-HTTP-Method-Override" : "PUT"
		},
		data:JSON.stringify({
			msg_id:msg_id
		}),
		success:function(){
			msgcnt(id);
			console.log($(msg_target).nextAll('.read-ck'));
			$(msg_target).nextAll('.read-ck').text('읽음');
		}

	})
}
function msgcnt(id){
	$.ajax({
		type : 'post',
		url : '/message/msgcnt',
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType : 'json',
		data : JSON.stringify({
			r_id : id
		}),
		success:function(data){
			$('#msg').find('.badge').text(data);
		},
		error:function(){
			alert('ddd');
		}
	})
}
function recieveList(id,cri,r_authority){
	
	var target = $('.modal-body').find('tbody');
	$(target).empty();
	console.log(id);
	$.ajax({
		type : 'post',
		url : '/message/receive'+cri,
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType : 'json',
		data : JSON.stringify({
			r_id : id,
			r_authority:r_authority
		}),
		success : function(data) {
			var list = data.list;
			$(list).each(function(index, item){
				var html='<tr>';
				html += '<input type="hidden" name="msg_id" value ="'+item.msg_id+'">';
				html +='<input type="hidden" name="receiver" value ="'+item.receiver+'">';
				html +='<td><input type="checkbox" autocomplete="off" aria-label="..." ></td>';
				if(item.read_check =='N'){					
					html += '<td class="read-ck">안읽음</td>';
				}else{
					html += '<td class="read-ck">읽음</td>';
				}
				//html += '<td class="read-ok">'+item.sender+'</td>';
				if(item.r_authority == '관리소'){
					html += '<td ><a tabindex="0" role="button" data-toggle="popover" data-placement="bottom" data-trigger="focus"';
					html += 'title="from > 관리소" data-content="'+item.msg_content+'">';
					html +='관리소로부터 쪽지가 도착했습니다.'+'</a></td>';
				}else{
					html += '<td>';
					html+='<a tabindex="0" role="button" data-toggle="popover" data-placement="bottom" data-trigger="focus"';
					html += 'title="'+'from > '+item.sender+'" data-content="'+item.msg_content+'">';
					html += '<span name ="sender" value ="'+item.sender+'">[ '+item.sender+' ]</span>님께서 보낸 쪽지입니다.'+'</a>';
					html +='</td>';
					html += '<td>';
					html += '<button type="button" class="btn btn-warning send_btn" data-toggle="modal" data-target="#messageModal">';
					html +='<span class="glyphicon glyphicon-envelope"></span></button>';
					html += '</td>';
				}
				html += '<td>'+item.msg_regdate+'</td>'
				
				html+='</tr>';
				
				$(target).append(html);
				printPaging(data.pageMaker);
			})
		},
		error : function() {
			alert('error');
		}
	})

}
function printPaging(pageMaker,cri){
	var str ="";
	
	console.log(pageMaker);
	var cri = pageMaker.cri;
	
	console.log(cri);
	
	if(pageMaker.prev){
		str+="<li><a href='"+(pageMaker.makeSearch(pageMaker.startPage-1))+"'>&laquo; Previous</a></li>";
	}
	for(var i = pageMaker.startPage, len = pageMaker.endPage; i<=len ; i++){
		var strClass = pageMaker.cri.page == i?'class = current':'';
		var keyword = cri.keyword;
		var searchType = cri.searchType;
		str += "<li "+strClass+"><a href ='"+makeUrl(i,cri)+"'>"+i+"</a></li>";
	}
	
	if(pageMaker.next){
		str += "<li><a href='"+(pageMaker.makeSearch(pageMaker.endPage+1))+"'>Next &raquo;</a></li>";
	}
	
	$('.pagination').html(str);
}

function makeUrl(page,cri){
	var location = "?page="+page+"&keyword="+cri.keyword+"&searchType="+cri.searchType;
	
	console.log(location);
	
	return location;
	
}







