package all.about.apartment.resident.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.resident.persistence.ResidentDAO;

@Service
public class ResidentServiceImpl implements ResidentService{

	@Inject
	ResidentDAO dao;
	
	@Override
	public List<Integer> get_dongList() throws Exception {
		return dao.get_dongList();
	}

	@Override
	public List<Integer> get_hoList(Integer r_dong) throws Exception {
		return dao.get_hoList(r_dong);
	}

}




















































