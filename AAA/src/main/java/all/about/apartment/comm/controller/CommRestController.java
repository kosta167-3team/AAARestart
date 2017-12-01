package all.about.apartment.comm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import all.about.apartment.comm.domain.Comm_board;
import all.about.apartment.comm.domain.Comm_user;
import all.about.apartment.comm.service.CommService;
import all.about.apartment.publicDomain.LoginDTO;
import all.about.apartment.publicDomain.ResidentVO;

@RequestMapping("/comm/*")
@RestController
public class CommRestController {

	@Inject
	CommService service;

	@RequestMapping(value = "/registerComm", method = RequestMethod.POST)
	public ResponseEntity<String> insertUser(@RequestBody Comm_user user, HttpServletRequest request) {

		ResponseEntity<String> entity = null;

		HttpSession session = request.getSession();
		String r_id = ((ResidentVO) session.getAttribute("login")).getR_id();

		user.setR_id(r_id);

		try {
			service.insertUser(user);

			entity = new ResponseEntity<String>("Success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> writeBoard(@RequestBody Comm_board board, HttpServletRequest request) {

		System.out.println("레스트 컨트롤러 도착");
		System.out.println(board.getCb_contents());
		System.out.println(board.getCb_interest());
		
		ResponseEntity<Map<String, Object>> entity = null;

		Map<String, Object> map = new HashMap<>();

		HttpSession session = request.getSession();
		String r_id = ((ResidentVO) session.getAttribute("login")).getR_id();

		board.setR_id(r_id);

		try {
			service.insertCommBoard(board);

			map.put("board", board);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
