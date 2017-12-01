package all.about.apartment.bid.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.bid.service.BidService;

@Controller
@RequestMapping("/bidd/*")
public class BidController_ms {
	
	@Inject
	private BidService service;
	
	@RequestMapping(value="/bidDetail", method=RequestMethod.GET)
	public void bidDetail()throws Exception{
	}
	
	
	
}
