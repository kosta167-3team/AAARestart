package all.about.apartment.bill.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SaleBillVO;
import all.about.apartment.bill.service.BillService;
import all.about.apartment.publicDomain.ResidentVO;

@RequestMapping("/billRest/*")
@RestController
public class BillRestController {
	
	@Inject
	BillService service;
	
	
	@RequestMapping(value = "/selectMonth/{selectMonth}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> selectedMonth(@PathVariable("selectMonth") String selectMonth){
		
		String[] tokens = selectMonth.split("-");
		int count = 0;
		Map<String, String> map = new HashMap<String,String>();
		ResponseEntity<Map<String, String>> entity = null;

		
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		
		for(int i = 0; i < 4; i++){
			
			month -= 1;
			
			if( month == 0 ){
				month = 12;
				year -=1;
			}		

			map.put("select"+i, new String(year + "-" + month));
			count++;
		}
		if( count == 4){
			entity = new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}
		else
			entity = new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
		
		return entity;
	}
	
	
	@RequestMapping(value = "/selectMonthDetail/{p_month}/{u_id}",method = RequestMethod.GET)
	public Map<String,String> monthDetail(@PathVariable String u_id, @PathVariable String p_month) throws Exception{
		
		Personal_mgmt_exVO bill = service.getMonthBill(u_id, p_month);

		List<SaleBillVO> saleBillList = service.getSaleBill(bill.getInput_num());

		Map<String,String> map = new HashMap<String,String>();
		
		int saleSum = 0;
		
		if( saleBillList != null){
			for(SaleBillVO sale : saleBillList){
				saleSum += sale.getPrice();
			}
		}
		
		map.put("saleBill", saleSum+"");
		map.put("bill", bill.allBill()+"");
		map.put("outsideing", bill.getOutstanding_pay()+"");
		
		return map;
		
	}
	@RequestMapping(value = "/SelectDetail/{select_p_month}/{detail}", method = RequestMethod.GET)
	public List<Personal_mgmt_exVO> getSelectDetailBill(HttpServletRequest request,Model model, @PathVariable String select_p_month, @PathVariable String detail) throws Exception{
		
		/* u_id 구하기*/
		HttpSession session = request.getSession();
		ResidentVO residentvo = (ResidentVO)session.getAttribute("login");
		String u_id = "";
		
		if( residentvo != null){
			u_id = residentvo.getR_id();
		}
		else{
			u_id = "alstlr123";
		}
		int detailListNum = 0;
		
		for( int i = 0; i < Personal_mgmt_exVO.getList().length; i++){
			if(Personal_mgmt_exVO.getList()[i].equals(detail)){
				detailListNum = i;
			}
		}
		

		
		List<Personal_mgmt_exVO> list = service.getSelectDetail(u_id, select_p_month);	
		
		return list;
		
		
		
		
	}

}
