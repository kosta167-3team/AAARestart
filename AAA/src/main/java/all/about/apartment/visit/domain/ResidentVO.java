package all.about.apartment.visit.domain;

public class ResidentVO {
	private String r_id;
	private String r_name;
	private String r_pw;
	private String r_tel;
	private String r_dong;
	private String r_ho;
	private String r_authority;
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_pw() {
		return r_pw;
	}
	public void setR_pw(String r_pw) {
		this.r_pw = r_pw;
	}
	public String getR_tel() {
		return r_tel;
	}
	public void setR_tel(String r_tel) {
		this.r_tel = r_tel;
	}
	public String getR_dong() {
		return r_dong;
	}
	public void setR_dong(String r_dong) {
		this.r_dong = r_dong;
	}
	public String getR_ho() {
		return r_ho;
	}
	public void setR_ho(String r_ho) {
		this.r_ho = r_ho;
	}
	public String getR_authority() {
		return r_authority;
	}
	public void setR_authority(String r_authority) {
		this.r_authority = r_authority;
	}
	@Override
	public String toString() {
		return "ResidentVO [r_id=" + r_id + ", r_name=" + r_name + ", r_pw=" + r_pw + ", r_tel=" + r_tel + ", r_dong="
				+ r_dong + ", r_ho=" + r_ho + ", r_authority=" + r_authority + "]";
	}	
}
