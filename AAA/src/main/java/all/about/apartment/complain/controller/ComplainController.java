package all.about.apartment.complain.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.complain.domain.ComplainDTO;
import all.about.apartment.complain.service.ComplainService;

@Controller
@RequestMapping("/complain")
public class ComplainController {
	
	@Inject
	ComplainService service;

	@RequestMapping(value = "/register" ,method  = RequestMethod.GET)
	public String registerGET (){
		return "/complain/register";
	}
	
	@RequestMapping(value = "/register" ,method  = RequestMethod.POST)
	public String registerPOST (ComplainDTO dto){
		

		try {
			dto.setComp_no(service.get_compNo());
			
			if(dto.getDisclosure_status() == null){
				dto.setDisclosure_status("N");
			}else{
				dto.setDisclosure_status("Y");
			}
			
			service.complain_register(dto);
			//System.out.println(dto.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	
}
