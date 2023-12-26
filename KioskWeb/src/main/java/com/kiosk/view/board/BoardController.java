package com.kiosk.view.board;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kiosk.biz.board.BoardService;
import com.kiosk.biz.board.BoardVO;
import com.kiosk.biz.board.impl.BoardDAO;

@Controller
//model.addAttribute("board", board);값을 세션에다가 저장한다.
@SessionAttributes({ "board" })
public class BoardController {
	@Autowired // elmpl에 있는걸 가져온다.@Service("boardService")
	private BoardService boardService;

	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");

		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";

	}

	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		BoardVO board = boardService.getBoard(vo);
		// 세션에다가 저장한다.
		model.addAttribute("board", board);
		return "getBoard";
	}

	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		// 검색 정보 null 체크
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		// DB 연동 처리
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	@RequestMapping(value = "/insertBoard.do")
	public String insertBoar(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("글 등록 처리");

		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 처리");
		System.out.println(vo.toString());
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

}
