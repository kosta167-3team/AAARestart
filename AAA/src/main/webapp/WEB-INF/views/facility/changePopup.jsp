<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<style type="text/css">
#popup {
	text-align: center;
}
</style>
<!-- <script src="/resources/layout/scripts/facility/changePopup.js"></script> -->
<script src="/resources/layout/scripts/facility/date.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>


  	<script type="text/javascript">
		$(function() {

			var fs_start = opener.$('#fs_start').val();
			var fs_end = opener.$('#fs_end').val();
			var fs_name = opener.$('#f_id option:selected').text();
			var fs_date = fs_start + '부터 ' + fs_end + '까지 이용 불가 ';

			document.getElementById('fs_date').innerHTML = fs_date;
			document.getElementById('f_name').innerHTML = fs_name;

		});
	</script>  

	<div id="popup">

		<!-- <p>-시설 상태 변경-</p> -->
		<p id="f_name"></p>
		<p id="fs_date"></p>

		<h4>기간 내 예약을 취소하고 쪽지를 보냅니다.</h4>
		<button id="submit">확인</button>
		<button id="cancel">취소</button>
	</div>


 	<script type="text/javascript">
		$('#cancel').on("click", function() {
			window.close();
		});

		$('#submit').on("click", function() {

			var s_string = opener.$('#fs_start').val();
			var e_string = opener.$('#fs_end').val(); 		
			
			var fs_start = Date.parse(s_string).getTime();
			var fs_end = Date.parse(e_string).getTime();
 

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

					//쪽지 
					//취소 건
					var cancel_cnt = data.cancel_cnt;

					html = '<p>' + cancel_cnt + '건의 예약을 취소하고 쪽지를 전송했습니다.</p>';
					html += '<button id="confirm">확인</button>'

					$('#popup').children().remove();
					$('#popup').append(html);

				}

			});

		});

		$('#popup').on("click", '#confirm', function() {
			opener.location.href="/facility/manageFacility";
			window.close();
		});
	</script>  

</body>
</html>