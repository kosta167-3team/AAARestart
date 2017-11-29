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



			<h1>${pme.p_month} 월 관리비 성적표</h1>
			<div class="scrollable">
				<p>사용자 정보</p>
				<input id="pme_input_num" type="hidden" value = "${pme.input_num }">
				<table >
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
				<table >
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
							<th colspan="3" rowspan="3">날짜</th>
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
						<c:forEach var="secondList" items="${oneYearEnergyList }" varStatus="status">
							<tr>
								<td colspan="3"><a href="/billScore//billScoreBody/${monthMap[status.index]}">${monthMap[status.index]}</a>  </td>
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


			<h1>&lt;h1&gt; to &lt;h6&gt; - Headline Colour and Size Are All
				The Same</h1>
			<img class="imgr borderedbox inspace-5"
				src="/resources/images/main/imgr.gif" alt="">
			<p>Aliquatjusto quisque nam consequat doloreet vest orna partur
				scetur portortis nam. Metadipiscing eget facilis elit sagittis
				felisi eger id justo maurisus convallicitur.</p>
			<p>
				Dapiensociis <a href="#">temper donec auctortortis cumsan</a> et
				curabitur condis lorem loborttis leo. Ipsumcommodo libero nunc at in
				velis tincidunt pellentum tincidunt vel lorem.
			</p>
			<img class="imgl borderedbox inspace-5"
				src="/resources/images/main/imgl.gif" alt="">
			<p>
				This is a W3C compliant free website template from <a
					href="http://www.os-templates.com/" title="Free Website Templates">OS
					Templates</a>. For full terms of use of this template please read our <a
					href="http://www.os-templates.com/template-terms">website
					template licence</a>.
			</p>
			<p>
				You can use and modify the template for both personal and commercial
				use. You must keep all copyright information and credit links in the
				template and associated files. For more website templates visit our
				<a href="http://www.os-templates.com/">free website templates</a>
				section.
			</p>
			<p>Portortornec condimenterdum eget consectetuer condis consequam
				pretium pellus sed mauris enim. Puruselit mauris nulla
				hendimentesque elit semper nam a sapien urna sempus.</p>
			<h1>Table(s)</h1>

			<div class="scrollable">
				<table>
					<thead>
						<tr>
							<th>Header 1</th>
							<th>Header 2</th>
							<th>Header 3</th>
							<th>Header 4</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="#">Value 1</a></td>
							<td>Value 2</td>
							<td>Value 3</td>
							<td>Value 4</td>
						</tr>
						<tr>
							<td>Value 5</td>
							<td>Value 6</td>
							<td>Value 7</td>
							<td><a href="#">Value 8</a></td>
						</tr>
						<tr>
							<td>Value 9</td>
							<td>Value 10</td>
							<td>Value 11</td>
							<td>Value 12</td>
						</tr>
						<tr>
							<td>Value 13</td>
							<td><a href="#">Value 14</a></td>
							<td>Value 15</td>
							<td>Value 16</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="comments">
				<h2>Comments</h2>
				<ul>
					<li>
						<article>
							<header>
								<figure class="avatar">
									<img src="/resources/images/main/avatar.png" alt="">
								</figure>
								<address>
									By <a href="#">A Name</a>
								</address>
								<time datetime="2045-04-06T08:15+00:00">
									Friday, 6<sup>th</sup> April 2045 @08:15:00
								</time>
							</header>
							<div class="comcont">
								<p>This is an example of a comment made on a post. You can
									either edit the comment, delete the comment or reply to the
									comment. Use this as a place to respond to the post or to share
									what you are thinking.</p>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<figure class="avatar">
									<img src="/resources/images/main/avatar.png" alt="">
								</figure>
								<address>
									By <a href="#">A Name</a>
								</address>
								<time datetime="2045-04-06T08:15+00:00">
									Friday, 6<sup>th</sup> April 2045 @08:15:00
								</time>
							</header>
							<div class="comcont">
								<p>This is an example of a comment made on a post. You can
									either edit the comment, delete the comment or reply to the
									comment. Use this as a place to respond to the post or to share
									what you are thinking.</p>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<figure class="avatar">
									<img src="/resources/images/main/avatar.png" alt="">
								</figure>
								<address>
									By <a href="#">A Name</a>
								</address>
								<time datetime="2045-04-06T08:15+00:00">
									Friday, 6<sup>th</sup> April 2045 @08:15:00
								</time>
							</header>
							<div class="comcont">
								<p>This is an example of a comment made on a post. You can
									either edit the comment, delete the comment or reply to the
									comment. Use this as a place to respond to the post or to share
									what you are thinking.</p>
							</div>
						</article>
					</li>
				</ul>
				<h2>Write A Comment</h2>
				<form action="#" method="post">
					<div class="one_third first">
						<label for="name">Name <span>*</span></label> <input type="text"
							name="name" id="name" value="" size="22">
					</div>
					<div class="one_third">
						<label for="email">Mail <span>*</span></label> <input type="text"
							name="email" id="email" value="" size="22">
					</div>
					<div class="one_third">
						<label for="url">Website</label> <input type="text" name="url"
							id="url" value="" size="22">
					</div>
					<div class="block clear">
						<label for="comment">Your Comment</label>
						<textarea name="comment" id="comment" cols="25" rows="10"></textarea>
					</div>
					<div>
						<input name="submit" type="submit" value="Submit Form">
						&nbsp; <input name="reset" type="reset" value="Reset Form">
					</div>
				</form>
			</div>
			<!-- ################################################################################################ -->
		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
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