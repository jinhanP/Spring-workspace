package com.kiosk.biz.cart.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kiosk.biz.cart.CartVO;
import com.kiosk.biz.common.JDBCUtil;

@Repository("cartDAO")
public class CartDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String CART_INSERT = "insert into kioskcart(seq, name, title, price) "
			+ "values ((select nvl(max(seq), 0)+1 from kioskcart), ?, ?, ?)";
	
	public void insertCart(CartVO vo) {
		System.out.println("InserCart");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CART_INSERT);
			stmt.setString(1, vo.getName());
			stmt.setString(1, vo.getTitle());
			stmt.setString(1, vo.getPrice());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	private final String CART_DELETE = "delete from kioskcart where seq=?";
	
	public void deleteCart(CartVO vo) {
		System.out.println("DeleteCart");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CART_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	private final String CART_LIST = "select * from kioskcart order by seq desc";

	
	public List<CartVO> CartList(CartVO vo){
		System.out.println("CartList");
		List<CartVO> cartList = new ArrayList<CartVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CART_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				CartVO cart = new CartVO();
				cart.setSeq(rs.getInt("SEQ"));
				cart.setName(rs.getString("NAME"));
				cart.setTitle(rs.getString("TITLE"));
				cart.setPrice(rs.getString("PRICE"));
				cartList.add(cart);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return cartList;
	}
	
	
}
