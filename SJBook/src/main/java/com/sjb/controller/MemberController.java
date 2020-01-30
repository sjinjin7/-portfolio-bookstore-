package com.sjb.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sjb.model.MemberVO;
import com.sjb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	//private static final String LOGIN = "login";
	
	@Autowired
	private MemberService memberservice;
	@Autowired
	private JavaMailSender mailSender;	
	
	
	@RequestMapping("/joinPage")
	public void joinPageGET() throws Exception{
		
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception{
		System.out.println("join진입성공");
		memberservice.enrollMember(member);
		System.out.println("insert완료");
		return "redirect:/main";
	}
	
	@RequestMapping(value="/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		System.out.println(email);
		//난수만들기
		Random random = new Random();
        int checkNum = random.nextInt(4589362) + 49311;
        
        System.out.println("인증번호 : "+ checkNum);
		//이메일 보내기
        String setfrom = "sjinjin7@naver.com";
        String tomail = email;
        String title = "회원가입 인증 이메일 입니다.";
        String content = 
        		System.getProperty("line.separator") + 
        		System.getProperty("line.separator") + 
        		"홈페이지를 방문해주셔서 감사합니다." + 
        		"<br><br>"+
        		/*System.getProperty("line.separator") + 
        		System.getProperty("line.separator") +*/ 
        		" 인증번호는 " + checkNum + " 입니다." +
        		System.getProperty("line.separator") + 
        		System.getProperty("line.separator") +
        		"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        System.out.println("setfrom"+setfrom);
        System.out.println("tomail"+tomail);
        System.out.println("title"+title);
        System.out.println("content"+content);
        
        
        try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setfrom);				//보내는 사람(생략하면 정상적으로 작동.)
			helper.setTo(tomail);					//받는사람
			helper.setSubject(title);			//메일 제목(생략가능)
			helper.setText(content, true);	// 메일 내용
			System.out.println("받는사람"+setfrom);
			System.out.println("보내는사람"+tomail);
			System.out.println("제목"+title);
			System.out.println("내용"+content);
			
			mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
        
        
        String num = Integer.toString(checkNum);
		
		return num;
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void loginPOST(MemberVO vo, Model model)throws Exception{
		
		System.out.println("vo작동" + vo);
		MemberVO lvo = memberservice.memberLogin(vo);
		System.out.println("로그인vo"+lvo);
		
		model.addAttribute("memberVO", lvo);
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginGET()throws Exception{
	
		return "redirect:/main";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
