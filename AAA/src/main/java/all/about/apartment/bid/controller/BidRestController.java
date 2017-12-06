package all.about.apartment.bid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.service.BidService;

@RestController
@RequestMapping("/bid")
public class BidRestController {
	
	
	@Inject
	private BidService service;

	@RequestMapping(value="/review",method=RequestMethod.POST)
	public ResponseEntity<String> review(@RequestParam("bid_id")String bid_id,
			@RequestParam("bid_evaluation")String bid_evaluation)throws Exception{
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("bid_id",bid_id);
		map.put("bid_evaluation", bid_evaluation);
		
		System.out.println("-------------review");
	
		System.out.println(bid_id);
		System.out.println(bid_evaluation);
		ResponseEntity<String> entity = null;
		
		try {
			
			service.readInsert(map);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/addBidTime", method=RequestMethod.GET)
	public ResponseEntity<BidProductVO> addBidTime(@RequestParam("bid_id")String bid_id) {
		ResponseEntity<BidProductVO> entity = null;
		HashMap<String, Object> map = new HashMap<>();
		System.out.println(bid_id);
		map.put("bid_id", bid_id);
		System.out.println(map);
		try {
			service.addBidTime(map);
			map.put("BidProductVO", service.bidDetail(bid_id));
			entity = new ResponseEntity<>(service.readDetail(Integer.parseInt(bid_id)), HttpStatus.OK);
			System.out.println("success" + service.readDetail(Integer.parseInt(bid_id)).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	
	/*@RequestMapping(value="/review/{bid_id}",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> review(BidProductVO vo,
			@PathVariable("bid_id")int bid_id)throws Exception{
		
		System.out.println("-------------------------reivew");		
		System.out.println(bid_id);
		System.out.println(vo);
		ResponseEntity<String> entity = null;
		service.readInsert(vo);
		try{
			service.readInsert(vo);
			System.out.println("!" + vo);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}*/
	
	
	
	
	/*@RequestMapping(value="/bidread2",method=RequestMethod.POST)
	public ResponseEntity<List<BidProductVO>> rest(@RequestBody BidProductVO vo,String sort
			)throws Exception{
			
		
		if(sort.equals("가격 순")){
			service.read2("bid_start");
		}else if(sort.equals("날짜 순")){
			service.read2("bid_date");
		}
			
		ResponseEntity<List<BidProductVO>> entity=null;
		
		try {
			
			entity=new ResponseEntity<>(service.read2(sort),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	*/

	
}
