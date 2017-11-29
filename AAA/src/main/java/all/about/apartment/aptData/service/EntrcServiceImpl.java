package all.about.apartment.aptData.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.org.eclipse.jdt.core.compiler.ITerminalSymbols;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.wstx.util.SymbolTable;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import all.about.apartment.aptData.domain.ApartmentVO;
import all.about.apartment.aptData.persistence.EntrcDAO;

@Service
public class EntrcServiceImpl implements EntrcService {

	@Inject
	EntrcDAO dao;

	@Override
	public List<String> list_dongcode() throws Exception {
		return dao.list_dongcode();
	}

	@Override
	@ResponseBody
	public List<Map<String, Object>> apt_list(String dong_code)throws Exception {

		Map<String, Object> resultMap = new HashMap<>();

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1611000/AptListService/getLegaldongAptList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=IcNzhYlBXfA7zdFDpQcQj%2BMG00Nt6tqEQJKCsh0H2xIKSPMHSvPG4Q2VZnAcb05PCfm8SRCWyE2dCtAZDMADUA%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder.append("&" + URLEncoder.encode("loadCode", "UTF-8") + "="
				+ URLEncoder.encode(dong_code, "UTF-8")); /* 시군구번호+법정동번호 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /**/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("30", "UTF-8")); /**/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		//System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		// System.out.println(sb.toString());

