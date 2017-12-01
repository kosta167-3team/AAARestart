package all.about.apartment.billTest;


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
@WebAppConfiguration
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
	@Test
	public void getSelectEnergyList() throws Exception{
		System.out.println(service.getSelectEnergyList("elec"));
		
	}
	
	

}
