package com.mire.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



//@Controller
public class LogoutController  {

	//@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
		session.invalidate();
		return "redirect:login.jsp";

		
		//mav.addObject - > request 추가하는 역할을 진행한다. : forward 전송한다.
		// 2. 세션 종료 후, 메인 화면으로 이동한다.
//		return "login";
	}

}
