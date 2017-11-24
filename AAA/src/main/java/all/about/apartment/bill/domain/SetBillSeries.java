package all.about.apartment.bill.domain;

public class SetBillSeries {
	private String listName;
	private int monthBill;
	private int preMonthBill;
	private int compareBill;
	
	public SetBillSeries(){}

	public SetBillSeries(String listName, int monthBill, int preMonthBill, int compareBill) {
		super();
		this.listName = listName;
		this.monthBill = monthBill;
		this.preMonthBill = preMonthBill;
		this.compareBill = compareBill;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public int getMonthBill() {
		return monthBill;
	}

	public void setMonthBill(int monthBill) {
		this.monthBill = monthBill;
	}

	public int getPreMonthBill() {
		return preMonthBill;
	}

	public void setPreMonthBill(int preMonthBill) {
		this.preMonthBill = preMonthBill;
	}

	public int getCompareBill() {
		return compareBill;
	}

	public void setCompareBill(int compareBill) {
		this.compareBill = compareBill;
	}
	
	
	
	
	
	

}
