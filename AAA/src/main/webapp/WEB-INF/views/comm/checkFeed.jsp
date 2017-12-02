<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Viral | Pages | Gallery</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body id="top">

	<!-- ################################################################################################ -->

	<div class="wrapper row2 bgded"
		style="background-image: url('/resources/images/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">커뮤니티</a></li>
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
		<div class="wrapper row4">
			<section id="info" class="clear">
				<!-- ################################################################################################ -->
				<div class="center btmspace-80">
					<h2 class="heading uppercase btmspace-30">*이웃과 교류하세요</h2>
				</div>
				<div class="group">
					<div class="one_half">
						<ul class="nospace group services">
							<li>
								<article>
									<a><i class="fa fa-paper-plane-o"></i></a> <select
										id="cb_interest" name="cb_interest"
										style="width: 100px; height: 25px;">
										<option selected="" disabled="" hidden="">키워드</option>
										<option value="1">자녀 교육</option>
										<option value="2">반려동물</option>
										<option value="3">운동</option>
										<option value="4">카풀</option>
										<option value="5">나눠쓰기</option>
										<option value="6">우리 동네 주변 후기</option>
										<option value="7">기타</option>
									</select> <br> <br>
									<textarea id="cb_contents" cols="43" rows="7"
										onclick="this.value=''">지금 무슨 일이 일어나고 있나요?</textarea>
									<footer>
										<a href="#" id="submit">등록</a>
									</footer>
								</article>
							</li>
							<li>
								<article>
									<a href="#"><i class="fa fa-asterisk"></i></a>
									<h6 class="heading">Ut pharetra nisi eu massa</h6>
									<p>Nunc nec tincidunt turpis sed feugiat dui vestibulum
										euismod nunc sed vestibulum interdum&hellip;</p>
									<footer>
										<a href="#">Read More &raquo;</a>
									</footer>
								</article>
							</li>
						</ul>
					</div>
				</div>

				<script type="text/javascript">
  					$('#submit').on("click", function() {
						event.preventDefault();

						//alert($('#cb_contents').val());
						
  						var data = {
								cb_interest:$('#cb_interest option:selected').val(),
								cb_contents:$('#cb_contents').val()
						}
						
  						$.ajax({
  							datatype : "json",
  							contentType : "application/json; charset=utf-8",
  							type : "POST",
  							url : '/comm/insertBoard',
  							data : JSON.stringify(data),
  							success : function(data) {
  								alert("이제 출력하기");
						} 
					})
  					})
				</script>
				<!-- ################################################################################################ -->
				<div class="clear"></div>
			</section>
		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row5">
		<footer id="footer" class="clear">
			<!-- ################################################################################################ -->
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
				<!-- 		<button type="submit" value="submit">Submit</button> -->
					</fieldset>
				</form>
			</div>
			<!-- ################################################################################################ -->
		</footer>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row6">
		<div id="copyright" class="clear">
			<!-- ################################################################################################ -->
			<p class="fl_left">
				Copyright &copy; 2015 - All Rights Reserved - <a href="#">Domain
					Name</a>
			</p>
			<p class="fl_right">
				Template by <a target="_blank" href="http://www.os-templates.com/"
					title="Free Website Templates">OS Templates</a>
			</p>
			<!-- ################################################################################################ -->
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>