package all.about.apartment.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import all.about.apartment.message.domain.MessageDTO;
import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.message.service.MessageService;
import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.PageMaker;
import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.publicDomain.SearchCriteria;
import oracle.net.aso.l;
import oracle.net.aso.s;

@RequestMapping("/message")
@RestController

public class MessageRestController{

	@Inject
	MessageService service;
	
	@RequestMapping(value="/send" , method = RequestMethod.POST)
	public ResponseEntity<String> messageSend(@RequestBody MessageDTO dto){
		System.out.println(dto.toString());
		
		ResponseEntity<String> entity = null;
		
		try {
			service.sendMessage(dto);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	

	/*쪽지 확인*/	
	@RequestMapping(value="/receive" ,method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> recieveGET(@RequestBody ResidentVO vo
			,@RequestParam("page") Integer page, @RequestParam("keyword") String keyword,@RequestParam("searchType") String searchType){
		System.out.println(vo);
		
		ResponseEntity<Map<String,Object>> entity = null;
		List<MessageVO> list= null;
		
		
		
		try {
			SearchCriteria cri = new SearchCriteria();
			cri.setPage(page);
			cri.setKeyword(keyword);
			cri.setSearchType(searchType);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			list = service.recieveMessage(vo.getR_id(),vo.getR_authority(),cri);
			
			
			
			map.put("list", list);
			
			int msgCnt = service.msgCnt(vo.getR_id(),vo.getR_authority(),cri);
			pageMaker.setTotalCount(msgCnt);

			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
/*	쪽지 확인	
	@RequestMapping(value="/recieve/{page}" ,method = RequestMethod.POST)
	public ResponseEntity<M<MessageVO>> recieveGET(@RequestBody ResidentVO vo
			,@PathVariable("page") Integer page){
		System.out.println(vo);
		
		ResponseEntity<List<MessageVO>> entity = null;
		List<MessageVO> list= null;
		
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			
			
			list = service.recieveMessage(vo.getR_id());
			entity = new ResponseEntity<List<MessageVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;

	}*/
	
	
	@RequestMapping(value ="/msgcnt", method = RequestMethod.POST)
	public ResponseEntity<Integer> msgCount(@RequestBody ResidentVO vo){
		
		ResponseEntity<Integer> entity = null;
		int msgCount;
		
		System.out.println(vo);
		
		try {
			msgCount = service.newMsgCount(vo.getR_id());
			entity = new ResponseEntity<Integer>(msgCount, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	@RequestMapping(value="/update_ck")
	public ResponseEntity<String> update_ck(@RequestBody MessageDTO vo){
		ResponseEntity<String> entity = null;
		
		try {
			service.update_ck(vo.getMsg_id());
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}















