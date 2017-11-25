package all.about.apartment.facility.domain;

public class ReviewVO {

	private int rev_id;
	private String r_id;
	private int f_id;
	private String rev_contents;
	private String rev_date;
	private int rev_rate;
	
	public ReviewVO(){}
	
	

	public ReviewVO(int rev_id, String r_id, int f_id, String rev_contents, String rev_date, int rev_rate) {
		super();
		this.rev_id = rev_id;
		this.r_id = r_id;
		this.f_id = f_id;
		this.rev_contents = rev_contents;
		this.rev_date = rev_date;
		this.rev_rate = rev_rate;
	}



	public int getRev_id() {
		return rev_id;
	}

	public void setRev_id(int rev_id) {
		this.rev_id = rev_id;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getRev_contents() {
		return rev_contents;
	}

	public void setRev_contents(String rev_contents) {
		this.rev_contents = rev_contents;
	}

	public String getRev_date() {
		return rev_date;
	}

	public void setRev_date(String rev_date) {
		this.rev_date = rev_date;
	}

	public int getRev_rate() {
		return rev_rate;
	}

	public void setRev_rate(int rev_rate) {
		this.rev_rate = rev_rate;
	}

	@Override
	public String toString() {
		return "ReviewVO [rev_id=" + rev_id + ", r_id=" + r_id + ", f_id=" + f_id + ", rev_contents=" + rev_contents
				+ ", rev_date=" + rev_date + ", rev_rate=" + rev_rate + "]";
	}
	
	
}
