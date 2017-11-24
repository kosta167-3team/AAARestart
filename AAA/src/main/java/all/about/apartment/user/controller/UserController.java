package all.about.apartment.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.publicDomain.LoginDTO;
import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.user.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Inject
	UserService service;
	
	@RequestMapping(value ="/login" , method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto){
		
	}
	
	@RequestMapping(value="/loginPost" , method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, 
			HttpSession session, Model model)throws Exception{
		
		System.out.println("User Controller ... LoginDTO : "+ dto);
		
		ResidentVO vo  = service.login(dto);
		
		if(vo == null){
			return;
		}
		
		model.addAttribute("residentVO",vo);
	}
}
