package all.about.apartment.aptData.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.util.JSONPObject;

import all.about.apartment.aptData.domain.ApartmentVO;
import all.about.apartment.aptData.domain.Entrc_seoulVO;

public interface EntrcService {
	
	//동코드 목록 뽑아오기
	public List<String> list_dongcode() throws Exception;
	
	public List<Map<String, Object>> apt_list(String dong_code) throws Exception;
	
	public Map<String,Object> apt_detail(String kaptCode) throws Exception;
	
	public List<Map<String, Object>> getPostNum(String kaptAddr) throws Exception;
	
	public Map<String, Object> getXY(String zipNO, int buildingNO) throws Exception;
	
	public void insertApt(ApartmentVO vo )throws Exception;
	
	//아파트 목록 가져오기
	public List<ApartmentVO> aptList() throws Exception;
	
	//xy -> 위도 경도
	public void updataLocation(ApartmentVO vo) throws Exception;
	
}