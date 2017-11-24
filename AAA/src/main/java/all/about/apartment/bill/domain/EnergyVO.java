package all.about.apartment.bill.domain;

public class EnergyVO {
	private int energy_num;
	private int input_num;
	private int elec;
	private int water;
	private int fever;
	private int heat;
	private int week_num;
	
	public EnergyVO(){}
	
	public EnergyVO(int energy_num, int input_num, int elec, int water, int fever, int heat, int week_num) {
		super();
		this.energy_num = energy_num;
		this.input_num = input_num;
		this.elec = elec;
		this.water = water;
		this.fever = fever;
		this.heat = heat;
		this.week_num = week_num;
	}

	public int getEnergy_num() {
		return energy_num;
	}

	public void setEnergy_num(int energy_num) {
		this.energy_num = energy_num;
	}

	public int getInput_num() {
		return input_num;
	}

	public void setInput_num(int input_num) {
		this.input_num = input_num;
	}

	public int getElec() {
		return elec;
	}

	public void setElec(int elec) {
		this.elec = elec;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getFever() {
		return fever;
	}

	public void setFever(int fever) {
		this.fever = fever;
	}

	public int getHeat() {
		return heat;
	}

	public void setHeat(int heat) {
		this.heat = heat;
	}

	public int getWeek_num() {
		return week_num;
	}

	public void setWeek_num(int week_num) {
		this.week_num = week_num;
	}

	
	
	
	@Override
	public String toString() {
		return "EnergyVO [energy_num=" + energy_num + ", input_num=" + input_num + ", elec=" + elec + ", water=" + water
				+ ", fever=" + fever + ", heat=" + heat + ", week_num=" + week_num + "]";
	}
	
	
	
	
	
	
	
	
}
