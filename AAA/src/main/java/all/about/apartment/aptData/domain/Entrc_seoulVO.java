package all.about.apartment.aptData.domain;

public class Entrc_seoulVO {
	
	private String dong_code;
	private String si_name;
	private String gungu_name;
	private String dong_name;
	private double x;
	private double y;
	private double lat;
	private double lon;
	
	
	public String getDong_code() {
		return dong_code;
	}
	public void setDong_code(String dong_code) {
		this.dong_code = dong_code;
	}
	public String getSi_name() {
		return si_name;
	}
	public void setSi_name(String si_name) {
		this.si_name = si_name;
	}
	public String getGungu_name() {
		return gungu_name;
	}
	public void setGungu_name(String gungu_name) {
		this.gungu_name = gungu_name;
	}
	public String getDong_name() {
		return dong_name;
	}
	public void setDong_name(String dong_name) {
		this.dong_name = dong_name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Entrc_seoulVO [dong_code=" + dong_code + ", si_name=" + si_name + ", gungu_name=" + gungu_name
				+ ", dong_name=" + dong_name + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
