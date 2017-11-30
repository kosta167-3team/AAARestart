package all.about.apartment.realEstate.service;

import java.util.List;
import java.util.Map;

import all.about.apartment.realEstate.domain.AnnualMinMaxVO;
import all.about.apartment.realEstate.domain.LastDataChartVO;
import all.about.apartment.realEstate.domain.LastDataListVO;

public interface RealEstateService {
	
	
	public String getAptCode(String aptName ,String dongname,String loadNum)throws Exception;
	
	public void inputData() throws Exception;
	
	public void inputRentData(List<Map<String, Object>> rent_list) throws Exception;
	public void inputTradeData(List<Map<String, Object>> trade_list) throws Exception;
	
	public List<Map<String, Object>> getRentData(String deal_ymd) throws Exception;
	public List<Map<String, Object>> getTradeData(String deal_ymd) throws Exception;
	
	public List<Integer> get_area()throws Exception;
	
	
	//
	public LastDataChartVO getLastData(int area) throws Exception;
	
	//이번달 상한가 , 하한가
	public List<LastDataListVO> monthlyRealEstate() throws Exception;
	
	
	//전세 일년치 상한가 하한가
	public List<AnnualMinMaxVO> annualRent(int area) throws Exception;
	
	//매매 일년치 상한가 하한가 
	public List<AnnualMinMaxVO> annualTrade(int area) throws Exception;
	
	
	public List<AnnualMinMaxVO> annualRentTrade(int area) throws Exception;
	
}















