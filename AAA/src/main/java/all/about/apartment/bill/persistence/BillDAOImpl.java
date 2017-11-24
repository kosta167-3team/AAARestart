package all.about.apartment.bill.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.bill.domain.FacilityTime;

@Repository
public class BillDAOImpl implements BillDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "all.about.apartment.mappers.visitMapper";
	
	@Override
	public List<FacilityTime> testMethod() throws Exception {
		
		return session.selectList(namespace+".test");

	}

}
