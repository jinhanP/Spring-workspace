package com.mire.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mire.biz.board.BoardVO;

@Repository // 의존성 주입
public class BoardDAOMybaties {
	@Autowired // 의존성 주입
	private SqlSessionTemplate mybatis;

	// CRUD insertBoard
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard() ");
		mybatis.insert("BoardDAO.insertBoard", vo);
		
	}

	// update Board
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard() ");
		mybatis.update("BoardDAO.updateBoard", vo);
		
	}

	// delete Board
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() ");
		mybatis.delete("BoardDAO.deleteBoard", vo);
		
	}

	// get Board
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard() ");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	// get Board List
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis getBoardList()");
        return mybatis.selectList("BoardDAO.getBoardList", vo);
//		if (vo.getContent().equals("TITLE")) {
//			return mybatis.selectList("BoardDAO.getBoardList_t", vo);
//		} else {
//			return mybatis.selectList("BoardDAO.getBoardList_c", vo);
//		}
	}
}