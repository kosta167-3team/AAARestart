<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>

<!-- <script src="/resources/layout/scripts/facility/checkReservation.js"></script> -->
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


<script src="/resources/layout/scripts/jquery.min.js"></script>
<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script> 
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body id="top">

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
					<c:choose>

						<c:when test="${empty latestList}">
							<p>- 내역이 없습니다 -
							<p>
						</c:when>

						<c:when test="${latestList != null}">
							<c:forEach var="i" items="${latestList}" varStatus="status">
								<c:choose>
									<c:when test="${status.index==0}">
										<c:forEach var="f" items="${facility }">
											<c:if test="${i.f_id == f.f_id}">
												<c:forEach var="t" items="${timeList}">
													<c:if test="${t.t_id == i.t_id }">

														<h4 class="accordion-toggle">${f.f_name}</h4>
														<div id="now">
															<p>시간: ${t.t_start }~${t.t_end }</p>
															<p>인원: ${i.fr_cnt }명</p>
															<img src="/facility/getQRimg/${i.fr_id }">
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

														<h4 class="accordion-toggle" val="${i.fr_id}">${f.f_name}</h4>
														<div class="accordion-content" val="${i.fr_id }">
															<p>시간: ${t.t_start }~${t.t_end }</p>
															<p>인원: ${i.fr_cnt }명</p>
															<button class="cancel" value="${i.fr_id}">예약 취소</button>
														</div>
													</c:if>
												</c:forEach>
											</c:if>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
					</c:choose>

				</div>


<script type="text/javascript">
$(document).ready(function() {
	$('.accordion').find('.accordion-toggle').click(function() {
		$(this).next().slideToggle('600');
		$(".accordion-content").not($(this).next()).slideUp('600');
	});
	$('.accordion-toggle').on('click', function() {
		$(this).toggleClass('active').siblings().removeClass('active');
	});
});
</script>





  				<script type="text/javascript">

$(".cancel").on("click", function () {
	
	if(confirm("예약을 취소하시겠습니까?")){

		 var fr_id = $(this).val();
		 
		 $.ajax({
				url: "/facility/cancleReservation/"+fr_id,
				success: function(){
						 					
 					$(document).find("div[val=" + fr_id + "]").remove();
					$(document).find("h4[val=" + fr_id + "]").remove();  
					
					alert("예약이 취소되었습니다.");
				}
		 
		 });
		
	}else{
		
		alert("ㅇ");
	}
	 
}); 

</script>  




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
									<c:forEach var="reservation" items="${reservationList }">
										<td><c:forEach var="r" items="${reservation}">
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
			</div>
		</div>
		</main>
	</div>

  	<script type="text/javascript">
					$('.reservation').on("click", function() {

										event.preventDefault();

										var fr_id = $(this).attr("val");

										getReservationDetail("/facility/detailPopup/"
												+ fr_id);

									});

  

					function getReservationDetail(f_info) {
						
						var popupX = (window.screen.width/2) - (300/2);
						var popupY= (window.screen.height/2) - (200/2);
						
						window.open(f_info,'childWindow', 'status=no, height=200, width=300, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
					}
					
				</script>  
</body>
</html>