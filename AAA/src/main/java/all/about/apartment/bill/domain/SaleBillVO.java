package all.about.apartment.bill.domain;

public class SaleBillVO {
	private int sale_num;
	private int input_num;
	private String sale_name;
	private int price;
	
	public SaleBillVO(){}
	
	public SaleBillVO(int sale_num, int input_num, String sale_name, int price) {
		super();
		this.sale_num = sale_num;
		this.input_num = input_num;
		this.sale_name = sale_name;
		this.price = price;
	}

	public int getSale_num() {
		return sale_num;
	}

	public void setSale_num(int sale_num) {
		this.sale_num = sale_num;
	}

	public int getInput_num() {
		return input_num;
	}

	public void setInput_num(int input_num) {
		this.input_num = input_num;
	}

	public String getSale_name() {
		return sale_name;
	}

	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SaleBillVO [sale_num=" + sale_num + ", input_num=" + input_num + ", sale_name=" + sale_name + ", price="
				+ price + "]";
	}
	
	
	
	
	
}
