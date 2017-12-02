package all.about.apartment.intercepter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import all.about.apartment.comm.service.CommService;
import all.about.apartment.publicDomain.ResidentVO;

public class Comm_feed_Inteceptor extends HandlerInterceptorAdapter {

 @Inject
 CommService service;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		
		HttpSession session = request.getSession();
		String r_id = ((ResidentVO)session.getAttribute("login")).getR_id();
		
		if(service.getUser(r_id)==null){
			
			response.sendRedirect("/comm/registerComm");
		}
		
		return true;
	}

}
