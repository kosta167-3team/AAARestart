<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<html>
<head>
<title>AAA</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
<script type="text/javascript">
	function submit() {
		var etcs = new Array();
		alert("qweqwe");
		var stateObject = new Object();
		

		$('select[name=state] option:selected').each(function(index) {
			stateObject.state = $(this).attr('etc');
			stateObject.vr_id = $('.vr_id').eq(index).attr('value');
			$.ajax({
				url: "/visit/applicationCheck", 
				type: "POST",
				data: stateObject,
				dataType: "json"
			});
			history.go(0);
			console.log(index);
			//etcs.push(checkObject);
		});
	}
</script>

</head>
<body id="top">
	
	
	<div class="wrapper row2 bgded"
		style="background-image: url('/resources/images/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">방문객 신청 조회</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="wrapper row3">
		<main class="container clear"> <!-- main body -->
		<div class="sidebar one_quarter first">
			<h6>방문객</h6>
			<nav class="sdb_holder">
				<ul>
					<li><a href="#">방문 신청</a></li>
					<li><a href="#">신청내역 조회</a></li>
				</ul>
			</nav>
		</div>
		<div class="content three_quarter">
			<div id="comments">
				<h2>방문신청 내역</h2>
				<table>
					<thead>
						<tr>
							<th>방문객</th>
							<th>연락처</th>
							<th>방문 예정일</th>
							<th>방문 사유</th>
							<th>방문 승인</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="application">

							<tr>
								<td>${application.v_name}</td>
								<td>${application.v_tel}</td>
								<td>${application.v_date}</td>
								<td>${application.v_contents}</td>
								<td>
								
									<select id="state" name="state">
									<c:set var="data" value="${application.v_state}"/>
									<c:choose>
										<c:when test="${data == '거부'} ">
											<option etc="accept">승인</option>
											<option etc="denial" selected="selected">거부</option>		
										</c:when>
										
										<c:otherwise> 
											<option etc="accept"  selected="selected">승인</option>
											<option etc="denial">거부</option>	
										</c:otherwise>
									
									</c:choose>						
									</select>
									<input class="vr_id" type="hidden" value="${application.vr_id}">
								</td>

							</tr>

						</c:forEach>
						<tr>
							<td colspan="5"><input type="button" value="저장"
								onclick="submit();"></td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="text-center">
			<%-- 	<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a
							href="applicationList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="applicationList${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="applicationList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>

				</ul> --%>
			</div>
		</div>
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

	<!-- JAVASCRIPTS -->
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>