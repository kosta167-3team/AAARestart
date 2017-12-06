$(function() {
	$('#sendMessage').on('click', function(event) {
		alert('dd');
		
		event.preventDefault();
	
		var form = $('#messageForm');
		var sender = $(form).find('[name="sender"]').val();
		var receiver=$(form).find('[name="receiver"]').val();
		
		var type_id= $(form).find('[ name="type_id"]').val();
		var msg_content =$(form).find('[ name="msg_content"]').val();
		
		
		console.log(sender+"," + receiver + "," + msg_content);
		$.ajax({
			type : 'post',
			url : '/message/send',
			headers : {
				"Content-type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			data:JSON.stringify({
				sender:sender,
				receiver:receiver,
				type_id : type_id,
				msg_content : msg_content
			}),
			success:function(){
				
				$('.alert-success').remove();
				
				$('#myAlert').removeClass('hide');
				var html ='<div class="alert alert-success fade in " id="myAlert">';
				html +='<strong>메세지 전송이 완료되었습니다</strong>';
				html += '<button type="button" class="close" data-dismiss="alert"aria-label="Close">';
				html += '<span aria-hidden="true">&times;</span>';
				html += '</button></div>';
				
				$('.container').prepend(html);
				
				$('[ name="msg_content"]').val('');
			},
			error:function(){
				alert('error');
			}	

		})
	
	})
});
$(function() {
	$(".close").click(function() {
		//$("#myAlert").alert("close");
	});
	$("#myAlert").on('close.bs.alert', function() {
	});
});