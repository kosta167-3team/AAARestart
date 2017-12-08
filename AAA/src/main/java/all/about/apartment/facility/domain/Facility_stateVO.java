package all.about.apartment.facility.domain;

import java.sql.Timestamp;

public class Facility_stateVO {

	private int fs_id;
	private String f_name;
	private int f_id;
	private String fs_start;
	private String fs_end;
	private String fs_reason;
	private Timestamp fs_regdate;

	public Facility_stateVO() {
	}

	public Facility_stateVO(int fs_id, String f_name, int f_id, String fs_start, String fs_end, String fs_reason,
			Timestamp fs_regdate) {
		super();
		this.fs_id = fs_id;
		this.f_name = f_name;
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

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getFs_start() {
		return fs_start;
	}

	public void setFs_start(Timestamp fs_start) {
		this.fs_start = Facility.TimestampToString(fs_start);
	}

	public String getFs_end() {
		return fs_end;
	}

	public void setFs_end(Timestamp fs_end) {
		this.fs_end = Facility.TimestampToString(fs_end);
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

	@Override
	public String toString() {
		return "Facility_stateVO [fs_id=" + fs_id + ", f_name=" + f_name + ", f_id=" + f_id + ", fs_start=" + fs_start
				+ ", fs_end=" + fs_end + ", fs_reason=" + fs_reason + ", fs_regdate=" + fs_regdate + "]";
	}

}