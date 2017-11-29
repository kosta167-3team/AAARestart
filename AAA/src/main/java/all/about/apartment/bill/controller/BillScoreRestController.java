package all.about.apartment.bill.controller;


import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.ScorePMEVO;
import all.about.apartment.bill.service.BillService;
import all.about.apartment.publicDomain.ResidentVO;

@RestController
@RequestMapping(value = "/billScoreRest/*")
public class BillScoreRestController {
	
	@Inject
	BillService service;
	
	@RequestMapping(value = "/setScoreBill/{energyName}/{energyUsed}", method = RequestMethod.GET)
	public ResponseEntity<String> getScoreBill(HttpServletRequest request, @PathVariable("energyName") String energyName, @PathVariable("energyUsed") String energyUsed) throws Exception{
		ResponseEntity<String> entity = null;
		
		List<ScorePMEVO> scoreEnergyList = null;
		
		if( energyName.equals("elec")){
			scoreEnergyList = service.getElecList();
			System.out.println(scoreEnergyList);
			
		}else if( energyName.equals("heat")){
			scoreEnergyList = service.getHeatList();
			System.out.println(scoreEnergyList);
		}
		
		entity = new ResponseEntity<String>("A", HttpStatus.OK);
		return entity;	
	}
	
	
	
	
	@RequestMapping(value = "/AverageEnergy", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Integer>> getAverageEnergy(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		Calendar cal = Calendar.getInstance();		
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		String u_id = resident.getR_id();
		String p_month = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
		Personal_mgmt_exVO pme = service.getMonthBill(u_id, p_month);
		ResponseEntity<Map<String, Integer>> entity = null;
		
		
		String month = "20%%-"+ (cal.get(Calendar.MONTH)+1) +"";
		int width = pme.getWidth() ;
		int week_num = 0;
		String energyName = "";
		int avgEnergy= 0;
		
		HashMap<String, Integer> energyMap = new HashMap<String,Integer>();	
		
		
		for( int i = 0; i < EnergyVO.getEnergyNameList().length; i++){
			energyName = EnergyVO.getEnergyNameList()[i];
			avgEnergy = service.getElecAVG(energyName, month, width);
			
			energyMap.put(energyName, avgEnergy);			
		}

		entity = new ResponseEntity<Map<String,Integer>>(energyMap, HttpStatus.OK);		
		
		return entity;		
	}

}
