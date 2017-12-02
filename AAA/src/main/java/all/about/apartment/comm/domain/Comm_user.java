package all.about.apartment.comm.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Comm_user implements Serializable {

	private String r_id;
	private int cu_size;
	private int cu_interest;
	private int cu_type;

	public Comm_user() {
	}

	public Comm_user(String r_id, int cu_size, int cu_interest, int cu_type) {
		super();
		this.r_id = r_id;
		this.cu_size = cu_size;
		this.cu_interest = cu_interest;
		this.cu_type = cu_type;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public int getCu_size() {
		return cu_size;
	}

	public void setCu_size(int cu_size) {
		this.cu_size = cu_size;
	}

	public int getCu_interest() {
		return cu_interest;
	}

	public void setCu_interest(int cu_interest) {
		this.cu_interest = cu_interest;
	}

	public int getCu_type() {
		return cu_type;
	}

	public void setCu_type(int cu_type) {
		this.cu_type = cu_type;
	}

	@Override
	public String toString() {
		return "Comm_user [r_id=" + r_id + ", cu_size=" + cu_size + ", cu_interest=" + cu_interest + ", cu_type="
				+ cu_type + "]";
	}

}
