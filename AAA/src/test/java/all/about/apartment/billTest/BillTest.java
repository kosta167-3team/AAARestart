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



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BillTest {
	
	@Inject
	BillDAO dao;
	
	SetMonthBill setMonthBill = new SetMonthBill("alstlr123", "2017-11");
	
	@Test
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
		dao.monthBill(new SetMonthBill("alstlr123", "2017-11"));
	}
	
	@Test
	public void getSaleBillDAOTest() throws Exception{
		dao.getSaleBill(11);
	}
	@Test
	public void getEnergyList() throws Exception{
		dao.getEnergyList(new SetMonthBill("alstlr123", "2017-11"));
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
		dao.getElecAVG(new SetEnergyAVG("elec", "2017-11", 33));
	}
	
	

}
