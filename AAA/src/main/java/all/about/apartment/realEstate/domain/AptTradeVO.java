package all.about.apartment.realEstate.domain;

public class AptTradeVO {
	private int trade_id;
	private String apartcode;
	private int trade_year;
	private int trade_month;
	private int trade_price;
	private int trade_area;
	public int getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(int trade_id) {
		this.trade_id = trade_id;
	}
	public String getApartcode() {
		return apartcode;
	}
	public void setApartcode(String apartcode) {
		this.apartcode = apartcode;
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

	public int getTrade_area() {
		return trade_area;
	}
	public void setTrade_area(int trade_area) {
		this.trade_area = trade_area;
	}
	public int getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(int trade_price) {
		this.trade_price = trade_price;
	}
	@Override
	public String toString() {
		return "AptTradeVO [trade_id=" + trade_id + ", apartcode=" + apartcode + ", trade_year=" + trade_year
				+ ", trade_month=" + trade_month + ", trade_price=" + trade_price + ", trade_area=" + trade_area + "]";
	}
	

}
