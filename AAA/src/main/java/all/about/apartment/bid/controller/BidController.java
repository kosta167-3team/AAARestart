package all.about.apartment.bid.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.service.BidService;
import all.about.apartment.bid.util.MediaUtils;
import all.about.apartment.bid.util.uploadFileUtils;
import all.about.apartment.publicDomain.ResidentVO;

@Controller
@RequestMapping("/bid/*")
public class BidController {

	@Inject
	private BidService service;

	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/bidRegister", method = RequestMethod.GET)
	public void registerGET(@ModelAttribute("BidProductVO") BidProductVO vo) throws Exception {
		System.out.println("register get...");

	}

	@RequestMapping(value = "/bidRegister", method = RequestMethod.POST)
	public String registerPOST(@ModelAttribute("BidProductVO") @Valid BidProductVO vo, BindingResult errors,
			RedirectAttributes rttr, @RequestParam("file") MultipartFile file) throws Exception {

		if (errors.hasErrors()) {
			System.out.println("에러발생");
			return "/bid/bidRegister";
		}

		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		vo.setBid_filename(savedName);

		service.regist(vo);
		/* rttr.addAttribute("result","success"); */
		return "redirect:/bid/bidListAll";
	}

	@RequestMapping(value = "/bidRead", method = RequestMethod.GET)
	public void read(Model model) throws Exception {

		model.addAttribute("list", service.read());
	}

	/*
	 * 수정
	 * 
	 * @RequestMapping(value="/bidread2",method=RequestMethod.GET) public void
	 * read2(@RequestParam("bid_id")int bid_id,Model model)throws Exception{
	 * model.addAttribute(service.readDetail(bid_id)); System.out.println("gg");
	 * }
	 */
          
	
	@RequestMapping(value = "/bidmodify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bid_id") int bid_id, Model model) throws Exception {
		System.out.println("ggg");
		model.addAttribute(service.readDetail(bid_id));

	}

	@RequestMapping(value = "/bidmodify", method = RequestMethod.POST)
	public String modifyPOST(@RequestParam("bid_id") int bid_id, BidProductVO vo, RedirectAttributes rttr,
			@RequestParam("file") MultipartFile file) throws Exception {
		System.out.println("mod");
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		String[] fileName = savedName.split("_");
		if (fileName.length > 1) {
			vo.setBid_filename(savedName);
		}
		service.modify(vo);
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/bid/bidListAll";
	}

	@RequestMapping(value = "/bidremove")
	public String remove(@RequestParam("bid_id") int bid_id, RedirectAttributes rttr) throws Exception {
		System.out.println("remove");
		service.remove(bid_id);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/bid/bidListAll";
	}

	@RequestMapping(value = "/bidEvaluation", method = RequestMethod.GET)
	public void bidEvaluation(@RequestParam("bid_id") int bid_id, BidProductVO vo, Model model) throws Exception {
		model.addAttribute("list", service.readDetail(bid_id));
		model.addAttribute("evaluation", vo.getBid_evaluation());

		System.out.println("상품평 클릭시 " + service.readDetail(bid_id));

	}

	/* @ResponseBody */
	/*@RequestMapping(value = "/bidEvaluation", method = RequestMethod.POST)
	public void EvaluationPOST(BidProductVO vo) throws Exception {

		service.readInsert(vo);

	}*/

	@RequestMapping(value = "/bidListAll", method = RequestMethod.GET)
	public void getAttach(Integer bid_id, Model model) throws Exception {

		model.addAttribute("listAll", service.read());

	}

/*	@RequestMapping(value = "/bidListAll2", method = RequestMethod.GET)
	public void bidListAll2() {

	}*/

	/*
	 * @RequestMapping(value="/bidListAll",method=RequestMethod.POST)
	 * 
	 * @ResponseBody public List<String> getAttach(Integer bid_id)throws
	 * Exception{ return service.getAttach(bid_id);
	 * 
	 * }
	 */

	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {

	}

	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {

		System.out.println("originalName : " + file.getOriginalFilename());

		return new ResponseEntity<>(uploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		/* System.out.println("FILE NAME: " + fileName); */

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FILE NAME: " + fileName);
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/deleteFile", method=RequestMethod.POST) public
	 * ResponseEntity<String> deleteFile(String fileName){
	 * 
	 * System.out.println("delete file: "+ fileName);
	 * 
	 * String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	 * 
	 * MediaType mType = MediaUtils.getMediaType(formatName);
	 * 
	 * if(mType != null){
	 * 
	 * String front = fileName.substring(0,12); String end =
	 * fileName.substring(14); new File(uploadPath + (front+end).replace('/',
	 * File.separatorChar)).delete(); }
	 * 
	 * new File(uploadPath + fileName.replace('/',
	 * File.separatorChar)).delete();
	 * 
	 * 
	 * return new ResponseEntity<String>("deleted", HttpStatus.OK); }
	 */

	public String uploadFile(String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;

	}

	@RequestMapping(value = "/bidread2", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<BidProductVO>> rest(@RequestParam(value = "sort", required = false) String sort)
			throws Exception {
		System.out.println(sort);
		List<BidProductVO> list = null;
		if (sort.equals("가격 순")) {
			list = service.read2("bid_start");
		} else if (sort.equals("날짜 순")) {
			list = service.read2("bid_date");
		}
		ResponseEntity<List<BidProductVO>> entity = null;
			
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getBid_start());
		}
			
		try {

			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	
	@RequestMapping(value="/map",method=RequestMethod.GET)
	public void map()throws Exception{
		
	}
	
	@RequestMapping(value="/map2",method=RequestMethod.GET)
	public void map2()throws Exception{
		
	}
	@RequestMapping(value="/gallery",method=RequestMethod.GET)
	public void gallery(Integer bid_id, Model model)throws Exception{
		model.addAttribute("listAll", service.read());
	}
	@RequestMapping(value="/bidDetail/{bid_id}",method=RequestMethod.GET)
	public ModelAndView bidDetail(@PathVariable String bid_id, HttpServletRequest request)throws Exception{	
		HttpSession session = request.getSession();
		ResidentVO resident = (ResidentVO)session.getAttribute("login");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/bid/bidDetail");
		System.out.println("bid_id : " + bid_id);
		System.out.println("로그인한 사람 : " + resident.getR_id());
		mav.addObject("bid_id", bid_id);
		mav.addObject("r_id", resident.getR_id());
		mav.addObject("bidProduct", service.readDetail(Integer.parseInt(bid_id)));
		return mav;	
	}
	
	
}
