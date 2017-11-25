package all.about.apartment.facility.domain;

public class TodayGuest {
	private int vh_id;
	private int vh_dong;
	private int vh_ho;
	private String vh_date;
	private String r_id;
	private String vh_name;
	private String vh_contents;
	private String vh_car;
	private String vr_id;
	private String vh_tel;
	private String vh_check;
	
	public TodayGuest(){}
	
	

	public TodayGuest(int vh_id, int vh_dong, int vh_ho, String vh_date, String r_id, String vh_name,
			String vh_contents, String vh_car, String vr_id, String vh_tel, String vh_check) {
		super();
		this.vh_id = vh_id;
		this.vh_dong = vh_dong;
		this.vh_ho = vh_ho;
		this.vh_date = vh_date;
		this.r_id = r_id;
		this.vh_name = vh_name;
		this.vh_contents = vh_contents;
		this.vh_car = vh_car;
		this.vr_id = vr_id;
		this.vh_tel = vh_tel;
		this.vh_check = vh_check;
	}



	public int getVh_id() {
		return vh_id;
	}

	public void setVh_id(int vh_id) {
		this.vh_id = vh_id;
	}

	public int getVh_dong() {
		return vh_dong;
	}

	public void setVh_dong(int vh_dong) {
		this.vh_dong = vh_dong;
	}

	public int getVh_ho() {
		return vh_ho;
	}

	public void setVh_ho(int vh_ho) {
		this.vh_ho = vh_ho;
	}

	public String getVh_date() {
		return vh_date;
	}

	public void setVh_date(String vh_date) {
		this.vh_date = vh_date;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getVh_name() {
		return vh_name;
	}

	public void setVh_name(String vh_name) {
		this.vh_name = vh_name;
	}

	public String getVh_contents() {
		return vh_contents;
	}

	public void setVh_contents(String vh_contents) {
		this.vh_contents = vh_contents;
	}

	public String getVh_car() {
		return vh_car;
	}

	public void setVh_car(String vh_car) {
		this.vh_car = vh_car;
	}

	public String getVr_id() {
		return vr_id;
	}

	public void setVr_id(String vr_id) {
		this.vr_id = vr_id;
	}

	public String getVh_tel() {
		return vh_tel;
	}

	public void setVh_tel(String vh_tel) {
		this.vh_tel = vh_tel;
	}

	public String getVh_check() {
		return vh_check;
	}

	public void setVh_check(String vh_check) {
		this.vh_check = vh_check;
	}

	@Override
	public String toString() {
		return "TodayGuest [vh_id=" + vh_id + ", vh_dong=" + vh_dong + ", vh_ho=" + vh_ho + ", vh_date=" + vh_date
				+ ", r_id=" + r_id + ", vh_name=" + vh_name + ", vh_contents=" + vh_contents + ", vh_car=" + vh_car
				+ ", vr_id=" + vr_id + ", vh_tel=" + vh_tel + ", vh_check=" + vh_check + "]";
	}
	
	

}
