package all.about.apartment.bill.domain;

public class SetEnergyAVG {
	private String energyName;

	String p_month;
	int width;
	
	public SetEnergyAVG(){}

	public String getEnergyName() {
		return energyName;
	}

	public void setEnergyName(String energyName) {
		this.energyName = energyName;
	}

	public String getP_month() {
		return p_month;
	}

	public void setP_month(String p_month) {
		this.p_month = p_month;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public SetEnergyAVG(String energyName, String p_month, int width) {
		super();
		this.energyName = energyName;
		this.p_month = p_month;
		this.width = width;
	}
	
	
	
	
	

}
