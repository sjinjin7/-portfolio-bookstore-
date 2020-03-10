package com.sjb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sjb.model.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter{

	private static final String LOGIN = "member";
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("pre handle...........");

		HttpSession session = request.getSession();
		
		MemberVO lvo = (MemberVO) session.getAttribute(LOGIN);
		logger.info("!!!lvo : " + lvo);
		logger.info("!!!lvo.getmemberId : " + lvo.getMemberAdmin());

		//session에 담긴 admin이 1일시 관리자로 간주하고 true
		if(lvo.getMemberAdmin() == 1) {
			
			return true;
			
		}

		// 관리자 아닐시 메인페이지로 이동
		response.sendRedirect("/main");
		return false;		
		
		
	}
}
