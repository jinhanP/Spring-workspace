package com.kiosk.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kiosk.biz.board.BoardVO;
import com.kiosk.biz.board.impl.BoardDAO;
import com.kiosk.biz.user.UserVO;
import com.kiosk.biz.user.impl.UserDAO;

public class DispatcherServlet_backup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	
	// 클라이언트 요청 정보를 추출한다.
	// 추출한 정보를 가지고 해당된 프로세스 분기를 컨트롤러로 처리 해야된다. log_proc.***
	// 화면 전환을 한다.
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 1. 클라이언트의 요청 path 정보를 추출한다.
		// http://localhost:8080/BoardWeb/login.do => /login.do 추출된다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. 추출한 정보를 가지고 해당된 프로세스 분기를 컨트롤러로 처리 해야된다. log_proc.***
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. 화면 네비게이션
			if (user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}

		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
			HttpSession session = request.getSession();
			session.invalidate();

			// 2. 세션 종료 후, 메인 화면으로 이동한다.
			response.sendRedirect("login.jsp");
			

		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");

			// 1. 사용자 입력 정보 추출
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
			// 2. DB 연동 처리
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
				
				BoardDAO boardDAO = new BoardDAO();
				boardDAO.insertBoard(vo);
				
			// 3. 화면 네이게이션
				response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			

		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			// 1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. 화면 네이게이션
			response.sendRedirect("getBoardList.do");
			

		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");

			// 1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);

			// 3. 응답 화면 구성
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");

		} else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");

			// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);

			// 3. 응답 화면 구성
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}

	}

}
