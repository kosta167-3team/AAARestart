package all.about.apartment.complain.service;

import java.util.List;
import java.util.Map;

import all.about.apartment.complain.domain.ComplainDTO;

public interface ComplainService {
	
	//타입 번호, 이름 가져오기
	public List<Map<String, Object>> getTypeList(String select_type) throws Exception;
	
	//글번호
	public Integer get_compNo() throws Exception ;
	
	//항의 등록
	public void complain_register(ComplainDTO dto) throws Exception; 
	
}
