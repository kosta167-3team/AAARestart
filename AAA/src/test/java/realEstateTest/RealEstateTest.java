package realEstateTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import all.about.apartment.realEstate.domain.AnnualMinMaxVO;
import all.about.apartment.realEstate.domain.LastDataChartVO;
import all.about.apartment.realEstate.domain.LastDataListVO;
import all.about.apartment.realEstate.service.RealEstateService;
import oracle.net.aso.l;
import oracle.net.aso.s;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class RealEstateTest {
	@Inject
	RealEstateService service;

	
//	@Test
//	public void getAptCodeTest(){
//		
//		String dongname = "역삼동";
//		String loadNum = "754-1";
//		try {
//			String a = service.getAptCode(dongname, loadNum);
//			System.out.println(a);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	//전월세 자료 잘 가져오는지 Test
//	@Test
//	public void getRentDataTest(){
//		List<Map<String, Object>> list = null;
//		
//		try {
//			list = service.getRentData("201710");
//			System.out.println(list.size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//매매 자료 잘 가져오는지 TEST
//	@Test
//	public void getTradeDataTest(){
//		List<Map<String, Object>> list = null;
//		
//		try {
//			list = service.getRentData("201710");
//			for(Map<String, Object> map : list){
//				System.out.println(map);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void date(){
//		try {
//			service.inputData();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	
//	@Test
//	public void get_areaTest(){
//		List<Integer> list ;
//		
//		try {
//			list = service.get_area();
//			for(int a : list){
//				System.out.println(a);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	
	
//	@Test
//	public void getDatasTest(){
//		LastDataChartVO vo;
//		
//		try {
//			//평수를 넣어줌
//			vo = service.getLastData(34);
//			System.out.println(vo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	@Test
//	public void monthlyRealEstateTest(){
//		List<LastDataListVO> list ;
//		
//		try {
//			list = service.monthlyRealEstate();
//			
//			for(LastDataListVO vo :list){
//				System.out.println(vo.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void annualTradeListTest(){
//		List<AnnualMinMaxVO> list ;
//		
//		try {
//			//평수를 넣어줌
//			list = service.annualTrade(34);
//			
//			for(AnnualMinMaxVO vo : list){
//				System.out.println(vo.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void annualRentListTest(){
//		List<AnnualMinMaxVO> list ;
//		
//		try {
//			//평수를 넣어줌
//			list = service.annualRent(34);
//			
//			for(AnnualMinMaxVO vo : list){
//				System.out.println(vo.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void annualRentTradeTest(){
//		
//		
//		List<AnnualMinMaxVO> result = new ArrayList<>();
//		
//		try {
//			result = service.annualRentTrade(34);
//			
//			for(AnnualMinMaxVO vo: result){
//				System.out.println(vo.toString());
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	
//	
//	@Test
//	public void getTradeTest(){
//		List<Map<String, Object>> list ;
//		
//		try {
//			list = service.getTradeData("201711");
//			
//			for(Map< String, Object> map : list){
//				System.out.println(map);
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
//	@Test
//	public void test(){
//		String day = "^+";
//		Pattern p = Pattern.compile(day);
//		
//		Matcher m ; 
//		
//		m= p.matcher("11~10");
//		
//		if(m.find()){
//			System.out.println("매칭");
//		}
//	}
	

/*	
	@Test
	public void inputRentData(){
		
		List<Map<String, Object>> list;
		
		try {
			list = service.getRentData("201711");
			service.inputRentData(list, "11");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	
	@Test
	public void test(){
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;

		int day = cal.get(cal.DAY_OF_MONTH);
		
		String date = year+""+month;
		
		System.out.println(date +","+day);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}










