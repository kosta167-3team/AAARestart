/**
 * 
 */


$(function () {
$("#cancel").on("click", function() {

	var fr_id = $(this).val();

	$.ajax({
		url : "/facility/cancleReservation/" + fr_id,
		success : function(data) {

			html = '<p>' + data + '</p>';
			html += '<button id="close">확인</button>';

			$('#popup').children().remove();
			$('#popup').append(html);

			$(opener.document).find("a[val=" + fr_id + "]").remove();

		}

	});

});




/*$(function () {*/
$('#close').on("click", function() {
	window.close();
});
/*});*/

/*$(function () {*/
$('#popup').on("click", '#close', function() {
	window.close();
});

});