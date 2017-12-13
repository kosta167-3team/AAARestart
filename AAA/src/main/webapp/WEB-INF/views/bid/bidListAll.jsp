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
<style>
	li {
		font-size: 18px;
	}
	.one_quarter{
	font-size:14px;
	}
</style>
<html>
<head>
<title>Viral | Pages | Gallery</title>
   	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
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
        <li><a href="#">경매 리스트</a></li>
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
      		


            <li class="one_quarter" name="imageList">
            <a>
            <img src="/bid/displayFile?fileName=${BidProductVO.bid_filename }"
             etc="${BidProductVO.bid_id }" id="bid_filename" class="bid_filename"  alt="" width="800" height="800"></a>
            <p id="bid_seller">판매자 : ${BidProductVO.bid_seller }</p>
            <p id="bid_name">상품 이름 : ${BidProductVO.bid_name }</p>
            <p id="bid_start" >가격 : ${BidProductVO.bid_nowprice }</p>            

            
            &nbsp;&nbsp;&nbsp;&nbsp;
             <c:if test="${login.r_id == BidProductVO.bid_seller || login.r_id == BidProductVO.admin}">
            <input type="button" value="수정" class="button" size="10"
            onClick="location.href='/bid/bidmodify?bid_id=${BidProductVO.bid_id }'">
            
            &nbsp;&nbsp;&nbsp;
           
            <input type="button" value="삭제" class="button"
            onClick="location.href='/bid/bidremove?bid_id=${BidProductVO.bid_id }'">
			</c:if>

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
  height:28px;
  font-size:1em;
  padding:0.1em 0.7em 0.5em 0.7em;
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
  		width: 180px;
    height: 320px;
  	}
  	
 #bid_filename{
 	width:200px;
 	height:150px;
 }
  	
    </style>
    
    

	
</body>
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
    				html+='<p> 상품가격 : ' + item.bid_nowprice + '</p>';

    				html+='<input type="button" value="수정" class="button" id="gg">';
    				html+='&nbsp;&nbsp;&nbsp;&nbsp'
    				html+='<input type="button" value="삭제" class="button" ></li>';
    			});
    			$('.nospace_clear').append(html);
    		}
    	});   		
    });
    
    

    
    $("#gg").on("click",function(){
    	console.log("gg11");
    	 onClick="location.href='/bid/bidmodify?bid_id=${BidProductVO.bid_id }'";
    });     

	$('.bid_filename').on('click', function(){
		//location.href="/bidder/bidDetail?bid_id=" +$(this).attr('etc');
		var detail=$(this).attr('etc');
		console.log(detail);
		location.href="/bid/bidDetail/"+detail;
	})

    </script>
</html>