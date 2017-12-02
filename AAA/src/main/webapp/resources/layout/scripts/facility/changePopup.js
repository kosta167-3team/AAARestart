/**
 * 
 */

$(function() {

	var fs_start = opener.$('#fs_start').val();
	var fs_end = opener.$('#fs_end').val();
	var fs_name = opener.$('#f_id option:selected').text();
	var fs_date = fs_start + '부터 ' + fs_end + '까지 이용 불가 ';

	document.getElementById('fs_date').innerHTML = fs_date;
	document.getElementById('f_name').innerHTML = fs_name;




$('#cancel').on("click", function() {
	window.close();
});


$('#submit').on("click", function() {

	var s_string = opener.$('#fs_start').val();
	var e_string = opener.$('#fs_end').val();

	var fs_start = Date.parse(s_string).getTime();
	var fs_end = Date.parse(e_string).getTime();

	alert(s_string);
	alert(fs_start);

	var data = {
		f_id : opener.$('#f_id option:selected').val(),
		fs_start : fs_start,
		fs_end : fs_end,
		fs_reason : opener.$('#fs_reason').val()
	};

	$.ajax({
		datatype : "json",
		contentType : "application/json; charset=utf-8",
		type : "POST",
		url : '/facility/changeState',
		data : JSON.stringify(data),
		success : function(data) {

			var cancel_cnt = data.cancel_cnt;

			html = '<p>' + cancel_cnt + '건의 예약을 취소하고 쪽지를 전송했습니다.</p>';
			html += '<button id="confirm">확인</button>'

			$('#popup').children().remove();
			$('#popup').append(html);

		}

	});

});


$('#popup').on("click", '#confirm', function() {
	window.close();
});

});