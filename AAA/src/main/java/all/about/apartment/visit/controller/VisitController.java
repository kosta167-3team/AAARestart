package all.about.apartment.visit.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import all.about.apartment.visit.domain.Criteria;
import all.about.apartment.visit.domain.PageMaker;
import all.about.apartment.visit.domain.ResidentVO;
import all.about.apartment.visit.dto.ApplicationDTO;
import all.about.apartment.visit.service.VisitService;

@Controller
@RequestMapping(value = "/visit/*")
public class VisitController {
	@Inject
	private VisitService service;

	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public void visitApplication() throws Exception { // 방문신청

	}

	@RequestMapping(value = "/application", method = RequestMethod.POST)
	public String visitApplication(ApplicationDTO dto, RedirectAttributes rttr) throws Exception {

		ResidentVO getResident = service.getResident(dto);
		dto.setR_id(getResident.getR_id());
		dto.setVr_id(Integer.toString(service.maxVR()));
		System.out.println(dto.toString());
		service.applicationVisit(dto);
		rttr.addAttribute("dto", dto.getV_date());
		return "redirect:/visit/sendPassImage";
	}

	@RequestMapping(value = "/sendPassImage", method = RequestMethod.GET)
	public ModelAndView sendPassImage(@RequestParam(value = "dto", defaultValue = "1111") String date)
			throws Exception {
		System.out.println(date);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("visit/sendPassImage");
		modelAndView.addObject("date", date);

		return modelAndView;
	}

	@RequestMapping(value = "/applicationList", method = RequestMethod.GET)
	public ModelAndView applicationList(Criteria cri, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		PageMaker pageMaker = new PageMaker();
		String r_id = "alstlr123";
		modelAndView.addObject("applicationList", service.applicationList(r_id));
		cri.setR_id(r_id);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount(r_id));
		System.out.println(service.totalCount(r_id));
		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("list", service.listCriteria(cri));
		return modelAndView;
	}

	@RequestMapping(value = "/applicationCheck", method = RequestMethod.POST)
	@ResponseBody
	public String applicationCheck(@RequestParam(value = "vr_id", required = false) String vr_id,
			@RequestParam(value = "state", required = false) String state) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("vr_id : " + vr_id + " " + "state : " + state);
		if (state.equals("accept")) {
			map.put("vr_id", vr_id);
			map.put("state", "승인");
		} else {
			map.put("vr_id", vr_id);
			map.put("state", "거부");
		}
		service.updateCheck(map);

		return "/visit/applicationList";
	}

	@RequestMapping(value = "/visitManagement" , method = RequestMethod.GET)
	public ModelAndView adminVisitManagement() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/visit/admin/visitManagement");
		
		modelAndView.addObject("application", service.adminApplicationList());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/visitCheck", method = RequestMethod.GET)
	@ResponseBody
	public String visitCheck(@RequestParam(value = "vr_id", required = false) String vr_id,
			@RequestParam(value = "state", required = false) String state) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("vr_id : " + vr_id + " " + "state : " + state);
		if (state.equals("attendance")) {
			// visit_re에서 
		} else {
			map.put("vr_id", vr_id);
			map.put("state", "거부");
		}
		service.updateCheck(map);

		return "/visit/applicationList";
	}

}
