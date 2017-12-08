package all.about.apartment.bill.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.bill.service.BillService;

@Controller
@RequestMapping("/billPrediction/*")
public class BillPredictionController {
	
	@Inject
	BillService service;
	
	@RequestMapping(value = "/billPredictionBody", method = RequestMethod.GET)
	public String goTobillPredictionBody(){
		
		System.out.println("haha");
		
		return "/billPrediction/billPredictionBody";
	}
	

}
