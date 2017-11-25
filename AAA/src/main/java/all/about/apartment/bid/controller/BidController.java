package all.about.apartment.bid.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import all.about.apartment.bid.domain.BidContentVO;
import all.about.apartment.bid.domain.BidProductVO;
import all.about.apartment.bid.service.BidService;
import all.about.apartment.bid.util.MediaUtils;
import all.about.apartment.bid.util.uploadFileUtils;

@Controller
@RequestMapping("/bid/*")
public class BidController {
	
	@Inject
	private BidService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/bidRegister", method=RequestMethod.GET)
	public void registerGET(BidProductVO vo,Model model)throws Exception{
		System.out.println("register get...");
	}
	
	@RequestMapping(value="/bidRegister",method=RequestMethod.POST)
	public String registerPOST(BidProductVO vo,RedirectAttributes rttr,@RequestParam("file") MultipartFile file)throws Exception{
		
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		vo.setBid_filename(savedName);
		
		service.regist(vo);
		
		
		rttr.addAttribute("result","success");
		
		
		return "redirect:/bid/bidListAll";
	}
	
	
	@RequestMapping(value="/bidRead",method=RequestMethod.GET)
	public void read(Model model)throws Exception{
		
		model.addAttribute("list",service.read());
	}
	
	
	@RequestMapping(value="/bidEvaluation",method=RequestMethod.GET)
	public void bidEvaluation(@RequestParam("bid_id")int bid_id,BidProductVO vo,Model model)throws Exception{
		model.addAttribute("list",service.readDetail(bid_id));
		model.addAttribute("evaluation",vo.getBid_evaluation());
		
		System.out.println(service.readDetail(bid_id));
		
	}

	/*@ResponseBody*/
	@RequestMapping(value="bidEvaluation",method=RequestMethod.POST)
	public void EvaluationPOST(BidProductVO vo)throws Exception{
		
		service.readInsert(vo);
		
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/bidListAll",method=RequestMethod.GET)
	public void getAttach(Integer bid_id, Model model)throws Exception{
		
		
		
		model.addAttribute("listAll",service.read());
		
	}
	
	@RequestMapping(value="/bidListAll2",method=RequestMethod.GET)
	public void bidListAll2(){
		
	}
	
	
	
	
	
	
	
	
	/*
	@RequestMapping(value="/bidListAll",method=RequestMethod.POST)
	@ResponseBody
	public List<String> getAttach(Integer bid_id)throws Exception{
		return service.getAttach(bid_id);
		
	}*/

	
	@RequestMapping(value = "/uploadAjax",method=RequestMethod.GET)
	public void uploadAjax(){
		
	}
	
	 @ResponseBody
	 @RequestMapping(value ="/uploadAjax", method=RequestMethod.POST, 
	                  produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{
		 
		 System.out.println("originalName : " + file.getOriginalFilename());

		return new ResponseEntity<>(
				uploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),
						file.getBytes()),HttpStatus.CREATED);
	  }
	 
	 @ResponseBody
	 @RequestMapping("/displayFile")
	 public ResponseEntity<byte[]> displayFile(String fileName)throws Exception{
		 
		 InputStream in = null;
		 ResponseEntity<byte[]> entity = null;
		 
		 System.out.println("FILE NAME: " + fileName);
		 
		 try{
		      
		      String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		      
		      MediaType mType = MediaUtils.getMediaType(formatName);
		      
		      HttpHeaders headers = new HttpHeaders();
		      
		      in = new FileInputStream(uploadPath+fileName);
		      
		      if(mType != null){
		        headers.setContentType(mType);
		      }else{
		        
		        fileName = fileName.substring(fileName.indexOf("_")+1);       
		        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.add("Content-Disposition", "attachment; filename=\""+ 
		          new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
		      }

		        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), 
		          headers, 
		          HttpStatus.CREATED);
		    }catch(Exception e){
		      e.printStackTrace();
		      System.out.println("FILE NAME: " + fileName);
		      entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		    }finally{
		      in.close();
		    }
		      return entity;    
		  }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	  public ResponseEntity<String> deleteFile(String fileName){
	    
	   System.out.println("delete file: "+ fileName);
	    
	    String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	    
	    MediaType mType = MediaUtils.getMediaType(formatName);
	    
	    if(mType != null){      
	      
	      String front = fileName.substring(0,12);
	      String end = fileName.substring(14);
	      new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
	    }
	    
	    new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
	    
	    
	    return new ResponseEntity<String>("deleted", HttpStatus.OK);
	  }  
	
	  
	  public String uploadFile(String originalName, 
	                              byte[] fileData)throws Exception{
	    
	    UUID uid = UUID.randomUUID();
	    
	    String savedName = uid.toString() +"_"+originalName;

	    File target = new File(uploadPath, savedName);
	    
	    FileCopyUtils.copy(fileData, target);

	    return savedName;
	    
	  }
	
	
	
	
	
	

}
