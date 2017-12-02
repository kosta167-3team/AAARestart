package all.about.apartment.realEstate.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import all.about.apartment.realEstate.domain.AnnualMinMaxVO;
import all.about.apartment.realEstate.domain.AptRentVO;
import all.about.apartment.realEstate.domain.AptTradeVO;
import all.about.apartment.realEstate.domain.LastDataChartVO;
import all.about.apartment.realEstate.domain.LastDataListVO;
import all.about.apartment.realEstate.persistence.RealEstateDAO;

@Service
public class RealEstateServiceImpl implements RealEstateService {

	@Inject
	RealEstateDAO dao;

	// @Scheduled(fixedRate = 5000)
	// public void test() {
	// System.out.println("Sceduler test...");
	// }

	// @Scheduled(cron ="0 18 20 ? ? ? ?")

	@Scheduled(cron = "0 30 20 30,31 * *")
	public void test() {
		System.out.println("dddd");
	}

	@Scheduled(cron = "0 0 15 2 * *")
	@Transactional
	public void firstAutoUpdate() {
		Calendar cal = Calendar.getInstance();

		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;

		int day = cal.get(cal.DAY_OF_MONTH) - 1;

		String date = year + "" + month;
		try {
			deleteOldest();
			inputRentData(getRentData(date), "" + day);
			inputTradeData(getTradeData(date), "" + day);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Scheduled(cron = "0 0 10 12,22 * *")
	public void autoUpdate() {

		Calendar cal = Calendar.getInstance();

		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;

		int day = cal.get(cal.DAY_OF_MONTH) - 1;

		String date = year + "" + month;

		try {
			inputRentData(getRentData(date), "" + day);
			inputTradeData(getTradeData(date), "" + day);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getAptCode(String aptName, String dongname, String loadNum) throws Exception {

		Map<String, Object> map = new HashMap<>();
		String name = dongname + loadNum;

		String aptname = "%" + aptName + "%";

		map.put("dongname", name);
		map.put("aptname", aptname);

		// System.out.println(name);

		// System.out.println(dao.dongCnt(name));
		Integer dongcnt = dao.dongCnt(name);

		if (dongcnt == null) {
			return null;
		} else if (dongcnt == 1) {
			return dao.getAptCode(name);
		} else {
			return dao.getdetailAptCode(map);
		}

	}

	// 전세 정보 API
	@Override
	public List<Map<String, Object>> getRentData(String deal_ymd) throws Exception {

		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=OI5LYNDHa%2Bq3Qa6rIeQ%2BnJG8XYqzWPAZQPm5phhjuYYxb2KSIgLFTLqzU9PlMe6jiw55PTPUQJ8Ztg4urkLdIw%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "="
				+ URLEncoder.encode("11680", "UTF-8")); /* 각 지역별 코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode(deal_ymd, "UTF-8")); /* 월 단위 신고자료 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		// System.out.println("Response code: " + conn.getResponseCode());
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

		JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
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

		// System.out.println(body);

		int totalCount = (int) (body.get("totalCount"));

		items = (Map<String, Object>) body.get("items");

		if (body.get("items") == null || totalCount == 0) {
			throw new Exception("검색결과 없음", new Throwable("검색결과없음"));

		}
		if (items.get("item") instanceof Map) {
			Map<String, Object> item = (Map<String, Object>) (items.get("item"));
			itemList.add(item);
		} else {
			itemList = (List<Map<String, Object>>) (items.get("item"));
		}

		// System.out.println(itemList.size());

		return itemList;
	}

	// 매매 정보 API
	@Override
	public List<Map<String, Object>> getTradeData(String deal_ymd) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=OI5LYNDHa%2Bq3Qa6rIeQ%2BnJG8XYqzWPAZQPm5phhjuYYxb2KSIgLFTLqzU9PlMe6jiw55PTPUQJ8Ztg4urkLdIw%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "="
				+ URLEncoder.encode("11680", "UTF-8")); /* 각 지역별 코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode(deal_ymd, "UTF-8")); /* 월 단위 신고자료 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		// System.out.println("Response code: " + conn.getResponseCode());
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

		JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
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

		// System.out.println(body);

		int totalCount = (int) (body.get("totalCount"));

		items = (Map<String, Object>) body.get("items");

		if (body.get("items") == null || totalCount == 0) {
			throw new Exception("검색결과 없음", new Throwable("검색결과없음"));

		}
		if (items.get("item") instanceof Map) {
			Map<String, Object> item = (Map<String, Object>) (items.get("item"));
			itemList.add(item);
		} else {
			itemList = (List<Map<String, Object>>) (items.get("item"));
		}

		// System.out.println(itemList.size());

		return itemList;
	}

	// 1년치 전세 매매 정보 가져오기
	@Override
	public void inputData() throws Exception {

		Calendar cal = Calendar.getInstance();

		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;

		int day = cal.get(cal.DAY_OF_MONTH);

		int remonth = month + 1;
		int reyear = year;
		for (int i = 0; i <= 11; i++) {
			remonth--;

			String strMonth = "";
			if (remonth < 1) {
				remonth += 12;
				reyear--;

			}
			if (remonth < 10) {
				strMonth = "0";
			}

			strMonth += remonth;
			String date = reyear + strMonth;
			// System.out.println(date);
			inputRentData(getRentData(date), "");
			inputTradeData(getTradeData(date), "");
		}

	}

	@Override
	public void inputRentData(List<Map<String, Object>> rent_list, String day) throws Exception {

		String dayPattern = "^" + day + "+";
		Pattern pattern = Pattern.compile(dayPattern);
		Matcher m;

		for (Map<String, Object> map : rent_list) {

			String dataDay = (String) map.get("일");

			m = pattern.matcher(dataDay);

			if (m.find()) {
				int deposit;
				if (map.get("월세금액") instanceof String) {
					deposit = Integer.parseInt(((String) map.get("월세금액")).replaceAll("[^0-9]", ""));
				} else {
					deposit = (int) map.get("월세금액");
				}
				if (deposit == 0) {
					System.out.println(map);
					String dong = (String) map.get("법정동");

					String roadNum = "";

					if (map.get("지번") instanceof Integer) {
						int lotNum = (int) map.get("지번");
						roadNum += lotNum;
					} else {
						roadNum = (String) map.get("지번");
					}
					// System.out.println(dong + roadNum);

					String aptname = ((String) map.get("아파트"));
					aptname = aptname.replaceAll(" ", "%");
					aptname = aptname.replaceAll("동", "%");

					// System.out.println(aptname);

					String aptCode = getAptCode(aptname, dong, roadNum);

					if (aptCode == null) {
						continue;
					}

					AptRentVO vo = new AptRentVO();
					int rent_area;
					if (map.get("전용면적") instanceof Double) {
						rent_area = (int) ((double) map.get("전용면적"));
					} else {

						rent_area = (int) (map.get("전용면적"));
					}
					int rent_deposit = Integer.parseInt(((String) map.get("보증금액")).replaceAll("[^0-9]", ""));
					int rent_year = (int) map.get("년");
					int rent_month = (int) map.get("월");

					vo.setApartcode(aptCode);
					vo.setRent_area(rent_area);
					vo.setRent_year(rent_year);
					vo.setRent_month(rent_month);
					vo.setRent_deposit(rent_deposit);

					// System.out.println(vo.toString());
					dao.insertRentData(vo);
				}
			}
		}

	}

	@Override
	public void inputTradeData(List<Map<String, Object>> trade_list, String day) throws Exception {

		String dayPattern = "^" + day + "+";
		Pattern pattern = Pattern.compile(dayPattern);
		Matcher m;

		for (Map<String, Object> map : trade_list) {
			String dataDay = (String) map.get("일");

			m = pattern.matcher(dataDay);

			if (m.find()) {

				String dong = (String) map.get("법정동");

				String roadNum = "";

				if (map.get("지번") instanceof Integer) {
					int lotNum = (int) map.get("지번");
					roadNum += lotNum;
				} else {
					roadNum = (String) map.get("지번");
				}
				// System.out.println(dong + roadNum);

				String aptname = ((String) map.get("아파트"));
				aptname = aptname.replaceAll(" ", "%");
				aptname = aptname.replaceAll("동", "%");

				// System.out.println(aptname);

				String aptCode = getAptCode(aptname, dong, roadNum);

				if (aptCode == null) {
					continue;
				}

				AptTradeVO vo = new AptTradeVO();
				int trade_area;
				if (map.get("전용면적") instanceof Double) {
					trade_area = (int) ((double) map.get("전용면적"));
				} else {

					trade_area = (int) (map.get("전용면적"));
				}
				int trade_price = Integer.parseInt(((String) map.get("거래금액")).replaceAll("[^0-9]", ""));
				int trade_year = (int) map.get("년");
				int trade_month = (int) map.get("월");

				vo.setApartcode(aptCode);
				vo.setTrade_area(trade_area);
				vo.setTrade_price(trade_price);
				vo.setTrade_year(trade_year);
				vo.setTrade_month(trade_month);

				// System.out.println(vo.toString());
				dao.insertTradeData(vo);
			}
		}
	}

	@Override
	public List<Integer> get_area() throws Exception {
		return dao.get_area();
	}

	@Override
	public LastDataChartVO getLastData(int area) throws Exception {

		LastDataChartVO vo = new LastDataChartVO();

		vo.setKaptname(dao.getAptName());
		vo.setRent_deposit(dao.getLastRentData(area));
		vo.setTrade_price(dao.getLastTradeData(area));

		return vo;
	}

	@Override
	public List<LastDataListVO> monthlyRealEstate() throws Exception {

		List<LastDataListVO> list = dao.monthlyRealEstate();
		List<LastDataListVO> result = new ArrayList<>();

		for (LastDataListVO vo : list) {
			vo.setKaptname(dao.getAptName());
			if (vo.getRent_area() != null) {
				vo.setArea(vo.getRent_area());
			} else if (vo.getTrade_area() != null) {
				vo.setArea(vo.getRent_area());
			}

			result.add(vo);

		}

		return result;
	}

	@Override
	public List<AnnualMinMaxVO> annualRent(int area) throws Exception {
		return dao.annualRent(area);
	}

	@Override
	public List<AnnualMinMaxVO> annualTrade(int area) throws Exception {
		return dao.annualTrade(area);
	}

	@Override
	public List<AnnualMinMaxVO> annualRentTrade(int area) throws Exception {
		return dao.annualRentTrade(area);
	}

	// 가장 오래된 달 지우기
	@Override
	public void deleteOldest() throws Exception {
		dao.deleteRentOldest();
		dao.deleteTradeOldest();
	}

}
