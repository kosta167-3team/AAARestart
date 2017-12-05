package all.about.apartment.visit.service;


import java.util.HashMap;
import java.util.List;

import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.visit.domain.ApplicationVO;
import all.about.apartment.visit.dto.ApplicationDTO;

public interface VisitService {
	public ResidentVO getResident(ApplicationDTO dto);
	public int maxVR();
	public void applicationVisit(ApplicationDTO dto);
	public List<ApplicationVO> applicationList(String r_id);
	public List<ApplicationVO> listCriteria(Criteria cri);
	public int totalCount(String r_id);
	public void updateState(HashMap<String, Object> map);
	public void updateCheck(HashMap<String, Object> map);
	public List<ApplicationVO> adminApplicationList(String selectedDate);
	//public List<ApplicationVO> searchApplication(String selectedDate);
}
