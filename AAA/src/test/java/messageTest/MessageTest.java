package messageTest;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.message.persistence.MessageDAO;
import all.about.apartment.message.service.MessageService;
import all.about.apartment.publicDomain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MessageTest {

	@Inject
	MessageService service;
	
	@Inject
	MessageDAO dao;
	
/*	@Test
	public void recieveTest() {
		List<MessageVO> list;
		try {
			list= service.recieveMessage("dustks123");
			
			for (MessageVO messageVO : list) {
				System.out.println(messageVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test(){
		System.out.println("dd");
	}*/
	
	@Test
	public void testListPage() throws Exception{
		int page = 3;
		
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(5);
		
		List<MessageVO> list = dao.recieveMessage("dustks123", cri);
		
		for(MessageVO vo :list){
			System.out.println(vo);
		}
		
	}

}
















































