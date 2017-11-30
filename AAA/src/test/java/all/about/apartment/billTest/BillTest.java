package all.about.apartment.billTest;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import all.about.apartment.bill.persistence.BillDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BillTest {
	
	@Inject
	BillDAO dao;
	

	
	@Test
	public void daoTest() throws Exception{
		System.out.println("haha");
		System.out.println(dao.getPersonal_mgmt_exList());
	}
	
	

}
