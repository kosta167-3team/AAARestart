package all.about.apartment.facility.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_state;
import all.about.apartment.facility.domain.Facility_stateVO;
import all.about.apartment.facility.domain.Facility_time;
import all.about.apartment.publicDomain.Criteria;

public interface FacilityService {
	
	public List<Facility> getFacilityList() throws Exception;
	
	public Facility getDetail(int f_id) throws Exception; 
	
	public List<String> getDateList (int f_id) throws Exception;
	
	public List<Facility_time> getTimetable () throws Exception;
	 
	public Map<String, List<Object>> getOptions(Map<String, Object> map) throws Exception;
	
	public int getSpot(Map<String, Object> map) throws Exception;
	
	public Integer checkDoubleBook(Map<String, Object> map) throws Exception;
	
	public void insertReservation(Map<String, Object> map) throws Exception;
	
	public Facility_reservation getOneReservation(int fr_id) throws Exception;
	
	public List<Facility_reservation> getReservationList (Map<String, Object> map) throws Exception;
	
	public String getReservationQR (int fr_id) throws Exception;
	
	//스케쥴러
	public void deleteQR () throws Exception;
	
	public int cancelReservation(int fr_id) throws Exception;
	
	public int insertState(Facility_state state) throws Exception;
	
	public List<Facility_stateVO> getStatePage (Facility factility, Criteria cri) throws Exception;
	
	public int getStateCount (Facility facility) throws Exception;
	
	public void deleteState (int fs_id) throws Exception;
	
	public List<String> getCancelmsgList (Map<String, Object> map) throws Exception;
	
	public void cancelAllReservation (Map<String, Object> map) throws Exception;
	
	//스케쥴러
	public void alterFacilityState () throws Exception;
	
	
}
