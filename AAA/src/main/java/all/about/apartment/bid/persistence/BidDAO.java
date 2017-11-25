package all.about.apartment.bid.persistence;

import java.util.List;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;

public interface BidDAO {
	
	public void create(BidProductVO vo)throws Exception;
	public void readInsert(BidProductVO vo)throws Exception;
	
	public List<BidProductVO> read()throws Exception;
	
	public BidProductVO readDetail(Integer bid_id)throws Exception;
	
	
	public void addAttach(FileVO vo)throws Exception;
	
	public int maxNum()throws Exception;
	
	public List<String> getAttach(Integer bid_id)throws Exception;
	
	

}
