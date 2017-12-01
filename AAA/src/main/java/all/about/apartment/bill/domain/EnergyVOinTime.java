package all.about.apartment.bill.domain;

public class EnergyVOinTime extends EnergyVO {
	private String p_month;
	
	public EnergyVOinTime(){ super();}

	public EnergyVOinTime(String p_month) {
		super();
		this.p_month = p_month;
	}

	public String getP_month() {
		return p_month;
	}

	public void setP_month(String p_month) {
		this.p_month = p_month;
	}
	
	
}
