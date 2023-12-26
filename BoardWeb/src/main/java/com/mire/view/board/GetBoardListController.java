package com.mire.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mire.biz.board.BoardVO;
import com.mire.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardListController {

//	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo,BoardDAO boardDAO,Model model) {
		System.out.println("글 목록 검색 처리");

		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
		
		
		//mav.addObject - > request 추가하는 역할을 진행한다. : forward 전송한다.
		
		
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		return "getBoardList";
	}
}
