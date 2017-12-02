package all.about.apartment.realEstate.domain;

public class AptRentVO {
	private int rent_id;
	private String apartcode;
	private int rent_year;
	private int rent_month;
	private int rent_deposit;
	private int rent_area;
	public int getRent_id() {
		return rent_id;
	}
	public void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}
	public String getApartcode() {
		return apartcode;
	}
	public void setApartcode(String apartcode) {
		this.apartcode = apartcode;
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
	public int getRent_deposit() {
		return rent_deposit;
	}
	public void setRent_deposit(int rent_deposit) {
		this.rent_deposit = rent_deposit;
	}
	public int getRent_area() {
		return rent_area;
	}
	public void setRent_area(int rent_area) {
		this.rent_area = rent_area;
	}
	@Override
	public String toString() {
		return "AptRentVO [rent_id=" + rent_id + ", apartcode=" + apartcode + ", rent_year=" + rent_year
				+ ", rent_month=" + rent_month + ", rent_deposit=" + rent_deposit + ", rent_area=" + rent_area + "]";
	}
	
	
}
