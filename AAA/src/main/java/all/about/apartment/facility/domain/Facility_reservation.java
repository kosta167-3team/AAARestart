package all.about.apartment.facility.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

@Repository
public class Facility_reservation implements Serializable {

	private int fr_id;
	private int f_id;
	private int t_id;
	private String r_id;
	private int fr_cnt;
	private Timestamp fr_date;
	private String fr_qr;

	public int getFr_id() {
		return fr_id;
	}

	public void setFr_id(int fr_id) {
		this.fr_id = fr_id;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public int getFr_cnt() {
		return fr_cnt;
	}

	public void setFr_cnt(int fr_cnt) {
		this.fr_cnt = fr_cnt;
	}

	public Timestamp getFr_date() {
		return fr_date;
	}

	public void setFr_date(Timestamp fr_date) {
		this.fr_date = fr_date;
	}

	public String getFr_qr() {
		return fr_qr;
	}

	public void setFr_qr(String fr_qr) {
		this.fr_qr = fr_qr;
	}

	@Override
	public String toString() {
		return "Facility_reservation [fr_id=" + fr_id + ", f_id=" + f_id + ", t_id=" + t_id + ", r_id=" + r_id
				+ ", fr_cnt=" + fr_cnt + ", fr_date=" + fr_date + ", fr_qr=" + fr_qr + "]";
	}

}