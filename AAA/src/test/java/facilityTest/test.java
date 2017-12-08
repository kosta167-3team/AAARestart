package facilityTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import all.about.apartment.facility.domain.Facility;
import all.about.apartment.facility.domain.Facility_stateVO;
import all.about.apartment.facility.persistence.FacilityDAO;
import all.about.apartment.facility.service.FacilityService;
import all.about.apartment.publicDomain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class test {

	@Inject 
	FacilityService service;
	
	@Inject
	FacilityDAO dao;
	
	@Inject
	Facility facility;
	
	@Test
	public void test() {
		try {
			
			Criteria cri = new Criteria();
			cri.setPerPageNum(2);
			cri.setPage(1);
	
			facility.setF_id(0); 
			List<Facility_stateVO> list = dao.getStatePage(facility, cri);
			
			for (Facility_stateVO facility_stateVO : list) {
				System.out.println(facility_stateVO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
