package all.about.apartment.complain.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import all.about.apartment.complain.service.ComplainService;
import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.service.FacilityService;
import all.about.apartment.resident.service.ResidentService;

@RestController
@RequestMapping("/complain")
public class ComplainRestController {

	@Inject
	ComplainService compService;

	@Inject
	FacilityService facilityService;

	@Inject
	ResidentService residentService;

	@RequestMapping(value = "/getType{select_type}", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> typeListGet(@PathVariable("select_type") String select_type) {
		ResponseEntity<List<Map<String, Object>>> entity = null;
		try {
			List<Map<String, Object>> list = compService.getTypeList(select_type);
			entity = new ResponseEntity<List<Map<String, Object>>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/getFacilityList", method = RequestMethod.GET)
	public ResponseEntity<List<Facility>> getFacilityList() {
		ResponseEntity<List<Facility>> entity = null;
		List<Facility> list;

		try {
			list = facilityService.getFacilityList();
			entity = new ResponseEntity<List<Facility>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	@RequestMapping(value = "/get_dong_ho{r_dong}", method = RequestMethod.GET)
	public ResponseEntity<List<Integer>> getDongList(@PathVariable Integer r_dong) {
		ResponseEntity<List<Integer>> entity = null;
		List<Integer> list = null;
		System.out.println(r_dong);
		try {
			if (r_dong == null) {
				list = residentService.get_dongList();
			} else {
				list = residentService.get_hoList(r_dong);

			}
			entity = new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
}
