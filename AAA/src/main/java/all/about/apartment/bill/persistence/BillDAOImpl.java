package all.about.apartment.bill.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class BillDAOImpl implements BillDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "all.about.apartment.mappers.BillMapper";
	
	

}
