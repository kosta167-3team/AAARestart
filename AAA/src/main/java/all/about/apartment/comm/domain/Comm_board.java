package all.about.apartment.comm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Comm_board implements Serializable {

	private int cb_no;
	private int cb_interest;
	private String cb_contents;
	private String r_id;
	private Timestamp cb_regdate;

	public Comm_board() {
	}

	public Comm_board(int cb_no, int cb_interest, String cb_contents, String r_id, Timestamp cb_regdate) {
		super();
		this.cb_no = cb_no;
		this.cb_interest = cb_interest;
		this.cb_contents = cb_contents;
		this.r_id = r_id;
		this.cb_regdate = cb_regdate;
	}

	public int getCb_no() {
		return cb_no;
	}

	public void setCb_no(int cb_no) {
		this.cb_no = cb_no;
	}

	public int getCb_interest() {
		return cb_interest;
	}

	public void setCb_interest(int cb_interest) {
		this.cb_interest = cb_interest;
	}

	public String getCb_contents() {
		return cb_contents;
	}

	public void setCb_contents(String cb_contents) {
		this.cb_contents = cb_contents;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public Timestamp getCb_regdate() {
		return cb_regdate;
	}

	public void setCb_regdate(Timestamp cb_regdate) {
		this.cb_regdate = cb_regdate;
	}

	@Override
	public String toString() {
		return "Comm_board [cb_no=" + cb_no + ", cb_interest=" + cb_interest + ", cb_contents=" + cb_contents
				+ ", r_id=" + r_id + ", cb_regdate=" + cb_regdate + "]";
	}

}
