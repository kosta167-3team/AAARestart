package all.about.apartment.billTest;


import java.text.DecimalFormat;
import java.util.Calendar;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.web.context.annotation.ApplicationScope;

import all.about.apartment.bill.domain.SetEnergyAVG;
import all.about.apartment.bill.domain.SetMonthBill;

import all.about.apartment.bill.persistence.BillDAO;
import all.about.apartment.bill.service.BillService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BillTest {
	
	@Inject
	BillDAO dao;
	
	@Inject
	BillService service;
	
	SetMonthBill setMonthBill = new SetMonthBill("alstlr123", "2017-11");
	SetEnergyAVG setEnergyAVG = new SetEnergyAVG("elec", "2017-11", 33); 
	
/*	@Test
	public void daoTest() throws Exception{
		System.out.println("haha");
		System.out.println(dao.getPersonal_mgmt_exList());
	}
	@Test
	public void daoEnergyAVG() throws Exception{
		System.out.println();
	}
	@Test
	public void daoPersonal_mgmt_exListTest() throws Exception{
		System.out.println(dao.getPersonal_mgmt_exList());
	}
	@Test
	public void monthBillDAOTest()throws Exception{
		dao.monthBill(setMonthBill);
	}
	
	@Test
	public void getSaleBillDAOTest() throws Exception{
		dao.getSaleBill(11);
	}
	@Test
	public void getEnergyList() throws Exception{
		dao.getEnergyList(setMonthBill);
	}
	@Test
	public void getSelectDetail() throws Exception{
		dao.getSelectDetail(setMonthBill);
	}
	@Test
	public void getYearEnergy() throws Exception{
		dao.getYearEnergy(setMonthBill);
	}
	@Test
	public void getElecAVG() throws Exception{
		dao.getElecAVG(setEnergyAVG);
	}
	@Test
	public void getElecList() throws Exception{
		System.out.println(dao.getElecList());
	}
	@Test
	public void getHeatList() throws Exception{
		System.out.println(dao.getHeatList());
	}*/
/*	@Test
	public void getScoreNum() throws Exception{
		System.out.println(service.getScoreNum("elec"));
	}*/
/*	@Test
	public void getSelectEnergyList() throws Exception{
		System.out.println(service.getSelectEnergyList("elec"));
		
	}*/
	
	@Test
	public void getAVGelecMonth() throws Exception{
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		String p_month = year + "-" + month;
		int power = 0;
		
		/* weight 설정 0.1 ~ 0.3 정도가 적당하다. */
		
		double weight = 0.1;
		
		double num = 0.0;
		DecimalFormat df = new DecimalFormat("0.00000");
		double df_num = 0.0;
		/*System.out.println(dao.getAVGelecMonth(p_month));
		DecimalFormat df = new DecimalFormat("0.00000");
		double num = getSquare(weight,dao.getAVGelecMonth(p_month), 0);
		
		double df_num = Double.parseDouble(df.format(num));*/
		
		while( year >= 2002 ){
			for(int i = 1; i <4; i++){
				power += 1;
				month = i;
				p_month = year + "-" + month;
				System.out.println(power);
				num = getSquare(weight,dao.getAVGelecMonth(p_month), power);
				df_num += Double.parseDouble(df.format(num));
				System.out.println(p_month + " : " + num);
			}
			
			year -= 1;
		}
		System.out.println("result : "+df_num);
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
