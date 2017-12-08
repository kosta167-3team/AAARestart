<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
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

<!-- 1.수신자id 2.cb_no 받기 -->

<!-- 쪽지; 1.수신자id 2.contents 3.발신자-->
<!-- 관심; 1.글번호 2.쪽지번호(maxNum)  -->

<!-- 총 5가지 넘기기 -->

	<div id="popup">
	 
		<button id="send">보내기</button>
		<button id="cancel">취소</button>

	</div>

	<script type="text/javascript">
	
		$(function() {

			$('#send').on("click", function() {
			 
				$.ajax({
						url:"/comm/ddddddd", //쪽지 insert / 관심 insert
						success: function() {
							
							alert("성공");
						}
				})
				
			});

			
			$('#cancel').on("click", function() {
				window.close();
			});

		});
	</script>
</body>
</html> --%>