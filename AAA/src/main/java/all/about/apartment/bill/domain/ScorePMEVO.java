package all.about.apartment.bill.domain;

public class ScorePMEVO {
	
	private int rownum;
	private int input_num;
	private int allUsed;
	public ScorePMEVO() {
	
	}
	public ScorePMEVO(int rownum, int input_num, int allUsed) {
		super();
		this.rownum = rownum;
		this.input_num = input_num;
		this.allUsed = allUsed;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getInput_num() {
		return input_num;
	}
	public void setInput_num(int input_num) {
		this.input_num = input_num;
	}
	public int getAllUsed() {
		return allUsed;
	}
	public void setAllUsed(int allUsed) {
		this.allUsed = allUsed;
	}
	@Override
	public String toString() {
		return "ScorePMEVO [rownum=" + rownum + ", input_num=" + input_num + ", allUsed=" + allUsed + "]";
	}
	
	
	
	
	
	
	

}
