package all.about.apartment.bill.domain;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import all.about.apartment.bill.service.BillService;

public class GetEnergySelector 
{
	
	BillService service;
	
	String[] oneQ = {"1","2","3"};
	String[] twoQ = {"4","5","6"};
	String[] threeQ = {"7","8","9"};
	String[] fourQ = {"10","11","12"};
	
	
	public GetEnergySelector() {
		super();
	}
	
	
	public Map<String, Double> getAVGelecMonth(BillService service,String u_id ,String quarter) throws Exception{
		this.service = service;
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int lastYear = year-5;
		int month = cal.get(Calendar.MONTH)+1;
		String p_month = year + "-" + month;
		int power = 0;
		String thisU_id = u_id;
		System.out.println("thisU_id : " + thisU_id);
		
		/* weight 설정 0.1 ~ 0.3 정도가 적당하다. */
		double topWeight = 0.2;
		double bottomWeight = 0.3;
		
		double topNum = 0.0;
		double bottomNum = 0.0;
		
		DecimalFormat df = new DecimalFormat("0.00000");
		double topDf_num = 0.0;
		double bottomDf_num = 0.0;
		
		String[] quarterList = null;
		if(quarter.equals("oneQ") ){
			quarterList = oneQ;
		}else if(quarter.equals("twoQ") ){
			quarterList = twoQ;
		}else if(quarter.equals("threeQ") ){
			quarterList = threeQ;
		}else if(quarter.equals("fourQ") ){
			quarterList = fourQ;
		}
		Map<String, Double> quterBillMap = new HashMap<String,Double>();
		
		while( year >= lastYear){
			double topQuterBill = 0.0;
			double bottomQuterBill = 0.0;
			
			for(int i = 0; i <quarterList.length; i++){
				power += 1;
				month = Integer.parseInt(quarterList[i]);
				p_month = year + "-" + month;
				System.out.println("power : " + power);
				
				double getAvgElecMonth = service.getAVGelecMonth(new SetMonthBill(thisU_id,p_month));
				
				topNum = getSquare(topWeight,getAvgElecMonth, power);
				bottomNum = getSquare(bottomWeight,getAvgElecMonth, power);
				
				topDf_num += Double.parseDouble(df.format(topNum));
				bottomDf_num +=  Double.parseDouble(df.format(bottomNum));
				
				topQuterBill += getAvgElecMonth;
				
				
				System.out.println(p_month + " : " + topNum + " , bottomNum : " + bottomNum);
				System.out.println("df_num : " + topDf_num);
			}
			quterBillMap.put(String.valueOf(year), topQuterBill/3);
			year -= 1;
		}
		quterBillMap.put("topAllElecAVG", topDf_num);
		quterBillMap.put("bottomAllElecAVG", bottomDf_num);

		return quterBillMap;
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
