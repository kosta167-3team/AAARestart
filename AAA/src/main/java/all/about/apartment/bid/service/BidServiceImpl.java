package all.about.apartment.bid.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.domain.FileVO;
import all.about.apartment.bid.persistence.BidDAO;

@Service
public class BidServiceImpl implements BidService {
	
	@Inject
	private BidDAO dao;

	

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
		return dao.getAttach(bid_id);
	}

	@Override
	public BidProductVO readDetail(Integer bid_id) throws Exception {
		return dao.readDetail(bid_id);
	}

	@Override
	public void readInsert(HashMap<String, String> bid_id) throws Exception {
		dao.readInsert(bid_id);

		
	}

	@Override
	public void modify(BidProductVO bid_id) throws Exception {
		dao.update(bid_id);
		
		/*Integer bno = bid_id.getBid_id();
		
		dao.deleteAttach(bno);
		
		String[] files = bid_id.getFiles();
		if(files == null){return;}
		
		for(String fileName : files){
			dao.replaceAttach(fileName, bno);
		}*/
		
	}

	@Override
	public void remove(Integer bid_id) throws Exception {
		dao.delete(bid_id);
	}

	@Override
	public List<BidProductVO> read2(String sort) throws Exception {
		return dao.read2(sort);
	}

	@Override
	public BidProductVO bidDetail(String bid_id) throws Exception {
		return null;
	}

	
}
