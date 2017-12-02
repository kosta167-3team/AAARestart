package all.about.apartment.bid.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;
import all.about.apartment.bid.persistence.BidDAO;

@Service
public class BidderServiceImpl implements BidderService {
	
	@Inject
	private BidDAO dao;

	@Override
	public BidProductVO bidDetail(String bid_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	

}
