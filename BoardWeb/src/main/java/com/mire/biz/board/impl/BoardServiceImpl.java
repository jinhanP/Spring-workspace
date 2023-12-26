package com.mire.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mire.biz.board.BoardService;
import com.mire.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired // 의존성 주입
	private BoardDAOMybaties boardDAO;

	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0) {
//			throw new NullPointerException("0������ �ش�Ǵ� ��ü�� ã�� �� �����ϴ�.");
//			//�߰����� �� ���� ����
//		}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {

		boardDAO.updateBoard(vo);

	}

	@Override 
	public void deleteBoard(BoardVO vo) {

		boardDAO.deleteBoard(vo);

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {

		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {

		return boardDAO.getBoardList(vo);
	}

}
