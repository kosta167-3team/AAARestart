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

<!-- 1.������id 2.cb_no �ޱ� -->

<!-- ����; 1.������id 2.contents 3.�߽���-->
<!-- ����; 1.�۹�ȣ 2.������ȣ(maxNum)  -->

<!-- �� 5���� �ѱ�� -->

	<div id="popup">
	 
		<button id="send">������</button>
		<button id="cancel">���</button>

	</div>

	<script type="text/javascript">
	
		$(function() {

			$('#send').on("click", function() {
			 
				$.ajax({
						url:"/comm/ddddddd", //���� insert / ���� insert
						success: function() {
							
							alert("����");
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