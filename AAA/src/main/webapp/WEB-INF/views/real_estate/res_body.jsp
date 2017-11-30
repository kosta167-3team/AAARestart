
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<!-- css -->
<link href="/resources/layout/styles/real_estate/real_layout.css"
	rel="stylesheet" type="text/css" media="all">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- scripts -->

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="/resources/layout/scripts/jquery.min.js"></script>

<script type="text/javascript"
	src="/resources/layout/scripts/real_estate/real_estate.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

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

	<div class="wrapper row3">
		<main class="container clear">
		<div id="apart_title">
			<h1>
				<p></p>
			</h1>
		</div>

		<div class="page-header">
			<h2>
				면적별시세 조회<span class="pull-right label label-default">부동산</span>
			</h2>
			<div class="selected-item">
				<!-- <p>
					You Selected Country : <span>Empty</span>
				</p> -->
			</div>
		</div>
		<div class="">
			<div class="panel with-nav-tabs panel-primary">
				<div class="panel-heading">
					<ul class="nav nav-tabs">
						<li class="active"><a class="tab" href="#tab1primary"
							data-toggle="tab">면적별시세 조회</a></li>
						<li><a class="tab" href="#tab2primary" data-toggle="tab">시세변동추이</a></li>
						<li><a class="tab" href="#tab3primary" data-toggle="tab">주변단지시세조회</a></li>
					</ul>
				</div>
				<div class="panel-body">
					<div class="tab-content">
						<div class="tab-pane fade in active" id="tab1primary">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									면적 선택 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
								</ul>
							</div>
							<div class="real_estateData">
								<div class="chart"></div>
								<div class="table scrollable">
									<table class="real_estate_table">
										<thead>
											<tr>

												<th scope="col" rowspan="2" class="spanTH">면적(㎡)</th>
												<th scope="colgroup" colspan="2" class="spanTH">전세(만원)</th>
												<th scope="colgroup" colspan="2" class="tit_lease spanTH">매매(만원)</th>
											</tr>
											<tr>
												<th scope="col">최대가</th>
												<th scope="col">최소가</th>
												<th scope="col">최대가</th>
												<th scope="col">최소가</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>

						</div>
						<div class="tab-pane fade" id="tab2primary">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									면적 선택 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
								</ul>

							</div>
							<div class="apt_type">
								<a href="rent" class="type_select">전세</a> <a href="trade">매매</a>
							</div>
							<div class="real_estateData">
								<div class="chart"></div>
								<div class="table scrollable">
									<table class="real_estate_table">
										<thead>
											<tr>
												<th scope="col" rowspan="2" class="spanTH">년/월</th>
												<th scope="colgroup" colspan="2" class="spanTH">전세(만원)</th>
												<th scope="colgroup" colspan="2" class="tit_lease spanTH">매매(만원)</th>
											</tr>
											<tr>
												<th scope="col">최대가</th>
												<th scope="col">최소가</th>
												<th scope="col">최대가</th>
												<th scope="col">최소가</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="tab3primary">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									면적 선택 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
								</ul>

							</div>
							<div class="real_estateData">Primary3</div>

						</div>
						
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

