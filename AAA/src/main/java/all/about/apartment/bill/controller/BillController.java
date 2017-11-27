package all.about.apartment.bill.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.bill.persistence.BillDAO;

@Controller
public class BillController {
	
	@Inject
	BillDAO dao;
	
	
	@RequestMapping(value = "/Bill", method = RequestMethod.GET)
	public void BillControllerMethod() throws Exception{
		
	}
	
}
