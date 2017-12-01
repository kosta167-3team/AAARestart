package all.about.apartment.realEstate.domain;

public class AnnualMinMaxVO {
	private int trade_year;
	private int trade_month;
	private int rent_year;
	private int rent_month;
	private Integer rent_max;
	private Integer rent_min;
	
	private Integer trade_max;
	private Integer trade_min;
	
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
	public int getTrade_year() {
		return trade_year;
	}
	public void setTrade_year(int trade_year) {
		this.trade_year = trade_year;
	}
	public int getTrade_month() {
		return trade_month;
	}
	public void setTrade_month(int trade_month) {
		this.trade_month = trade_month;
	}
	public int getRent_year() {
		return rent_year;
	}
	public void setRent_year(int rent_year) {
		this.rent_year = rent_year;
	}
	public int getRent_month() {
		return rent_month;
	}
	public void setRent_month(int rent_month) {
		this.rent_month = rent_month;
	}
	@Override
	public String toString() {
		return "AnnualMinMaxVO [trade_year=" + trade_year + ", trade_month=" + trade_month + ", rent_year=" + rent_year
				+ ", rent_month=" + rent_month + ", rent_max=" + rent_max + ", rent_min=" + rent_min + ", trade_max="
				+ trade_max + ", trade_min=" + trade_min + "]";
	}
	
	
	
}
