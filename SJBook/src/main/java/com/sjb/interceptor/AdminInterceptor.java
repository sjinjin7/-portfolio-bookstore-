package com.sjb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sjb.model.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter{

	private static final String LOGIN = "member";
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	/*
	 * preHandle : 컨트롤러가 호출되기 전에 실행 postHandle : 컨트롤러가 실행된 후에 실행 afterComplete : 뷰에서
	 * 최종결과가 생성하는 일을 퐇ㅁ한 모든일이 완료 되었을 때 실행.
	 * 
	 */
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println("post handle...........");
		//FlashMap flashMap = new FlashMap();
		//FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
		//flashMapManager.saveOutputFlashMap(flashMap, request, response);
		
		
		
		
		/*
		HttpSession session = request.getSession();
		
		Object lvo = modelAndView.getModel().get("memberVO");
		System.out.println("user : " + lvo);
		if(lvo==null) {
			//String msg = "사용자 id 도는 비밀번호를 잘못 입력하였습니다.";
			int result = 0;
			//rttr.addFlashAttribute("result", result);
			System.out.println("resut전3333 : " + result);
			//flashMap.put("result", result);
			System.out.println("resut후3333 : " + result);
			response.sendRedirect("/loginMain");//로그인 성공한 후 메인페이지로 이동.
			//response.sendRedirect("/loginMain");
			
		}else {
		System.out.println("new login success");
		session.setAttribute(LOGIN, lvo);
		System.out.println("lvo값 : "+lvo);
		
		response.sendRedirect(request.getContextPath() +"/main");
		}
		*/
		
		
		
		
		
		/*
		 * if(lvo != null) {//사용자가 회원가입을 했으면 logger.info("new login success");
		 * System.out.println("new login success"); session.setAttribute(LOGIN,
		 * userVO);//로그인 처리(session 회원정보 저장)
		 * response.sendRedirect("/controller/board/list");//로그인 성공한 후 메인페이지로 이동. }
		 */
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("pre handle...........");
		
		/*
		HttpSession session = request.getSession();
		
		MemberVO lvo = (MemberVO) session.getAttribute(LOGIN);
		logger.info("!!!lvo : " + lvo);
		logger.info("!!!lvo.getmemberId : " + lvo.getMemberAdmin());
		if(lvo.getMemberAdmin() != 1) {
			response.sendRedirect("main");
			return false;
		}
		response.sendRedirect("/admin/list");
		return true;
		*/

		HttpSession session = request.getSession();
		
		MemberVO lvo = (MemberVO) session.getAttribute(LOGIN);
		logger.info("!!!lvo : " + lvo);
		logger.info("!!!lvo.getmemberId : " + lvo.getMemberAdmin());
		if(lvo.getMemberAdmin() == 1) {
			//response.sendRedirect("/admin/list");
			return true;
		}

		response.sendRedirect("/main");
		return false;		
		
		
		
		
		
		
		
		/*
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			System.out.println("clear login data before");
			session.removeAttribute(LOGIN);
			
		}
		*/
		
		
		
		
		
		
	}
}
