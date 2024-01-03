package com.kiosk.view.cart;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kiosk.biz.board.BoardVO;
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
	public String insertCart(CartVO vo )throws IllegalStateException, IOException {
		System.out.println("상품 추가 처리");
		
		cartService.insertCart(vo);
		return "redirect:CartList.do";
	}
	
	@RequestMapping(value = "/CartList.do")
	public String CartList(CartVO vo , Model model) {
		System.out.println(" 목록 검색 처리");
		
		List<CartVO> cartList = cartService.CartList(vo);
		model.addAttribute("cartList", cartList);
		return "CartList";
	}
}
