package all.about.apartment.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class asdg {

	@Test
	public void test() {
		System.out.println("ha");
	}

}
