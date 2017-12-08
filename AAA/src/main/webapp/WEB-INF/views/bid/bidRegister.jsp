<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@page import="java.util.List"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

 
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

	<style>
.fileDrop {
  width: 80%;
  height: 100px;
  border: 1px dotted gray;
  background-color: lightslategrey;
  margin: auto;
  
  
 
}

.error{
      color: #ff0000;
   }
</style>


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
        <li><a href="#">경매 등록</a></li>
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
      <h6>경매</h6>
       <nav class="sdb_holder">
        <ul>
          <li><a href="/bid/bidListAll">경매 리스트</a></li>
          <li><a href="/bid/bidRegister">경매 등록</a></li>
            
         
          <li><a href="/bid/bidRead">경매 조회</a></li>
        </ul>
      </nav>
     
      
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- ################################################################################################ -->
    <div class="content three_quarter"> 
      <!-- ################################################################################################ -->
		

	
      <div id="comments">

        <h2>경매 등록</h2>
        <form:form commandName="BidProductVO" action="bidRegister" method="post" enctype="multipart/form-data">
			 <div class="form-group">
			 	<input type='file' name='file'>
			</div> 

         <%--  <div class="one_third first">
            <label for="name">판매자 <span>*</span></label>
            <form:input type="text" path="bid_seller" name="bid_seller" id="name" value="" size="22"/>
          	<form:errors path="bid_seller" cssClass="error"/>
          </div> --%>
          <div class="one_third first">
            <label for="email">상품이름 </label>
            <form:input type="text" path="bid_name" name="bid_name" id="email" value="" size="22"/>
            <form:errors path="bid_name" cssClass="error"/>
          </div>
          <div class="one_third">
            <label for="url">입찰 시작가</label>
            <input type="text" name="bid_start" id="url" value="" size="22"/>
            
          </div>
          <div class="one_third">
            <label for="url">경매 시간</label>
            <input type="text" name="bid_time" id="url" value="" size="22"/>
            
          </div>
          
           
          <div class="block clear">
            <label for="comment">내용</label>
            <form:textarea name="bid_content" path="bid_content" placeholder="자세히 작성해주세요 " id="comment" cols="25" rows="10"/></textarea>
            <form:errors path="bid_content" cssClass="error"/>
          </div> 
         
          <button type="submit" class="btn btn-primary">등록</button>
        </form:form>
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

 



</script>
</body>
</html>