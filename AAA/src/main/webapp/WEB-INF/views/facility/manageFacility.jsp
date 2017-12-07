<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- 달력 위젯 jquery -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />

<!-- <script src="/resources/layout/scripts/facility/manageFacility.js"></script> -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="/resources/layout/scripts/facility/date.js"></script>

<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">


</head>
<body id="top">

	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">시설 관리</a></li>
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
		<div class="content">
			<h1>현재 시설 상태</h1>
			<div class="scrollable">
				<table>
					<thead>
						<tr>
							<c:forEach var="facilityList" items="${facilityList}">
								<th>${facilityList.f_name }</th>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="facilityList" items="${facilityList}">
								<td>${facilityList.f_state }</td>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>

			<label for="url">&nbsp;</label><label for="url">&nbsp;</label>
			<h1>시설 관리 내역</h1>
			<div class="scrollable" id="state">
				<select id="category" name="category" style="width: 100px; height: 30px;">
					<option value="0">전체</option>
					<c:forEach var="facilityList" items="${facilityList}">
						<option value="${facilityList.f_id }">${facilityList.f_name }</option>
					</c:forEach>
				</select> <label for="url">&nbsp;</label>
				<table>
					<thead>
						<tr>
							<th>기간</th>
							<th>시설</th>
							<th>사유</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="stateList" items="${stateList}">
							<tr id="${stateList.fs_id }">
								<td style="width:20%;">${stateList.fs_start  }~${stateList.fs_end }</td>
								<td style="width:20%;">${stateList.f_name}</td>
								<td style="width:53.5%;">${stateList.fs_reason}</td>
								<td style="width: 6.5%;"><button class="cancel" value="${stateList.fs_id }">취소</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


			<script type="text/javascript">
$('#category').on('change', function () {
	 
	  var f_id = $(this).val();
			
	 $.ajax({
		url:"/facility/getCategoryList/"+f_id,
		success:function(data){
			
	  		$('#state').find('tbody').empty();
			$('#pagination').empty();
			
			var stateList = data.stateList;
			var pageMaker = data.pageMaker;
			var cri = pageMaker.cri;
			
			printStateList(stateList);
			
			printPagination(pageMaker,cri);
			}
		})  
	 
})
	 
</script>



<script type="text/javascript">

