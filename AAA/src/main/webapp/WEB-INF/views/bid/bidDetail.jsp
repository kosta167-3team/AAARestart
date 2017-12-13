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
				<!-- 사진이 안나온드아~~ -->
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
				<br>
				
				</li>
					<li class="one_third"><input type="button" value="입찰하기" class="bidButton"></li>
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
	var hhRound; 
	var mmRound; 

	function getTime() {
		var date = new Date();
		date = "${bidProduct.bid_date }";
		var remainTime = new Date(); // 남은 시간
		var bidTime = new Date(); // 경매 시작시간
		var split = date.split(' '); // split : 날짜 / 시간 구분
		var splitDate = split[0].split('-'); // splitDate : 년 / 월 / 일로 구분
		var splitTime = split[1].split(':'); // splitTime : 시 / 분 / 초로 구분
		bidTime.setFullYear(splitDate[0]); // 경매 시간 세팅
		bidTime.setMonth(splitDate[1]-1);
		bidTime.setDate(splitDate[2]);
		bidTime.setHours(eval(parseInt(splitTime[0]) + parseInt(${bidProduct.bid_time})));
		bidTime.setMinutes(splitTime[1]);
		bidTime.setSeconds(splitTime[2]);
		var now = new Date();
		remainTime = (bidTime-now)/1000/60/60/24;
		var ddate = date.split(' '); 
		var bid_time = ${bidProduct.bid_time };
		var year = splitDate[0];
		var month = splitDate[1]-1;
		var day = splitDate[2];
		var hour = eval(parseInt(splitTime[0]) + parseInt(${bidProduct.bid_time}));
		var minute = eval(parseInt(splitTime[1]) + (parseInt(${bidProduct.addTime })*5));
		var secondss = splitTime[2];
		var dday = new Date(parseInt(year), parseInt(month), parseInt(day), parseInt(hour),parseInt(minute), parseInt(secondss)); // 원하는 날짜, 시간 정확하게 초단위까지 기입.
		var days = (bidTime - now) / 1000 / 60 / 60 / 24;
		var dRound = Math.floor(days);
		var hours = (bidTime - now) / 1000 / 60 / 60 - (24 * dRound); 
		 
		var hRound = Math.floor(hours); 
		hhRound = hRound;
		var minutes = (dday - now) / 1000 /60 - (24 * 60 * dRound) - (60 * hRound); 
		var mRound = Math.floor(minutes); 
		mmRound = mRound;
		var seconds = (dday - now) / 1000 - (24 * 60 * 60 * dRound) - (60 * 60 * hRound) - (60 * mRound); 
		var sRound = Math.round(seconds);
		if((bidTime-now) <= 0) {
			var obj = new Object();
			var bid_id = ${bidProduct.bid_id};
			obj.bid_id = ${bidProduct.bid_id};
			alert(obj.bid_id);
			$.ajax({
				type:"GET",
				url:"/bid/updateBidState",
				dataType:"json",
				data: obj,
				contentType : "application/json; charset=utf-8",
				success:function(data){
					alert("해당 상품을 경매 시간이 종료되었습니다.");
					location.href="/bid/bidListAll";
				}
			});
		} else {
			//document.getElementById("counter1").innerHTML = dRound; 
			document.getElementById("counter2").innerHTML = hRound; 
			document.getElementById("counter3").innerHTML = mRound; 
			document.getElementById("counter4").innerHTML = sRound;
			newtime = window.setTimeout("getTime();", 1000);  
		}
		
	};
	
	$('.addBidTime').on('click', function() {
	//location.href="/bidder/bidDetail?bid_id=" +$(this).attr('etc');
	var obj = new Object();
	obj.bid_id = ${bidProduct.bid_id};
	if($(".addTimeCount").attr('value') >= 5 && ${r_id != bidProduct.bid_seller}) {
		alert("추가 횟수(5회)를 모두 사용하였습니다.");
	} else if(!(hhRound == 0 && mmRound <= 9)) {
		alert("시간 연장은 종료 10분전에 가능합니다.");
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
	
	$('.bidButton').on('click', function() {
		var bid_id = ${bidProduct.bid_id};
		var nowPrice = ${bidProduct.bid_nowprice};
		console.log("qwe");
		 window.open("/bid/inputBidPrice/"+bid_id+"/"+nowPrice, "a", "width=400, height=300, left=100, top=50"); 
	})
	
</script>
<script>getTime();</script>
</html>