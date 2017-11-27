package all.about.apartment.facility.persistence;

import java.util.List;
import java.util.Map;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_time;

public interface FacilityDAO {

	public List<Facility> getFacilityList() throws Exception;

	public Facility getDetail(int f_id) throws Exception;

	public List<Facility_time> getTimetable() throws Exception;

	public Integer getSpot(Map<String, Object> map) throws Exception;

	public Integer checkDoubleBook(Map<String, Object> map) throws Exception;

	public void insertReservation(Map<String, Object> map) throws Exception;

	public List<Facility_reservation> getReservationList (Map<String, Object> map) throws Exception;
	
	public Facility_reservation getOneReservation(int fr_id) throws Exception;

	public int cancelReservation(int fr_id) throws Exception;

}
