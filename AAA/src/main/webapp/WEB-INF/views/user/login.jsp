
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<link href="/resources/layout/styles/login/login.css" rel="stylesheet" >
<script type="text/javascript" src="/resources/layout/scripts/login/login.js"></script>
</head>
<script type="text/javascript">
	String loginCk  = session.getAttribute("error");
	if(loginCK != null){
		alert('아이디나 비밀번호를 다시 확인해 주세요')
	}
</script>
<body>
	<div class="container">
	<div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
                <form action="/user/loginPost" method="post">
                    <input name="urd" type="text" placeholder="username">
                    <input type="password" name="upw" placeholder="password">
                    <button class="btn btn-info btn-block login" type="submit">Login</button>
                </form>
            </div>
        </div>
 
</div>


</body>

</html>

