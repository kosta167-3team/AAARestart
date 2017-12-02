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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>

<style type="text/css">
#month_list{
	display: none;
}
#save_tile_one{
border-radius: 10px;
display: inline-block;
padding : 10px;
	background-color: #2898c4;
}

#header_article{
margin-bottom: 40px;
}
#save_tile_one{

}


#save_tile_one > p{
	font-size:20px;
	color: white;
	display: inline;
}
#save_tile{
	margin-top: 6.55%;
	float:left;
	display: inline-block;
}

#header_article{
	border-radius: 10px;
	background-color: #ededed;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-right: 5px;
}
#payment_content{
	width:67.8%;
	padding-top:-10%;
	border-radius: 11px;
	background-color: white;
	display: inline-block;
	color : black;
}
#payment_content p{
font-size: 15pt;
padding-left: 15px;
}
#payment_content button{
	margin-left: 15px;
	margin-bottom: 14px;
	margin-top: 2px;
}

#payment_p{
	margin-bottom: 10px;
}
#p_year, #p_month, #p_date{
	color:#2898c4;
	display: inline;
}
#payment_content p{

}
#payment_endDate_in{
	display: inline;
}
#payment_endDate{
padding:10px;
	padding-right:20px;
	padding-left:10px;
	display: inline-block;
	margin-top:3%;
	float: left;
}
#payment_endDate p:first-child{
	color: black;
	display: block;
	text-align: center;
	font-size: 15pt;
	font-weight: bold;
}

#detail_content{
	position: absolute;
}
#table_payment{
	
}




</style>



<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="/resources/images/bill/css/billMonth.css" rel="stylesheet" type="text/css">
<script src="/resources/layout/scripts/jquery.min.js"></script>
<script src="/resources/images/bill/js/billBody.js"></script>

</head>
<body id="top">

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2 bgded" style="background-image:url('resourcesimages/main/backgrounds/01.png');">
  <div class="overlay">
    <div id="breadcrumb" class="clear"> 
      <!-- ################################################################################################ -->
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">Lorem</a></li>
        <li><a href="#">Ipsum</a></li>
        <li><a href="#">관리비 조회</a></li>
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
    <div class="content"> 
      <!-- ################################################################################################ -->

			<div id="select_month">
				<p id="select_month_content">${billMonth.p_month}</p>
				<a data-rno="${billMonth.p_month}" id="select_month_btn" href="">
				<img src="/resources/images/bill/img/arw_select.png"> </a>
				<div id="month_list">
				</div>
			</div>

			<div id="header_article">
				<div id="save_tile">
					<div id="save_tile_one">
						<p>D - ${paymentDate }</p>
						<p>납기내</p>
					</div>


				</div>
				<div id="payment_endDate">
					<div id="payment_endDate_in">
						<p>납부 마감일</p>
						<p id="p_year" data-rno="${dateMap.year }">${dateMap.year }년</p>
						<p id="p_month" data-rno="${dateMap.month }">${dateMap.month }
							월</p>
						<p id="p_date" data-rno="${dateMap.date }">${dateMap.date }일</p>

					</div>
				</div>

				<div id="payment_content">
					<p id="content_month">${dateMap.month }월부과금액</p>
					<p id="content_monthP">${allBill } 원</p>
					<p id="payment_p">${dateMap.year }년${dateMap.month } 월
						${dateMap.date }일</p>
					<button id="payment_detail" data-rno="${billMonth.u_id }"
						value="${billMonth.p_month }">상세보기</button>
				</div>
				
			</div>
			<div id="detail_content">
				
				</div>

			<h1> 관리비 항목 상세 </h1>
			<div id="payment_details" class = "scrollable">
				<table id="selectDetailTable">

					<tr class = 'table_title'>
						<td>항목</td>
						<td>당월</td>
						<td>전월</td>
						<td>증감</td>
					</tr>

					<c:forEach var="bill" items="${billSerise }">
					<tr>
						<td><a href="" class="selectDetail" data-rno1 = "${billMonth.p_month }" data-rno="${bill.listName }"> ${bill.listName }</a></td>
						<td>${bill.monthBill }</td>	
						<td>${bill.preMonthBill} </td>
						<td>${bill.compareBill} </td>
					</tr>
					
					</c:forEach>
					

				</table>

			</div>
			<div id="selectDetailDiv">
			
			</div>

    <div class="clear"></div>
  </main>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS -->

<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>

</body>
</html>