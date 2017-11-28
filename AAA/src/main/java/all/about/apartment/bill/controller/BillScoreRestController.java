package all.about.apartment.bill.controller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.persistence.BillService;
import all.about.apartment.publicDomain.ResidentVO;

@RestController
@RequestMapping(value = "/billScoreRest/*")
public class BillScoreRestController {
	
	@Inject
	BillService service;
	
	
	@RequestMapping(value = "/AverageEnergy", method = RequestMethod.GET)
	public String getAverageEnergy(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		Calendar cal = Calendar.getInstance();		
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		String u_id = resident.getR_id();
		String p_month = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
		String width = "";
		
		Personal_mgmt_exVO pme = null;
		List<Personal_mgmt_exVO> equlesWidthList = null;
		
		
		if( resident != null){
			pme = service.getMonthBill(u_id, p_month);
			
		}
		else{
			
		}
		
		
		return null;
		
		
		
		
	}

}
