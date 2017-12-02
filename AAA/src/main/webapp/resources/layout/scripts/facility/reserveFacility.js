/**
 * 
 */

$("#f_list ul li a").on("click", function() {
	event.preventDefault();

	var f_id = $(this).attr("value");

	getDate("/facility/date/" + f_id);
});

function getDate(f_info) {

	// 1-1.재클릭시 내용 지우기
	$('#f_date').children().remove();
	$('#f_time').children().remove();
	$('#f_spot').children().remove();
	$('#f_reserve p').children().remove();

	$.getJSON(f_info, function(data) {
		// 객체 넘어옴
		var facility = data.facility;
		var string = data.stringList;
		var date = data.dateList;

		// 시설 설명
		detail = '<p>' + facility.f_name + '</p>';
		detail += '<p>' + facility.f_contents + '</p>';
		detail += '<p>정원: ' + facility.f_capa + '</p>';
		$('#f_date').append(detail);

		var html = "";
		var check = false;

		$.each(string, function(i, entry) {
			check = false;
			$.each(date, function(j, items) {
				if (entry == items) {
					check = true;
				}
			})
			if (check == true) {
				html = '<ul><li><a href="#" class="date" value="' + entry
						+ '">' + entry + '</a></li></ul>';
			} else {
				html = '<ul><li><p>' + entry + '</p></li></ul>';
			}
			$('#f_date').append(html);
		})
	})
}
// 2. 날짜 클릭 → 시간표
$("#f_date").on("click", "a", function() {
	event.preventDefault();

	// alert($(this).attr("value"));
	var fr_date = $(this).attr("value");

	getOptions("/facility/time/" + fr_date);
});

// 2-1.
function getOptions(f_info) {

	// 재클릭시 내용 지우기
	$('#f_time').children().remove();
	$('#f_spot').children().remove();
	$('#f_reserve').children().remove();

	$.getJSON(f_info, function(data) {

		var spot = data.spotList;
		var runningTime = data.timeList;

		$.each(runningTime, function(index, entry) {

			html = '<ul><li><a href="#" class="time" value="' + entry.t_id
					+ '">' + entry.t_start + '~' + entry.t_end
					+ '</a></li></ul>';

			// div에 붙이기
			$('#f_time').append(html);

		})

		$.each(spot, function(index, entry) {

			html = '<ul><li><p class="spot">' + entry + '</p></li></ul>';

			// div에 붙이기
			$('#f_spot').append(html);

		})
	})
}

// 3. 시간 클릭 → 중복예약
$("#f_time").on("click", "a", function() {
	event.preventDefault();

	var t_id = $(this).attr("value");

	CheckDoubleBook("/facility/doubleBook/" + t_id);

});

function CheckDoubleBook(f_info) {

	$('#f_reserve').children().remove();

	$.getJSON(f_info, function(data) {

		var doublebook = data.doublebook;

		if (doublebook == null) {
			getSpot("/facility/getSpot");
		} else {

			var fr_id = doublebook.fr_id;
			var double_f_name = data.double_f_name;

			if (confirm("같은 시간에 " + double_f_name
					+ "을 예약하셨습니다. 기존 예약을 취소하시겠습니까?")) {
				// 남은 자리 구하러 가면서 인터셉터;예약 취소
				getSpot("/facility/getSpot/" + fr_id);

			} else {
				console.log("다른 시간 선택");
			}

		}
	})
}

function getSpot(f_info) {

	$('#f_reserve').children().remove();

	$
			.getJSON(
					f_info,
					function(data) {

						var spot = data.spot;

						html = '<p>예약 가능 인원: ' + spot + '</p>';
						html += '<select name="fr_cnt">';

						for (var i = 0; i < spot; i++) {

							html += '<option value="' + (i + 1) + '">'
									+ (i + 1) + '</option>';
						}

						html += '</select>';
						html += '<input type="submit" value="예약하기" id="reserve" class="btn btn-default">';

						$("#f_reserve").append(html);

					})

}

$("#f_reserve").on("click", "input", function() {

	var fr_cnt = $("#f_reserve select").val();

	reserve("/facility/reserve/" + fr_cnt);

});

function reserve(f_info) {

	$('#f_spot p').remove();

	$.getJSON(f_info, function(data) {

		var success = data.success_reserve;

		if (confirm("예약 내역을 확인하시겠습니까?")) {

			location.href = "/facility/checkReservation";
		} else {

			location.href = "/facility/reserveFacility";
		}

	});
}