<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"> 
<script src="http://code.jquery.com/jquery-1.9.1.js"></script> 
</head>
<script type="text/javascript">
	
	function submit1() {
		var etcs = new Array();
		alert("qweqwe");
		var checkObject = new Object();

		$('select[name=check] option:selected').each(function(index) {
			checkObject.check = $(this).attr('etc');
			checkObject.vr_id = $('.vr_id').eq(index).attr('value');
			$.ajax({
				url : "/visit/checkUpdate",
				type : "POST",
				data : checkObject,
				dataType : "json"
			});
			history.go(0);
			console.log(index);
			//etcs.push(checkObject);
		});
	}
	function fn_search() {	
		var selectedDate = $('#datePicker').val();
		console.log(selectedDate)
		$.ajax({
			url : "/visit/searchApplication",
			type : "POST",
			data : selectedDate,
			dataType : "json",
			headers : {
				'Content-Type' : 'application/text'
			},
			success: function(data) {
				var html = "";
				$('.beforeTable').remove();
				$(data).each(function (index, item){
					html += '<tr class = "beforeTable">';
					html += '<td>' +  item.v_name + '</td>';
					html += '<td>' + item.v_tel + '</td>';
					html += '<td>' + item.v_date + '</td>';
					html += '<td>' + item.v_contents + '</td>';
					html += '<td><select name="check">';
					html += '<option etc="O" >O</option>';
					html += '<option etc="X" selected="selected">X</option>';
					html += '</select> <input class="vr_id" type="hidden" value=' + item.vr_id + '></td>';
				
					html +=	'</tr>';
					$('#visitManageBody').before(html);
				})
				
			}
		});
	}
</script>

<body id="top">
	
	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">방문신청 조회</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="wrapper row3">
		<main class="container clear"> <!-- main body -->
		<div class="content">
			<h1>방문객 조회</h1>

			<div id="comments">
				<form action="#" method="post">
				
					<div class="one_third first">
					</div>
					<div class="one_third">
					</div>
					<div class="one_third">
						<!-- <input type="date" onchange="fn_search()" name="url" id="datePicker" size="22"> -->
						<input id="datePicker" type="date" onchange="fn_search()" style="margin-bottom: 200px;">
					</div>
					
					<div id="comments">
						<table>
							<thead>
								<tr>
									<th>방문객</th>
									<th>연락처</th>
									<th>방문 예정일</th>
									<th>방문 사유</th>
									<th>방문 여부</th>
								</tr>
							</thead>
							<tbody>
							
								<tr id = "visitManageBody">
									<td colspan="5"><input type="button" value="저장"
										onclick="submit1();"></td>
								</tr>
								
							</tbody>
						</table>
					</div>
					<%-- <div class="text-center">
				<ul class="pagination">

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

				</ul>
			</div> --%>
				</form>
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
	<div class="wrapper row6">
		<div id="copyright" class="clear">
			<!-- ################################################################################################ -->
			<p class="fl_left">
				Copyright &copy; 2015 - All Rights Reserved - <a href="#">Domain
					Name</a>
			</p>
			<p class="fl_right">
				Template by <a target="_blank" href="http://www.os-templates.com/"
					title="Free Website Templates">OS Templates</a>
			</p>
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
</body>
</html>