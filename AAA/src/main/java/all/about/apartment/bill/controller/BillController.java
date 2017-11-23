package all.about.apartment.bill.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.bill.domain.Personal_mgmt_ex;
import all.about.apartment.bill.persistence.BillDAO;

@Controller
public class BillController {
	
	@Inject
	BillDAO dao;	
	
	@RequestMapping(value = "/bill/full-width", method = RequestMethod.GET)
	public String BillControllerMethod() throws Exception{
		List<Personal_mgmt_ex> list = dao.getPersonal_mgmt_ex();
		System.out.println(list);
		
		return "/bill/template";
	}
	
}
