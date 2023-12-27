package com.mire.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 연속성 
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction etx =em.getTransaction();
		
		try {
			// DB CURD 작업 처리.
			etx.begin();
			
			Board board = new Board();
			board.setTitle("JPA Test");
			board.setWriter("홍마떡");
			board.setContent("quert문 없이 작업하는게 신기ㅎㅎ");
			
			// 글 등록(insert)
			em.persist(board);
			
			// 글 목록조회 Board를 b로 바꿔서 설정
			String jpasql = "select b from Board b order by b.seq desc";
			// jpasql 돌리면서 Board에 저장
			List<Board> boardList = em.createQuery(jpasql,Board.class).getResultList();
			
			//콘솔창 출력
			for( Board data : boardList) {
				System.out.println("******"+data.toString());
			}
			etx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			etx.rollback();
		}finally {
			em.close();
		}
		emf.close();	
	}

}
