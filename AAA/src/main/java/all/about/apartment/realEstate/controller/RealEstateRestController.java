package all.about.apartment.realEstate.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import all.about.apartment.realEstate.domain.AnnualMinMaxVO;
import all.about.apartment.realEstate.domain.AptRentVO;
import all.about.apartment.realEstate.domain.AptTradeVO;
import all.about.apartment.realEstate.domain.LastDataChartVO;
import all.about.apartment.realEstate.domain.LastDataListVO;
import all.about.apartment.realEstate.service.RealEstateService;

@RestController
@RequestMapping("/real_estate/rest")
public class RealEstateRestController {

	
	@Inject
	RealEstateService service;
	
	@RequestMapping(value ="/area_list", method = RequestMethod.GET)
	public ResponseEntity<List<Integer>> get_area(){
		
		List<Integer> list;
		ResponseEntity<List<Integer>> entity  = null;
		
		try {
			list = service.get_area();
			entity = new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	@RequestMapping(value="/lastMonth", method=RequestMethod.POST)
	public ResponseEntity<LastDataChartVO> getLastData(@RequestBody AptRentVO rentVO){
		ResponseEntity<LastDataChartVO> entity = null;
		
		LastDataChartVO vo = null;
		
		
		try {
			vo = service.getLastData(rentVO.getRent_area());
			System.out.println(vo.toString());
			entity = new ResponseEntity<LastDataChartVO>(vo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value ="/getmonthlyList" , method = RequestMethod.POST)
	public ResponseEntity<List<LastDataListVO>> monthlyRealEstate(){
		ResponseEntity<List<LastDataListVO>> entity = null;
		
		List<LastDataListVO> list = null;
		
		System.out.println("ddd");
		
		try {
			list = service.monthlyRealEstate();
			
			for(LastDataListVO vo : list){
				System.out.println(vo.toString());
			}
			
			entity = new ResponseEntity<List<LastDataListVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	@RequestMapping(value ="/annulRent" ,method = RequestMethod.POST)
	public ResponseEntity<List<AnnualMinMaxVO>> annulRent(@RequestBody AptRentVO rentVO){
		ResponseEntity<List<AnnualMinMaxVO>> entity = null;
		List<AnnualMinMaxVO> list  = null;
		
		try {
			list = service.annualRent(rentVO.getRent_area());
			entity = new ResponseEntity<List<AnnualMinMaxVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value ="/annulTrade" ,method = RequestMethod.POST)
	public ResponseEntity<List<AnnualMinMaxVO>> annulTrade(@RequestBody AptTradeVO tradeVO){
		ResponseEntity<List<AnnualMinMaxVO>> entity = null;
		List<AnnualMinMaxVO> list  = null;
		
		try {
			list = service.annualTrade(tradeVO.getTrade_area());
			entity = new ResponseEntity<List<AnnualMinMaxVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/getAnnualList" , method = RequestMethod.POST)
	public ResponseEntity<List<AnnualMinMaxVO>> agetAnnualList(@RequestBody AptRentVO rentVO){
		ResponseEntity<List<AnnualMinMaxVO>> entity = null;
		List<AnnualMinMaxVO> list  = null;
		
		System.out.println("dd");
		
		try {
			list = service.annualRentTrade(rentVO.getRent_area());
			entity = new ResponseEntity<List<AnnualMinMaxVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}














