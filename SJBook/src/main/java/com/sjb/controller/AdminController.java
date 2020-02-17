  package com.sjb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sjb.model.AuthorVO;
import com.sjb.model.BookCoverVO;
import com.sjb.model.BookVO;
import com.sjb.model.Criteria;
import com.sjb.model.PageVO;
import com.sjb.service.BookService;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BookService bookservice;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	/*
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public void listGET(Model model) throws Exception{
		logger.info("list 결과 : " + bookservice.bookList());
		model.addAttribute("list",bookservice.bookList());
	}
	*/
	@RequestMapping(value="/enterAdmin", method=RequestMethod.GET)
	public void enterAdmin() throws Exception{
		logger.info("enterAdmin진입");
	}
	
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGET(Criteria cri, Model model) throws Exception{
		int total = bookservice.bookCount(cri);
		PageVO pv = new PageVO(cri, total);
		logger.info("keyword="+cri.getKeyword());
		logger.info("total = "+total);
		logger.info("bookservice.bookListPaging()" + bookservice.bookListPaging(cri));
		model.addAttribute("list",bookservice.bookListPaging(cri));
		model.addAttribute("page", pv);
		
		
	}
	
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detailGEt(@RequestParam("num")int num,Model model) throws Exception {
		logger.info("제품상세(detailGET.........) 실행");
		model.addAttribute("bd", bookservice.bookDetail(num));
		return "admin/detail";
		
	}

	@RequestMapping(value = "/enroll", method=RequestMethod.GET)
	public void enrollGET(BookVO book) throws Exception{
		
		
	}	
	
	@RequestMapping(value = "/enroll", method=RequestMethod.POST)
	public String enrollPOST(BookVO book) throws Exception{
		
		
		logger.info("=================================");
		
		logger.info("등록(enrollPOST)"+book);
		
		if(book.getbCover() != null) {
			System.out.println("aaaaaa");
			book.getbCover().forEach(attach -> logger.info(""+attach));
			//logger.info("book.getbCover()"+book.getbCover());
			//System.out.println("book.getbCover()"+book.getbCover());
			
		}
				
		bookservice.bookEnroll(book);
		
		
		
		return "redirect:/admin/main";
		//return null;
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public void modifyGET(@RequestParam("num")int num,Model model) throws Exception{
		model.addAttribute("bd", bookservice.bookDetail(num));
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modifyPOST(@RequestParam("num")int num, BookVO book) throws Exception{
		System.out.println("BookVO="+book);
		System.out.println("글수정시작");
		book.setProductID(num);
		System.out.println("BookVO(수정후)="+book);
		bookservice.bookModify(book);
		System.out.println("글수정완료");
		return "redirect:list";
	}
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String deleteGET(@RequestParam("num")int num) throws Exception{
		logger.info("deleteGET......");
		bookservice.bookDel(num);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax() {
		logger.info("upload ajax");
	}
	
	//폴더의 경로설정하는 메서드
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-",File.separator);
	}
	
	
	// 파일이 이미지인지 다른파일의 형식인지를 판단하는 메서드
	private boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			System.out.println(contentType);
			return contentType.startsWith("image");
		} catch(IOException e) {
			e.printStackTrace();			
		}
		return false;
		
	}
	
	
	@RequestMapping(value = "/uploadAjaxAction", method = RequestMethod.POST
			, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BookCoverVO>> uploadajaxPost(MultipartFile[] uploadFile) {
		
		logger.info("update ajax post........");
	
		List<BookCoverVO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
		
		String uploadFolderPath = getFolder();
		//make folder ------
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		
		logger.info("upload path : " + uploadPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// make yyy/MM/dd folser
		
		for (MultipartFile multipartFile : uploadFile) {
			
			BookCoverVO coverVO = new BookCoverVO();
			
			logger.info("-----------------------------------------");
			logger.info("Upload File Name: " + multipartFile.getOriginalFilename());
			logger.info("Upload File Size: " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			logger.info("only file name: " + uploadFileName);
			coverVO.setFileName(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			//File saveFile = new File(uploadFolder, uploadFileName);
			//File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				coverVO.setUuid(uuid.toString());
				coverVO.setUploadPath(uploadFolderPath);
				
				System.out.println(saveFile);
				
				//check image type file  => make thumbnail
				if(checkImageType(saveFile)) {
					
					coverVO.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					System.out.println("aa"+thumbnail);
					System.out.println("bb : " +multipartFile.getInputStream());
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					
					thumbnail.close();
				}
				
				//add to List
				list.add(coverVO);
				
				
			} catch(Exception e) {
				logger.error(e.getMessage());
			}// end catch
			
			
		} //end for
		System.out.println("등록완료");
		return new ResponseEntity<>(list, HttpStatus.OK);
		
		
		
		
	}
	
	
	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		
		logger.info("fileName : " + fileName);
		
		File file = new File("C:\\upload\\"+fileName);
		
		logger.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	//구글 크롬을 통해서만 다운로드할 경우
	/*
	  
	@RequestMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName){
	
		logger.info("download file : " + fileName);
	
		Resource resource = new FileSystemResource("C:\\upload\\"+fileName);
		
		logger.info("resource : " + resource);
		
		String resourceName = resource.getFilename();
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			
			headers.add("Content-Disposition", "attachment; filename="+new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
			
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		
		
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
		
	}*/
	
	
	@RequestMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName){
	
		logger.info("download file : " + fileName);
	
		Resource resource = new FileSystemResource("C:\\upload\\"+fileName);
		
		if(resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		logger.info("resource : " + resource);
		
		String resourceName = resource.getFilename();
		
		//UUID 제거
		String resourceOrignalName = resourceName.substring(resourceName.indexOf("_") +1);
		
		
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			
			String downloadName = null;
			if(userAgent.contains("Trident")) {
				
				logger.info("IE browser");
				
				downloadName = URLEncoder.encode(resourceOrignalName, "UTF-8").replaceAll("\\+", " ");
				
			}else if(userAgent.contains("Edge")) {
				
				logger.info("edge browser");
				
				downloadName = URLEncoder.encode(resourceOrignalName, "UTF-8");
				
				logger.info("Edge name : " + downloadName);
				
			}else {
				
				logger.info("Chrome browser");
			
				downloadName = new String(resourceOrignalName.getBytes("UTF-8"), "ISO-8859-1");
				
				
			}
			
			headers.add("Content-Disposition", "attachment; filename="+downloadName);
			
			
			
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		
		
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	
	
	}
	
	
	// 업로드 파일 삭제 처리
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		
		logger.info("deleteFile: " + fileName);
		
		File file;
		
		try {
			file = new File("C:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			
			if(type.contentEquals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				
				logger.info("largeFileName: " + largeFileName);
				
				file = new File(largeFileName);
				
				file.delete();
			}
			
			
			
			
			
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	//게시물 첨부파일 조회 컨트롤러
	@RequestMapping(value="/getBcoverList", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BookCoverVO>> getBcover(int productID){
		
		logger.info("getBcover " + productID);
		
		return new ResponseEntity<>(bookservice.getBCover(productID), HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void mainGET() throws Exception{
		
	}

	/* 작가등록 */
	@RequestMapping(value="/authorEnroll", method=RequestMethod.GET)
	public void authorEnrollGET() throws Exception{
		
	}
	@RequestMapping(value="/authorEnroll", method=RequestMethod.POST)
	public void authorEnrollPOST(AuthorVO author) throws Exception{
		bookservice.authrEnroll(author);
	}
	
	/* 제품 등록 */
	@RequestMapping(value="/bookEnroll", method=RequestMethod.GET)
	public void bookEnrollGET() throws Exception{
		
	}
	
	/* 작가등록 팝업창 페이지 */
	@RequestMapping(value="/authorSearch", method=RequestMethod.GET)
	public void authorSearchGET(Criteria cri, Model model) throws Exception{
		int total = bookservice.authorCount(cri);
		PageVO pv = new PageVO(cri, total);
		logger.info("keyword = : " + cri.getKeyword());
		logger.info("total = " + total);
		
		model.addAttribute("list",bookservice.authorListPaging(cri));
		model.addAttribute("page",pv);
		
	}
	
	
	
	
}
