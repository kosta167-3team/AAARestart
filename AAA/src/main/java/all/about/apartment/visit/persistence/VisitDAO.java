package all.about.apartment.visit.persistence;

import java.util.HashMap;
import java.util.List;

import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.visit.domain.ApplicationVO;
import all.about.apartment.visit.dto.ApplicationDTO;

public interface VisitDAO {
	public List<ResidentVO> get(ApplicationDTO dto);
	public Integer maxVR();
	public void applicationVisit(ApplicationDTO dto);
	public int totalCount(String r_id);
	public List<ApplicationVO> applicationList(String r_id);
	public List<ApplicationVO> applicationListPage(String r_id, int page);
	public List<ApplicationVO> listCriteria(Criteria cri);
	public void updateState(HashMap<String, Object> map);
	public void updateCheck(HashMap<String, Object> map);
	public List<ApplicationVO> adminListPage(String selectedDate);
	//public List<ApplicationVO> searchApplication(String selectedDate);
}
