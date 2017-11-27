package all.about.apartment.facility.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.service.FacilityService;

@Controller
@RequestMapping("/facility/*")
public class FacilityController {

	@Inject
	FacilityService service;

	@Inject
	Facility facility;

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {

		List<Facility> list = service.getFacilityList();

		model.addAttribute("facilityList", list);

		return "/facility/reservation";
		// return "/facility/full-width";
	}	
	

	@RequestMapping(value = "/checkReservation", method = RequestMethod.GET)
	public String checkReservation(Model model) throws Exception {

		List<String> dateList = facility.Set_date();

		Map<String, Object> map = new HashMap<>();

		map.put("r_id", "dmsql123");

		List<List<Facility_reservation>> list = new ArrayList<>();

		for (int i = 0; i < dateList.size(); i++) {

			java.sql.Timestamp fr_date = java.sql.Timestamp.valueOf("20" + dateList.get(i) + " 00:00:00.0");
			map.put("fr_date", fr_date);

			list.add(service.getReservationList(map));

			System.out.println(list.get(i).size());
		}

		model.addAttribute("dateList", dateList);
		model.addAttribute("timeList", service.getTimetable());
		model.addAttribute("reservationList", list);
		model.addAttribute("facility", service.getFacilityList());

		////////////////////////////////////////////////////////////////

		// 1.오늘 예약 구하기
		long now = System.currentTimeMillis();

		Timestamp fr_date = new Timestamp(now);

		System.out.println(fr_date);

		Map<String, Object> today = new HashMap<>();

		// id
		today.put("r_id", "dmsql123");
		// fr_date
		today.put("fr_date", fr_date);

		System.out.println(today.get("r_id"));
		System.out.println(today.get("fr_date"));

		List<Facility_reservation> todayList = service.getReservationList(today);

		System.out.println("총 예약" + todayList.size());

		SimpleDateFormat mmddFormat = new SimpleDateFormat("H");
		String mmdd = mmddFormat.format(new Timestamp(now));

		int now_id = Integer.parseInt(mmdd) / 2 + 1;

		System.out.println("현재 시각 id:" + now_id);

		List<Facility_reservation> latestList = new ArrayList<>();

		for (int i = 0; i < todayList.size(); i++) {

			if (todayList.get(i).getT_id() >= now_id) {

				latestList.add(todayList.get(i));
			}

		}

		model.addAttribute("latestList", latestList);

		return "/facility/checkReservation";
	//	return "/facility/Tria3";
		 	//return "/facility/table";
	}

	
/* 	@RequestMapping(value="/showModal", method=RequestMethod.GET)
	public String showModal () throws Exception{
		
		return "/facility/modal";
	} */
	
	
	
 	@RequestMapping(value = "/ReservationDetail/{fr_id}", method = RequestMethod.GET)
	public String reservationDetail(@PathVariable("fr_id") int fr_id, Model model) throws Exception{

 
			Facility_reservation reservation = service.getOneReservation(fr_id);

			int f_id = reservation.getF_id();
			int fr_cnt = reservation.getFr_cnt();
			int t_id = reservation.getT_id();
			
			model.addAttribute("fr_id", fr_id);
			model.addAttribute("r_f_name", service.getDetail(f_id).getF_name());
			model.addAttribute("r_fr_cnt", fr_cnt);
			model.addAttribute("r_time", service.getTimetable().get(t_id - 1)); 
		 

		return "/facility/modal";
	} 
 	

}
