package com.mire.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mire.biz.board.BoardVO;

@Repository // 의존성 주입
public class BoardDAOJPA {
	@PersistenceContext 
	private EntityManager em;

	// CRUD insertBoard
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JPA insertBoard() ");
		//persist = insert 같다.
		em.persist(vo);
		
	}

	// update Board
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JPA updateBoard() ");
		// merge
		em.merge(vo);
		
	}

	// delete Board
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JPA deleteBoard() ");
		BoardVO boardVO = em.find(BoardVO.class, vo.getSeq());
		em.remove(boardVO);
		
	}

	// get Board
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JPA getBoard() ");
		return em.find(BoardVO.class, vo.getSeq());
	}

	// get Board List
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JPA getBoardList()");
		String jpasql = "select b from BoardVO b order by b.seq";
        return em.createQuery(jpasql).getResultList();
//		if (vo.getContent().equals("TITLE")) {
//			return mybatis.selectList("BoardDAO.getBoardList_t", vo);
//		} else {
//			return mybatis.selectList("BoardDAO.getBoardList_c", vo);
//		}
	}
}