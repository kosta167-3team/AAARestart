package all.about.apartment.bid.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;
import all.about.apartment.bid.persistence.BidDAO;

@Service
public class BiddServiceImpl implements BidService {
	
	@Inject
	private BidDAO dao;

	@Transactional
	@Override
	public void regist(BidProductVO bid) throws Exception {
		dao.create(bid);
		
	/*	String[] files = bid.getFiles();
		int bid_id = dao.maxNum();
		
		FileVO fileVO = new FileVO();
		fileVO.setBid_id(bid_id);
		
		if(files == null) {return;}
		
		for(String fileName : files){
			fileVO.setContent_filename(fileName);
			dao.addAttach(fileVO);
		}*/
		
	}

	@Override
	public List<BidProductVO> read() throws Exception {
		
		return dao.read();
	}

	@Override
	public List<String> getAttach(Integer bid_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAttach(bid_id);
	}

	@Override
	public BidProductVO readDetail(Integer bid_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.readDetail(bid_id);
	}

	@Override
	public void readInsert(BidProductVO bid_id) throws Exception {
		// TODO Auto-generated method stub
		dao.readInsert(bid_id);
		
	}

}