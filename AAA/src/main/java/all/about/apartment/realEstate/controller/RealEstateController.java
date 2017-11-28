package all.about.apartment.realEstate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import all.about.apartment.realEstate.service.RealEstateService;

@Controller
@RequestMapping(value = "/realEstate")
public class RealEstateController {
	
	@Inject
	RealEstateService service;
	
	@RequestMapping
	public String test(){
		return "/realEstate";
	}
}
