package all.about.apartment.billTest;


import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.web.context.annotation.ApplicationScope;

import all.about.apartment.bill.domain.GetEnergySelector;
import all.about.apartment.bill.domain.SetEnergyAVG;
import all.about.apartment.bill.domain.SetMonthBill;

import all.about.apartment.bill.persistence.BillDAO;
import all.about.apartment.bill.service.BillService;


class Super{
	public int i = 0;
	public Super(){};
	public Super(String text){
		i = 0;
	}
}
class Sub extends Super{
	public Sub(String tex){
		i=2;
	}
}


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BillTest {
	
	
	interface fish {};
	interface asdf extends fish{};
	
	
	class perch implements fish{};
	class aaa extends perch {};
	class bbb {};
	
	
	
	
	
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
	
	/*@Test
	public void getAVGelecMonth() throws Exception{
		
		GetEnergySelector ges = new GetEnergySelector();		

		Map<String,Double> quterBillMap ;

		quterBillMap = ges.getAVGelecMonth(service,"alstlr123" ,"oneQ");
		
		System.out.println("Billtest num : " + quterBillMap);

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
	}*/
	
	
	
	
	
	/*@Test
	public void asb(){
		fish f = new aaa();
		aaa A = new aaa();
		bbb B =new bbb();
		
		if(f instanceof aaa )System.out.println("f-p ");
		if( A instanceof fish) System.out.println("w-f ");
		
		
	}*/
	@Test
	public void sdfsdf(){
		Sub sub = new Sub("hello");
		System.out.println(sub.i);
		System.out.println( 10 == 10.0);
	}
	
	

}
