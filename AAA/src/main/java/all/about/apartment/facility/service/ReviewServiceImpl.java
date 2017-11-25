package all.about.apartment.facility.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.facility.domain.ReviewVO;
import all.about.apartment.facility.domain.TodayGuest;
import all.about.apartment.facility.persistence.ReviewDAO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Inject
	private ReviewDAO dao;

	@Override
	public int regist(ReviewVO review) throws Exception {
		review.setRev_id(dao.reviewMax());
		System.out.println(review.toString());
		return dao.create(review);

	}

	@Override
	public List<ReviewVO> listAll(int f_id) throws Exception {
		
		return dao.listAll(f_id);
	}

	@Override
	public List<TodayGuest> selectedGuest(String date) throws Exception {	
		
		return dao.selectedGuest(date);
	}

}
