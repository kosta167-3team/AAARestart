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
<html>
<head>
<style type="text/css">

</style>
<title>AAA</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link href="/resources/layout/styles/layout.css" rel="stylesheet">
</head>

<body id="top">

	<div class="wrapper row3">
		<main class="container clear"> <!-- main body -->
		<div class="group">
			<div class="one_third first">
				<img src="/resources/images/main/460x700.png" alt="">
			</div>
			<div class="two_third">
				<h2 class="heading">${bidProduct.bid_name }</h2>
				<h4>판매 시작가 : ${bidProduct.bid_start }</h4>
				<h4>현재 입찰가 : ${bidProduct.bid_nowprice }</h4
				
				>
				<a> 입찰 현황보기</a>
				<h3 class="btmspace-80">
					남은 입찰 시간 :
					<div id=count>
						<SPAN id=counter2></SPAN>시간 <SPAN id=counter3></SPAN>분 <SPAN
							id=counter4></SPAN>초 남음
					</div>
				</h3>
				
				<ul class="nospace group">
				<li>
				<p class="addTimeCount" value = "${bidProduct.addTime }">경매 시간 연장 횟수 : ${bidProduct.addTime }</p>
				<button class="addBidTime">입찰 시간 추가</button>
				</li>
					<li class="one_third"><input type="button" value="입찰하기"></li>
				</ul>
			</div>
			<!--// content-->
		</div>
	</div>
	<br />	
	<!-- JAVASCRIPTS -->


	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
		type="text/javascript"></script>
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
</body>


<script type="text/javascript">
var hour=0;
var hRound=0;
	function getTime() { 
		var now = new Date();  
		var date = "${bidProduct.bid_date }";
		var ddate = date.split(' '); 
	
		console.log("등록 시간 : " + "${bidProduct.bid_date }");
		var year = date.substring(0, 4);
		var month = date.substring(5, 7);
		var day = date.substring(8, 10);
		hour = date.substring(11, 13);
		var minute = eval(parseInt(date.substring(14, 16)) + (parseInt(${bidProduct.addTime })*5));
		var secondss = date.substring(17, 19);
		var dday = new Date(parseInt(year), parseInt(month), parseInt(day), parseInt(hour),parseInt(minute), parseInt(secondss)); // 원하는 날짜, 시간 정확하게 초단위까지 기입.
		var days = (dday - now) / 1000 / 60 / 60 / 24; 
		var dRound = Math.floor(days);
		var hours = (dday - now) / 1000 / 60 / 60 - (24 * dRound); 
	
		hRound = Math.floor(hours); 
		var minutes = (dday - now) / 1000 /60 - (24 * 60 * dRound) - (60 * hRound); 
		var mRound = Math.floor(minutes); 
		var seconds = (dday - now) / 1000 - (24 * 60 * 60 * dRound) - (60 * 60 * hRound) - (60 * mRound); 
		var sRound = Math.round(seconds);
		 console.log(dRound + " "+ hRound + ":"+ mRound + ":"+ sRound + ":");	
		//document.getElementById("counter1").innerHTML = dRound; 
		document.getElementById("counter2").innerHTML = hRound; 
		document.getElementById("counter3").innerHTML = mRound; 
		document.getElementById("counter4").innerHTML = sRound;
		newtime = window.setTimeout("getTime();", 1000);  
	};
	
	$('.addBidTime').on('click', function() {
	//location.href="/bidder/bidDetail?bid_id=" +$(this).attr('etc');
	var obj = new Object();
	obj.bid_id = ${bidProduct.bid_id};
	if($(".addTimeCount").attr('value') >= 5 && ${r_id != bidProduct.bid_seller}) {
		alert("추가 횟수(5회)를 모두 사용하였습니다.");
	} else {
		$.ajax({
			type:"get",
			url:"/bid/addBidTime",
			dataType:"json",
			data: obj,
			contentType : "application/json; charset=utf-8",
			success:function(data){
				history.go(0);
			}
		}); 
	}
	
});
	
	
</script>
<SCRIPT>getTime();</SCRIPT>
</html>