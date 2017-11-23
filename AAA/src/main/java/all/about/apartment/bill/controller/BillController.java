package all.about.apartment.bill.controller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tiles.definition.dao.CachingLocaleUrlDefinitionDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.persistence.BillDAO;
import all.about.apartment.bill.persistence.BillService;

@Controller
public class BillController {
	
	@Inject
	BillService service;
	
	
	@RequestMapping(value = "/bill/full-width", method = RequestMethod.GET)
	public String BillControllerMethod(HttpServletRequest request, Model model) throws Exception{
		
		HttpSession session = request.getSession();
		Calendar cal = Calendar.getInstance();
		Personal_mgmt_exVO billMonth;
		
		String p_month = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
		
		String u_id = (String)session.getAttribute("u_id");
	
		if( u_id != null){
			billMonth = service.getMonthBill(u_id, p_month);
			System.out.println(billMonth);
			model.addAttribute("billMonth", billMonth);
		}
		else{
			billMonth = service.getMonthBill("alstlr123", p_month);
			System.out.println(billMonth);
			model.addAttribute("billMonth", billMonth);
		}
		
		return "/bill/full-width";
	}
	
	
	
	
}
