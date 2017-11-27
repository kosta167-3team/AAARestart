package all.about.apartment.facility.service;

import java.util.List;

import all.about.apartment.facility.domain.ReviewVO;
import all.about.apartment.facility.domain.TodayGuest;

public interface ReviewService {
	public int regist(ReviewVO review)throws Exception;
	public List<ReviewVO> listAll(int f_id) throws Exception;
	
	public List<TodayGuest> selectedGuest(String date)throws Exception;

}
