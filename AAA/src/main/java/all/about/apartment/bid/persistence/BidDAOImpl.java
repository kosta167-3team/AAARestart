package all.about.apartment.bid.persistence;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;

@Repository
public class BidDAOImpl implements BidDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "all.about.apartment.mappers.BidMapper";
	
	
	@Override
	public void addAttach(FileVO vo) throws Exception {
		session.insert(namespace+".addAttach",vo);
	}

	@Override
	public void create(BidProductVO vo) throws Exception {
		session.insert(namespace+".create",vo);
		
	}
	
	@Override
	public int maxNum() throws Exception {
		
		return session.selectOne(namespace+".maxNum");
	}

	@Override
	public List<BidProductVO> read() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".read");
	}
	
	@Override
	public List<BidProductVO> read2(String sort) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".read2", sort);
	}

	@Override
	public List<String> getAttach(Integer bid_id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getAttach", bid_id);
	}

	@Override
	public BidProductVO readDetail(Integer bid_id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".readDetail", bid_id);
	}

	@Override
	public void readInsert(HashMap<String, String> vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".readInsert",vo);
	}

	@Override
	public void update(BidProductVO bid_id) throws Exception {
		session.update(namespace+".update", bid_id);
		
	}

	@Override
	public void delete(Integer bid_id) throws Exception {
		session.delete(namespace+".delete",bid_id);	
	}
	/*@Override
	public void deleteAttach(Integer bid_id) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteAttach", bid_id);
	}


	@Override
	public void replaceAttach(String fullName, Integer bid_id) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap=new HashMap<String,Object>();
		
		paramMap.put("bid_id", bid_id);
		paramMap.put("fullName", fullName);
		
		session.insert(namespace+".replaceAttach", paramMap);
	}*/

	@Override
	public void addBidTime(HashMap<String, Object> map) {
		session.update(namespace + ".addBidTime", map);
	}

	@Override
	public void updateBidState(String bid_id) throws Exception {
		session.update(namespace + ".updateBidState", bid_id);
	}


}
