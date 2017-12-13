package all.about.apartment.bid.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import all.about.apartment.bid.domain.BidPenalty;
import all.about.apartment.bid.domain.BidProductVO;

public interface BidService {
	public void regist(BidProductVO bid)throws Exception;
	public void modify(BidProductVO bid_id)throws Exception;
	public void remove(Integer bid_id)throws Exception;
	
	public void readInsert(HashMap<String, String> bid_id)throws Exception;
	
	public List<BidProductVO> read() throws Exception;
	public List<BidProductVO> read2(String sort) throws Exception;
	
	public BidProductVO readDetail(Integer bid_id) throws Exception;
		
	public List<String> getAttach(Integer bid_id)throws Exception;
	BidProductVO bidDetail(String bid_id) throws Exception;
	

	public Integer penalty(BidProductVO vo)throws Exception;
	

	public void addBidTime(HashMap<String , Object> map) throws Exception;
	public void updateBidState(String bid_id) throws Exception;
	public void updateBidPrice(Map<String, Object> map) throws Exception;

}
