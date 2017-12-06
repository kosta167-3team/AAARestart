
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<!-- css -->
<link href="/resources/layout/styles/message/message.css"
	rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- Script -->
<script src="/resources/layout/scripts/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/resources/layout/scripts/message/message.js"></script>

</head>

<body>

	<div class="container">

		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#messageModal" data-whatever="@mdo">쪽지 쓰기</button>

		<div class="modal fade" id="messageModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">새로운 쪽지</h4>
					</div>
					<div class="modal-body">

						<form id="messageForm">
							<input type="hidden" name="type_id" value="6">
							<div class="form-group">
								<label for="recipient-name" class="control-label">보내는사람</label>
								<!-- <input type="text" class="form-control" id="recipient-name"> -->
								<input type="hidden" class="form-control" name="sender" value="dmsql123">
								<p class="form-control-static sender"></p>
							</div>
							<div class="form-group">
								<label for="recipient-name" class="control-label">받는 사람</label>
								<input type="hidden" class="form-control" name="receiver"
									value="dustks123">
								<p class="form-control-static receiver"></p>
							</div>
							<div class="form-group">
								<label for="message-text" class="control-label">메세지 내용:</label>
								<textarea class="form-control" id="message-text"
									name="msg_content"></textarea>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" id="sendMessage">메세지 보내기</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- Large modal -->
<a class="btn" data-toggle="modal" data-target=".messageListmodal">Large
	modal</a>

<div class="modal fade messageListmodal" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">새로운 쪽지</h4>
			</div>
			<div class="modal-body"></div>
		</div>
	</div>
</div>
</html>

