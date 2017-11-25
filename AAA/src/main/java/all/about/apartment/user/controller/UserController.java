package all.about.apartment.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.validation.BindingResult;
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
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception{
		
		Object obj = session.getAttribute("login");
		
		if(obj != null){
			ResidentVO vo = (ResidentVO)obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			//책에는 쿠키 내용 추가...
			
		}
		
		return "redirect:/";
	}
}
