package com.kiosk.biz.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kiosk.biz.cart.CartService;
import com.kiosk.biz.cart.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;

	public void insertCart(CartVO vo) {
		cartDAO.insertCart(vo);
	}

	public void deleteCart(CartVO vo) {
		cartDAO.deleteCart(vo);

	}

	public List<CartVO> CartList(CartVO vo) {

		return cartDAO.CartList(vo);
	}

}
