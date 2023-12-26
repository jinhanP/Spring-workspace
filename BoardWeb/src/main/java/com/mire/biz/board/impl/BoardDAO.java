package com.mire.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mire.biz.board.BoardVO;
import com.mire.biz.common.JDBCUtil;

@Repository("boardDAO") // BoardServicelmpl .
public class BoardDAO {
	// 占쏙옙DBC 占쏙옙占쏙옙 占쏙옙占쏙옙
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 占쏙옙占쏙옙
	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) "
			+ "values ((select nvl(max(seq), 0)+1 from myboard), ?, ?, ?)";
	private final String BOARD_UPDATE = "update myboard set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
//	private final String BOARD_LIST = "select * from myboard order by seq desc";
	//title 검색 기능  
	private final String BOARD_LIST_TITLE = "select * from myboard where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_CONTENT = "select * from myboard where content like '%'||?||'%' order by seq desc";

	// CRUD 占쏙옙占쏙옙占� 占쌨소듸옙 占쏙옙占쏙옙

	// insertBoard
	public void insertBoard(BoardVO vo) {
		System.out.println("===> DBC insertBoard() ");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 占쏙옙 占쏙옙占쏙옙
	public void updateBoard(BoardVO vo) {
		System.out.println("===> DBC updateBoard() ");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 占쏙옙 占쏙옙占쏙옙
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> DBC deleteBoard() ");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 占쏙옙 占쏙옙 占쏙옙회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> DBC getBoard() ");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}

	// 占쏙옙 占쏙옙占� 占쏙옙회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC getBoardList() ");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			//검색 찾아주기
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_TITLE);				
			}else{
				stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
			}
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}