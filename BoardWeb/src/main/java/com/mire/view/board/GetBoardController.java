package com.mire.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mire.biz.board.BoardVO;
import com.mire.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardController  {

//	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo,BoardDAO boardDAO,Model model) {
		System.out.println("글 상세 조회 처리");

		BoardVO board = boardDAO.getBoard(vo);
		model.addAttribute("board", board);
		return "getBoard";
		
		// 3. 응답 화면 구성
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		return "getBoard";
	}

}
