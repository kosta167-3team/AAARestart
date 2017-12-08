<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<script type="text/javascript"
	src="http://map.vworld.kr/jquery/jquery-1.7.1.min.js"></script>

</head>

<body>
	<h1>테스트</h1>

<script type="text/javascript">
var i = 0;
$(function() {
	console.log('테스트');

	$.ajax({
		type : 'get',
		url : '/aptData/rest/dong_list',
		dataType : "json",
		async : false,
		success : function(data) {
			console.log(data);
			$(data).each(function(index, item) {
				$.ajax({
					type : 'get',
					url : '/aptData/rest/aptlist/' + item,
					dataType : "json",
					async : false,
					success : function(data) {
						$(data).each(function(index, item) {
							console.log(item);
							detailApt(item);
						});
					}
				});
			chanegeXY();
			});
		}
	});
});

		//location.href = "/aptData/changeXY";
		/* $.getJSON('/aptData/rest/dong_list', function(data) {

		console.log(data);
		$(data).each(function(index, item) {

			$.getJSON('/aptData/rest/aptlist/' + item, function(data) {
				$(data).each(function(index, item) {
					console.log(item);
					detailApt(item);
				});
				//location.href = "/aptData/changeXY";
			});
		});
		});  */

function detailApt(data) {
	var kaptCode = data.kaptCode;
	var kaptName = data.kaptName;

	console.log((++i) + " : " + kaptCode + " , " + kaptName);

	$.ajax({
		type : 'post',
		url : '/aptData/rest/aptdetail',
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		async : false,
		data : JSON.stringify({
			kaptCode : kaptCode,
			kaptName : kaptName
		}),
		success : function() {
			//location.href = "/aptData/changeXY";
		}
	})
};

function chanegeXY(){
	alert('위도경도바꾸기');
	location.href = "/aptData/changeXY";
}
	</script>
</body>
<a href="/aptData/changeXY">좌표변환 ~</a>
</html>