		org.json.JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
		String xmlJSONObjString = xmlJSONObj.toString();
		// System.out.println("### xmlJSONObjString=>" + xmlJSONObjString);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map = objectMapper.readValue(xmlJSONObjString, new TypeReference<Map<String, Object>>() {
		});
		Map<String, Object> dataResponse = (Map<String, Object>) map.get("response");

		Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
		Map<String, Object> items = null;
		List<Map<String, Object>> itemList = null;
		
		System.out.println(body);

		int totalCount = (int)(body.get("totalCount"));

		items = (Map<String, Object>) body.get("items");
	
		if (body.get("items") == null || totalCount==0) {
			throw new Exception("검색결과 없음", new Throwable("검색결과없음"));
			
		}
		if(items.get("item") instanceof Map){
			Map<String, Object>item = (Map<String, Object>)(items.get("item"));
			itemList.add(item);
		}else{
			itemList = (List<Map<String,Object>>)(items.get("item"));
		}


		System.out.println(itemList.size());
		
		resultMap.put("Result", "0000");
		resultMap.put("numOfRows", body.get("numOfRows"));
		resultMap.put("pageNo", body.get("pageNo"));
		resultMap.put("totalCount", body.get("totalCount"));
		resultMap.put("data", itemList);

		resultMap.clear();
		resultMap.put("Result", "0001");

		return itemList;

	}

	@Override
	@ResponseBody
	public Map<String, Object> apt_detail(String kaptCode)	throws Exception {
		Map<String, Object> resultMap = new HashMap<>();

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1611000/AptBasisInfoService/getAphusBassInfo"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=IcNzhYlBXfA7zdFDpQcQj%2BMG00Nt6tqEQJKCsh0H2xIKSPMHSvPG4Q2VZnAcb05PCfm8SRCWyE2dCtAZDMADUA%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder
				.append("&" + URLEncoder.encode("kaptCode", "UTF-8") + "=" + URLEncoder.encode(kaptCode, "UTF-8")); /**/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		//System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		// System.out.println(sb.toString());

		org.json.JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
		String xmlJSONObjString = xmlJSONObj.toString();
		//System.out.println("### xmlJSONObjString=>" + xmlJSONObjString);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map = objectMapper.readValue(xmlJSONObjString, new TypeReference<Map<String, Object>>() {
		});

		Map<String, Object> dataResponse = (Map<String, Object>) map.get("response");
		if (dataResponse.get("body") == null) {
			throw new Exception("해당 정보 없음...");
		}
		Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
		Map<String, Object> items = null;
		List<Map<String, Object>> itemList = null;

		items = (Map<String, Object>) body.get("item");
		itemList = (List<Map<String, Object>>) items.get("item");

		resultMap.put("Result", "0000");
		resultMap.put("numOfRows", body.get("numOfRows"));
		resultMap.put("pageNo", body.get("pageNo"));
		resultMap.put("totalCount", body.get("totalCount"));
		resultMap.put("data", itemList);

		resultMap.clear();
		resultMap.put("Result", "0001");

		return items;

	}

	
	//우편번호 API
	@SuppressWarnings("unchecked")
	@Override
	@ResponseBody
	public List<Map<String, Object>> getPostNum(String kaptAddr) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();

		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=IcNzhYlBXfA7zdFDpQcQj%2BMG00Nt6tqEQJKCsh0H2xIKSPMHSvPG4Q2VZnAcb05PCfm8SRCWyE2dCtAZDMADUA%3D%3D"); /* Service Key */
		urlBuilder.append(
				"&" + URLEncoder.encode("srchwrd", "UTF-8") + "=" + URLEncoder.encode(kaptAddr, "UTF-8")); /* 검색어 */
		urlBuilder.append("&" + URLEncoder.encode("countPerPage", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 페이지당 출력될 개수를 지정(최대50) */
		urlBuilder.append("&" + URLEncoder.encode("currentPage", "UTF-8") + "="
				+ URLEncoder.encode("1", "UTF-8")); /* 출력될 페이지 번호 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		//System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//System.out.println(sb.toString());

		org.json.JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
		String xmlJSONObjString = xmlJSONObj.toString();
		
		//System.out.println("### xmlJSONObjString=>" + xmlJSONObjString);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map = objectMapper.readValue(xmlJSONObjString, new TypeReference<Map<String, Object>>() {
		});

		Map<String, Object> dataResponse = (Map<String, Object>) map.get("NewAddressListResponse");
//		if (dataResponse.get("newAddressListAreaCdSearchAll") == null) {
//			throw new Exception("해당 정보 없음...");
//		}
//		Map<String, Object> newAddressListAreaCdSearchAll = (Map<String, Object>) (dataResponse.get("newAddressListAreaCdSearchAll"));
		List<Map<String, Object>> newAddressListAreaCdSearchAll = new ArrayList<>();
		if((dataResponse.get("newAddressListAreaCdSearchAll")) instanceof Map){
			Map<String, Object> searchAllMap = (Map<String, Object>)((dataResponse.get("newAddressListAreaCdSearchAll")));
			newAddressListAreaCdSearchAll.add(searchAllMap);
		}else{
			
			newAddressListAreaCdSearchAll = (List<Map<String, Object>>) (dataResponse.get("newAddressListAreaCdSearchAll"));
		}
		
		
		//Map<String, Object> items = null;
		//List<Map<String, Object>> itemList = null;

		//items = (Map<String, Object>) body.get("item");
		//itemList = (List<Map<String, Object>>) items.get("item");

//		resultMap.put("Result", "0000");
//		resultMap.put("numOfRows", body.get("numOfRows"));
//		resultMap.put("pageNo", body.get("pageNo"));
//		resultMap.put("totalCount", body.get("totalCount"));
//		resultMap.put("data", itemList);

//		resultMap.clear();
//		resultMap.put("Result", "0001");

		return newAddressListAreaCdSearchAll;
	}

	@Override
	public Map<String, Object> getXY(String zipNO, int buildingNO) throws Exception {
		Map<String, Object> insertMap= new HashMap<>();
		
		insertMap.put("zipNO", zipNO);
		insertMap.put("buildingNO", buildingNO);
		
		return dao.getXY(insertMap);
	}

	@Override
	public void insertApt(ApartmentVO vo) throws Exception {
		dao.insertApt(vo);
		
	}

	//아파트 목록 
	@Override
	public List<ApartmentVO> aptList() throws Exception {
		return dao.aptList();
	}

	@Override
	public void updataLocation(ApartmentVO vo) throws Exception {
		dao.updataLocation(vo);
	}
}
