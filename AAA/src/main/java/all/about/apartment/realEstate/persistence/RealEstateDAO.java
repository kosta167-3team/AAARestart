package all.about.apartment.realEstate.persistence;

import java.util.List;
import java.util.Map;

import all.about.apartment.realEstate.domain.AnnualMinMaxVO;
import all.about.apartment.realEstate.domain.AptRentVO;
import all.about.apartment.realEstate.domain.AptTradeVO;
import all.about.apartment.realEstate.domain.LastDataChartVO;
import all.about.apartment.realEstate.domain.LastDataListVO;

public interface RealEstateDAO {
	public String getdetailAptCode(Map<String, Object> map)throws Exception;
	
	public String getAptCode(String dongname)throws Exception;
	
	public Integer dongCnt(String dongname)throws Exception;
	
	public void insertRentData(AptRentVO vo )throws Exception;
	
	public void insertTradeData (AptTradeVO vo) throws Exception;
	
	public List<Integer> get_area() throws Exception;
	
	public int getLastRentData(int area) throws Exception;

	public int getLastTradeData(int area) throws Exception;
	
	//아파트 이름
	public String getAptName() throws Exception;
	
	//이번달 평수별 상한가, 하한가 조회
	public List<LastDataListVO> monthlyRealEstate() throws Exception;
	
	//전세 일년치 상한가 하한가
	public List<AnnualMinMaxVO> annualRent(int area) throws Exception;
	
	//매매 일년치 상한가 하한가 
	public List<AnnualMinMaxVO> annualTrade(int area) throws Exception;
	
	public List<AnnualMinMaxVO>annualRentTrade(int area) throws Exception;
	
}
























