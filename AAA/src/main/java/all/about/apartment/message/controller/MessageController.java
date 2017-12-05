package all.about.apartment.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.message.domain.MessageVO;

@RequestMapping("/message")
@Controller
public class MessageController {

	@RequestMapping(value = "" ,method = RequestMethod.GET )
	public String messageForm(){
		return "/message/messageForm";
	}
	
}
