package com.mire.view.user;

import com.mire.biz.user.UserVO;
import com.mire.biz.user.impl.UserDAO;

//@Controller
public class JoinController{

//	@RequestMapping(value = "/join.do")
	public String join(UserVO vo, UserDAO userDAO) {
		System.out.println("회원가입");
		userDAO.getJoin(vo);
		return "login.jsp";

		
		
		//mav.addObject - > request 추가하는 역할을 진행한다. : forward 전송한다.
		// 3. 화면 네비게이션
//			return "login";
		}

	}


