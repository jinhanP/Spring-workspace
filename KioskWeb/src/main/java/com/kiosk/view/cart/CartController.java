package com.kiosk.view.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kiosk.biz.cart.CartService;
import com.kiosk.biz.cart.CartVO;
import com.kiosk.biz.cart.impl.CartDAO;

@Controller
@SessionAttributes({"cart"})
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/deleteCart.do")
	public String deleteCart(CartVO vo , CartDAO cartDAO) {
		System.out.println("상품 삭제 처리");
		
		cartDAO.deleteCart(vo);
		return "redirect:CartList.do";
	}
	
	@RequestMapping(value = "/insertCart.do")
	public String insertCart(CartVO vo , CartDAO cartDAO) {
		System.out.println("상품 추가 처리");
		
		cartService.insertCart(vo);
		return "redirect:CartList.do";
	}
	
}
