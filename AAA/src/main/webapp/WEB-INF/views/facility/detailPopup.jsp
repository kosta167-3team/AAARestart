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
<!-- <script src="/resources/layout/scripts/facility/detailPopup.js"></script> -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div id="popup">
		<h3>${r_f_name }</h3>
		<p>인원: ${r_fr_cnt}</p>
		<p>시간: ${r_time.t_start} ~ ${r_time.t_end }</p>
		<button id="cancel" value="${fr_id }">예약 취소</button>
		<button id="close">확인</button>
	</div>


  	<script type="text/javascript">
		$("#cancel").on("click", function() {

			var fr_id = $(this).val();

			$.ajax({
				url : "/facility/cancleReservation/" + fr_id,
				success : function(data) {

					html = '<p>' + data + '</p>';
					html += '<button id="close">확인</button>';

					$('#popup').children().remove();
					$('#popup').append(html);

					$(opener.document).find("a[val=" + fr_id + "]").remove();

				}

			});

		});

		$('#close').on("click", function() {
			window.close();
		});

		$('#popup').on("click", '#close', function() {
			window.close();
		});
	</script> 

</body>
</html>