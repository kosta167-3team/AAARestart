$(function () {
	var id = $('[ name="user_id"]').val();
	 $('[data-toggle="popover"]').popover()
	 $('table').on('popover','[data-toggle="popover"]',function(){})
	 $('#messageListmodal').on('click','a',function(){
		// alert('ddd');
		 $(this).popover('show');
	 })
	msgcnt(id);
	$('tbody').on('click','.read-ok',function(event){
		$.ajax({
			type:'put',
			url:'/message/update_ck',
			headers : {
                "Content-Type" : "application/json",
                "X-HTTP-Method-Override" : "PUT"
			},

		})
	})
});
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
$(function() {
	var id = $('[ name="user_id"]').val();
	var target = $('.modal-body').find('tbody');
	$('#msg').on('click', function() {
		$(target).empty();
		console.log(id);
		$.ajax({
			type : 'post',
			url : '/message/recieve',
			headers : {
				"Content-type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'json',
			data : JSON.stringify({
				r_id : id
			}),
			success : function(data) {
				$(data).each(function(index, item){
					var html='<tr>';
					html
					html +='<td><input type="checkbox" autocomplete="off" aria-label="..." ></td>';
					if(item.read_check =='N'){
						
						html += '<td class="read-no">안읽음</td>';
					}else{
						html += '<td class="read-ok">읽음</td>';
					}
					//html += '<td class="read-ok">'+item.sender+'</td>';
					if(item.r_authority == '관리소'){
						html += '<td ><a tabindex="0" class="read-ok" role="button" data-toggle="popover" data-placement="bottom" data-trigger="focus"';
						html += 'title="from > 관리소" data-content="'+item.msg_content+'">';
						html +='관리소로부터 쪽지가 도착했습니다.'+'</a></td>';
					}else{
						html += '<td>';
						html+='<a tabindex="0" class="read-ok" role="button" data-toggle="popover" data-placement="bottom" data-trigger="focus"';
						html += 'title="'+'from > '+item.sender+'" data-content="'+item.msg_content+'">';
						html += '<span>[ '+item.sender+' ]</span>님께서 보낸 쪽지입니다.'+'</a>';
						html += '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#messageModal">';
						html +='<span class="glyphicon glyphicon-envelope"></span></button>'
						html +='</td>';
					}
					html += '<td>'+item.msg_regdate+'</td>'
			
					html+='</tr>';
					
					$(target).append(html);
				})
			},
			error : function() {
				alert('error');
			}
		})
	})
})