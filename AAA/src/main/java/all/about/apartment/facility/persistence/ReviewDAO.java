package all.about.apartment.facility.persistence;

import java.util.List;

import all.about.apartment.facility.domain.ReviewVO;
import all.about.apartment.facility.domain.TodayGuest;

public interface ReviewDAO {

	public int create(ReviewVO vo)throws Exception;
	
	public int reviewMax()throws Exception;
	
	public List<ReviewVO> listAll(int f_id)throws Exception;
	
	public List<TodayGuest> selectedGuest(String date)throws Exception;
	
	
}