$('#state').on('click', '.cancel', function() {
	
	var fs_id = $(this).val();
	var page = $('#pagination li[class=current]').find('a').attr('value'); 
	var f_id =$('#category').val();
	
	if(confirm("취소하시겠습니까?")){
	
	$.ajax({
		url:"/facility/deleteState/"+f_id+"/"+page+"/"+fs_id,
		success:function(data){
			
			$('#state').find('tbody').empty(); 
			$('#pagination').empty();

			var stateList = data.stateList_page;
			var pageMaker = data.pageMaker;
			var cri = pageMaker.cri;
			 			
			printStateList(stateList);
			
			printPagination(pageMaker,cri);
			
			}
		})
	}
})
</script>
			<nav class="pagination" id="pagination">
				<ul>
					<c:if test="${pageMaker.prev }">
						<li><a href="#">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="index">
						<li
							<c:out value="${pageMaker.cri.page == index?'class=current':''}"/>><a
							href="#" value="${index }">${index }</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
						<li><a href="#" value="${pageMaker.endPage+1 }">&raquo;</a></li>
					</c:if>
				</ul>
			</nav>

			<script type="text/javascript">
	$('#pagination').on('click', 'a', function() {
		
		event.preventDefault();
				
		var page = $(this).attr('value');
		var f_id = $('#category').val();
		 		
		$.ajax({
				url:"/facility/manageFacility/"+f_id+"/"+page,
				success: function(data) { 
					
					$('#state').find('tbody').empty(); 
					$('#pagination').empty();
  
					var stateList = data.stateList_page;
					var pageMaker = data.pageMaker;
					var cri = pageMaker.cri;
					 
					printStateList(stateList);
					
					printPagination(pageMaker,cri);
									
				}
		})  
		
	}) 
	
	
	
 	function printPagination(pageMaker,cri){
	var str ="";
	
	if(pageMaker.prev){
		str+='<li><a href="#">&laquo;</a></li>';
	}
	for(var index = pageMaker.startPage, len = pageMaker.endPage; index<=len; index++){
		var Class = pageMaker.cri.page == index?'class = current':'';
		
		str += '<li '+Class+'><a href="#" value="'+index+'">'+index+'</a></li>';
		
	}
	
	if(pageMaker.next){
		str += '<li><a href="#" value="'+pageMaker.endPage+1+'">&raquo;</a></li>';
	}
	
	$('#pagination').append(str);
} 
	
	
	
	function printStateList(stateList) {

		var html= "";
		 		
		$.each(stateList, function(index, s){ 
			 
			html+= '<tr id="'+s.fs_id+'">';
			html+= '<td style="width:20%;">'+s.fs_start+' ~ '+s.fs_end +'</td>';
			html+= '<td style="width:20%;">'+s.f_name+'</td>'; 
			html+= '<td style="width:53.5%;">'+s.fs_reason+'</td>';
			html+= '<td style="width:6.5%;"><button class="cancel" value="'+s.fs_id+'">취소</button></td></tr>'; 						
		})
		
		$('#state').find('tbody').append(html);
	}
	
	
	</script>

			<div id="comments">
				<label for="url">&nbsp;</label><label for="url">&nbsp;</label>
				<h2>시설 관리</h2>
				<form action="#" method="post">

					<div class="one_third first">
						<label for="f_name">시설 <span>*</span></label> <select id="f_id"
							name="f_id" style="width: 300px; height: 40px;">
							<c:forEach var="facilityList" items="${facilityList}">
								<option value="${facilityList.f_id }">${facilityList.f_name }</option>
							</c:forEach>
						</select>

					</div>
					<div class="one_third">
						<label for="fs_start">기간 <span>*</span></label> <input type="text"
							id="fs_start" name="fs_start" size="22">
					</div>
					<div class="one_third">
						<label for="url">&nbsp;</label> <input type="text" id="fs_end"
							name="fs_end" size="22">
					</div>
					<div class="block clear">
						<label for="comment">사유 <span>*</span></label>
						<textarea name="fs_reason" id="fs_reason" cols="25" rows="10"
							placeholder="사용 불가 사유가 쪽지로 전송됩니다."></textarea>
					</div>
					<div>
						<input name="submit" type="submit" value="확인" id="submit" />
						&nbsp; <input name="reset" type="reset" value="내용 지우기">
					</div>
				</form>
			</div>




			<script type="text/javascript">
					$("#fs_start").datepicker({
						showButtonPanel : false,
						dateFormat : "yy-mm-dd",
						altField : '#fs_start',
						minDate: 0,
						onSelect: function(selected) {
							$("#fs_end").datepicker("option","minDate", selected)
							}
					});
					
					$("#fs_end").datepicker({
						showButtonPanel : false,
						dateFormat : "yy-mm-dd",
						altField : '#fs_end',
						minDate: 0						
					});
				
				$('#submit').on("click", function() {
					
					event.preventDefault();	
							 
					var fs_start = $("fs_start").val();
					var fs_end = $("fs_start").val();
					var fs_reason = $('#fs_reason').val();
					
					if(fs_start=="" || fs_end==""||fs_reason==""){
						alert("전부 입력해주세요!");
						return;
					}					
			
					var popupX = (window.screen.width/2) - (400/2);
					var popupY= (window.screen.height/2) - (400/2);
					
					window.open('/facility/changePopup','childWindow', 'status=no, height=200, width=400, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
		});
								
			</script>

		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>

	<!-- ################################################################################################ -->
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<!-- 	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script> -->
</body>
</html>