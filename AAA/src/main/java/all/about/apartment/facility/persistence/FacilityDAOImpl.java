package all.about.apartment.facility.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_time;

@Repository
public class FacilityDAOImpl implements FacilityDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "all.about.apartment.mappers.FacilityMapper";

	@Override
	public List<Facility> getFacilityList() throws Exception {

		return session.selectList(namespace + ".getFacilityList");
	}

	@Override
	public Facility getDetail(int f_id) throws Exception {

		return session.selectOne(namespace + ".getDetail", f_id);
	}

	@Override
	public List<Facility_time> getTimetable() throws Exception {

		return session.selectList(namespace + ".getTimetable");
	}

	@Override
	public Integer getSpot(Map<String, Object> map) throws Exception {

		return session.selectOne(namespace + ".getSpot", map);
	}

	@Override
	public Integer checkDoubleBook(Map<String, Object> map) throws Exception {

		return session.selectOne(namespace + ".checkDoubleBook", map);
	}

	@Override
	public void insertReservation(Map<String, Object> map) throws Exception {

		session.insert(namespace + ".insertReservation", map);
	}

	@Override
	public Facility_reservation getOneReservation(int fr_id) throws Exception {

		return session.selectOne(namespace + ".getOneReservation", fr_id);
	}

	@Override
	public int cancelReservation(int fr_id) throws Exception {

		return session.delete(namespace + ".cancelReservation", fr_id);
	}

	@Override
	public List<Facility_reservation> getReservationList(Map<String, Object> map) throws Exception {
		
		return session.selectList(namespace+".getReservationList", map);
	}

}
