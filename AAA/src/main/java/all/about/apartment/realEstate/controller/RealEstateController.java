package all.about.apartment.realEstate.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.realEstate.service.RealEstateService;
import oracle.net.aso.s;

@Controller
@RequestMapping(value = "/real_estate")
public class RealEstateController {
	
	@Inject
	RealEstateService service;
	
	@RequestMapping(method =RequestMethod.GET)
	public String realEstateGET(){
		return "/real_estate";
	}
	@RequestMapping (value ="/inputdata" ,method = RequestMethod.GET)
	public void test(){
		//return "/real_estate/inputdata";
	}
	
	@RequestMapping(value="/getApi" ,method=RequestMethod.GET)
	public ResponseEntity<String> inputdataGET(){
		System.out.println("부동산 정보 insert....");
		
		ResponseEntity<String> entity ;
		
		
		try {
			service.inputData();
			entity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
