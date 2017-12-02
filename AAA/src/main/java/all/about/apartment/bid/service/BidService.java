package all.about.apartment.bid.service;

import java.util.HashMap;
import java.util.List;

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
	
}
