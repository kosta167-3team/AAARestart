<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	#tt{
		width: 200px;
	}
</style>
<html>
<head>
<title>Viral | Pages | Sidebar Left</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body id="top">

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
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
					<li><a href="#">경매 조회</a></li>
				</ul>
				<!-- ################################################################################################ -->
			</div>
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row3">
		<main class="container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<div class="sidebar one_quarter first">
			<!-- ################################################################################################ -->
			 <h6> 경매 </h6>
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
			
			<c:if test="${login.r_id == 'wjdrl123' }">
				<h1>관리자</h1>
				 <input type="text" placeholder="입찰자 ID 입력 " class="button" size="20">
				 <br>
				 <input type="button" value="패널티 부여" class="button" size="10">
			<br><br>
			</c:if>
			
			<h1>입찰 목록</h1>
			<div class="scrollable">
				<table>
					<thead>
					
						<tr>
							<th>판매자</th>
							<th>상품이름</th>
							<th>입찰 시작가</th>
							<th>입찰 시작일</th>
							<th>경매 시간</th>
							<th>상품평</th>
			
						</tr>
						
					</thead>
					<tbody>
						<c:forEach var="BidProductVO" items="${list }">
						
							<tr id="${BidProductVO.bid_id }">

								<td>${BidProductVO.bid_seller }</td>
								<td>${BidProductVO.bid_name }</td>
								<td>${BidProductVO.bid_start }</td>
								<td>${BidProductVO.bid_date }</td>
								<td >${BidProductVO.bid_time }</td>
								<td >
								<div id="test123"></div>
									<c:set var="data" value="${BidProductVO.bid_evaluation }" /> 
									<c:choose>
										<c:when test="${data != null}">
            								${BidProductVO.bid_evaluation }
          							  	</c:when>

										<c:otherwise>
											<input type="button" value="상품평 쓰기" 
												onclick="window.open('bidEvaluation?bid_id=${BidProductVO.bid_id}',
												'window','left=500,top=100,width=400,height=400');">
										</c:otherwise>
									</c:choose></td>
								
								
								
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
			
			<br><br>
			
			<h1>패널티</h1>
			
			<table id="tt">
				<thead>
					<tr>
						<th  >패널티</th>
						<th >점수</th>
						
						
					</tr>
				</thead>
				<tbody>
				
					<tr>
						<td>${login.r_id }</td>
						<%-- <td>${list.get(0).bid_seller }</td> --%>
						<td>2</td>
					</tr>
				
				</tbody>
			
			</table>
			
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

	<script type="text/javascript">
	 /* 	var result = '${msg}';

		if (result == 'SUCCESS') {
			alert("처리됨");
		}  */
	
	
	</script>
</body>
</html>