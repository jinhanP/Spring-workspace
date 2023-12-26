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
public class InsertBoardController {

//	@RequestMapping(value = "/insertBoard.do")
	public String insertBoar(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
			boardDAO.insertBoard(vo);
			return "redirect:getBoardList.do";

			//mav.addObject - > request 추가하는 역할을 진행한다. : forward 전송한다.
			
		// 3. 화면 네이게이션
//			return "getBoardList.do";		
	}

}
