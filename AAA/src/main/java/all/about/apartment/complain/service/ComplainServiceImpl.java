package all.about.apartment.complain.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.complain.domain.ComplainDTO;
import all.about.apartment.complain.persistence.ComplainDAO;

@Service
public class ComplainServiceImpl implements ComplainService {

	@Inject
	ComplainDAO dao;
	
	@Override
	public List<Map<String, Object>> getTypeList(String select_type) throws Exception {
		return dao.getTypeList(select_type);
	}

	//글번호
	@Override
	public Integer get_compNo() throws Exception {
		if(dao.get_compNo() == null){
			return 1;
		}
		
		return dao.get_compNo() + 1;
	}

	@Override
	public void complain_register(ComplainDTO dto) throws Exception {
		dao.complain_register(dto);
	}

}
















