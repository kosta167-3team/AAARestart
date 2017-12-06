package all.about.apartment.facility.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_reservation;
import all.about.apartment.facility.domain.Facility_state;
import all.about.apartment.facility.domain.Facility_time;
import all.about.apartment.facility.persistence.FacilityDAO;
import all.about.apartment.message.domain.MessageDTO;
import all.about.apartment.message.persistence.MessageDAO;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Inject
	FacilityDAO facilityDao;

	@Inject
	MessageDAO messageDao;

	private static int open;
	private static int close;

	public List<Facility> getFacilityList() throws Exception {

		return facilityDao.getFacilityList();
	}

	public Facility getDetail(int f_id) throws Exception {

		return facilityDao.getDetail(f_id);
	}

	public Map<String, List<Object>> getOptions(Map<String, Object> map) throws Exception {

		int f_id = (int) map.get("f_id");

		System.out.println("운영시간 확인 - 시설번호 " + f_id);

		Map<String, List<Object>> options = new HashMap<>();

		Facility facility = facilityDao.getDetail(f_id);
		List<Facility_time> timeTable = facilityDao.getTimetable();

		for (int i = 0; i < timeTable.size(); i++) {

			if (timeTable.get(i).getT_start().equals(facility.getF_open())) {
				open = timeTable.get(i).getT_id();
			}
			if (timeTable.get(i).getT_end().equals(facility.getF_close())) {
				close = timeTable.get(i).getT_id();
			}
		}

		List<Object> runningTime = new ArrayList<>();
		List<Object> spotList = new ArrayList<>();

		for (int j = open - 1; j < close; j++) {
			runningTime.add(timeTable.get(j));

			map.put("t_id", j + 1);
			spotList.add(getSpot(map));

		}

		options.put("runningTime", runningTime);
		options.put("spotList", spotList);

		return options;
	}

	public int getSpot(Map<String, Object> map) throws Exception {

		int f_id = (int) map.get("f_id");

		Integer taken = facilityDao.getSpot(map);

		if (taken == null) {

			taken = 0;
		}

		Facility facility = facilityDao.getDetail(f_id);
		int f_capa = facility.getF_capa();

		int spot = f_capa - taken;

		return spot;
	}

	public Integer checkDoubleBook(Map<String, Object> map) throws Exception {

		Integer ok = facilityDao.checkDoubleBook(map);

		System.out.println("중복 예약 번호 - " + ok);

		return ok;
	}

	public void insertReservation(Map<String, Object> map) throws Exception {
		facilityDao.insertReservation(map);
	}

	public Facility_reservation getOneReservation(int fr_id) throws Exception {

		return facilityDao.getOneReservation(fr_id);
	}

	public int cancelReservation(int fr_id) throws Exception {

		return facilityDao.cancelReservation(fr_id);
	}

	@Override
	public List<Facility_reservation> getReservationList(Map<String, Object> map) throws Exception {

		return facilityDao.getReservationList(map);
	}

	@Override
	public List<Facility_time> getTimetable() throws Exception {

		return facilityDao.getTimetable();
	}

	@Override
	public String getReservationQR(int fr_id) throws Exception {

		String imgPath = "";

		File file = null;
		String imgpath = "/C:/Users/conve/git/AAA/AAA/src/main/webapp/resources/images/facility_qr";

		file = new File(imgpath);

		if (!file.exists()) {
			file.mkdirs();
		}

		String fr_id_qr = Integer.toString(fr_id);
		int qrcodeColor = 0xFF2e4e96;
		int backgroundColor = 0xFFFFFFFF;

		QRCodeWriter qrCodeWriter = new QRCodeWriter();

		BitMatrix bitMatrix = qrCodeWriter.encode(fr_id_qr, BarcodeFormat.QR_CODE, 200, 200);

		MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);
		BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);

		ImageIO.write(bufferedImage, "png", new File(imgpath + "/" + fr_id_qr + ".png"));

		imgPath = imgpath + "/" + fr_id_qr + ".png";

		return imgPath;
	}

	// 초 분 시 일 월 요일 년
	@Scheduled(cron = "50 8 14 * * * ")
	@Override
	public void deleteQR() throws Exception {

		System.out.println("스케쥴러 - qr 삭제");

		File file = null;
		String imgpath = "/C:/Users/conve/git/AAA/AAA/src/main/webapp/resources/images/facility_qr";

		file = new File(imgpath);

		// 파일을 배열로 받기
		File[] fileArr = file.listFiles();

		if (fileArr.length > 0) {

			for (int i = 0; i < fileArr.length; i++) {

				fileArr[i].delete();
			}
		}
	}

	@Override
	public List<String> getCancelmsgList(Map<String, Object> map) throws Exception {

		return facilityDao.getCancelmsgList(map);
	}

	@Override
	public void cancelAllReservation(Map<String, Object> map) throws Exception {

		facilityDao.cancelAllReservation(map);
	}

	@Scheduled(cron = "0 25 15 * * *")
	@Override
	public void alterFacilityState() throws Exception {

		System.out.println("스케쥴러 - 시설 상태 변경");

		facilityDao.alterState_bad();
		facilityDao.alterState_ok();
	}

	@Override
	public List<String> getDateList(int f_id) throws Exception {

		List<Timestamp> list = Facility.Set_date();
		Map<String, Object> map = new HashMap<>();

		System.out.println("서비스 임플리먼트" + f_id);

		map.put("f_id", f_id);

		List<String> dateList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			map.put("date", list.get(i));

			System.out.println(list.get(i));

			if (facilityDao.checkState(map) == 0) {

				String date = Facility.TimestampToString(list.get(i));

				dateList.add(date);
			}

			System.out.println("dateList:" + dateList.size());

		}

		return dateList;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public int insertState(Facility_state state) throws Exception {

		facilityDao.insertState(state);

		Map<String, Object> cancelMap = new HashMap<>();

		cancelMap.put("f_id", state.getF_id());
		cancelMap.put("fs_start", state.getFs_start());
		cancelMap.put("fs_end", state.getFs_end());

		List<String> receiver = facilityDao.getCancelmsgList(cancelMap);

		if (receiver.size() > 0) {

			MessageDTO messageDTO = new MessageDTO();

			messageDTO.setMsg_content(state.getFs_reason());
			messageDTO.setSender("wjdrl123");
			messageDTO.setType_id(7);

			// 1.취소하기
			facilityDao.cancelAllReservation(cancelMap);

			for (int i = 0; i < receiver.size(); i++) {

				messageDTO.setReceiver(receiver.get(i));
				try {
					messageDao.sendMessage(messageDTO);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		return receiver.size();
	}

	
	@Override
	public List<Facility_state> getStateList() throws Exception {
		 
		return facilityDao.getStateList();
	}

	
	@Override
	public void deleteState(int fs_id) throws Exception {
	
		facilityDao.deleteState(fs_id);
		
	}
}