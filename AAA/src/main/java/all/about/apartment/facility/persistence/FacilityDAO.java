package all.about.apartment.facility.persistence;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_state;
import all.about.apartment.facility.domain.Facility_time;

public interface FacilityDAO {

	public List<Facility> getFacilityList() throws Exception;

	public Facility getDetail(int f_id) throws Exception;
	
	public int checkState (Map<String, Object> map) throws Exception;

	public List<Facility_time> getTimetable() throws Exception;

	public Integer getSpot(Map<String, Object> map) throws Exception;

	public Integer checkDoubleBook(Map<String, Object> map) throws Exception;

	public void insertReservation(Map<String, Object> map) throws Exception;

	public List<Facility_reservation> getReservationList (Map<String, Object> map) throws Exception;
	
	public Facility_reservation getOneReservation(int fr_id) throws Exception;

	public int cancelReservation(int fr_id) throws Exception;
	
	public void insertState (Facility_state state) throws Exception;
	
	public List<Facility_state> getStateList () throws Exception;
	
	public void deleteState (int fs_id) throws Exception;
	
	public List<String> getCancelmsgList (Map<String, Object> map) throws Exception;
	
	public int cancelAllReservation (Map<String, Object> map) throws Exception;
	
	public void alterState_bad () throws Exception;

	public void alterState_ok () throws Exception;

}
