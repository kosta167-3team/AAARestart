package all.about.apartment.resident.service;

import java.util.List;

import all.about.apartment.publicDomain.ResidentVO;

public interface ResidentService {
	
	//동목록 불러오기
	public List<Integer> get_dongList() throws Exception;
	
	//호 목록 
	public List<Integer> get_hoList(Integer r_dong) throws Exception;
}
