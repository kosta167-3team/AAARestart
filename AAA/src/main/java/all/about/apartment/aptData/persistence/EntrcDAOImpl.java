package all.about.apartment.aptData.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.aptData.domain.ApartmentVO;
import all.about.apartment.aptData.domain.Entrc_seoulVO;

@Repository
public class EntrcDAOImpl implements EntrcDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "all.about.apartment.mappers.EntrcMapper";
	
	//동목록 가져오기	
	@Override
	public List<String> list_dongcode() throws Exception{
		return session.selectList(namespace+".dong_code");
	}	
	
	// x, y 좌표 얻기
	@Override
	public HashMap<String, Object> getXY(Map<String, Object> insertMap) throws Exception {
		return session.selectOne(namespace+".getXY", insertMap);
	}

	@Override
	public void insertApt(ApartmentVO vo) throws Exception {
		 session.insert(namespace+".insertApt", vo);
	}

	@Override
	public List<ApartmentVO> aptList() throws Exception {
		return session.selectList(namespace+".getAptList");
	}
	

}
