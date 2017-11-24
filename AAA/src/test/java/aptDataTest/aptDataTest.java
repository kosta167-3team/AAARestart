package aptDataTest;


import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import all.about.apartment.aptData.domain.ApartmentVO;
import all.about.apartment.aptData.service.EntrcService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class aptDataTest {

	@Inject
	EntrcService service ;

//	
//	@Test
//	public void aptListTest(){
//		HttpServletRequest request = null;
//		HttpServletResponse response = null;
//		Map<String, Object> map = null;
//		try {
//			map = service.apt_list("1111017400", request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println();
//		System.out.println(map);
//	}
//	
	@Test
	public void aptDetailTest(){
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		Map<String, Object> map = null;
		try {
			map = service.apt_detail("A13402304");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ApartmentVO apartmentVO = new ApartmentVO();
		
		String kaptName = (String) (map.get("kaptName"));
		String bjdCode = ((int) map.get("bjdCode"))+"";
		int kaptdaCnt =(int) map.get("kaptdaCnt");
		String kaptCode = (String)(map.get("kaptCode"));
		String kaptAddr = (String)(map.get("kaptAddr"));
		
		StringTokenizer token = new StringTokenizer(kaptAddr, " ");
		token.nextToken();
		
		
		
		apartmentVO.setSigungu(token.nextToken());
		apartmentVO.setDong_name(token.nextToken() + token.nextToken());
		apartmentVO.setKaptName(kaptName);
		apartmentVO.setKaptCode(kaptCode);
		apartmentVO.setBjdCode(bjdCode);
		
		getXYTest(apartmentVO);
		
//		System.out.println(apartmentVO);
//		System.out.println();
//		System.out.println(map);
	}
	
//	//우편번호 API 조회
//	@Test
//	public void checkPostApi(){
//		Map<String, Object> map = null;
//		
//		try {
//			map = service.getPostNum("명륜2가237 ");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(map);
//	}
	
	//getXY 테스트
//	@Test
	public void getXYTest(ApartmentVO vo){
		List<Map <String,Object>> map1 = null;
		Map <String,Object> map2= null;
		
		
		try {
			map1 = service.getPostNum(vo.getDong_name());
			for(Map<String, Object> map : map1){
				
				String zipNO = (String) map.get("zipNo");
				String lnmAdres = (String)map.get("lnmAdres");
				
				StringTokenizer token2 = new StringTokenizer(lnmAdres, " ");
				token2.nextToken();
				token2.nextToken();
				token2.nextToken();
				
				System.out.println(map);
				
				String buString = token2.nextToken();
				int buildingNO ;
				try {
					buildingNO = Integer.parseInt(buString);
				} catch (Exception e) {
					e.getMessage();
					System.out.println("건물번호에 문자열 있음");
					StringTokenizer errortoken = new StringTokenizer(buString, "-"); 
					buString = errortoken.nextToken();
					buildingNO = Integer.parseInt(buString);
				}
				
				System.out.println(buildingNO);
				
				map2 = service.getXY(zipNO, buildingNO);
				
				System.out.println(map2);
				
				String x = String.valueOf(map2.get("X"));
				String y = String.valueOf(map2.get("Y"));
				
				double X = Double.parseDouble(x);
				double Y = Double.parseDouble(y);
				
				vo.setLat(Y);
				vo.setLon(X);
			}
			
			
			System.out.println(vo.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(map);
	}

}




















