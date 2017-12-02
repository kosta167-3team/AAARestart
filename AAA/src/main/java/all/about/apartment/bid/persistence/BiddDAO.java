package all.about.apartment.bid.persistence;

import java.util.List;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;

public interface BiddDAO {
	public BidProductVO bidDetail(String bid_id) throws Exception;
}
