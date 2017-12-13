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
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS -->
<script src="/resources/layout/scripts/jquery.min.js"></script>
<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>

 



</script>
</body>
</html>