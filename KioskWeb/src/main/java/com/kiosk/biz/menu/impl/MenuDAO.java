package com.kiosk.biz.menu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kiosk.biz.common.JDBCUtil;
import com.kiosk.biz.menu.MenuVO;

@Repository("menuDAO")
public class MenuDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String MENU_INSERT = "insert into kioskmenu(seq, title, price) "
			+ "values ((select nvl(max(seq), 0)+1 from kioskmenu), ?, ?)";
	private final String MENU_UPDATE = "update kioskmenu set title=?, price=? where seq=?";
	private final String MENU_DELETE = "delete from kioskmenu where seq=?";
	private final String MENU_GET = "select * from kioskmenu where seq=?";
	private final String MENU_LIST = "select * from kioskmenu order by seq desc";

	public void insertMenu(MenuVO vo) {
		System.out.println("InsertMenu 처리");
		 try {
			 	conn = JDBCUtil.getConnection();
			 	stmt = conn.prepareStatement(MENU_INSERT);
			 	stmt.setString(1, vo.getTitle());
			 	stmt.setString(2, vo.getPrice());
			 	stmt.executeUpdate();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 JDBCUtil.close(stmt, conn);
		 }
	}
	public void updateMenu(MenuVO vo) {
		System.out.println("updateMenu 처리");
		try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(MENU_UPDATE);
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getPrice());
				stmt.setInt(3, vo.getSeq());
				stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public void deleteMenu(MenuVO vo) {
		System.out.println("deleteMenu 처리");
		try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(MENU_DELETE);
				stmt.setInt(1, vo.getSeq());
				stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
			
	}
	public MenuVO getMenu(MenuVO vo) {
		System.out.println("getMenu");
		MenuVO menu = null;
		try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(MENU_GET);
				stmt.setInt(1, vo.getSeq());
				rs = stmt.executeQuery();
				if(rs.next()) {
					menu = new MenuVO();
					menu.setSeq(rs.getInt("SEQ"));
					menu.setTitle(rs.getString("TITLE"));
					menu.setPrice(rs.getString("PRICE"));
				}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		return menu;
		
	}
	
	public List<MenuVO> getMenuList(MenuVO vo){
		System.out.println("getMenuList");
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MENU_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MenuVO menu = new MenuVO();
				menu.setSeq(rs.getInt("SEQ"));
				menu.setTitle(rs.getString("TITLE"));
				menu.setPrice(rs.getString("PRICE"));
				menuList.add(menu);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		return menuList;
	}
}
