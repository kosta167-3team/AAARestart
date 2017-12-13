package residentTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.resident.service.ResidentService;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ResidentTest {

	@Inject
	ResidentService service;
	
	@Test
	public void get_hoListTest() {
		try {
			List<Integer>list = service.get_hoList(101);
			
			for (Integer integer : list) {
				System.out.println(integer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	@Test
//	public void getdongListTest() {
//		try {
//			List<Integer>list = service.get_dongList();
//			
//			for (Integer integer : list) {
//				System.out.println(integer);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}

}


























