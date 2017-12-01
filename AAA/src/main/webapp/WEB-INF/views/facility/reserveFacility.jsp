<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Viral | Pages | Sidebar Left</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">

<!-- CSS FILES -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css"
	media="screen" data-name="skins">
<link rel="stylesheet" href="/resources/css/layout/wide.css"
	data-name="layout">

<link rel="stylesheet" type="text/css"
	href="/resources/css/switcher.css" media="screen" />
</head>

<style type="text/css">
#f_time {
	font-weight: bold;
	margin-right: 10px;
	float: left;
}

.row ul li {
	list-style: none;
}

#f_date p {
	font-size: 13px;
}
</style>

</head>
<body id="top">

	<div class="wrapper row2 bgded"
		style="background-image: url('/resources/images/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">

				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">Sidebar Left</a></li>
				</ul>

			</div>
		</div>
	</div>

	<!-- ################################################################################################ -->

	<div class="wrapper row3">
		<main class="container clear">
		<div class="sidebar one_quarter first">

			<!-- 시설 -->
			<h6>시설예약</h6>
			<nav id="f_list">
				<ul>
					<c:forEach var="facility" items="${facilityList }">
						<li><a href="#" class="f_normal" value="${facility.f_id }">${facility.f_name }</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>


		<div class="row">

			<div class="col-lg-3">
				<div id="f_date"></div>
			</div>

			<div class="col-lg-3">
				<div>
					<div id="f_time"></div>
					<div id="f_spot"></div>
				</div>
			</div>

			<div class="col-lg-3">
				<div id="f_reserve"></div>
			</div>

		</div>
	</div>

	<!-- ################################################################################################ -->

	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
	<script src="/resources/layout/scripts/facility/reserveFacility.js"></script>


</body>
</html>