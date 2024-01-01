package com.kiosk.biz.cart;

import java.util.List;

public interface CartService {
	
	List<CartVO> CartList(CartVO vo);
	void insertCart(CartVO vo);
	void deleteCart(CartVO vo);
	
}
