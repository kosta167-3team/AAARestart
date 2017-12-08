<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
	#comments{
  position: absolute;
height: 50px;
top: 5%;


margin-top: -20px;
margin-left: 50px; 
}
 
 h2{
 	text-align: center;
 }
 body{
 	background: #fff3f3;
 }

</style>

<head>

<script src="/resources/layout/scripts/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		$(function() {
			$('#input').on('click', function(event) {
				console.log("ddd");
				var bid_id=$('#bid_id').val();
				var evaluation =  $('#comment').val();
				
				
				var params = $('#formid').serialize(); 
				var obj = new Object();
				
				obj.bid_id = $('#bid_id').val();
				obj.bid_evaluation = $('#comment').val();
				console.log(JSON.stringify(params));
				event.preventDefault();

				/* var bid_id = $('#bid_id').val();
				 var obj = new Object();
				obj.bid_id = $(this).html();
				alert(bid_id);  */

				/* var b_id = $('#bid_id').val();
				var ev = $('#comment').val();
				console.log(b_id + ' ' + ev);
				
				var data={
						b_id:b_id,
						ev : ev
				}; */
				/* var params = $('#formid').serialize();
				var bid_id = $('#formid').find('input:first-child').val(); */
				/* console.log(bid_id);
				console.log(JSON.stringify(params)); */

				$.ajax({
					type : 'post',
					url : '/bid/review',
					dataType : "text",
					data : obj
					,
					success : function(data) {
						alert("상품평 등록 완료");
						$(opener.document).find('#' + bid_id ).children().last().remove();

						$(opener.document).find('#' + bid_id).append("<td>" + evaluation + "</td>");
						window.close();
						
					},
					error : function(e) {
						alert("error");
					}
				});

			});

		});
	</script>


	<div id="comments">

		<h2>상품평 등록</h2><br>
		<form role="form" id="formid">
			<input type='hidden' name='bid_id' id='bid_id'
				value="${list.bid_id }">

			<div class="one_third first">

				<label for="name">판매자 : </label> &nbsp&nbsp&nbsp <input type="text" name="bid_seller"
					id="name" value="${list.bid_seller }" size="12" readonly="readonly">
			</div>
			<br>
			<div class="one_third">
				<label for="email">상품이름 : </label>&nbsp <input type="text" name="bid_name"
					id="email" value="${list.bid_name }" size="12" readonly="readonly">
			</div>

			<br>

			<div class="block clear">
				<label for="comment">내용</label><br><br>
				<textarea name="bid_evaluation" id="comment" placeholder="내용을 작성해주세요 " value="${evaluation }"
					cols="35" rows="5"></textarea>
			</div>
			<br>
			<button type="submit" id="input" value="${list.bid_id }"
				class="btn btn-primary">등록</button>
		</form>
	</div>



</body>
</html>