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

	<div id="popup">
		<h4>가입이 완료되었습니다.</h4>
		<br>
		<br>
		<button id="write">피드로 가기</button>
		<button id="main">메인으로 가기</button>

	</div>

	<script type="text/javascript">
		$(function() {

			$('#write').on("click", function() {
				opener.document.location.href="/comm/checkFeed";
				window.close();
			});

			$('#main').on("click", function() {
				opener.document.location.href="/";
				window.close();
			});

		});
	</script>
</body>
</html>