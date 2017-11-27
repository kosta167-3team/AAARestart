package all.about.apartment.bid.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.service.BidService;

@RestController
@RequestMapping(value="/gkgk/*")
public class ggggg {
	
	
	@Inject
	private BidService service;
	
	@RequestMapping(value="/rest",method=RequestMethod.POST)
	public String rest(BidProductVO vo)throws Exception{
		System.out.println(vo);

		service.readInsert(vo);
		
		System.out.println("gggg");
		return "success";
	}
	
	
}
