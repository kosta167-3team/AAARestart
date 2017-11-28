package all.about.apartment.visit.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.visit.domain.ApplicationVO;
import all.about.apartment.visit.domain.Criteria;
import all.about.apartment.visit.dto.ApplicationDTO;
import all.about.apartment.visit.persistence.VisitDAO;

@Service
public class VisitServiceImpl implements VisitService {
	
	@Inject
	private VisitDAO dao;
	
	@Override
	public ResidentVO getResident(ApplicationDTO dto) {
		System.out.println("service : " + dto.toString());
		return dao.get(dto);
	}

	@Override
	public int maxVR() {
		if(dao.maxVR() == null){
			return 1;
		} else
			return dao.maxVR()+1;
	}

	@Override
	public void applicationVisit(ApplicationDTO dto){
		dao.applicationVisit(dto);		
	}

	@Override
	public List<ApplicationVO> applicationList(String r_id) {
		return dao.applicationList(r_id);
	}

	@Override
	public List<ApplicationVO> listCriteria(Criteria cri) {
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount(String r_id) {		
		return dao.totalCount(r_id);
	}

	@Override
	public void updateCheck(HashMap<String, Object> map) {
		dao.updateCheck(map);
	}

	@Override
	public List<ApplicationVO> adminApplicationList(String selectedDate) {
		return dao.adminListPage(selectedDate);
	}

	/*@Override
	public List<ApplicationVO> searchApplication(String selectedDate) {
		return dao.searchApplication(selectedDate);
	}*/
}
