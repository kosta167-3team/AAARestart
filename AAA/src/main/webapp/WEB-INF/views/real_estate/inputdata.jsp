<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="http://map.vworld.kr/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'get',
		url:'/real_estate/getApi',
		dataType:'text',
		async: false,
		success:function(data){
			if(data == 'Success'){
				alert('데이터 입력 완료');
				
			location.href="/";
			}
			
		}
	})
})
</script>

</head>

<body>



</body>

</html>

