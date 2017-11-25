package all.about.apartment.facility.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.facility.domain.ReviewVO;
import all.about.apartment.facility.domain.TodayGuest;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Inject
	private SqlSession	session;
	
	
	private static String namespace = "all.about.apartment.mappers.ReviewMapper";

	@Override
	public int create(ReviewVO vo) throws Exception {
		return session.insert(namespace+".create",vo);
		
	}

	@Override
	public List<ReviewVO> listAll(int f_id) throws Exception {
		
		return session.selectList(namespace+".listAll",  f_id);
	}

	@Override
	public int reviewMax() throws Exception {
		
		return (int)session.selectOne(namespace+".reviewMax")+1;
	}

	@Override
	public List<TodayGuest> selectedGuest(String date)throws Exception {
		
		return session.selectList(namespace+".selectedGuest",date);
	}

}
