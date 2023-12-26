package com.mire.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mire.biz.user.UserVO;
import com.mire.biz.user.impl.UserDAO;


@Controller
public class UserController {
	
	//핸들러 맵핑
//	@RequestMapping(value = "/login.do")
//	public String login(UserVO vo, UserDAO userDAO,HttpServletRequest request) {
//		System.out.println("로그인 처리");
//		//아이디 미입력시 예외처리
//		if(vo.getId() == null || vo.getId().equals("")) {
//			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
//		}
//		UserVO user = userDAO.getUser(vo);
//		// 3. 화면 네비게이션
//		if (user != null) {
//			// ViewREsolver register /WEB-INF/board/getBoardList.do.jsp redirect를 붙여서 안나오게 한다.
//			return"redirect:getBoardList.do";
//		} else {
//			return"redirect:login.jsp";
//		}
//	}
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(@ModelAttribute("user") UserVO vo) {
        System.out.println("login.do");
        // 3. 화면 네비게이션
        vo.setId("test");
        vo.setPassword("test123");
        return "login";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(UserVO vo,UserDAO userDAO, HttpSession session) {
        System.out.println("login.do");
        if(vo.getId() == null || vo.getId().equals("")) {
            throw new IllegalArgumentException("아이디 패스워드는 반드시 입력해야됩니다.");
        }
        UserVO user = userDAO.getUser(vo);
        // 3. 화면 네비게이션
        if (user != null) {
            session.setAttribute("userName", user.getName()); 
            return "redirect:getBoardList.do";
        } else {
            return "login";
        }
    }
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value = "/join.do")
	public String join(UserVO vo, UserDAO userDAO) {
		System.out.println("회원가입");
		userDAO.getJoin(vo);
		return "login";
	}
	
	@RequestMapping(value = "/updateUser.do")
	public String updateUser(UserVO vo,UserDAO userDAO) {
		System.out.println("정보수정");
		userDAO.getUpdateUser(vo);
		return "login";
	}
	
	@RequestMapping(value = "/deleteUser.do")
	public String deleteUser(UserVO vo,UserDAO userDAO) {
		System.out.println("회원탈퇴");
		userDAO.getDeleteUser(vo);
		return "login";
	}
	
}
