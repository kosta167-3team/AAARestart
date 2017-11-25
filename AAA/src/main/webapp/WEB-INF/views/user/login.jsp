
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>
<%
	String loginCk = (String)session.getAttribute("error");
%>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="/resources/layout/styles/login/login.css" rel="stylesheet" >
<script src="/resources/layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="/resources/layout/scripts/login/login.js"></script>
</head>
<script type="text/javascript">
$(function () {
	var str = "<%=loginCk%>";
	
	console.log(str);
	if(str == "fail"){
		
		 $("#output").removeClass(' alert alert-success');
         $("#output").addClass("alert alert-danger animated fadeInUp").html("아이디나 비밀번호를 확인해주세요.");
         
	}
	if(str != null){
	}
})
</script>
<body>

	<div class="container">
	<div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
                <form id="loginForm" method="post">
                    <input name="urd" type="text" placeholder="username">
                    <input type="password" name="upw" placeholder="password">
                    <button class="btn btn-info btn-block login" type="submit">Login</button>
                </form>
            </div>
        </div>
 
</div>


</body>

</html>

