package all.about.apartment.intercepter;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import all.about.apartment.facility.service.FacilityService;

public class FacilityInterceptor extends HandlerInterceptorAdapter {

	@Inject
	FacilityService service;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("인터셉터 - 예약 취소");
		
		Map<String, Object> pathVariables = (Map<String, Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		//Integer pathVariables = (Integer) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		  
		System.out.println("취소할 예약 번호: " + pathVariables.get("fr_id"));
		
		service.cancelReservation(Integer.parseInt((String)pathVariables.get("fr_id")));

		return true;
	}

	
	
}
