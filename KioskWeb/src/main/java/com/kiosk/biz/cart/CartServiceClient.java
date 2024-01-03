package com.kiosk.biz.cart;


import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CartServiceClient {

	public static void main(String[] args) {
		
	
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml"); 

		CartService cartService = (CartService) beanFactory.getBean("cartService");		
					
	
		CartVO vo = new CartVO();
//		vo.setSeq(0);
		vo.setTitle("양념");
		vo.setPrice("18000");
		cartService.insertCart(vo);
		
		
		// 4. 글 목록 검색 기능 테스트
		List<CartVO> list = cartService.CartList(vo);
		for(CartVO cart : list) {
			System.out.println("---->" + cart.toString());
		}
		// 종료
		beanFactory.close();
	}

}
