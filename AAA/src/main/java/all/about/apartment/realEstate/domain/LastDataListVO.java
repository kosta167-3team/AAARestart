package all.about.apartment.realEstate.domain;

public class LastDataListVO {
	private String kaptname;

	private Integer trade_max;
	private Integer trade_min;
	
	private Integer rent_max;
	private Integer rent_min;
	
	private Integer rent_area;
	private Integer trade_area;
	
	private int area;

	
	public String getKaptname() {
		return kaptname;
	}


	public void setKaptname(String kaptname) {
		this.kaptname = kaptname;
	}


	public Integer getTrade_max() {
		return trade_max;
	}


	public void setTrade_max(Integer trade_max) {
		this.trade_max = trade_max;
	}


	public Integer getTrade_min() {
		return trade_min;
	}


	public void setTrade_min(Integer trade_min) {
		this.trade_min = trade_min;
	}


	public Integer getRent_max() {
		return rent_max;
	}


	public void setRent_max(Integer rent_max) {
		this.rent_max = rent_max;
	}


	public Integer getRent_min() {
		return rent_min;
	}


	public void setRent_min(Integer rent_min) {
		this.rent_min = rent_min;
	}


	public Integer getRent_area() {
		return rent_area;
	}


	public void setRent_area(Integer rent_area) {
		this.rent_area = rent_area;
	}


	public Integer getTrade_area() {
		return trade_area;
	}


	public void setTrade_area(Integer trade_area) {
		this.trade_area = trade_area;
	}


	public int getArea() {
		return area;
	}


	public void setArea(int area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "LastDataListVO [kaptname=" + kaptname + ", trade_max=" + trade_max + ", trade_min=" + trade_min
				+ ", rent_max=" + rent_max + ", rent_min=" + rent_min + ", rent_area=" + rent_area + ", trade_area="
				+ trade_area + ", area=" + area + "]";
	}
	
}
