package all.about.apartment.realEstate.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.realEstate.domain.AnnualMinMaxVO;
import all.about.apartment.realEstate.domain.AptRentVO;
import all.about.apartment.realEstate.domain.AptTradeVO;
import all.about.apartment.realEstate.domain.LastDataListVO;
import oracle.net.aso.s;

@Repository
public class RealEstateDAOImpl implements RealEstateDAO {
	
	@Inject
	private SqlSession session;
	private static String namespace = "all.about.apartment.mappers.RealEstateMapper";
	
	@Override
	public String getdetailAptCode(Map<String, Object>map)throws Exception{
		return session.selectOne(namespace+".getdetailAptCode", map);
	}
	@Override
	public String getAptCode(String dongname)throws Exception{
		//System.out.println(dongname);
		return session.selectOne(namespace+".getAptCode", dongname);
	}
	@Override
	public Integer dongCnt(String dongname) throws Exception {
		return session.selectOne(namespace+".dongCnt",dongname);
	}
	
	
	//전세 정보 넣기
	@Override
	public void insertRentData(AptRentVO vo) throws Exception {
		session.insert(namespace+".insertRentData", vo);
		
	}
	
	//매매 정보 넣기
	@Override
	public void insertTradeData(AptTradeVO vo) throws Exception {
		session.insert(namespace+".insertTradeData", vo);
	}
	
	//평수 가져오기
	@Override
	public List<Integer> get_area() throws Exception {
		return session.selectList(namespace+".area_list");
	}
	
	//최근 전세 정보
	@Override
	public int getLastRentData(int area) throws Exception {
		return session.selectOne(namespace+".getLastRentData", area);
	}
	
	//최근 매매 정보
	@Override
	public int getLastTradeData(int area) throws Exception {
		return session.selectOne(namespace+".getLastTradeData", area);
	}
	@Override
	public String getAptName() throws Exception {
		return session.selectOne(namespace+".getAptName");
	}
	
	
	//이번달 상한가 , 하한가
	@Override
	public List<LastDataListVO> monthlyRealEstate() throws Exception {
		return session.selectList(namespace+".monthlyRealEstate");
	}
	
	
	@Override
	public List<AnnualMinMaxVO> annualRent(int area) throws Exception {
		return session.selectList(namespace+".annualRent", area);
	}
	@Override
	public List<AnnualMinMaxVO> annualTrade(int area) throws Exception {
		return session.selectList(namespace+".annualTrade", area);
	}
	
	
	@Override
	public List<AnnualMinMaxVO> annualRentTrade(int area) throws Exception {
		return session.selectList(namespace+".annualRentTrade", area);
	}
	@Override
	public void deleteRentOldest() throws Exception {
		session.delete(namespace+".deleteRentOldest");
		
	}
	@Override
	public void deleteTradeOldest() throws Exception {
		session.delete(namespace+".deleteTradeOldest");
	}
	
	
}








