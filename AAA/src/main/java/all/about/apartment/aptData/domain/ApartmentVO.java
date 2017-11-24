package all.about.apartment.aptData.domain;

public class ApartmentVO {
	private String kaptCode;
	private String kaptName;
	private String sigungu;
	private String dong_name;
	private int kaptdaCnt;
	private double lat;
	private double lon;
	private String bjdCode;
	
	public String getBjdCode() {
		return bjdCode;
	}
	public void setBjdCode(String bjdCode) {
		this.bjdCode = bjdCode;
	}
	public String getKaptCode() {
		return kaptCode;
	}
	public void setKaptCode(String kaptCode) {
		this.kaptCode = kaptCode;
	}
	public String getKaptName() {
		return kaptName;
	}
	public void setKaptName(String kaptName) {
		this.kaptName = kaptName;
	}

	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getDong_name() {
		return dong_name;
	}
	public void setDong_name(String dong_name) {
		this.dong_name = dong_name;
	}

	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public int getKaptdaCnt() {
		return kaptdaCnt;
	}
	public void setKaptdaCnt(int kaptdaCnt) {
		this.kaptdaCnt = kaptdaCnt;
	}
	@Override
	public String toString() {
		return "ApartmentVO [kaptCode=" + kaptCode + ", kaptName=" + kaptName + ", sigungu=" + sigungu + ", dong_name="
				+ dong_name + ", kaptdaCnt=" + kaptdaCnt + ", lat=" + lat + ", lon=" + lon + ", bjdCode=" + bjdCode
				+ "]";
	}

}
