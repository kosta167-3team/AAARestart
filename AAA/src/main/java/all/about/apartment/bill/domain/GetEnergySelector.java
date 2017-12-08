package all.about.apartment.bill.domain;

import java.text.DecimalFormat;
import java.util.Calendar;

import all.about.apartment.bill.service.BillService;

public class GetEnergySelector 
{
	
	BillService service;
	
	public GetEnergySelector() {
		super();
	}
	
	
	public double getAVGelecMonth(BillService service) throws Exception{
		this.service = service;
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		String p_month = year + "-" + month;
		int power = 0;
		double weight = 0.1;
		double num = 0.0;
		DecimalFormat df = new DecimalFormat("0.00000");
		double df_num = 0.0;
		
		while( year >= 2002 ){
			for(int i = 1; i <4; i++){
				power += 1;
				month = i;
				p_month = year + "-" + month;
				System.out.println(power);
				num = getSquare(weight,service.getAVGelecMonth(p_month), power);
				df_num += Double.parseDouble(df.format(num));
				System.out.println(p_month + " : " + num);
			}
			
			year -= 1;
		}

		return df_num;
	}
	
	
	public double getSquare(double weight, double num, int power){
		double result = 0.0;
		if( power > 0){
			result = weight * Math.pow( (1-weight), power) * num;
		}
		else{
			result = weight * num;
		}
		
		return result;		
	}
	
}
