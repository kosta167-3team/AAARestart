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
		
		if(residentVO != null){
			//System.out.println();
			System.out.println("로그인 성공");
			session.setAttribute(LOGIN, residentVO);
			
			Object dest = session.getAttribute("dest");
			session.removeAttribute("dest");
			response.sendRedirect(dest!=null ? (String)dest : "/");
//			response.sendRedirect("/");
		}else{
			//response.sendRedirect("/user/login");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		System.out.println("pre login post...");
		if(session.getAttribute("login") != null){
			session.removeAttribute("login");
			
		}
		
		return true;
	}
	
}
