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
		/* return "admin/detail"; */
		return "/admin/bookDetail";
		
	}

	// 제품 등록 페이지
	@RequestMapping(value = "/enroll", method=RequestMethod.GET)
	public void enrollGET(BookVO book) throws Exception{
		
		
	}	
	
	// 제품 등록
	@RequestMapping(value = "/enroll", method=RequestMethod.POST)
	public String enrollPOST(BookVO book) throws Exception{
		
		
		logger.info("=================================");
		
		logger.info("등록(enrollPOST)"+book);
		
		if(book.getbCover() != null) {
			
			book.getbCover().forEach(attach -> logger.info(""+attach));
			
		}
				
		bookservice.bookEnroll(book);
		
		
		return "redirect:/admin/main";
		
	}
	
	// 제품 수정페이지
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public void modifyGET(@RequestParam("num")int num,Model model) throws Exception{
		model.addAttribute("bd", bookservice.bookDetail(num));
	}
	
	// 제품 삭제 
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String deleteGET(@RequestParam("num")int num) throws Exception{
		logger.info("deleteGET......");
		bookservice.bookDel(num);
		return "redirect:list";
	}
	
	// ajax url 테스트
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
	
	// 업로드
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
	
	// 화면 띄우기
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
	
	
		
	
	// 업로드 파일 삭제 처리(데이터베이스 등록 전)
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
	
	
	
	/* 게시물 첨부파일 조회 컨트롤러 */
	@RequestMapping(value="/getBcoverList", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BookCoverVO>> getBcover(int productID){
		
		logger.info("getBcover " + productID);
		
		return new ResponseEntity<>(bookservice.getBCover(productID), HttpStatus.OK);
		
	}
	
	/* 관리자 페이지 첫화면(상품목록 페이지) */
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void mainGET(Criteria cri, Model model) throws Exception{
		int total = bookservice.bookCount(cri);
		PageVO pv = new PageVO(cri, total);
		logger.info("keyword = : " + cri.getKeyword());
		logger.info("total = " + total);
		
		model.addAttribute("list",bookservice.bookListPaging(cri));
		model.addAttribute("page",pv);
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
	
	
	/* 제품 정보 수정 페이지*/
	@RequestMapping(value="/bookModify", method=RequestMethod.POST)
	public void bookModifyPOST(BookVO vo, Model model) throws Exception{
		
		int productID = vo.getProductID();
		
		logger.info("id = " + productID);
		
		model.addAttribute("bm", bookservice.bookDetail(productID));
		
	}
	
	
	// 제품 정보 수정 페이지에서의 업로드물삭제
	@RequestMapping(value="/modifyDeleteFile", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> modifyDeleteFile(String fileName, String type, String uuid){
		
		logger.info("uuid = " + uuid);
		
		//기존 저장되어있던 업로드물
		if(uuid !=null) {
			
			logger.info("쿼리실행");
			
			bookservice.modifyDeleteFile(uuid);
			
		}
		
		
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
	
	
	//제품 정보 수정
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modifyPOST(BookVO book) throws Exception{
		
		logger.info(""+book);
		
		if(book.getbCover() != null) {
			
			logger.info("수정페이지 새로운 업로드");
			
			book.getbCover().forEach(attach -> logger.info(""+attach));
			
		}
		
		bookservice.bookModify(book);
		
		return "redirect:/admin/main";
		
	}
	
	
	//작가목록
	@RequestMapping(value="/authorList", method=RequestMethod.GET)
	public void authorListGET(Criteria cri, Model model) throws Exception{
		int total = bookservice.authorCount(cri);
		PageVO pv = new PageVO(cri, total);
		logger.info("keyword = : " + cri.getKeyword());
		logger.info("total = " + total);
		
		model.addAttribute("list",bookservice.authorListPaging(cri));
		model.addAttribute("page",pv);
	}
	
	
	//작가 상세
	@RequestMapping(value="/authorDetail", method=RequestMethod.GET)
	public void authorDetailGET(int authorID, Model model) throws Exception{
		model.addAttribute("author", bookservice.authorDetail(authorID));
	}
	
	
	//작가 수정페이지
	@RequestMapping(value="/authorModify", method=RequestMethod.GET)
	public void authorModifyGET(AuthorVO vo, Model model) throws Exception{
		
		int authorID = vo.getAuthorID();
		model.addAttribute("author", bookservice.authorDetail(authorID));
		
	}
	
	
	//작가 수정
	@RequestMapping(value="/authorModify", method=RequestMethod.POST)
	public String authorModifyPOST(AuthorVO vo, Model model) throws Exception{
		
		bookservice.authorModify(vo);
		
		return "redirect:/admin/authorList";
	}
	
	
	//제품 삭제
	@RequestMapping(value="/bookDelete", method=RequestMethod.POST)
	public String bookDeletePOST(BookVO vo) throws Exception{
		
		int productID = vo.getProductID();
		
		bookservice.bookDel(productID);
		
		return "redirect:/admin/main";
		
	}
	
	
	//작가 삭제
		@RequestMapping(value="/authorDelete", method=RequestMethod.POST)
		public String authorDeletePOST(AuthorVO vo) throws Exception{
			
			int authorID = vo.getAuthorID();
			bookservice.authorDel(authorID);
			
			return "redirect:/admin/authorList";
		}
		
		
	//주문 목록 페이지
	@RequestMapping(value="/orderList", method=RequestMethod.GET)
	public void orderListGET(Criteria cri, Model model) throws Exception{
		int total = bookservice.orderCount(cri);
		PageVO pv = new PageVO(cri, total);
		
		model.addAttribute("list", bookservice.orderList(cri));
		model.addAttribute("page", pv);
		
	}
	
	
	// 배송 출발 버튼
	@RequestMapping(value="/shipStart", method=RequestMethod.POST)
	@ResponseBody
	public String shipStartPOST(String orderId) throws Exception{
		
		String result = "false";
		System.out.println("orderId : " + orderId);
		if(orderId != null) {
			
			bookservice.shipStart(orderId);
			
			result = "true";
			
		}
		
		return result;
		
	}

	
	// 배송 도착 버튼
	@RequestMapping(value="/shipArrive", method=RequestMethod.POST)
	@ResponseBody
	public String shipArrivePOST(String orderId) throws Exception{
		
		String result = "false";
		System.out.println("orderId : " + orderId);
		if(orderId != null) {
			
			bookservice.shipArrive(orderId);
			
			result = "true";
			
		}
		
		return result;
	}
		
		
	
}
