package com.sjb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sjb.model.MemberVO;
import com.sjb.service.MemberService;

public class ReSessionInterceptor extends HandlerInterceptorAdapter {
	
	
	@Autowired
	private MemberService memberservice;
	
	private static final String LOGIN = "member";
	private static final Logger logger = LoggerFactory.getLogger(ReSessionInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 진입");
		HttpSession session = request.getSession();
		//기존 세션 정보제거
		if(session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			System.out.println("clear login data before");
			session.removeAttribute(LOGIN);
			
		}
		
		
		
		//새 세션 정보 저장
		String memberId = (String) modelAndView.getModel().get("memberId");
		MemberVO vo = memberservice.reSession(memberId);
		Object lvo = vo;
		System.out.println("lvo새로담기");
		session.setAttribute(LOGIN, lvo);
		System.out.println("lvo값 = " + lvo);
		response.sendRedirect(request.getContextPath() +"/main");
		
		
		
		
		
		
		
		
		
		
		
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
