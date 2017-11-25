package all.about.apartment.aptData.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import all.about.apartment.aptData.domain.ApartmentVO;

public interface EntrcDAO {
	
	public List<String> list_dongcode() throws Exception;
	public Map<String, Object> getXY(Map<String, Object> insertMap) throws Exception; 
	public void insertApt(ApartmentVO vo )throws Exception;
	
	//아파트 목록 가져오기
	public List<ApartmentVO> aptList () throws Exception;

}
