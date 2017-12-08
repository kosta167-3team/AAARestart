package all.about.apartment.facility.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.facility.domain.ReviewVO;
import all.about.apartment.facility.domain.TodayGuest;
import all.about.apartment.facility.service.ReviewService;
import all.about.apartment.publicDomain.ResidentVO;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Inject
	private ReviewService service;
	
	@RequestMapping(value="/insertReview",method=RequestMethod.GET)
	public void ReviewGET(ReviewVO review,Model model)throws Exception{
		System.out.println("review get..");
	}
	
	@RequestMapping(value="/insertReview",method=RequestMethod.POST)
	public String ReviewPOST(ReviewVO review,Model model,HttpServletRequest request)throws Exception{
		HttpSession session =request.getSession();
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		String r_id = resident.getR_id();
		review.setR_id(r_id);
		
		service.regist(review);
		
		//model.addAttribute("result", "success");
		model.addAttribute("list",service.listAll(review.getF_id()));
		return "/review/insertReview";
	}
	
	@RequestMapping(value="/todayGuest",method=RequestMethod.GET)
	public void Guest(TodayGuest to,Model model)throws Exception{
		System.out.println("TodayGuest...");
		
		Date today = new Date();

		SimpleDateFormat today_format = new SimpleDateFormat("yy/MM/dd");
		String string_today = today_format.format(today);

		model.addAttribute("guest", service.selectedGuest(string_today));
	}
	
	

}
