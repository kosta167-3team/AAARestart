package complainTest;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import all.about.apartment.complain.service.ComplainService;
import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.message.persistence.MessageDAO;
import all.about.apartment.message.service.MessageService;
import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.SearchCriteria;
import oracle.net.aso.s;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class ComplainTest {

	@Inject
	ComplainService service;
//	
//	@Test
//	public void getTypeListTest(){
//		try {
//			List<Map<String, Object>> list= service.getTypeList("시설");
//			
//			for (Map<String, Object> map : list) {
//				System.out.println(map);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void getTest(){
		int compNo;
		try {
			compNo = service.get_compNo();
			System.out.println(compNo);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}
















































