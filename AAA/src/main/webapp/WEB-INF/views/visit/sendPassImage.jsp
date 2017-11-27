<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
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
					<li><a href="visit/application">방문 신청</a></li>
					<li><a href="visit/applicationList">신청내역 조회</a></li>
				</ul>
			</nav>
		</div>
		<div class="content three_quarter">
			<div id="comments">
				<h2>방문 신청</h2>
				<a id="kakao-login-btn"></a> <a
					href="http://developers.kakao.com/login"></a>
				<script type='text/javascript' charset="utf-8">
					var date = "${date}";
					Kakao.init('ae9f974b5119a84092f103b5834f90ea'); // ê°ë°ìì Javascript Key		

					Kakao.Auth.createLoginButton({ // create login button
						container : '#kakao-login-btn',

						success : function(authObj) {
							Kakao.Auth.login({ // ì¹´ì¹´ì¤í¡ ë¡ê·¸ì¸
								scope : "PROFILE,TALK_MESSAGE",
								success : function(res) {
									Kakao.API.request({ // ì¹´ì¹´ì¤í¡ 						
										url : '/v1/api/talk/memo/send',
										data : {
											template_id : '6174',
											args : '{"\${date}" : "'
													+ date + '"}',
										},

										success : function(res) { // ë³´ë´ê¸° ì±ê³µ
											Kakao.Auth.logout();
											alert("'" + date + "' 방문 신청되었습니다.");
											location.href = "application";
										},
										fail : function(error) { // ë³´ë´ê¸° ì¤í¨
											Kakao.Auth.logout();
											alert(JSON.stringify(error));
										}
									})
								},
								persistAccessToken:false,
								fail : function(error) {
									alert('login error');

								}
							});
						},
						fail : function(err) { // ë²í¼ ìì± ì¤í¨ ì
							alert("create button fail");
						}
					});
				</script>
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