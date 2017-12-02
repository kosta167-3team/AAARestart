<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Viral | Pages | Full Width</title>
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
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">커뮤니티</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- ################################################################################################ -->

	<div class="wrapper row3">
		<main class="container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<div class="content">
			<!--      ################################################################################################
      <h1>&lt;h1&gt; to &lt;h6&gt; - Headline Colour and Size Are All The Same</h1>
      <img class="imgr borderedbox inspace-5" src=/"resources/images/main/imgr.gif" alt="">
      <p>Aliquatjusto quisque nam consequat doloreet vest orna partur scetur portortis nam. Metadipiscing eget facilis elit sagittis felisi eger id justo maurisus convallicitur.</p>
      <p>Dapiensociis <a href="#">temper donec auctortortis cumsan</a> et curabitur condis lorem loborttis leo. Ipsumcommodo libero nunc at in velis tincidunt pellentum tincidunt vel lorem.</p>
      <img class="imgl borderedbox inspace-5" src="/resources/images/main/imgl.gif" alt="">
      <p>This is a W3C compliant free website template from <a href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a>. For full terms of use of this template please read our <a href="http://www.os-templates.com/template-terms">website template licence</a>.</p>
      <p>You can use and modify the template for both personal and commercial use. You must keep all copyright information and credit links in the template and associated files. For more website templates visit our <a href="http://www.os-templates.com/">free website templates</a> section.</p>
      <p>Portortornec condimenterdum eget consectetuer condis consequam pretium pellus sed mauris enim. Puruselit mauris nulla hendimentesque elit semper nam a sapien urna sempus.</p>
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
      </div>-->
			<div id="comments">
				<!--   <h2>Comments</h2>
        <ul>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="/resources/images/main/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="/resources/images/main/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="/resources/images/main/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
        </ul> -->
				<h2>내 정보 등록</h2>
				<label for="url"> &nbsp; </label>
				<form action="/comm/registerComm" method="post">
					<div class="one_third first">
						<label for="name">가족 구성원 <span>*</span></label> <select
							id="cu_size" name="cu_size" style="width: 300px; height: 40px;">
							<option selected="" disabled="" hidden="">비슷한 사용자의 글을
								받아보세요</option>
							<option value="1">1인 가구</option>
							<option value="2">2인 가구</option>
							<option value="3">3인 가구</option>
							<option value="4">4인 가구</option>
							<option value="5">5인 가구</option>
							<option value="6">6인 가구</option>
							<option value="7">기타</option>
						</select>

						<!-- <input type="text" name="name" id="name" value="" size="22"> -->
					</div>
					<div class="one_third">
						<label for="email">관심사 <span>*</span></label> <select
							id="cu_interest" name="cu_interest"
							style="width: 300px; height: 40px;">
							<option selected="" disabled="" hidden="">중심으로 피드를 구성합니다
							</option>
							<option value="1">자녀 교육</option>
							<option value="2">반려동물</option>
							<option value="3">운동</option>
							<option value="4">카풀</option>
							<option value="5">나눠쓰기</option>
							<option value="6">우리 동네 주변 후기</option>
							<option value="7">기타</option>
						</select>

						<!-- <input type="text" name="email" id="email" value="" size="22"> -->
					</div>


					<div class="one_third">
						<label for="url">소통 유형 <span>*</span></label> <select id="cu_type"
							name="cu_type" style="width: 300px; height: 40px;">
							<option selected="" disabled="" hidden="">피드 구성 기준을
								설정하세요</option>
							<option value="1">비슷한 사용자의 글을 우선으로 받아봅니다</option>
							<option value="2">관심사와 관련된 글을 우선으로 받아봅니다</option>
						</select>

						<!-- <input type="text" name="url" id="url" value="" size="22"> -->
					</div>

					<!-- 					<div class="block clear">
						<label for="comment">Your Comment</label>
						<textarea name="comment" id="comment" cols="25" rows="10"></textarea>
					</div> -->
					<div>
						<label for="url"> &nbsp; </label> <label for="url"> &nbsp;
						</label> <input name="submit" type="submit" id="submit" value="등록하기">
						&nbsp; <input name="reset" type="reset" value="다시 선택하기">
					</div>
				</form>
			</div>


			<script type="text/javascript">
		 	 
			$('#submit').on("click", function() {

				event.preventDefault();
				
 
				var data = {
						 	cu_size : $('#cu_size option:selected').val(),
							cu_interest : $('#cu_interest option:selected').val(), 		
							cu_type : $('#cu_type option:selected').val() 
							};  

				$.ajax({
					datatype : "json",
					contentType : "application/json; charset=utf-8",
					type : "POST",
					url : '/comm/registerComm',
					data : JSON.stringify(data),
					success : function() {

						var popupX = (window.screen.width/2) - (400/2);
						var popupY= (window.screen.height/2) - (400/2);
						
						window.open('/comm/registerPopup','childWindow', 'status=no, height=200, width=300, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);

					},
					error : function() {
						alert("전체 항목을 작성해주세요!");
					}

				});

			}); 
		</script>


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