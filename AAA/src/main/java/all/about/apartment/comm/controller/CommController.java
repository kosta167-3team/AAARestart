package all.about.apartment.comm.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.comm.domain.Comm_user;
import all.about.apartment.comm.service.CommService;
import all.about.apartment.publicDomain.ResidentVO;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/comm/*")
public class CommController {

	@Inject
	CommService service;

	@RequestMapping(value = "/registerComm", method = RequestMethod.GET)
	public String registerComm() throws Exception {

		return "/comm/registerComm";
	}

	@RequestMapping(value = "/checkFeed", method = RequestMethod.GET)
	public String checkFeed() throws Exception {

		return "/comm/checkFeed";
	}

	@RequestMapping(value = "/registerPopup", method = RequestMethod.GET)
	public String registerPopup() throws Exception {

		return "/comm/registerPopup";
	}

}
