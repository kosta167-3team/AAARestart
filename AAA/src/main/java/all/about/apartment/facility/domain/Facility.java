package all.about.apartment.facility.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;

@Repository
public class Facility implements Serializable {

	private int f_id;
	private String f_name;
	private String f_contents;
	private int f_capa;
	private String f_state;
	private String f_open;
	private String f_close;

	public Facility() {
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_contents() {
		return f_contents;
	}

	public void setF_contents(String f_contents) {
		this.f_contents = f_contents;
	}

	public int getF_capa() {
		return f_capa;
	}

	public void setF_capa(int f_capa) {
		this.f_capa = f_capa;
	}

	public String getF_state() {
		return f_state;
	}

	public void setF_state(String f_state) {
		this.f_state = f_state;
	}

	public String getF_open() {
		return f_open;
	}

	public void setF_open(String f_open) {
		this.f_open = f_open;
	}

	public String getF_close() {
		return f_close;
	}

	public void setF_close(String f_close) {
		this.f_close = f_close;
	}

	@Override
	public String toString() {
		return "Facility [f_id=" + f_id + ", f_name=" + f_name + ", f_contents=" + f_contents + ", f_capa=" + f_capa
				+ ", f_state=" + f_state + ", f_open=" + f_open + ", f_close=" + f_close + "]";
	}

	public List<String> Set_date() {

		List<String> dateList = new ArrayList<String>();

		for (int i = 1; i < 8; i++) {

			Timestamp now = new Timestamp(System.currentTimeMillis());

			int today = now.getDate();
			now.setDate(today + i);

			// string으로 변환
			String date = TimestampToString(now);

			dateList.add(date);
		}

		return dateList;
	}

	// 타임스탬프 →스트링
	public String TimestampToString(Timestamp timestamp) {

		Calendar cal = Calendar.getInstance();

		cal.setTime(timestamp);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");

		String string = dateFormat.format(cal.getTime());

		return string;
	}

}
