<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Viral | Pages | Gallery</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
#background {
	width: 105%;
	margin-right: 300px;
	margin-left: 0px;
}

#head {
	font-weight: bold;
	font-size: 20pt;
	font-family: nanumgothic;
}

#info {
	
}
</style>
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
	<div class="wrapper row3">
		<main class="container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<div class="wrapper row4" id="background">
			<section id="info" class="clear">
				<!-- ################################################################################################ -->
				<div class="center btmspace-80">
					<h2 class="heading uppercase btmspace-30" id="head">*이웃과 교류하세요</h2>
				</div>
				<div class="group">
					<div class="one_half">
						<ul class="nospace group services">
							<li>
								<article>
									<a href="#"><i class="glyphicon glyphicon-pencil"></i></a> <select
										id="cb_interest" name="cb_interest"
										style="width: 150px; height: 25px;">
										<option selected="" disabled="" hidden="">키워드</option>
										<option value="1">자녀 교육</option>
										<option value="2">반려동물</option>
										<option value="3">운동</option>
										<option value="4">카풀</option>
										<option value="5">나눠쓰기</option>
										<option value="6">동네 상점 후기</option>
										<option value="7">기타</option>
									</select> <br> <br>
									<textarea id="cb_contents" cols="43" rows="5"
										onclick="this.value=''">지금 무슨 일이 일어나고 있나요?</textarea>
									<footer>
										<a href="#" class="delete" id="submit">등록</a>
									</footer>
								</article>
							</li>
							<!--   <li>
								<article>
									<a href="#"><i class="fa fa-asterisk"></i></a>
									<h6 class="heading">Ut pharetra nisi eu massa</h6>
									<p>Nunc nec tincidunt turpis sed feugiat dui vestibulum
										euismod nunc sed vestibulum interdum&hellip;</p>
									<footer>
										<a href="#">Read More &raquo;</a>
									</footer>
								</article>
							</li>   -->
						</ul>
					</div>
				</div>

				<script type="text/javascript">
					$('#submit')
							.on(
									"click",
									function() {
										event.preventDefault();

										var data = {
											cb_interest : $(
													'#cb_interest option:selected')
													.val(),
											cb_contents : $('#cb_contents')
													.val()
										}

										$
												.ajax({
													datatype : "json",
													contentType : "application/json; charset=utf-8",
													type : "POST",
													url : '/comm/insertBoard',
													data : JSON.stringify(data),
													success : function(data) {

														//1. 글쓰기 창 초기화
														resetTextbox();

														//2. 글 출력하기 
														printOnFeed(data);
													},
													error : function() {
														alert("다시 작성해주세요!");
													}
												})
									})

					//글쓰기 창 초기화
					function resetTextbox() {
						$('#cb_contents').val('지금 무슨 일이 일어나고 있나요?');
						$('select')
								.append('<option selected="" disabled="" hidden="">키워드</option>');
					}

					function printOnFeed(data) {

						//1.방금 쓴 글 피드에 출력
						var cb = data.board;
						var cb_contents = cb.cb_contents;
						var cb_no = cb.cb_no;

						var html = '<li value="'+cb_no+'"><article><a href="#"><i class="glyphicon glyphicon-ok"></i></a>';
						html += '<p>' + cb_contents + '</p>';
						html += '<footer><a href="#" class="delete" value="'+cb_no+'">삭제</a></footer></article></li>';

						$('.one_half > ul:first-child').append(html);

						//2.글 전체 목록 
						

					}

					//내 글 삭제하기					
					$('.one_half').on('click', '.delete', function() {

						event.preventDefault();

						var cb_no = $(this).attr('value');

						$.ajax({
							url : "/comm/deleteBoard/" + cb_no,
							success : function() {
								$('li[value=' + cb_no + ']').remove();
							}
						})

					})

					/* 					다른 사람들의 글
					 var html = '<li value="'+cb_no+'"><article><a href="#"><i class="glyphicon glyphicon-ok"></i></a>';
					 html += '<p>' + cb_contents + '</p>';
					 html += '<footer><a href="#"><i class="glyphicon glyphicon-ok"></i></a></li>'; */
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
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>