package all.about.apartment.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInteceptor extends HandlerInterceptorAdapter{

	private static final String LOGIN ="login";
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelMap  modelMap = modelAndView.getModelMap();
		Object residentVO = modelMap.get("residentVO");
		Object dest = null;
		if(residentVO != null){
			
			session.setAttribute(LOGIN, residentVO);
			
			dest = session.getAttribute("dest");
			session.removeAttribute("dest");
			session.removeAttribute("error");
			response.sendRedirect(dest!=null ? (String)dest : "/");
			
		}else{
			session.setAttribute("error","fail");
			response.sendRedirect("/user/login");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null){
			session.removeAttribute("login");
		}
		
		
		return true;
	}
	
}






