package all.about.apartment.resident.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.publicDomain.ResidentVO;

@Repository
public class ResidentDAOImpl implements ResidentDAO{
	
	@Inject
	private SqlSession session;
	private static String namespace="all.about.apartment.mappers.ResidentMapper";
	
	
	@Override
	public List<Integer> get_dongList() throws Exception {
		return session.selectList(namespace+".get_dongList");
	}


	@Override
	public List<Integer> get_hoList(Integer r_dong) throws Exception {
		return session.selectList(namespace + ".get_hoList", r_dong);
	}
	
	
}


























