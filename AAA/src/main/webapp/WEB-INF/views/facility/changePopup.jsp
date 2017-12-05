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
			var fs_date = fs_start + '���� ' + fs_end + '���� �̿� �Ұ� ';

			document.getElementById('fs_date').innerHTML = fs_date;
			document.getElementById('f_name').innerHTML = fs_name;

		});
	</script>  

	<div id="popup">

		<!-- <p>-�ü� ���� ����-</p> -->
		<p id="f_name"></p>
		<p id="fs_date"></p>

		<h4>�Ⱓ �� ������ ����ϰ� ������ �����ϴ�.</h4>
		<button id="submit">Ȯ��</button>
		<button id="cancel">���</button>
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

					//���� 
					//��� ��
					var cancel_cnt = data.cancel_cnt;

					html = '<p>' + cancel_cnt + '���� ������ ����ϰ� ������ �����߽��ϴ�.</p>';
					html += '<button id="confirm">Ȯ��</button>'

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