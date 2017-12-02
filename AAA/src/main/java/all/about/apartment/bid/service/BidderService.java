package all.about.apartment.bid.service;

import java.util.List;

import all.about.apartment.bid.domain.BidProductVO;

public interface BidderService {
	public BidProductVO bidDetail(String bid_id) throws Exception;
}
