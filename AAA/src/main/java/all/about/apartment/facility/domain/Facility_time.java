package all.about.apartment.facility.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Facility_time implements Serializable{

	private int t_id;
	private String t_start;
	private String t_end;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_start() {
		return t_start;
	}

	public void setT_start(String t_start) {
		this.t_start = t_start;
	}

	public String getT_end() {
		return t_end;
	}

	public void setT_end(String t_end) {
		this.t_end = t_end;
	}

	@Override
	public String toString() {
		return "Facility_time [t_id=" + t_id + ", t_start=" + t_start + ", t_end=" + t_end + "]";
	}

}
