$(function() {
	var id = $('[ name="user_id"]').val();
	var target = $('.modal-body').find('tbody');
	$('#msg').on('click', function() {
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
					if(item.read_check =='N'){
						
						html += '<td class="read-no">안읽음</td>';
					}else{
						html += '<td class="read-ok">읽음</td>';
					}
					html += '<td class="read-ok">'+item.sender+'</td>';
					html += '<td class="read-ok">'+item.msg_content+'</td>';
					html += '<td class="read-ok">'+item.msg_regdate+'</td>'
			
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