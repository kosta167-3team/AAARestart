package all.about.apartment.bill.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.about.apartment.bill.domain.GetEnergySelector;
import all.about.apartment.bill.service.BillService;
import all.about.apartment.publicDomain.ResidentVO;

@Controller
@RequestMapping("/billPrediction/*")
public class BillPredictionController {
	
	@Inject
	BillService service;
	
	@ResponseBody
	@RequestMapping(value = "/getPredictElec/{quarter}", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Double>> getPredictionElecBill(HttpServletRequest request , @PathVariable("quarter") String quarter) throws Exception{
		
		GetEnergySelector ges = new GetEnergySelector();
		HttpSession session = request.getSession();
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		String u_id = resident.getR_id();
		ResponseEntity<Map<String, Double>> entity;
		
		Map<String,Double> quterBillMap = ges.getAVGelecMonth(service, u_id, quarter);
		
		System.out.println(quterBillMap);
		if( quterBillMap != null){
			entity = new ResponseEntity<Map<String,Double>>(quterBillMap, HttpStatus.OK);
		}
		else{
			entity = new ResponseEntity<Map<String, Double>>(quterBillMap,HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value = "/billPredictionBody", method = RequestMethod.GET)
	public String goTobillPredictionBody(){
		
		System.out.println("haha");
		
		return "/billPrediction/billPredictionBody";
	}
	
	
	
	

}
