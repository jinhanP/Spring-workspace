package com.mire.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.mire.biz.user.UserVO;
import com.mire.biz.user.impl.UserDAO;


//@Controller
public class LoginController {
	
//	@RequestMapping(value = "/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 처리");
		UserVO user = userDAO.getUser(vo);

		// 3. 화면 네비게이션
		if (user != null) {
			// ViewREsolver register /WEB-INF/board/getBoardList.do.jsp redirect를 붙여서 안나오게 한다.
			return"redirect:getBoardList.do";
		} else {
			return"redirect:login.jsp";
		}
	}
}
