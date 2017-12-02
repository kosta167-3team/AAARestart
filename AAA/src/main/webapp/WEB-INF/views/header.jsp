<%@page import="all.about.apartment.publicDomain.ResidentVO"%>
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

<style>
	li {
		font-size: 18px;
	}
</style>
<%
	ResidentVO vo = (ResidentVO)session.getAttribute("login");
	
%>

<html>
<head>
<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- CSS -->

<link href="/resources/layout/styles/message/message.css"
	rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">

<!-- JAVASCRIPTS -->
<script src="/resources/layout/scripts/jquery.min.js"></script>
<script src="/resources/layout/scripts/jquery.backtotop.js"></script>

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
<script src="/resources/layout/scripts/message/messageChk.js"></script>
<script type="text/javascript">

$(function () {
	var id = $('[ name="user_id"]').val();
	console.log(id);
	if(id == ''){
		$('#login').text('로그인');
		$('#login').attr('href', '/user/login');
	}else{
		$('#login').text('로그아웃');
		$('#login').attr('href', '/user/logout');
		$('#msg').html('쪽지 [<span>0</span>]');
	}
	
});
</script>
</head>

<%-- <input type="hidden" name="user_id" value="${login.r_id}"> --%>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<div class="wrapper row0">
  <div id="topbar" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="fl_left">
      <ul class="nospace inline">
<!--         <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
        <li><i class="fa fa-envelope-o"></i> info@domain.com</li> -->
      </ul>
    </div>
   <div class="fl_right">
      <ul class="faico clear">
        <li><a  href="#" id="login"></a></li>
        <li><a  href="#">마이페이지</a></li>
        <li><a  href="#" id ="msg"></a></li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="/"><img src="/resources/images/main/main_log_mini.png" alt="" class="main_log_img"></a></h1>
    </div>
    <nav id="mainav" class="fl_right">
      <ul class="clear">
        <li><a href="/">홈</a></li>
        
        <li class="active"><a class="drop" href="#">관리비</a>
          <ul>
            <li><a href="/">Gallery</a></li>
            <li class="active"><a class="drop" href="/bill/full-width">관리비 조회</a>
            	<ul>
            		<li> <a href="/billScore/billScoreBody">관리비 성적표</a></li>
            	</ul>
            </li>
            <li><a href="/">관리비 1</a></li>
            <li><a href="/">관리비 2</a></li>
            <li><a href="/">관리비 3</a></li>
          </ul>
        </li>
         <li class="active"><a class="drop" href="#">방문객</a>
          <ul>
            <li><a href="/visit/application">방문 신청</a></li>
            <li><a href="/visit/applicationList">방문 예약 내역 조회</a></li>
            <li><a href="/visit/visitManagement">방문 예약 내역</a></li>
          </ul>
        </li>
         <li class="active"><a class="drop" href="#">시설</a>
          <ul>
            <li><a href="/">시설 예약</a></li>
            <li><a href="/">시설 예약 조회</a></li>
          </ul>
        </li>
        <li><a class="drop" href="#">항의</a>
          <ul>
            <li><a href="/">항의하기</a></li>
            <li><a href="/">항의..</a></li>
          </ul>
        </li>
        <li><a href="#">커뮤니티</a></li>
        <li><a href="#">부동산</a></li>
        <li><a class="drop" href="#">경매</a>
          <ul>
            <li><a href="/bidd/bidDetail">경매 물품보기</a></li>
            <li><a href="/">내 입찰 내역 조회</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    <!-- ################################################################################################ -->
  </header>
</div>

<div class="wrapper row0">
  <div id="topbar" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="fl_left">
      <ul class="nospace inline">
<!--         <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
        <li><i class="fa fa-envelope-o"></i> info@domain.com</li> -->
      </ul>
    </div>
   <div class="fl_right">
      <ul class="faico clear">
        <li><a  href="#" id="login"></a></li>
        <li><a  href="#">마이페이지</a></li>
        <li><a  href="#" id ="msg"></a></li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="/"><img src="/resources/images/main/main_log_mini.png" alt="" class="main_log_img"></a></h1>
    </div>
    <nav id="mainav" class="fl_right">
      <ul class="clear">
        <li><a href="/">홈</a></li>
        
        <li class="active"><a class="drop" href="#">관리비</a>
          <ul>
            <li><a href="/">Gallery</a></li>
            <li class="active"><a class="drop" href="/bill/full-width">관리비 조회</a>
            	<ul>
            		<li> <a href="/billScore/billScoreBody">관리비 성적표</a></li>
            	</ul>
            </li>
            <li><a href="/">관리비 1</a></li>
            <li><a href="/">관리비 2</a></li>
            <li><a href="/">관리비 3</a></li>
          </ul>
        </li>
         <li class="active"><a class="drop" href="#">방문객</a>
          <ul>
            <li><a href="/visit/application">방문 신청</a></li>
            <li><a href="/visit/applicationList">방문 예약 내역 조회</a></li>
            <li><a href="/visit/visitManagement">방문 예약 내역</a></li>
          </ul>
        </li>
         <li class="active"><a class="drop" href="#">시설</a>
          <ul>
            <li><a href="/">시설 예약</a></li>
            <li><a href="/">시설 예약 조회</a></li>
          </ul>
        </li>
        <li><a class="drop" href="#">항의</a>
          <ul>
            <li><a href="/">항의하기</a></li>
            <li><a href="/">항의..</a></li>
          </ul>
        </li>
        <li><a href="#">커뮤니티</a></li>
        <li><a href="#">부동산</a></li>
        <li><a class="drop" href="#">경매</a>
          <ul>
            <li><a href="/bidd/bidDetail">경매 물품보기</a></li>
            <li><a href="/">내 입찰 내역 조회</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    <!-- ################################################################################################ -->
  </header>
</div>
	<div class="wrapper row0">
		<div id="topbar" class="clear">
			<!-- ################################################################################################ -->
			<div class="fl_left">
				<ul class="nospace inline">
					<li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
					<li><i class="fa fa-envelope-o"></i> info@domain.com</li>
				</ul>
			</div>
			<div class="fl_right">
				<ul class="faico clear">
					<li><a href="#" id="login"></a></li>
					<li><a href="#">마이페이지</a></li>
					<li><a href="#" id="msg" data-toggle="modal"
						data-target=".messageListmodal"></a></li>
				</ul>
			</div>
			<!-- ################################################################################################ -->
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->


	<!-- ##################################################################################################### -->
	<!-- Modal  -->
	<div class="modal fade messageListmodal" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">
						<span class="glyphicon glyphicon-envelope"></span>
					</h4>
				</div>
				<div class="modal-body">
					<div class="scrollable">
						<table class="table table-hover table-striped">
							<thead>
								<tr>
									<th class ="col-md-2">읽음 / 안 읽음</th>
									<th class ="col-md-2">보낸 사람</th>
									<th class ="col-md-6">내용</th>
									<th class ="col-md-2">보낸 시간</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>