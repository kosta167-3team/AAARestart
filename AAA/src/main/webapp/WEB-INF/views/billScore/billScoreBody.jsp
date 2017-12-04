<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<!--
Template Name: Viral
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>


<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">

<script src="/resources/layout/scripts/jquery.min.js"></script>
<script src="/resources/images/billScore/js/billScoreBodyJS.js"></script>

<style type="text/css">
	#spanTH{
		text-align: center;
		vertical-align: middle;
		
	}
</style>

</head>
<body id="top">

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">관리비 성적표</a></li>
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


			<h1>${pme.p_month}월 관리비 성적표</h1>
			<div class="scrollable">
				<p>사용자 정보</p>
				<input id="pme_input_num" type="hidden" value="${pme.input_num }">
				<table>
					<thead>
						<tr>
							<th>사용자 이름</th>
							<th>사용자 ID</th>
							<th>전화 번호</th>
							<th>동</th>
							<th>호</th>
							<th>권한</th>
							<th>면적</th>
							<th>포인트</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${resident.r_name }</td>
							<td>${resident.r_id }</td>
							<td>${resident.r_tel }</td>
							<td>${resident.r_dong }</td>
							<td>${resident.r_ho }</td>
							<td>${resident.r_authority }</td>
							<td>${pme.width }</td>
							<td>${resident.point }</td>
						</tr>
					</tbody>
				</table>

				<p>전기 에너지</p>
				<input id="hiddenElec" type="hidden" data-rno="elec">
				<table>
					<thead>
						<tr>
							<th>년/월</th>
							<th>세대 전기료</th>
							<th>공동 전기료</th>

							<th>승강기</th>
							<th>TV수신료</th>
							<th>기본 전기료</th>

							<th>기타 전기료</th>
							<th>총 사용량(kwh)</th>
							<th>총 전기료</th>

							<th>환산</th>
						</tr>
					</thead>
					<tbody>
						<tr>

							<td>${pme.p_month }</td>
							<td>${pme.personal_elec }</td>
							<td>${pme.public_elec }</td>

							<td>${pme.elevator_maintain }</td>
							<td>${pme.tv }</td>
							<td>0</td>

							<td>0</td>
							<td>${energy.elec }</td>
							<td>${pme.allElec() }</td>

							<td id="elecTableTD">0</td>
						</tr>
					</tbody>
				</table>

				<p>열 에너지</p>
				<input id="hiddenHeat" type="hidden" data-rno="heat">
				<table>
					<thead>
						<tr>
							<th>년/월</th>
							<th>세대 난방료</th>
							<th>공동 난방료</th>

							<th>기본 난방료</th>
							<th>세대 급탕료</th>
							<th>세대 가스료</th>

							<th>공동 가스료</th>
							<th>기타 난방비</th>
							<th>총 난방료</th>

							<th>사용량(ton)</th>
							<th>환산</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${pme.p_month }</td>
							<td>${pme.personal_heat }</td>
							<td>${pme.public_heat }</td>

							<td>${pme.basic_heat }</td>
							<td>${pme.personal_heat_water }</td>
							<td>${pme.personal_gas }</td>

							<td>${pme.public_gas }</td>
							<td>${pme.etc_heat }</td>
							<td>${pme.allHeat() }</td>

							<td>${energy.heat }</td>
							<td id="heatTableTD">0</td>

						</tr>
					</tbody>
				</table>

				<p>총 에너지 사용량</p>
				<table>
					<thead>
						<tr>
							<th id="spanTH" colspan="3" rowspan="3">날짜</th>
						</tr>
						<tr>

							<th colspan="5">전기(kwh)</th>
							<th colspan="5">물(ton)</th>
							<th colspan="5">난방</th>

						</tr>
						<tr>
							<c:forEach begin="1" end="3">
								<c:forEach begin="1" end="5" var="a">
									<th>${a }</th>
								</c:forEach>
							</c:forEach>

						</tr>

					</thead>
					<tbody id="energyValueTable">
						<c:forEach var="secondList" items="${oneYearEnergyList }"
							varStatus="status">
							<tr>
								<td colspan="3"><a
									href="/billScore//billScoreBody/${monthMap[status.index]}">${monthMap[status.index]}</a>
								</td>
								<c:forEach begin="1" end="5" var="count">
									<c:forEach var="energyObject" items="${secondList }">
										<c:if test="${energyObject.week_num == count }">
											<td>${energyObject.elec }</td>
										</c:if>
									</c:forEach>
								</c:forEach>
								<c:forEach begin="1" end="5" var="count">
									<c:forEach var="energyObject" items="${secondList }">
										<c:if test="${energyObject.week_num == count }">
											<td>${energyObject.heat }</td>
										</c:if>
									</c:forEach>
								</c:forEach>
								<c:forEach begin="1" end="5" var="count">
									<c:forEach var="energyObject" items="${secondList }">
										<c:if test="${energyObject.week_num == count }">
											<td>${energyObject.fever }</td>
										</c:if>
									</c:forEach>
								</c:forEach>


							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<div>
				<p>전기 등급표</p>
				<table>
					<thead>
						<tr>
							<th>등급</th>
							<th>순위권</th>
						</tr>
					</thead>
					<c:forEach var="grade" items="${elecGradeTable.gradeStringList }">
						<tr>
							<td>${grade }</td>
							<td>${elecGradeTable.getGradeBill( grade )}</td>
						</tr>
					</c:forEach>


				</table>
				<p>열 등급표</p>
				<table>
					<thead>
						<tr>
							<th>등급</th>
							<th>순위권</th>
						</tr>
					</thead>

					<c:forEach var="grade" items="${heatGradeTable.gradeStringList }">
						<tr>
							<td>${grade }</td>
							<td>${heatGradeTable.getGradeBill( grade )}</td>
						</tr>
					</c:forEach>


				</table>
			</div>


			<div id="gradeTableDiv"></div>
			<div class="clear"></div>
		</main>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->

	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>

</body>
</html>