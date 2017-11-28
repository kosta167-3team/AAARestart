package all.about.apartment.facility.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_time;
import all.about.apartment.facility.service.FacilityService;

@RestController
@RequestMapping("/facility/*")
public class FacilityRestController {

	@Inject
	FacilityService service;

	static Map<String, Object> map = new HashMap<String, Object>();

	// 날짜 목록 출력
	@RequestMapping(value = "/date/{f_id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getDate(@PathVariable("f_id") int f_id) {

		ResponseEntity<Map<String, Object>> entity = null;
		map.put("r_id", "dmsql123");
		map.put("f_id", f_id);

		try {
			Facility facility = service.getDetail(f_id);

			List<String> dateList = facility.Set_date();

			map.put("facility", facility);
			map.put("dateList", dateList);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);

		}

		return entity;
	}

	// 운영시간 (+ 시간 별 예약가능 인원 구하기)
	@RequestMapping(value = "/time/{fr_date}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getOptions(@PathVariable("fr_date") String date) {

		ResponseEntity<Map<String, Object>> entity = null;

		// tring → timestamp
		java.sql.Timestamp fr_date = java.sql.Timestamp.valueOf("20" + date + " 00:00:00.0");
		map.put("fr_date", fr_date);

		System.out.println(date);
		System.out.println(fr_date);

		int f_id = (int) map.get("f_id");

		try {
			Facility facility = service.getDetail(f_id);

			// 운영시간 리스트, 시간 별 남은 인원 리스트
			Map<String, List<Object>> options = service.getOptions(map);

			map.put("timeList", options.get("runningTime"));
			map.put("spotList", options.get("spotList"));

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 중복예약 체크하기
	@RequestMapping(value = "/doubleBook/{t_id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> checkDoubleBook(@PathVariable("t_id") int t_id) {

		ResponseEntity<Map<String, Object>> entity = null;

		map.put("t_id", t_id);

		try {
			Integer doubel_fr_id = service.checkDoubleBook(map);

			if (doubel_fr_id == null) {
				map.put("doublebook", doubel_fr_id);

			} else {
				Facility_reservation fr = service.getOneReservation(doubel_fr_id);
				map.put("doublebook", fr);
				map.put("double_f_name", service.getDetail(fr.getF_id()).getF_name());
			}
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 중복예약 o → 남은 자리 구하기
	@RequestMapping(value = "/getSpot/{fr_id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getSpot() {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			int spot = service.getSpot(map);
			map.put("spot", spot);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	// 중복예약x → 남은 자리 구하기
	@RequestMapping(value = "/getSpot", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getSpots() {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			int spot = service.getSpot(map);
			map.put("spot", spot);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	// 예약하기
 	@RequestMapping(value = "/reserve/{fr_cnt}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> reserve(@PathVariable("fr_cnt") int fr_cnt) {

		ResponseEntity<Map<String, Object>> entity = null;

		map.put("fr_cnt", fr_cnt);

		try {
	 		service.insertReservation(map);
			
			//map.put("new_spotList", service.getOptions(map).get("spotList"));
			
	 		map.put("success", "예약 내역을 확인하시겠습니까?");
	 		
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	} 

/* 	@RequestMapping(value = "/ReservationDetail/{fr_id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> reservationDetail(@PathVariable("fr_id") int fr_id) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Facility_reservation reservation = service.getOneReservation(fr_id);

			int f_id = reservation.getF_id();
			int fr_cnt = reservation.getFr_cnt();
			int t_id = reservation.getT_id();

			map.put("r_f_name", service.getDetail(f_id).getF_name());
			map.put("r_fr_cnt", fr_cnt);
			map.put("r_time", service.getTimetable().get(t_id - 1));

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	} */
	
	@RequestMapping(value="/cancleReservation/{fr_id}", method=RequestMethod.GET)
	public void cancleReservation (@PathVariable ("fr_id") int fr_id) {
		
		try {
			service.cancelReservation(fr_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
