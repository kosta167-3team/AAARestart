<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="/resources/layout/scripts/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
/* 
	$(function(){
		$('#input').on('click',function(event){
			console.log("ddd");
			event.preventDefault();
			
			var params = $('#gg').serialize();
			
			$.ajax(
			{
				url:"/bid/bidEvaluation",
				data:params,
				type:'post',
				dataType:'json',
				 headers : {
	                  'Content-Type' : 'application/json'
	               },
				success : function(data)				
				{
					alert(data);
					if(data == 'success')
					window.close();
				}
			});
		
		});
		
	
	});
 */
	
</script>


	<div id="comments">

		<h2>상품평 등록</h2>
		<form role="form" method="post">
			<input type='hidden' name='bid_id' value="${list.bid_id }">
			
			<div class="one_third first">
			
				<label for="name">판매자 </label> <input type="text"
					name="bid_seller" id="name" value="${list.bid_seller }" size="22"
					readonly="readonly">
			</div>
			<br>
			<div class="one_third">
				<label for="email">상품이름</label> <input type="text"
					name="bid_name" id="email" value="${list.bid_name }" size="22"
					readonly="readonly">
			</div>
			
			<br>

			<div class="block clear">
				<label for="comment">내용</label><br>
				<textarea name="bid_evaluation" id="comment" value="${evaluation }"
				 cols="25" rows="5"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary"> 등록 </button>
		</form>
	</div>



</body>
</html>