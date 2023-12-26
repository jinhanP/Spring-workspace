package com.mire.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mire.biz.board.BoardVO;
import com.mire.biz.board.impl.BoardDAO;


//@Controller
public class DeleteBoardController {
	
//	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
		
		//mav.addObject - > request 추가하는 역할을 진행한다. : forward 전송한다.
//		mav.setViewName("redirect:getBoardList.do");
		
		// 3. 화면 네이게이션
//		return "getBoardList.do";
		
	}

}
