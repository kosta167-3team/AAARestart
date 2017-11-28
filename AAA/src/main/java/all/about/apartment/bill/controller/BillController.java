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

import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SetBillSeries;
import all.about.apartment.bill.persistence.BillService;
import all.about.apartment.publicDomain.ResidentVO;

@Controller
public class BillController {
	
	@Inject
	private BillService service;
	
	@RequestMapping(value = "/bill/full-width", method = RequestMethod.GET)
	public String BillControllerMethod(HttpServletRequest request, Model model) throws Exception{
		
		HttpSession session = request.getSession();
		Calendar cal = Calendar.getInstance();
		Personal_mgmt_exVO billMonth;
		String paymentDate = "";
		Map<String,String> date = new HashMap<String,String>();
		
		/* 남은 기간 계산 매월 28일 납부 */
		int day = 28-cal.get(Calendar.DATE);
		// 납부 기간을 넘었을 때
		if( day < 0){
			day = 28 + (-day);
		}
		paymentDate = day+"";
		System.out.println(paymentDate);
		model.addAttribute("paymentDate", paymentDate);
		/* date 설정 년/월/일 */
		date.put("year", cal.get(Calendar.YEAR)+"");
		date.put("month", (cal.get(Calendar.MONTH))+"");
		date.put("date", "28");		
		model.addAttribute("dateMap", date);		
		/////
		/* 날짜 출력*/
		
		/* jsp 에서 p_month를 선택했을 경우*/
		String p_month = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
		/*
		if (select_p_month != null) {
			p_month = select_p_month;
		}
		else{
			p_month = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
		}*/
		
		/* 세션 검사 */
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		
		String u_id = "";
		
		if( resident != null){
			u_id = resident.getR_id();
			billMonth = service.getMonthBill(u_id, p_month);
			System.out.println(billMonth);
			model.addAttribute("billMonth", billMonth);
		}
		else{
			u_id = "alstlr123";
			billMonth = service.getMonthBill(u_id, p_month);
			System.out.println(billMonth);
			model.addAttribute("billMonth", billMonth);
		}
		/////
		
		/* 전월 구하기 */
		String preMonth = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH);
		
		Personal_mgmt_exVO preBill = service.getMonthBill(u_id, preMonth);		
		////////////
		/* 에너지 구하기 
		List<EnergyVO> energyList = service.getEnergyList(u_id, p_month);
		EnergyVO allEnergy = new EnergyVO();
		allEnergy.setInput_num(energyList.get(0).getInput_num());
		int elec=0,heat=0,water=0,fever=0;
		
		for( int i = 0; i < energyList.size(); i++){
			elec += energyList.get(i).getElec();
			heat += energyList.get(i).getHeat();
			water += energyList.get(i).getWater();
			fever += energyList.get(i).getFever();
		}
		allEnergy.setElec(elec);
		allEnergy.setFever(fever);
		allEnergy.setHeat(heat);
		allEnergy.setWater(water);				
				
		//////
*/		
		List<SetBillSeries> billList = new ArrayList<SetBillSeries>();
		for( int i = 0; i < Personal_mgmt_exVO.getList().length; i++){
			String listName = Personal_mgmt_exVO.getList()[i];
			int monthBill = billMonth.getSeris().get(listName);
			int preMonthBill = preBill.getSeris().get(listName);
			
			billList.add(new SetBillSeries(listName, monthBill, preMonthBill,monthBill - preMonthBill));			
		}
		
		/*model.addAttribute("energy", allEnergy);*/
		
		model.addAttribute("billSerise", billList);

		model.addAttribute("allBill", billMonth.allBill());
		
		
		return "/bill/full-width";

	}
	@RequestMapping(value = "/bill/full-width/{select_p_month}", method = RequestMethod.GET)
	public String BillControllerMethodSelectMonth(HttpServletRequest request, Model model,@PathVariable String select_p_month) throws Exception{
		
		HttpSession session = request.getSession();
		Calendar cal = Calendar.getInstance();
		Personal_mgmt_exVO billMonth;
		String paymentDate = "";
		Map<String,String> date = new HashMap<String,String>();
		
		/* 남은 기간 계산 매월 28일 납부 */
		int day = 28-cal.get(Calendar.DATE);
		// 납부 기간을 넘었을 때
		if( day < 0){
			day = 28 + (-day);
		}
		paymentDate = day+"";
		System.out.println(paymentDate);
		model.addAttribute("paymentDate", paymentDate);
		/* date 설정 년/월/일 */
		date.put("year", cal.get(Calendar.YEAR)+"");
		date.put("month", (cal.get(Calendar.MONTH))+"");
		date.put("date", "28");		
		model.addAttribute("dateMap", date);		
		/////
		/* 날짜 출력*/
		
		/* jsp 에서 p_month를 선택했을 경우*/
		String p_month = "";		
		if (select_p_month != null) {
			p_month = select_p_month;
		}
		else{
			p_month = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
		}
		
		/* 세션 검사 */
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		
		String u_id = "";
	
		
		
		if( resident != null){
			u_id = resident.getR_id();
			billMonth = service.getMonthBill(u_id, p_month);
			System.out.println(billMonth);
			model.addAttribute("billMonth", billMonth);
		}
		else{
			u_id = "alstlr123";
			billMonth = service.getMonthBill(u_id, p_month);
			System.out.println(billMonth);
			model.addAttribute("billMonth", billMonth);
		}
		/////
		
		/* 전월 구하기 */
		String preMonth = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH);
		
		Personal_mgmt_exVO preBill = service.getMonthBill(u_id, preMonth);		
		////////////
		/* 에너지 구하기 */
		List<EnergyVO> energyList = service.getEnergyList(u_id, p_month);
		EnergyVO allEnergy = new EnergyVO();
		allEnergy.setInput_num(energyList.get(0).getInput_num());
		int elec=0,heat=0,water=0,fever=0;
		
		for( int i = 0; i < energyList.size(); i++){
			elec += energyList.get(i).getElec();
			heat += energyList.get(i).getHeat();
			water += energyList.get(i).getWater();
			fever += energyList.get(i).getFever();
		}
		allEnergy.setElec(elec);
		allEnergy.setFever(fever);
		allEnergy.setHeat(heat);
		allEnergy.setWater(water);				
				
		//////
		/* 에너지 넣기 */
		List<SetBillSeries> billList = new ArrayList<SetBillSeries>();
		for( int i = 0; i < Personal_mgmt_exVO.getList().length; i++){
			String listName = Personal_mgmt_exVO.getList()[i];
			int monthBill = billMonth.getSeris().get(listName);
			int preMonthBill = preBill.getSeris().get(listName);
			
			billList.add(new SetBillSeries(listName, monthBill, preMonthBill,monthBill - preMonthBill));			
		}
		
		model.addAttribute("energy", allEnergy);
		
		model.addAttribute("billSerise", billList);

		model.addAttribute("allBill", billMonth.allBill());
		
		
		return "/bill/full-width";
	}
	
	
	
	
	
	
	
}
