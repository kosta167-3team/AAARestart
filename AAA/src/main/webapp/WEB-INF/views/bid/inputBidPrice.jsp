
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


</head>

<div ng-app="myApp" ng-controller="myCtrl">
  <div class="container">
   <form>
   <div class="input-group">
   
    	<div class="form-group  has-feedback">
            <input type="text" class="form-control" id="bidPrice" placeholder="입찰가 입력">
        </div>
        <span class="input-group-btn">
            <button id="bidButton" class="btn btn-default" type="button">입찰</button>
        </span>
    </div>
  </form>
</div>
<p>현재 입찰가  : <fmt:formatNumber value="${nowPrice}" type="number"/> 원</p>

<script>
$('#bidButton').on('click', function() {
	var bidPrice = $('#bidPrice').val();
	var bid_id = ${bid_id};
	var nowPrice = ${nowPrice};
	var obj = new Object();
	obj.bidPrice = bidPrice;
	obj.bid_id = bid_id;
	if(bidPrice <= nowPrice) {
		alert("입찰 금액은 현재 입찰가보다 높게 설정해야합니다.");
	} else {
		$.ajax({
			type:"get",
			url:"/bid/updateBidPrice",
			dataType:"json",
			data: obj,
			contentType : "application/json; charset=utf-8",
			success:function(){
				opener.parent.location.reload();
				window.close();
			} 
		})
	}
})
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) { 
    var str='';
    $scope.check=function(){
     alert($scope.prime);
     var value=$scope.prime;
        fibonacciRecursive(0, 1, 1, value);
       $scope.message=str;
    }
    function fibonacciRecursive(a, b, counter, len) {
    if (counter <= len) {
         str=str+","+a;
        fibonacciRecursive(b, a + b, counter + 1, len);
    }
}
    
});
</script>

<p>입찰 금액은 현재 입찰가보다 높게 설정해야합니다.</p>