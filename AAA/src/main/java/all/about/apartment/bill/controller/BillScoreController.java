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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.about.apartment.bill.domain.BillGradeSeletor;
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
		Map<Integer,String> monthMap = new HashMap<Integer,String>();
		
		
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
			monthMap.put(i, selectMonth);
			ArrayList<EnergyVO> list = (ArrayList<EnergyVO>) service.getYearEnergy(u_id, selectMonth);
			
			
			oneYearEnergyList.add((ArrayList<EnergyVO>) service.getYearEnergy(u_id, selectMonth));
			month += 1;
			if( month >12){
				year += 1;
				month = 1;
			}					
		}
		
		BillGradeSeletor elecGrade = new BillGradeSeletor(service);
		BillGradeSeletor heatGrade = new BillGradeSeletor(service);
		elecGrade.setEnergyName("elec");
		heatGrade.setEnergyName("heat");
		
		System.out.println(elecGrade.getC() + " : " + elecGrade.getA());
		model.addAttribute("elecGradeTable", elecGrade);
		model.addAttribute("heatGradeTable", heatGrade);
		
		model.addAttribute("monthMap", monthMap);
		model.addAttribute("oneYearEnergyList", oneYearEnergyList);
		
		
		return "/billScore/billScoreBody";
	}
	@RequestMapping(value = "/billScoreBody/{select_month}", method=RequestMethod.GET)
	public String moveBillScorePageSelectMonth(HttpServletRequest request, Model model, @PathVariable("select_month") String select_month ) throws Exception{
		
		HttpSession session = request.getSession();
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		Calendar cal = Calendar.getInstance();
		
		
		String p_month = select_month;
		System.out.println(select_month);
		String[] yearMonth = p_month.split("-");
		String year1 = yearMonth[0];
		String month2 = yearMonth[1];
		
		System.out.println(year1 + " : " + month2);
		String u_id = "";
		
		Personal_mgmt_exVO pme = null;
		Map<String,String> date = new HashMap<String,String>();
		List<EnergyVO> energyList = null;
		List<ArrayList<EnergyVO>> oneYearEnergyList = new ArrayList<ArrayList<EnergyVO>>();
		EnergyVO energy = new EnergyVO();
		int elec =0, water=0, heat=0,fever=0;
		Map<Integer,String> monthMap = new HashMap<Integer,String>();
		
		
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
		
						
		int month = Integer.parseInt(month2);
		int year = Integer.parseInt(year1)-1;
		String selectMonth ="";
		
		
		for( int i = 0; i <= 12; i++){
			
			selectMonth = year + "-" + month;
			monthMap.put(i, selectMonth);
			ArrayList<EnergyVO> list = (ArrayList<EnergyVO>) service.getYearEnergy(u_id, selectMonth);
			
			
			oneYearEnergyList.add((ArrayList<EnergyVO>) service.getYearEnergy(u_id, selectMonth));
			month += 1;
			if( month >12){
				year += 1;
				month = 1;
			}					
		}
		System.out.println(monthMap);
		
		
		
		
		model.addAttribute("monthMap", monthMap);
		model.addAttribute("oneYearEnergyList", oneYearEnergyList);
		
		
		
		
		BillGradeSeletor elecGrade = new BillGradeSeletor(service);
		BillGradeSeletor heatGrade = new BillGradeSeletor(service);
		elecGrade.setEnergyName("elec");
		heatGrade.setEnergyName("heat");
		
		System.out.println(elecGrade.getC() + " : " + elecGrade.getA());
		
		
		
		model.addAttribute("elecGradeTable", elecGrade);
		model.addAttribute("heatGradeTable", heatGrade);
		
		return "/billScore/billScoreBody";
	}

}
