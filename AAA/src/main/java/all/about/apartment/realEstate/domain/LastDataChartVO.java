package all.about.apartment.realEstate.domain;

public class LastDataChartVO {
	
	private String kaptname;
	private int trade_price;
	private int rent_deposit;
	

	public String getKaptname() {
		return kaptname;
	}
	public void setKaptname(String kaptname) {
		this.kaptname = kaptname;
	}
	public int getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(int trade_price) {
		this.trade_price = trade_price;
	}
	public int getRent_deposit() {
		return rent_deposit;
	}
	public void setRent_deposit(int rent_deposit) {
		this.rent_deposit = rent_deposit;
	}
	@Override
	public String toString() {
		return "LastDataChartVO [kaptname=" + kaptname + ", trade_price=" + trade_price + ", rent_deposit="
				+ rent_deposit + "]";
	}
	
}
