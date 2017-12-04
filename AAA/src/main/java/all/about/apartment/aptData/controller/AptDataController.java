package all.about.apartment.aptData.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.aptData.domain.Entrc_seoulVO;
import all.about.apartment.aptData.service.EntrcService;

@Controller
@RequestMapping("/aptData")
public class AptDataController {
	
	@Inject
	EntrcService service;
	
	@RequestMapping(value = "/entrc" , method =RequestMethod.GET)
	public void test() throws Exception{
		List<String> list = service.list_dongcode();
		
		if(list == null){
			System.out.println("연결안됨..");
		}else{
			for(String vo : list){
				System.out.println(vo);
			}
		}
	}
	
	@RequestMapping(value ="" ,method = RequestMethod.GET)
	public String aptData(){
		return "/pages/aptdata/aptData";
	}
	
	@RequestMapping(value ="/changeXY",method = RequestMethod.GET)
	public String changeXY(){
		return "/pages/aptdata/changeXY";
	}
}













