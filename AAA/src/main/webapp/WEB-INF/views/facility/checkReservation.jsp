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

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Viral | Pages | Full Width</title>




<style type="text/css">
.scrollable table a {
	text-align: center;
}
</style>

<style type="text/css">
.accordion {
	width: 500px;
	margin: 0 auto;
	margin-bottom: 100px;
}

.accordion-toggle {
	border-bottom: 1px solid #cccccc;
	cursor: pointer;
	margin: 0;
	padding: 10px 0;
	position: relative;
}

.accordion-toggle.active:after {
	content: "";
	position: absolute;
	right: 0;
	top: 17px;
	width: 0;
	height: 0;
	border-bottom: 5px solid #f00;
	border-left: 5px solid rgba(0, 0, 0, 0);
	border-right: 5px solid rgba(0, 0, 0, 0);
}

.accordion-toggle:before {
	content: "";
	position: absolute;
	right: 0;
	top: 17px;
	width: 0;
	height: 0;
	border-top: 5px solid #000;
	border-left: 5px solid rgba(0, 0, 0, 0);
	border-right: 5px solid rgba(0, 0, 0, 0);
}

.accordion-toggle.active:before {
	display: none;
}

.accordion-content {
	display: none;
}

.accordion-toggle.active {
	color: #ff0000;
}
</style>


<!-- <style type="text/css">
@import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css"); 
h1 { font-family:"Nanum Gothic" !important; 
	 font-weight:bold;
}

</style> -->

<script src="/resources/layout/scripts/jquery.min.js"></script>
<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
<script src="/resources/layout/scripts/checkReservation.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body id="top">
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row0">
		<div id="topbar" class="clear">
			<!-- ################################################################################################ -->
			<div class="fl_left">
				<ul class="nospace inline">
					<li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
					<li><i class="fa fa-envelope-o"></i> info@domain.com</li>
				</ul>
			</div>
			<div class="fl_right">
				<ul class="faico clear">
					<li><a class="faicon-facebook" href="#"><i
							class="fa fa-facebook"></i></a></li>
					<li><a class="faicon-pinterest" href="#"><i
							class="fa fa-pinterest"></i></a></li>
					<li><a class="faicon-twitter" href="#"><i
							class="fa fa-twitter"></i></a></li>
					<li><a class="faicon-dribble" href="#"><i
							class="fa fa-dribbble"></i></a></li>
					<li><a class="faicon-linkedin" href="#"><i
							class="fa fa-linkedin"></i></a></li>
					<li><a class="faicon-google-plus" href="#"><i
							class="fa fa-google-plus"></i></a></li>
					<li><a class="faicon-rss" href="#"><i class="fa fa-rss"></i></a></li>
				</ul>
			</div>
			<!-- ################################################################################################ -->
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row1">
		<header id="header" class="clear">
			<!-- ################################################################################################ -->
			<div id="logo" class="fl_left">
				<h1>
					<a href="/"><img src="/resources/images/main/main_log_mini.png"
						alt="" class="main_log_img"></a>
				</h1>
			</div>
			<nav id="mainav" class="fl_right">
				<ul class="clear">
					<li><a href="resourcesindex.html">Home</a></li>
					<li class="active"><a class="drop" href="#">Pages</a>
						<ul>
							<li><a href="gallery.html">Gallery</a></li>
							<li class="active"><a href="full-width.html">Full Width</a></li>
							<li><a href="sidebar-left.html">Sidebar Left</a></li>
							<li><a href="sidebar-right.html">Sidebar Right</a></li>
							<li><a href="basic-grid.html">Basic Grid</a></li>
						</ul></li>
					<li><a class="drop" href="#">Dropdown</a>
						<ul>
							<li><a href="#">Level 2</a></li>
							<li><a class="drop" href="#">Level 2 + Drop</a>
								<ul>
									<li><a href="#">Level 3</a></li>
									<li><a href="#">Level 3</a></li>
								</ul></li>
						</ul></li>
					<li><a href="#">Link Text</a></li>
					<li><a href="#">Link Text</a></li>
				</ul>
			</nav>
			<!-- ################################################################################################ -->
		</header>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->

	<!-- 	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
 -->

	<div class="wrapper row2 bgded">

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
			<!-- ################################################################################################ -->






			<div class="scrollable">
				<div class="accordion">

					<h1>오늘의 예약</h1>
					<c:forEach var="i" items="${latestList}" varStatus="status">
						<c:choose>
							<c:when test="${i==null }">
								<h4 class="accordion-toggle">- 내역이 없습니다 -</h4>
							</c:when>

							<c:when test="${status.index == 0 }">
								<c:forEach var="f" items="${facility }">
									<c:if test="${i.f_id == f.f_id}">
										<c:forEach var="t" items="${timeList}">
											<c:if test="${t.t_id == i.t_id }">

												<h4 class="accordion-toggle">${f.f_name}</h4>
												<div id="now">
													<p>시간: ${t.t_start }~${t.t_end }</p>
													<p>인원: ${i.fr_cnt }명</p>
												</div>

											</c:if>
										</c:forEach>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="f" items="${facility }">
									<c:if test="${i.f_id == f.f_id}">
										<c:forEach var="t" items="${timeList}">
											<c:if test="${t.t_id == i.t_id }">

												<h4 class="accordion-toggle">${f.f_name}</h4>
												<div class="accordion-content">
													<p>시간: ${t.t_start }~${t.t_end }</p>
													<p>인원: ${i.fr_cnt }명</p>
												</div>
											</c:if>
										</c:forEach>
									</c:if>
								</c:forEach>


							</c:otherwise>

						</c:choose>
					</c:forEach>
				</div>



				<h1>주간 예약 내역</h1>
				<div>
					<table>
						<thead>
							<tr>
								<th>시간</th>
								<c:forEach var="dateList" items="${dateList}">
									<th><a>${dateList}</a></th>
								</c:forEach>
							</tr>
						</thead>

						<tbody>

							<c:forEach var="t" items="${timeList }">

								<tr val="${t.t_id}">
									<td>${t.t_start }~${t.t_end }</td>
									<c:forEach var="reservation" items="${reservationList }" >
										<td ><c:forEach var="r" items="${reservation}">
												<c:choose>
													<c:when test="${r.t_id == t.t_id}">
														<c:forEach var="facility" items="${facility }">
															<c:if test="${r.f_id==facility.f_id}">
																<a class="reservation" href="#" val="${r.fr_id}">${facility.f_name}</a>
															</c:if>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<a> &nbsp; </a>
													</c:otherwise>
												</c:choose>
											</c:forEach></td>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<script type="text/javascript">
					$('.reservation').on("click", function() {

										event.preventDefault();

										var fr_id = $(this).attr("val");

										getReservationDetail("/facility/ReservationDetail/"
												+ fr_id);

									});

  

					function getReservationDetail(f_info) {
						
						var popupX = (window.screen.width/2) - (300 / 2);
						var popupY= (window.screen.height/2) - (200 / 2);
						
						window.open(f_info,'childWindow', 'status=no, height=200, width=300, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
					}
				</script>
</body>
</html>