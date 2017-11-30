package all.about.apartment.bill.domain;

import java.util.List;

import all.about.apartment.bill.service.BillService;

public class BillGradeSeletor {
	
	int aPlus,a,bPlus,b,cPlus,c,dPlus,d;
	String energyName;
	
	int allScoreNum;
	
	BillService service;	
	
	public BillGradeSeletor() {
	}
	
	public BillGradeSeletor(BillService service) {
		this.service = service;
	}

	public String setEnergyName(String energyName){
		this.energyName = energyName;
		setScoreScope();
		return this.energyName;
	}
	public String getGrade(int input_num) throws Exception{
		List<ScorePMEVO> list = service.getSelectEnergyList(energyName);
		
		for( int i = 0 ; i < list.size(); i++){
			ScorePMEVO person = list.get(i);
			if( person.getInput_num() == input_num){
				if( person.getRownum() < aPlus){
					return "A+";
				}
				else if(person.getRownum() < a){
					return "A";
				}
				else if(person.getRownum() < bPlus){
					return "B+";
				}
				else if(person.getRownum() < b){
					return "B";
				}
				else if(person.getRownum() < cPlus){
					return "C+";
				}
				else if(person.getRownum() < c){
					return "C";
				}
				else if(person.getRownum() < dPlus){
					return "D+";
				}
				else if(person.getRownum() < d){
					return "D";
				}
				else{
					return "F";
				}
				
			}
		}
		
		
		
		return "F";
	}
	
	
	private void setScoreScope(){		
		try 
		{
			allScoreNum = service.getScoreNum(energyName);
			
			aPlus = (int)(allScoreNum * 0.04);
			a = (int)(allScoreNum * 0.11);
			bPlus = (int)(allScoreNum * 0.23);
			b = (int)(allScoreNum * 0.4);
			cPlus = (int)(allScoreNum * 0.6);
			c = (int)(allScoreNum * 0.77);
			dPlus = (int)(allScoreNum * 0.89);
			d = (int)(allScoreNum * 0.96);
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}	
		
	}

	public int getaPlus() {
		return aPlus;
	}

	public void setaPlus(int aPlus) {
		this.aPlus = aPlus;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getbPlus() {
		return bPlus;
	}

	public void setbPlus(int bPlus) {
		this.bPlus = bPlus;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getcPlus() {
		return cPlus;
	}

	public void setcPlus(int cPlus) {
		this.cPlus = cPlus;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getdPlus() {
		return dPlus;
	}

	public void setdPlus(int dPlus) {
		this.dPlus = dPlus;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getAllScoreNum() {
		return allScoreNum;
	}

	public void setAllScoreNum(int allScoreNum) {
		this.allScoreNum = allScoreNum;
	}

	public BillService getService() {
		return service;
	}

	public void setService(BillService service) {
		this.service = service;
	}

	public String getEnergyName() {
		return energyName;
	}
	
	

}
