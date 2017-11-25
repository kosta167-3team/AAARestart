package userTest;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import all.about.apartment.publicDomain.LoginDTO;
import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class UserTest {

	@Inject
	UserService service;
	
	@Test
	public void test() {
		LoginDTO dto = new LoginDTO();
		dto.setUrd("dmsql123");
		dto.setUpw("abc1234");
	
		try {
			ResidentVO vo = service.login(dto);
			System.out.println(vo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
