package all.about.apartment.bid.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import all.about.apartment.bid.service.BiddService;

@Controller
@RequestMapping("/bidd/*")
public class BidController_ms {
	
	@Inject
	private BiddService service;
	
	@RequestMapping(value="/bidDetail", method=RequestMethod.GET)
	//public void bidDetail(@RequestParam("bid_id")String bid_id)throws Exception{
	public ModelAndView bidDetail()throws Exception{	
		ModelAndView mav = new ModelAndView();
		String bid_id = "1";
		mav.setViewName("/bidd/bidDetail");
		mav.addObject("bidProduct", service.bidDetail(bid_id));
		return mav;
	}
	
	
	
	
	
}
