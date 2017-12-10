package all.about.apartment.resident.persistence;

import java.util.List;

import all.about.apartment.publicDomain.ResidentVO;

public interface ResidentDAO {
	
	//동목록
	public List<Integer> get_dongList() throws Exception;
	
	//호 목록 
	public List<Integer> get_hoList(Integer r_dong) throws Exception;
}
