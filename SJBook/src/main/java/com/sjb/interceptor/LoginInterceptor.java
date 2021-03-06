package com.sjb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final String LOGIN = "member";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	/*
	 * preHandle : 컨트롤러가 호출되기 전에 실행 postHandle : 컨트롤러가 실행된 후에 실행 afterComplete : 뷰에서
	 * 최종결과가 생성하는 일을 퐇ㅁ한 모든일이 완료 되었을 때 실행.
	 * 
	 */
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		
		logger.info("post handle...........");
		
		FlashMap flashMap = new FlashMap();
		FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		
		HttpSession session = request.getSession();
		
		Object lvo = modelAndView.getModel().get("memberVO");
		System.out.println("user : " + lvo);
		if(lvo==null) {
			//String msg = "사용자 id 도는 비밀번호를 잘못 입력하였습니다.";
			int result = 0;
			//rttr.addFlashAttribute("result", result);
			System.out.println("resut전3333 : " + result);
			flashMap.put("result", result);
			System.out.println("resut후3333 : " + result);
			response.sendRedirect("/loginMain");//로그인 성공한 후 메인페이지로 이동.
			//response.sendRedirect("/loginMain");
			
		}else {
		System.out.println("new login success");
		session.setAttribute(LOGIN, lvo);
		System.out.println("lvo값 : "+lvo);
		
		response.sendRedirect(request.getContextPath() +"/main");
		}
		
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("pre handle...........");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) != null) {
			
			logger.info("clear login data before");
			
			session.removeAttribute(LOGIN);
			
		}
		
		
		return true;
		
		
	}
}
