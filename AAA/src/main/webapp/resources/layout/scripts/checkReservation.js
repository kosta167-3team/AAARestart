/**
 * 
 */

// 1.오늘의 예약
$(document).ready(function() {
	$('.accordion').find('.accordion-toggle').click(function() {
		$(this).next().slideToggle('600');
		$(".accordion-content").not($(this).next()).slideUp('600');
	});
	$('.accordion-toggle').on('click', function() {
		$(this).toggleClass('active').siblings().removeClass('active');
	});
});

// 2.주간 예약 내역
$('.reservation').on("click", function() {

	event.preventDefault();

	var fr_id = $(this).attr("val");

	getReservationDetail("/facility/ReservationDetail/" + fr_id);

});

function getReservationDetail(f_info) {

	$.getJSON(f_info, function(data) {

		var a = data.r_fr_cnt;
		var b = data.r_f_name;
		var c = data.r_time.t_start;
		var d = data.r_time.t_end;

		alert(a + "명  " + b + " " + c + "~" + d + " 예약");

	})
}