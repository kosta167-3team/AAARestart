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
HTML  CSS  JS  Result
Edit on 
* {
	margin: 0;
	padding: 0;
}

body {
	margin: 100px;
}

.pop-layer .pop-container {
	padding: 20px 25px;
}

.pop-layer p.ctxt {
	color: #666;
	line-height: 25px;
}

.pop-layer .btn-r {
	width: 100%;
	margin: 10px 0 20px;
	padding-top: 10px;
	border-top: 1px solid #DDD;
	text-align: right;
}

.pop-layer {
	display: none;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 410px;
	height: auto;
	background-color: #fff;
	border: 5px solid #3571B5;
	z-index: 10;
}

.dim-layer {
	display: none;
	position: fixed;
	_position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 100;
}

.dim-layer .dimBg {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
}

.dim-layer .pop-layer {
	display: block;
}

a.btn-layerClose {
	display: inline-block;
	height: 25px;
	padding: 0 14px 0;
	border: 1px solid #304a8a;
	background-color: #3f5a9d;
	font-size: 13px;
	color: #fff;
	line-height: 25px;
}

a.btn-layerClose:hover {
	border: 1px solid #091940;
	background-color: #1f326a;
	color: #fff;
}
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
				<h3>판매 시작가 : ${bidProduct.bid_start }</h3>
				<h3>현재 입찰가 : ${bidProduct.bid_nowprice }</h3>
				<a> 입찰 현황보기</a>
				<h3 class="btmspace-80">ㅂㅈㄷ</h3>
				<h3 class="btmspace-80">남은 입찰 시간 : 
				<DIV id=count><SPAN id=counter1></SPAN>일<SPAN id=counter2></SPAN>시간<SPAN id=counter3></SPAN>분<SPAN id=counter4></SPAN>초 남음<SPAN style="padding-left:30px;"></SPAN></div>
</h3>
				<ul class="nospace group">
					<li class="one_third first"><a href="#" class="btn-layerClose">Close</a>
			</div>
			<!--// content-->
		</div>
	</div>
	</div>
	<br />
	<br />
	<a href="#layer2" class="btn-example">딤처리 팝업레이어 1</a>
	<div class="dim-layer">
		<div class="dimBg"></div>
		<div id="layer2" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts">
					<!--content //-->
					<p class="ctxt mb20">
						Thank you.<br> Your registration was submitted successfully.<br>
						Selected invitees will be notified by e-mail on JANUARY 24th.<br>
						<br> Hope to see you soon!
					</p>

					<div class="btn-r">
						<a href="#" class="btn-layerClose">Close</a>
					</div>
					<!--// content-->
				</div>
			</div>
		</div>
	</div>
	</li>
	<li class="one_third"><input type="button" value="입찰하기"></li>
	<li class="one_third last"><input type="button" value="입찰하기">
	</li>
	</ul>
	</div>
	</div>
	<!-- / main body -->
	<div class="clear"></div>
	</main>
	</div>
	<div class="wrapper row4">
		<section id="info" class="clear">
			<div class="clear"></div>
		</section>
	</div>
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
		type="text/javascript"></script>
	<script src="/resources/layout/scripts/jquery.min.js"></script>
	<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
	<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>
</body>
<script type="text/javascript">
$('.btn-example').click(function(){
    var $href = $(this).attr('href');
    layer_popup($href);
});
function layer_popup(el){

    var $el = $(el);        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-layerClose').click(function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });

    $('.layer .dimBg').click(function(){
        $('.dim-layer').fadeOut();
        return false;
    });

}
</script>
<script type="text/javascript">

	function getTime() { 
		var now = new Date();  
		 var date = "${bidProduct.bid_date }";
		var ddate = date.split(' '); 
	
		console.log("${bidProduct.bid_date }");
		 var year = date.substring(0, 4);
		
		var month = date.substring(5, 7);
		var day = date.substring(8, 10);
		var hour = eval(parseInt(date.substring(11, 13)) + parseInt(${bidProduct.bid_time }));
		var minute = date.substring(14, 16);
		var secondss = date.substring(17, 19);
		var dday = new Date(parseInt(year), parseInt(month), parseInt(day), parseInt(hour),parseInt(minute), parseInt(secondss)); // 원하는 날짜, 시간 정확하게 초단위까지 기입.
		var days = (dday - now) / 1000 / 60 / 60 / 24; 
		var dRound = Math.floor(days); 
		var hours = (dday - now) / 1000 / 60 / 60 - (24 * dRound); 
		
		var hRound = Math.floor(hours); 
		var minutes = (dday - now) / 1000 /60 - (24 * 60 * dRound) - (60 * hRound); 
		var mRound = Math.floor(minutes); 
		var seconds = (dday - now) / 1000 - (24 * 60 * 60 * dRound) - (60 * 60 * hRound) - (60 * mRound); 
		var sRound = Math.round(seconds);
		 console.log(year + " "  + month + " "+ day + " "+ hour + " "+ minute + " "+ secondss + " ");	
		document.getElementById("counter1").innerHTML = dRound; 
		document.getElementById("counter2").innerHTML = hRound; 
		document.getElementById("counter3").innerHTML = mRound; 
		document.getElementById("counter4").innerHTML = sRound;
		newtime = window.setTimeout("getTime();", 1000);  
	}
</script>
<SCRIPT>getTime();</SCRIPT>
</html>