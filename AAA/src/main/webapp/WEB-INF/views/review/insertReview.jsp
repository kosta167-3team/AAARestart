<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@page import="java.util.List"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<html>
<head>
<title>Viral | Pages | Sidebar Left</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
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
        <li><a class="faicon-facebook" href="#"><i class="fa fa-facebook"></i></a></li>
        <li><a class="faicon-pinterest" href="#"><i class="fa fa-pinterest"></i></a></li>
        <li><a class="faicon-twitter" href="#"><i class="fa fa-twitter"></i></a></li>
        <li><a class="faicon-dribble" href="#"><i class="fa fa-dribbble"></i></a></li>
        <li><a class="faicon-linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
        <li><a class="faicon-google-plus" href="#"><i class="fa fa-google-plus"></i></a></li>
        <li><a class="faicon-rss" href="#"><i class="fa fa-rss"></i></a></li>
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
        <li><a href="/real_estate">부동산</a></li>
        <li><a class="drop" href="#">경매</a>
          <ul>
          	<li><a href="/bid/bidListAll">경매 목록</a></li>
            <li><a href="/bidd/bidDetail">경매 물품보기</a></li>
            <li><a href="/">내 입찰 내역 조회</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    <!-- ################################################################################################ -->
  </header>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2 bgded" style="background-image:url('/resources/images/main/backgrounds/01.png');">
  <div class="overlay">
    <div id="breadcrumb" class="clear"> 
      <!-- ################################################################################################ -->
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">Lorem</a></li>
        <li><a href="#">Ipsum</a></li>
        <li><a href="#">시설 후기 작성</a></li>
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
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="sidebar one_quarter first"> 
      <!-- ################################################################################################ -->
      <!--  <h6>시설</h6>
      <nav class="sdb_holder">
        <ul>
           <li><a href="#">시설 후기</a></li>
          <li><a href="#">Navigation - Level 1</a>
       
          </li> 

  
        </ul>
      </nav>  -->
      
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- ################################################################################################ -->
    <div class="content three_quarter"> 
      <!-- ################################################################################################ -->

      <div id="comments">

        <h2>시설 후기 작성</h2>
        <form action="#" method="post">
          <div class="one_third first">
           <label for="name">시설 ID <span>*</span></label> 
          	<select name="f_id" style="width:200px;height:40px;">
          		<option value="1"> 수영장 </option>
          		<option value="2"> 테니스장 </option>
          		<option value="3"> 헬스장 </option>
          		<option value="4"> DVD </option>
          		<option value="5"> 문화강좌실 </option>
          		
          	</select>
          
            
            
            <!-- <input type="text" name="f_id" placeholder="시설 ID를 입력하세요  " id="name" value="" size="22"><br>
          	1.&nbsp수영장 2.&nbsp테니스장 3.&nbsp헬스장&nbsp 4.&nbsp dvd &nbsp&nbsp 5.&nbsp문화강좌실  -->
          
          </div>
        <!--   <div class="one_third">
             <label for="email">입주민 ID <span>*</span></label>
            <input type="text" name="r_id" id="email" value="" size="22">
          </div> -->
          <div class="one_third">
            <label for="url">별점</label>
            <input type="text" name="rev_rate" id="url" value="" size="10">
          </div>
          <div class="block clear">
            <br><label for="comment"><h3>후기</h3></label>
            <textarea name="rev_contents" id="comment" cols="15" rows="10"></textarea>
          </div>
          <div>
            <input name="submit" type="submit" value="등록">
            &nbsp;
            
          </div><br>
        </form>
      </div>
      
          <h1>후기 리스트</h1>
      <div class="scrollable">
        <table>
          <thead>
            <tr>
              <th>글번호</th>
              <th>입주민 ID</th>
              <th>시설물 이름</th>
              <th>내용</th>
              <th>날짜</th>
              <th>별점</th>
            </tr>
          </thead>
          <tbody>
             <c:forEach var="ReviewVO" items="${list }">
        	<tr>
           	<td> ${ReviewVO.rev_id } </td>
            <td> ${ReviewVO.r_id } </td>
            <td> <c:if test="${ReviewVO.f_id >= 0 }">
            	<c:choose>
            		<c:when test="${ReviewVO.f_id == 1 }">
            			수영장
            		</c:when>
            		<c:when test="${ReviewVO.f_id == 2 }">
            			테니스장
            		</c:when>
            		<c:when test="${ReviewVO.f_id == 3 }">
            			헬스장
            		</c:when>
            		<c:when test="${ReviewVO.f_id == 4 }">
            			DVD
            		</c:when>
            		<c:when test="${ReviewVO.f_id == 5 }">
            			문화강좌실
            		</c:when>
            	</c:choose>
            </c:if> </td>
            <td> ${ReviewVO.rev_contents } </td>
            <td> ${ReviewVO.rev_date } </td>
            <td> ${ReviewVO.rev_rate } </td>            
      		</tr>
     		</c:forEach> 
          </tbody>
        </table>
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
<div class="wrapper row5">
  <footer id="footer" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="one_quarter first">
      <h6 class="title">Viral</h6>
      <address class="btmspace-15">
      Company Name<br>
      Street Name &amp; Number<br>
      Town<br>
      Postcode/Zip
      </address>
      <ul class="nospace">
        <li class="btmspace-10"><span class="fa fa-phone"></span> +00 (123) 456 7890</li>
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
        <h2 class="nospace"><a href="#">Praesent Vestibulum</a></h2>
        <time class="smallfont" datetime="2045-04-06">Friday, 6<sup>th</sup> April 2045</time>
        <p>Vestibulumaccumsan egestibulum eu justo convallis augue estas aenean elit intesque sed.</p>
      </article>
    </div>
    <div class="one_quarter">
      <h6 class="title">Grab Our Newsletter</h6>
      <form method="post" action="#">
        <fieldset>
          <legend>Newsletter:</legend>
          <input class="btmspace-15" type="text" value="" placeholder="Name">
          <input class="btmspace-15" type="text" value="" placeholder="Email">
          <button type="submit" value="submit">Submit</button>
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
    <p class="fl_left">Copyright &copy; 2015 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
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
 <script type="text/javascript">

	$("#f_id").val();
</script> 
<style>
	.container .content {
    margin-left: 180px;
}
</style>
</body>
</html>