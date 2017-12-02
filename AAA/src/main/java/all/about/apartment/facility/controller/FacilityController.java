package all.about.apartment.facility.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.about.apartment.bid.util.MediaUtils;
import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_state;
import all.about.apartment.facility.service.FacilityService;
import all.about.apartment.publicDomain.ResidentVO;

@Controller
@RequestMapping("/facility/*")
public class FacilityController {

	@Inject
	FacilityService service;

	@Inject
	Facility facility;

	@RequestMapping(value = "/reserveFacility", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {

		List<Facility> list = service.getFacilityList();

		model.addAttribute("facilityList", list);

		return "/facility/reserveFacility";
	}

	@RequestMapping(value = "/checkReservation", method = RequestMethod.GET)
	public String checkReservation(Model model, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();

		String r_id = ((ResidentVO) session.getAttribute("login")).getR_id();

		// 1.오늘 예약
		long now = System.currentTimeMillis();

		Timestamp fr_date = new Timestamp(now);

		System.out.println(fr_date);

		Map<String, Object> today = new HashMap<>();

		// id
		today.put("r_id", r_id);
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

		// 2.주간 예약
		List<String> dateList = facility.Set_Stringdate();
		Map<String, Object> map = new HashMap<>();

		map.put("r_id", r_id);

		List<List<Facility_reservation>> list = new ArrayList<>();

		for (int i = 0; i < dateList.size(); i++) {

			java.sql.Timestamp week = java.sql.Timestamp.valueOf("20" + dateList.get(i) + " 00:00:00.0");
			map.put("fr_date", week);

			list.add(service.getReservationList(map));

			System.out.println(list.get(i).size());
		}

		model.addAttribute("dateList", dateList);
		model.addAttribute("timeList", service.getTimetable());
		model.addAttribute("reservationList", list);
		model.addAttribute("facility", service.getFacilityList());

		return "/facility/checkReservation";
	}

	@ResponseBody
	@RequestMapping(value = "/getQRimg/{fr_id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getQRimg(@PathVariable("fr_id") int fr_id) throws Exception {

		String filename = service.getReservationQR(fr_id);

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		try {

			MediaType mType = MediaUtils.getMediaType("png");

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(filename);

			System.out.println(filename);

			headers.setContentType(mType);

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}

		return entity;
	}

	@RequestMapping(value = "/detailPopup/{fr_id}", method = RequestMethod.GET)
	public String reservationDetail(@PathVariable("fr_id") int fr_id, Model model) throws Exception {

		Facility_reservation reservation = service.getOneReservation(fr_id);

		int f_id = reservation.getF_id();
		int fr_cnt = reservation.getFr_cnt();
		int t_id = reservation.getT_id();

		model.addAttribute("fr_id", fr_id);
		model.addAttribute("r_f_name", service.getDetail(f_id).getF_name());
		model.addAttribute("r_fr_cnt", fr_cnt);
		model.addAttribute("r_time", service.getTimetable().get(t_id - 1));

		return "/facility/detailPopup";
	}

	
	@RequestMapping(value = "/manageFacility", method = RequestMethod.GET)
	public String manageFacility(Model model) throws Exception {

		List<Facility> list = service.getFacilityList();

		model.addAttribute("facilityList", list);
		
		return "/facility/manageFacility";
	}
	
	
	@RequestMapping(value="/changePopup", method= RequestMethod.GET)
	public String changePopup () throws Exception{
		
		return "/facility/changePopup";
	}

	
}
