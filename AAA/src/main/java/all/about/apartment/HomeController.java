
package all.about.apartment;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.persistence.BillDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	@Inject
	BillDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping(value = "/pages/gallery", method = RequestMethod.GET)
	public void gallery(){
		
	}
	@RequestMapping(value = "/pages/sidebar-left", method = RequestMethod.GET)
	public void pagessidebarLeft(){
	
	}
	@RequestMapping(value = "/pages/sidebar-right", method = RequestMethod.GET)
	public void pagessidebarRight(){

	}
	@RequestMapping(value = "/pages/basic-grid", method = RequestMethod.GET)
	public void pagesbasic(){

	}
	
}
