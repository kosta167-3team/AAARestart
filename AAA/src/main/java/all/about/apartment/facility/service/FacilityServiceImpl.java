package all.about.apartment.facility.service;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_time;
import all.about.apartment.facility.persistence.FacilityDAO;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Inject
	FacilityDAO facilityDao;

	static int open;
	static int close;

	public List<Facility> getFacilityList() throws Exception {

		return facilityDao.getFacilityList();
	}

	public Facility getDetail(int f_id) throws Exception {

		return facilityDao.getDetail(f_id);
	}


	public Map<String, List<Object>> getOptions(Map<String, Object> map) throws Exception {

		int f_id = (int) map.get("f_id");

		System.out.println("운영시간 확인 - 시설번호 " + f_id);

		Map<String, List<Object>> options = new HashMap<>();

		Facility facility = facilityDao.getDetail(f_id);
		List<Facility_time> timeTable = facilityDao.getTimetable();

		for (int i = 0; i < timeTable.size(); i++) {

			if (timeTable.get(i).getT_start().equals(facility.getF_open())) {
				open = timeTable.get(i).getT_id();
			}
			if (timeTable.get(i).getT_end().equals(facility.getF_close())) {
				close = timeTable.get(i).getT_id();
			}
		}

		List<Object> runningTime = new ArrayList<>();
		List<Object> spotList = new ArrayList<>();

		for (int j = open - 1; j < close; j++) {
			runningTime.add(timeTable.get(j));

			map.put("t_id", j+1);
			spotList.add(getSpot(map));

		}

		options.put("runningTime", runningTime);
		options.put("spotList", spotList);

		return options;
	}

	public int getSpot(Map<String, Object> map) throws Exception {

		int f_id = (int) map.get("f_id");

		Integer taken = facilityDao.getSpot(map);

		if (taken == null) {

			taken = 0;
		}

		Facility facility = facilityDao.getDetail(f_id);
		int f_capa = facility.getF_capa();

		int spot = f_capa - taken;
 
		return spot;
	}

	public Integer checkDoubleBook(Map<String, Object> map) throws Exception {

		Integer ok = facilityDao.checkDoubleBook(map);

		System.out.println("중복 예약 번호 - " + ok);

		return ok;
	}

	public void insertReservation(Map<String, Object> map) throws Exception {
		facilityDao.insertReservation(map);
	}

	public Facility_reservation getOneReservation(int fr_id) throws Exception {

		return facilityDao.getOneReservation(fr_id);
	}

	public int cancelReservation(int fr_id) throws Exception {

		return facilityDao.cancelReservation(fr_id);
	}

	@Override
	public List<Facility_reservation> getReservationList(Map<String, Object> map) throws Exception {
		
		return facilityDao.getReservationList(map);
	}

	@Override
	public List<Facility_time> getTimetable() throws Exception {
	 
		return facilityDao.getTimetable();
	}

 
}
