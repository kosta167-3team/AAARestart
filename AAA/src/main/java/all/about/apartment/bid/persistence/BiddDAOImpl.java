package all.about.apartment.bid.persistence;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;

@Repository
public class BiddDAOImpl implements BiddDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "all.about.apartment.mappers.BiddMapper";

	@Override
	public BidProductVO bidDetail(String bid_id) throws Exception {
		return session.selectOne(namespace + ".bidDetail", bid_id);
	}
	
	
	



}
