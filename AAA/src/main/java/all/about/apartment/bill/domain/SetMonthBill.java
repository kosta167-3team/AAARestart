package all.about.apartment.bill.domain;

public class SetMonthBill {
	
	private String u_id;
	private String p_month;
	
	public SetMonthBill(){}
	
	public SetMonthBill(String u_id, String p_month) {
		super();
		this.u_id = u_id;
		this.p_month = p_month;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getP_month() {
		return p_month;
	}
	public void setP_month(String p_month) {
		this.p_month = p_month;
	}

	@Override
	public String toString() {
		return "SetMonthBill [u_id=" + u_id + ", p_month=" + p_month + "]";
	}
	
	
	

}
