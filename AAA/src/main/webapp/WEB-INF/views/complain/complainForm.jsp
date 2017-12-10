<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script type="text/javascript"
	src="/resources/layout/scripts/complain/complain.js"></script>


<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<style type="text/css">
.select_target  ul {
	height: 150px;
	overflow: scroll;
}

.select_ho  ul {
	height: 150px;
	overflow: scroll;
}

.submit:HOVER {
	background: black;
}

.toggle.android {
	border-radius: 0px;
}

.toggle.android .toggle-handle {
	border-radius: 0px;
}

.toggle-handle {
	height: 34px;
}
.btn{
	border-radius: 0px;
}
</style>
</head>

<body>
	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
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

	<div class="wrapper row3">
		<main class="container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<div class="content">
			<div id="comments">
				<h2>항의 작성</h2>
				<form action="/complain/register" method="post">
					<input type="hidden" name="type_id" value=""> 
					<input	type="hidden" name="comp_target" value="">
					<div class="col-md-2 col-xs-3">
						<label for="name">내 아이디 <span>*</span></label> 
						<input type="text" value="${login.r_id}" size="22" disabled="disabled">
						<input type="hidden" name="comp_writer" id="name" value="${login.r_id}">
					</div>
					<div class="col-md-2 col-xs-3">
						<label for="email">항의 유형 <span>*</span></label>
						<div class="btn-group">
							<button type="button"
								class="btn btn-default  btn-lg dropdown-toggle select_type"
								data-toggle="dropdown" aria-expanded="false">
								유형 선택 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu select_type" role="menu">
								<li><a>입주민</a></li>
								<li><a>시설</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-2 col-xs-3  select_target hide">
						<label for="email"></label>
						<div class="btn-group">
							<button type="button"
								class="btn btn-default  btn-lg dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								</span>
							</button>
							<ul class="dropdown-menu" role="menu">
							</ul>
						</div>
					</div>
					<div class="col-md-2 col-xs-3  select_ho hide">
						<label for="email">호수 목록</label>
						<div class="btn-group">
							<button type="button"
								class="btn btn-default  btn-lg dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								호 선택<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
							</ul>
						</div>
					</div>
					<div class="col-md-2 col-xs-3 hide select_type_detail">
						<label for="email">항의 이유 <span>*</span></label>
						<div class="btn-group">
							<button type="button"
								class="btn btn-default  btn-lg dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								유형 선택 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
							</ul>
						</div>
					</div>
					<div class="block clear">
						<label for="comment">상세 이유</label>
						<textarea name="comp_content" id="comment" cols="25" rows="10"></textarea>

					</div>
					<div>
						<label class="col-md-2">공개 / 비공개<span>*</span></label> 
						<input  name ="disclosure_status"
							type="checkbox" checked data-toggle="toggle" data-on="공개"
							data-off="비공개" data-onstyle="success" data-offstyle="danger"
							data-style="android">
					</div>
					<div class= "col-md-6 col-md-offset-8">
						<input name="submit" class="submit" type="submit" value="작성 완료">
							&nbsp; <input name="reset" type="reset" value="다시 쓰기">
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

</body>

</html>
