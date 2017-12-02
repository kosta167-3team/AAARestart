<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- 달력 위젯 jquery -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
	
<!-- <script src="/resources/layout/scripts/facility/manageFacility.js"></script> -->	
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="/resources/layout/scripts/date.js"></script>

<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">


</head>
<body id="top">

	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">Full Width</a></li>
				</ul>
				<!-- ################################################################################################ -->
			</div>
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row3">
		<main class="container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<div class="content">
			<h1>시설 상태</h1>
			<div class="scrollable">
				<table>
					<thead>
						<tr>
							<c:forEach var="facilityList" items="${facilityList}">
								<th>${facilityList.f_name }</th>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="facilityList" items="${facilityList}">
								<td>${facilityList.f_state }</td>
							</c:forEach>
					</tbody>
				</table>
			</div>


			<div id="comments">
				<label for="url">&nbsp;</label> 
				<label for="url">&nbsp;</label>  
				<h2>시설 관리</h2>
				<form action="#" method="post">

					<div class="one_third first">
						<label for="f_name">시설 <span>*</span></label> 
							<select id="f_id" name="f_id" style="width:300px;height:40px;">
							<c:forEach var="facilityList" items="${facilityList}">
								<option value="${facilityList.f_id }">${facilityList.f_name }</option>
							</c:forEach>
						</select>

					</div>
					<div class="one_third">
						<label for="fs_start">기간 <span>*</span></label> <input type="text"
							id="fs_start" name="fs_start" size="22">
					</div>
					<div class="one_third">
						<label for="url">&nbsp;</label> <input type="text" id="fs_end"
							name="fs_end" size="22">
					</div>
					<div class="block clear">
						<label for="comment">사유 <span>*</span></label>
						<textarea name="fs_reason" id="fs_reason" cols="25" rows="10"></textarea>
					</div>
					<div>
						<input name="submit" type="submit" value="확인" id="submit" />
						&nbsp; <input name="reset" type="reset" value="내용 지우기">
					</div>
				</form>
			</div>

  			<script type="text/javascript">
					$("#fs_start").datepicker({
						showButtonPanel : false,
						dateFormat : "yy-mm-dd",
						altField : '#fs_start'
					});
					
					$("#fs_end").datepicker({
						dateFormat : "yy-mm-dd",
						altField : '#fs_end'
					});
				
				$('#submit').on("click", function() {

					event.preventDefault();
			
					var popupX = (window.screen.width/2) - (400/2);
					var popupY= (window.screen.height/2) - (400/2);
					
					window.open('/facility/changePopup','childWindow', 'status=no, height=200, width=400, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
		});
								
			</script>
 
		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>

	<!-- ################################################################################################ -->
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<!-- 	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script> -->
</body>
</html>