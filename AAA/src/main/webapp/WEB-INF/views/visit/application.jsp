<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
Template Name: Viral
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->

<html>
<head>
<title>AAA</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body id="top">
<div class="wrapper row2 bgded"
		style="background-image: url('/resources/images/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">방문 신청</a></li>
				</ul>
				<!-- ################################################################################################ -->
			</div>
		</div>
	</div>
	
	<div class="wrapper row3">
		<main class="container clear"> <!-- main body -->
		<div class="sidebar one_quarter first">
			<h6>방문객</h6>
			<nav class="sdb_holder">
				<ul>
					<li><a href="#">방문 신청</a></li>
					<c:if test="${r_id != null}">
										<li><a href="#">신청내역 조회</a></li>
					</c:if>
					
				</ul>
			</nav>
		</div>
		<div class="content three_quarter">
			<div id="comments">
				<h2>방문 신청</h2>
				<form action="/visit/application" method="post">
					<div class="one_third first">
						<label for="name"> 이름 <span>*</span></label> <input type="text"
							name="v_name" id="name" value="" size="15">
					</div>
					<div class="one_third">
						<label for="email"> 연락처 <span>*</span></label> <input type="text"
							name="v_tel" id="tel" value="" size="15">
					</div>
					<div class="one_third">
						<!-- 달력 띄우기 -->
						<label for="url">방문 예정일</label>
						<input type="date" name="v_date" size="15">
					</div>
					<div class="one_third first">
						<!-- 동 -->
						<label for="url">입주민 주소</label> 
						<input type="text" name="dong" placeholder="동을 입력하세요" size="15">
						
					</div>
					<div class="one_third">
						<label for="url">&nbsp;</label> 
						<input type="text" name="ho" placeholder="호수를 입력하세요" size="15">	
					</div>
					<div class="block clear">
						<label for="comment"> 방문 사유 </label>
						<textarea name="v_contents" id="comment" cols="25" rows="10"></textarea>
					</div>
					<div>
						<input name="submit" type="submit" value="신청">
						&nbsp; <input name="reset" type="reset" value="취소">
					</div>
				</form>
			</div>
		</div>
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	
	
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>