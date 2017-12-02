/**
 * 
 */ 

$(function () {
$('.reservation').on("click", function() {

					event.preventDefault();

					var fr_id = $(this).attr("val");

					getReservationDetail("/facility/detailPopup/"+ fr_id);

				});
});


function getReservationDetail(f_info) {
	
	var popupX = (window.screen.width/2) - (300/2);
	var popupY= (window.screen.height/2) - (200/2);
	
	window.open(f_info,'childWindow', 'status=no, height=200, width=300, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
}
  