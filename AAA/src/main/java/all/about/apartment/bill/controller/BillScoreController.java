package all.about.apartment.bill.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.service.BillService;
import all.about.apartment.publicDomain.ResidentVO;

@Controller
@RequestMapping(value = "/billScore/*", method = RequestMethod.GET)
public class BillScoreController {
	
	@Inject
	BillService service;
	
	@RequestMapping(value = "/billScoreBody", method=RequestMethod.GET)
	public String moveBillScorePage(HttpServletRequest request, Model model) throws Exception{
		
		HttpSession session = request.getSession();
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		Calendar cal = Calendar.getInstance();
		String p_month = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
		String u_id = "";
		Personal_mgmt_exVO pme = null;
		Map<String,String> date = new HashMap<String,String>();
		List<EnergyVO> energyList = null;
		List<ArrayList<EnergyVO>> oneYearEnergyList = new ArrayList<ArrayList<EnergyVO>>();
		EnergyVO energy = new EnergyVO();
		int elec =0, water=0, heat=0,fever=0;
		
		if( resident != null){			
			u_id = resident.getR_id();
			pme = service.getMonthBill(u_id, p_month);
			
			date.put("year", cal.get(Calendar.YEAR)+"");
			date.put("month", (cal.get(Calendar.MONTH))+"");			
			
			energyList = service.getEnergyList(u_id, p_month);
			
			for( int i = 0; i < energyList.size(); i++){
				elec += energyList.get(i).getElec();
				water += energyList.get(i).getWater();
				heat += energyList.get(i).getHeat();
				fever += energyList.get(i).getFever();
			}
			energy.setElec(elec);
			energy.setFever(fever);
			energy.setHeat(heat);
			energy.setWater(water);
			
			model.addAttribute("energyList", energyList);
			model.addAttribute("energy", energy);
			model.addAttribute("pme", pme);
			model.addAttribute("resident", resident);
			model.addAttribute("dateMap", date);		
		}
		
						
		int month = cal.get(Calendar.MONTH)+1;
		int year = cal.get(Calendar.YEAR)-1;
		String selectMonth ="";
		for( int i = 0; i <= 12; i++){
			selectMonth = year + "-" + month;
			System.out.println(selectMonth);
			ArrayList<EnergyVO> list = (ArrayList<EnergyVO>) service.getYearEnergy(u_id, selectMonth);
			
			
			oneYearEnergyList.add((ArrayList<EnergyVO>) service.getYearEnergy(u_id, selectMonth));
			month += 1;
			if( month >12){
				year += 1;
				month = 1;
			}					
		}
		for( int i = 0; i < oneYearEnergyList.size();i++){
			ArrayList<EnergyVO> list = oneYearEnergyList.get(i);
			
			for( int j = 0; j < list.size();j++){
				
				EnergyVO ener = list.get(j);    
				System.out.println(ener);
			}
			System.out.println("--------------------");
		}
		
		/*for(int i = 0; i < oneYearEnergyList.size(); i++){
			for( int j = 0; j < oneYearEnergyList.get(i).size(); j++){
				System.out.println(oneYearEnergyList.get(i).get(j).getEnergy_num());
			}
		}*/
		
		model.addAttribute("oneYearEnergyList", oneYearEnergyList);
		
		
		return "/billScore/billScoreBody";
	}

}
