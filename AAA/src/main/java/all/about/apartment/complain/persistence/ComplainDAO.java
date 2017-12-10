package all.about.apartment.complain.persistence;

import java.util.List;
import java.util.Map;

import all.about.apartment.complain.domain.ComplainDTO;

public interface ComplainDAO {
	
	public List<Map<String, Object>> getTypeList(String select_type) throws Exception;
	
	//글번호 가져오기
	public Integer get_compNo()throws Exception;
	
	//항의 등록
	public void complain_register (ComplainDTO dto) throws Exception;
}
