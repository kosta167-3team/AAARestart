package all.about.apartment.facility.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Facility_state implements Serializable{

	private int fs_id;
	private int f_id;
	private Timestamp fs_start;
	private Timestamp fs_end;
	private String fs_reason;
	private Timestamp fs_regdate;

	public Facility_state() {
	}

	public Facility_state(int fs_id, int f_id, Timestamp fs_start, Timestamp fs_end, String fs_reason,
			Timestamp fs_regdate) {
		super();
		this.fs_id = fs_id;
		this.f_id = f_id;
		this.fs_start = fs_start;
		this.fs_end = fs_end;
		this.fs_reason = fs_reason;
		this.fs_regdate = fs_regdate;
	}

	public int getFs_id() {
		return fs_id;
	}

	public void setFs_id(int fs_id) {
		this.fs_id = fs_id;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public Timestamp getFs_start() {
		return fs_start;
	}

	public void setFs_start(Timestamp fs_start) {
		this.fs_start = fs_start;
	}

	public Timestamp getFs_end() {
		return fs_end;
	}

	public void setFs_end(Timestamp fs_end) {
		this.fs_end = fs_end;
	}

	public String getFs_reason() {
		return fs_reason;
	}

	public void setFs_reason(String fs_reason) {
		this.fs_reason = fs_reason;
	}

	public Timestamp getFs_regdate() {
		return fs_regdate;
	}

	public void setFs_regdate(Timestamp fs_regdate) {
		this.fs_regdate = fs_regdate;
	}

}
