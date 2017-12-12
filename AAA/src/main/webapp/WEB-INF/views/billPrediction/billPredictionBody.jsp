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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>


<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">

<script src="/resources/layout/scripts/jquery.min.js"></script>


<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">



	var doubleArray;
    
    
	
	
	
	google.load("visualization", "1", {packages:["corechart"]});
	
	var qurter = "oneQ";
	function drawChart(titleArray){
       
		doubleArray = titleArray;
        console.log("doubleArray : "+ doubleArray );
		var data = google.visualization.arrayToDataTable(doubleArray);
		var options = {
		          title: '관리비 예측 (전기)'
		        };
		var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
		chart.draw(data, options);
	}
	
		var titleArray = new Array();
		titleArray.push(["year","높은 예상","낮은 예상","전기 사용량"]);
		
		$.ajax({
			type : 'GET',
			url : "/billPrediction/getPredictElec/" + "oneQ",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'json',
			success : function(result) {
				for(key in result){
					
					if( key == 'topAllElecAVG'){
						titleArray.push(['예상값',result['topAllElecAVG'],result['bottomAllElecAVG'],null]);
						break;
					}else{
						titleArray.push([key,result[key],result[key],result[key]]);
					}	
					console.log(titleArray);
				}
				google.setOnLoadCallback(drawChart(titleArray));
			}
		});
		
		
		



	
/* 	google.setOnLoadCallback(drawChart); */
	
	
	/* var firstArray = ['2004',400]; */
	
	
  
</script>

</head>
<body id="top">

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row2 bgded"
		style="background-image: url('resourcesimages/main/backgrounds/01.png');">
		<div class="overlay">
		
		
		
			<div id="breadcrumb" class="clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Lorem</a></li>
					<li><a href="#">Ipsum</a></li>
					<li><a href="#">관리비 예측</a></li>
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
			<!-- ################################################################################################ -->
			<div id="chart_div" style="width: 900px; height: 500px;"></div>


			<div class="clear"></div>
			</div>
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