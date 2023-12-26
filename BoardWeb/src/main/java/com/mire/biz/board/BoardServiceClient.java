package com.mire.biz.board;


import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//�����������̳� ��ü�� ���� �۵��� ���״�. 
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml"); 

		BoardService boardService = (BoardService) beanFactory.getBean("boardService");		
					
		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
//		vo.setSeq(0);
		vo.setTitle("임시 제목");
		vo.setWriter("PJH");
		vo.setContent("자리 하세요...");
		boardService.insertBoard(vo);
		
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> list = boardService.getBoardList(vo);
		for(BoardVO board : list) {
			System.out.println("---->" + board.toString());
		}
		// 종료
		beanFactory.close();
	}

}
