<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript">
	function submit() {
		var etcs = new Array();
		alert("qweqwe");
		var stateObject = new Object();
		

		$('select[name=state] option:selected').each(function(index) {
			stateObject.state = $(this).attr('etc');
			stateObject.vr_id = $('.vr_id').eq(index).attr('value');
			$.ajax({
				url: "/visit/applicationCheck", 
				type: "POST",
				data: stateObject,
				dataType: "json"
			});
			history.go(0);
			console.log(index);
			//etcs.push(checkObject);
		});
	}
</script>

</head>
<body id="top">
	<div class="wrapper row0">
		<div id="topbar" class="clear">
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
		</div>
	</div>
	<div class="wrapper row1">
		<header id="header" class="clear">
			<div id="logo" class="fl_left">
				<h1>
					<a href="/"><img src="/resources/images/main/main_log_mini.png"
						alt="" class="main_log_img"></a>
				</h1>
			</div>
			<nav id="mainav" class="fl_right">
				<ul class="clear">
					<li><a href="/resources/index.html">Home</a></li>
					<li class="active"><a class="drop" href="#">Pages</a>
						<ul>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="full-width.html">Full Width</a></li>
							<li class="active"><a href="sidebar-left.html">Sidebar
									Left</a></li>
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
		</header>
	</div>
	<div class="wrapper row2 bgded"
		style="background-image: url('/resources/images/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">Sidebar Left</a></li>
				</ul>
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
					<li><a href="#">신청내역 조회</a></li>
				</ul>
			</nav>
		</div>
		<div class="content three_quarter">
			<div id="comments">
				<h2>방문신청 내역</h2>
				<table>
					<thead>
						<tr>
							<th>방문객</th>
							<th>연락처</th>
							<th>방문 예정일</th>
							<th>방문 사유</th>
							<th>방문 승인</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="application">

							<tr>
								<td>${application.v_name}</td>
								<td>${application.v_tel}</td>
								<td>${application.v_date}</td>
								<td>${application.v_contents}</td>
								<td>
								
									<select id="state" name="state">
									<c:set var="data" value="${application.v_state}"/>
									<c:choose>
										<c:when test="${data == '거부'} ">
											<option etc="accept">승인</option>
											<option etc="denial" selected="selected">거부</option>		
										</c:when>
										
										<c:otherwise> 
											<option etc="accept"  selected="selected">승인</option>
											<option etc="denial">거부</option>	
										</c:otherwise>
									
									</c:choose>						
									</select>
									<input class="vr_id" type="hidden" value="${application.vr_id}">
								</td>

							</tr>

						</c:forEach>
						<tr>
							<td colspan="5"><input type="button" value="저장"
								onclick="submit();"></td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="text-center">
			<%-- 	<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a
							href="applicationList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="applicationList${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="applicationList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>

				</ul> --%>
			</div>
		</div>
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	<div class="wrapper row5">
		<footer id="footer" class="clear">
			<div class="one_quarter first">
				<h6 class="title">Viral</h6>
				<address class="btmspace-15">
					Company Name<br> Street Name &amp; Number<br> Town<br>
					Postcode/Zip
				</address>
				<ul class="nospace">
					<li class="btmspace-10"><span class="fa fa-phone"></span> +00
						(123) 456 7890</li>
					<li><span class="fa fa-envelope-o"></span> info@domain.com</li>
				</ul>
			</div>
			<div class="one_quarter">
				<h6 class="title">Quick Links</h6>
				<ul class="nospace linklist">
					<li><a href="#">Home Page</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Gallery</a></li>
					<li><a href="#">Portfolio</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</div>
			<div class="one_quarter">
				<h6 class="title">From The Blog</h6>
				<article>
					<h2 class="nospace">
						<a href="#">Praesent Vestibulum</a>
					</h2>
					<time class="smallfont" datetime="2045-04-06">
						Friday, 6<sup>th</sup> April 2045
					</time>
					<p>Vestibulumaccumsan egestibulum eu justo convallis augue
						estas aenean elit intesque sed.</p>
				</article>
			</div>
			<div class="one_quarter">
				<h6 class="title">Grab Our Newsletter</h6>
				<form method="post" action="#">
					<fieldset>
						<legend>Newsletter:</legend>
						<input class="btmspace-15" type="text" value="" placeholder="Name">
						<input class="btmspace-15" type="text" value=""
							placeholder="Email">
						<button type="submit" value="submit">Submit</button>
					</fieldset>
				</form>
			</div>
		</footer>
	</div>
	<div class="wrapper row6">
		<div id="copyright" class="clear">
			<p class="fl_left">
				Copyright &copy; 2015 - All Rights Reserved - <a href="#">Domain
					Name</a>
			</p>
			<p class="fl_right">
				Template by <a target="_blank" href="http://www.os-templates.com/"
					title="Free Website Templates">OS Templates</a>
			</p>
		</div>
	</div>
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

	<!-- JAVASCRIPTS -->
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>