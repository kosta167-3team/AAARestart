package all.about.apartment.aptData.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.wstx.util.SymbolTable;

import all.about.apartment.aptData.domain.ApartmentVO;
import all.about.apartment.aptData.service.EntrcService;

@RestController
@RequestMapping("/aptData/rest")
public class AptDataRestController {

	@Inject
	EntrcService service;

	@RequestMapping(value = "/dong_list", method = RequestMethod.GET)
	public ResponseEntity<List<String>> dong_list() {
		ResponseEntity<List<String>> entity = null;

		try {
			List<String> list = service.list_dongcode();

			entity = new ResponseEntity<List<String>>(list, HttpStatus.OK);
			for(String dong_code : list){
			//	System.out.println(k);
				//aptlist(dong_code);
				
			}
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	
	@RequestMapping(value = "/aptlist/{dong_code}", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> aptlist(@PathVariable String dong_code) {
		
		ResponseEntity<List<Map<String, Object>>> entity = null;

		//Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> listMap = null;
		
		System.out.println(dong_code);

		try {
			listMap = service.apt_list(dong_code);
			
			for(Map<String, Object> map : listMap){
				System.out.println("아파트 목록" + map);
			
			}
			entity = new ResponseEntity<List<Map<String, Object>>>(listMap,HttpStatus.OK);
			

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Map<String, Object>>>(HttpStatus.BAD_REQUEST);

		}
		//System.out.println("아파트 목록"+map);
		return entity;
	}

	@RequestMapping(value = "/aptdetail", method = RequestMethod.POST)
	public void aptDetail(@RequestBody ApartmentVO vo) {

		// System.out.println(vo.toString());
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> xyMap = new HashMap<>();

		try {
			map = (Map<String, Object>) service.apt_detail(vo.getKaptCode());
			 System.out.println("아파트 세부정보"+map);
			ApartmentVO apartmentVO = new ApartmentVO();

			if (map != null) {

				String kaptName = (String) (map.get("kaptName"));
				String bjdCode = ((int) map.get("bjdCode")) + "";
				int kaptdaCnt = (int) map.get("kaptdaCnt");
				String kaptCode = (String) (map.get("kaptCode"));
				String kaptAddr = (String) (map.get("kaptAddr"));

				StringTokenizer token1 = new StringTokenizer(kaptAddr, " ");
				token1.nextToken();

				apartmentVO.setSigungu(token1.nextToken());
				apartmentVO.setDong_name(token1.nextToken() + token1.nextToken());
				apartmentVO.setKaptName(kaptName);
				apartmentVO.setKaptCode(kaptCode);
				apartmentVO.setBjdCode(bjdCode);
				apartmentVO.setKaptdaCnt(kaptdaCnt);

				List<Map<String, Object>> postMapList = service.getPostNum(apartmentVO.getDong_name());
				for (Map<String, Object> map1 : postMapList) {

					String zipNO = (String) map1.get("zipNo");
					String lnmAdres = (String) map1.get("lnmAdres");

					StringTokenizer token2 = new StringTokenizer(lnmAdres, " ");
					token2.nextToken();
					token2.nextToken();
					token2.nextToken();

					System.out.println("우편정보"+map1);

					String buString = token2.nextToken();
					int buildingNO;
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

					if (service.getXY(zipNO, buildingNO) != null) {
						xyMap = service.getXY(zipNO, buildingNO);

						System.out.println(xyMap);

						String x = String.valueOf(xyMap.get("X"));
						String y = String.valueOf(xyMap.get("Y"));

						System.out.println(x + "," + y);

						double X = Double.parseDouble(x);
						double Y = Double.parseDouble(y);

						apartmentVO.setLat(Y);
						apartmentVO.setLon(X);

						System.out.println(apartmentVO.toString());

						service.insertApt(apartmentVO);

					}
					
				}

				// System.out.println(zipNO + " " + buildingNO);

				// System.out.println(apartmentVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value="/allAptList", method = RequestMethod.GET)
	public ResponseEntity<List<ApartmentVO>> allAptList(){
		System.out.println("AptRestController... > allAptList");
		ResponseEntity<List<ApartmentVO>> entityList = null;
		List<ApartmentVO> aptList = null;
		
		try {
			aptList = service.aptList();
			entityList = new ResponseEntity<List<ApartmentVO>>(aptList, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entityList = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		 
		return entityList;
	}
	
	
	

}
