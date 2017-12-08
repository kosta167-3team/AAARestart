package all.about.apartment.bid.persistence;

import java.util.HashMap;
import java.util.List;

import all.about.apartment.bid.domain.BidPenalty;
import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;

public interface BidDAO {
	
	public void create(BidProductVO vo)throws Exception;
	public void update(BidProductVO bid_id)throws Exception;
	public void delete(Integer bid_id)throws Exception;
	
	public void readInsert(HashMap<String, String> vo)throws Exception;
	
	public List<BidProductVO> read()throws Exception;
	public List<BidProductVO> read2(String sort)throws Exception;
	
	public BidProductVO readDetail(Integer bid_id)throws Exception;
	
	
	public void addAttach(FileVO vo)throws Exception;
	public int maxNum()throws Exception;
	public List<String> getAttach(Integer bid_id)throws Exception;
	
	/*public void deleteAttach(Integer bid_id)throws Exception;
	public void replaceAttach(String fullName,Integer bno)throws Exception;*/
	
	public Integer penalty(BidProductVO vo)throws Exception;

}
