<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  




<!DOCTYPE html>
<!--
Template Name: Viral
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html>
<head>
<title>Viral | Pages | Gallery</title>
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
        <li><a href="/resources/index.html">Home</a></li>
        <li class="active"><a class="drop" href="#">Pages</a>
          <ul>
            <li class="active"><a href="gallery.html">Gallery</a></li>
            <li><a href="full-width.html">Full Width</a></li>
            <li><a href="sidebar-left.html">Sidebar Left</a></li>
            <li><a href="sidebar-right.html">Sidebar Right</a></li>
            <li><a href="basic-grid.html">Basic Grid</a></li>
          </ul>
        </li>
        <li><a class="drop" href="#">Dropdown</a>
          <ul>
            <li><a href="#">Level 2</a></li>
            <li><a class="drop" href="#">Level 2 + Drop</a>
              <ul>
                <li><a href="#">Level 3</a></li>
                <li><a href="#">Level 3</a></li>
              </ul>
            </li>
          </ul>
        </li>
        <li><a href="#">Link Text</a></li>
        <li><a href="#">Link Text</a></li>
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
        <li><a href="#">Gallery</a></li>
      </ul>
      <!-- ################################################################################################ -->
    </div>
  </div>
</div>




<!-- <div class='popup back' style="display:none;"></div>
    <div id="popup_front" class='popup front' style="display:none;">
     <img id="popup_img">
    </div> -->




<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
     <div class="sidebar one_quarter first"> 
     
      <h6> 경매 </h6>
      <nav class="sdb_holder">
        <ul>
          <li><a href="/bid/bidListAll">경매 리스트</a></li>
          <li><a href="/bid/bidRegister">경매 등록</a></li>
          <li><a href="/bid/bidRead">경매 조회</a></li>
        </ul>
      </nav>
      
     
     
    </div> 
    <!-- ################################################################################################ -->
     <div class="content three_quarter">
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">경매 리스트</header>
        	<!-- <select id="select" size="1" onChange="setValues();">
        		<option value="1">낮은가격순</option>
        		<option value="2">날짜 순</option>
        	</select><br><br> -->
        	
        	<!-- <input id="orderprice" type="button" value="낮은가격 순"> -->
        	<a href='#' class="sort" >가격 순</a>
        	<a href='#' class="sort" >날짜 순</a>
        
         <!-- onclick="return price()" -->
         <br><br>
         
          <ul class="nospace_clear">
            <c:forEach var="BidProductVO" items="${listAll }">                     
      		

            <li class="one_quarter" name="imageList"><a href="/bid/bidDetail?bid_id=${BidProductVO.bid_id}">
            <img src="/bid/displayFile?fileName=${BidProductVO.bid_filename }" 
            id="bid_filename"  alt="" width="800" height="800"></a>
            <p id="bid_seller">판매자 : ${BidProductVO.bid_seller }</p>
            <p id="bid_name">상품 이름 : ${BidProductVO.bid_name }</p>
            <p id="bid_start" >가격 : ${BidProductVO.bid_start }</p>            
            
            <input type="button" value="수정" class="button"
            onClick="location.href='/bid/bidmodify?bid_id=${BidProductVO.bid_id }'">
            
            &nbsp;&nbsp;&nbsp;
            
            <input type="button" value="삭제" class="button"
            onClick="location.href='/bid/bidremove?bid_id=${BidProductVO.bid_id }'">


            <%--  <a href='/bid/bidmodify?bid_id=${BidProductVO.bid_id }'>수정
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> 
             <a href='/bid/bidremove?bid_id=${BidProductVO.bid_id }'>삭제</a> --%>


          	</li>
     		  </c:forEach> 
          </ul>
         
        </figure>
      </div>
      <!-- ################################################################################################ -->
      <!-- ################################################################################################ -->
     
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



<script type="text/javascript" src="/resources/js/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

 <style type="text/css">
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     .show{
       position:relative;
       max-width: 1200px; 
       max-height: 800px; 
       overflow: auto;       
     } 
     .button{
  background:#FF8000;
  color:#fff;
  border:none;
  position:relative;
  height:20px;
  font-size:1em;
  padding:0 1em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
  display:inline;
}
.button:hover{
  background:#fff;
  color:#FF8000;
}
.button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
.button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
.button:hover:before,button:hover:after{
  width:40%;
  transition:800ms ease all;
}
  	
  	li.one_quarter{
  		border-bottom:1px solid #c8c8c8;
  		border-top:1px solid #c8c8c8;
  		border-left:1px solid #c8c8c8;
  		border-right:1px solid #c8c8c8;
  		padding: 7px;
  	}
  	
 #bid_filename{
 	width:200px;
 	height:150px;
 }
  	
    </style>
    
    <script>
    $(".sort").on("click",function(){
    	var sort= $(this).html();
    	var obj = new Object();
    	obj.sort = $(this).html();
    	alert(sort);
    	$.ajax({
    		type:"post",
    		url:"/bid/bidread2",
    		dataType:"json",
    		data: obj,
    		
    		success:function(data){
    			var html="";
    			$("li[name=imageList]").remove();
    			$(data).each(function(index,item){
    				html+='<li class = "one_quarter" name="imageList">';
    				html+='<a> <img src="/bid/displayFile?fileName='+item.bid_filename+
    						'" id="bid_filename" alt="" width="800" height="400"></a>';
    				html+='<p> 판매자 : ' + item.bid_seller  + '</p>';
    				html+='<p> 상품이름 : ' + item.bid_name  + '</p>';
    				html+='<p> 상품가격 : ' + item.bid_start + '</p>';
    				html+='<input type="button" value="수정" class="button" id="gg">';
    				html+='&nbsp;&nbsp;&nbsp;&nbsp'
    				html+='<input type="button" value="삭제" class="button" ></li>';
    			});
    			$('.nospace_clear').append(html);
    		}
    	});   		
    });
    
    
    
    $(".nospace_clear").on("click",'#gg',function(){
    	console.log("gg11");
    	location.href('/bid/bidmodify?bid_id=${BidProductVO.bid_id}');
    });
    
    $(".bid_product").on("click", function() {
    	console.log("123123");
    })
    

	
</body>
</html>