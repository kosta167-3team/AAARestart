package all.about.apartment.realEstate.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RealEstateServiceImpl implements RealEstateService {
	
	
	@Scheduled(fixedRate = 5000)
	public void test(){
		//System.out.println("Sceduler test...");
	}
}
