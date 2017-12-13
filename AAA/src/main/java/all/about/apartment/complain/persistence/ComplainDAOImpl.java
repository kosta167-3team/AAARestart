package all.about.apartment.complain.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.complain.domain.ComplainDTO;

@Repository
public class ComplainDAOImpl implements ComplainDAO {

	@Inject
	private SqlSession session;
	private static String namespace="all.about.apartment.mappers.ComplainMapper";

	
	@Override
	public List<Map<String, Object>> getTypeList(String select_type) throws Exception {
		return session.selectList(namespace+".getTypeList", select_type);
	}


	@Override
	public Integer get_compNo() throws Exception {
		return session.selectOne(namespace+".get_compNo");
	}

	//항의 등록
	@Override
	public void complain_register(ComplainDTO dto) throws Exception {
		session.insert(namespace + ".complain_register",dto);
	}
		

}








