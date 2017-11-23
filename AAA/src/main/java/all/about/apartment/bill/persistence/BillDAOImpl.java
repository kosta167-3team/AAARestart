package all.about.apartment.bill.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.bill.domain.Personal_mgmt_ex;


@Repository
public class BillDAOImpl implements BillDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "all.about.apartment.mappers.BillMapper";

	@Override
	public List<Personal_mgmt_ex> getPersonal_mgmt_ex() throws Exception {
		
		return session.selectList(namespace + ".getPersonal_mgmt_ex");
	}


}
