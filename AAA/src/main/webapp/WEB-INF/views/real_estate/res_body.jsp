
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<link href="/resources/layout/styles/real_estate/real_layout.css"
	rel="stylesheet" type="text/css" media="all">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="/resources/layout/scripts/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.tab').on('click', function(event) {
			$('li').removeClass('active');
			$(this).parent().addClass('active');
			event.preventDefault();
		})
	})
</script>
</head>

<body>

	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">부동산정보</a></li>
				</ul>
				<!-- ################################################################################################ -->
			</div>
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row3">
		<main class="container clear">

		<div class="page-header">
			<h1>
				면적별시세 조회<span class="pull-right label label-default">부동산</span>
			</h1>
		</div>
		<div class="">
			<div class="panel with-nav-tabs panel-primary">
				<div class="panel-heading">
					<ul class="nav nav-tabs">
						<li class="active"><a class="tab" href="#tab1primary"
							data-toggle="tab">면적별시세 조회</a></li>
						<li><a class="tab" href="#tab2primary" data-toggle="tab">시세변동추이</a></li>
						<li><a class="tab" href="#tab3primary" data-toggle="tab">주변단지시세조회</a></li>
						<!-- <li class="dropdown"><a href="#" data-toggle="dropdown">Dropdown
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#tab4primary" data-toggle="tab">Primary 4</a></li>
								<li><a href="#tab5primary" data-toggle="tab">Primary 5</a></li>
							</ul>
						</li> -->
					</ul>
				</div>
				<div class="panel-body">
					<div class="tab-content">
						<div class="tab-pane fade in active" id="tab1primary">Primary
							1</div>
						<div class="tab-pane fade" id="tab2primary">Primary 2</div>
						<div class="tab-pane fade" id="tab3primary">Primary 3</div>
						<div class="tab-pane fade" id="tab4primary">Primary 4</div>
						<div class="tab-pane fade" id="tab5primary">Primary 5</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br />
	</main>
	</div>
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

</body>

</html>

