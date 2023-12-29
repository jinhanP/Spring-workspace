package com.mire.view.board;

import com.mire.biz.board.BoardVO;
import com.mire.biz.board.impl.BoardDAO;

//@Controller
public class UpdateBoardController {
	
//	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do";

		
		// mav.addObject - > request 추가하는 역할을 진행한다. : forward 전송한다.
	

		// 3. 화면 네비게이션
//		return"getBoardList.do";
	}

}
