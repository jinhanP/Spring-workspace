package com.kiosk.view.menu;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kiosk.biz.menu.MenuService;
import com.kiosk.biz.menu.MenuVO;
import com.kiosk.biz.menu.impl.MenuDAO;

@Controller
@SessionAttributes({"menu"})
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/deleteMenu.do")
	public String deleteMenu(MenuVO vo, MenuDAO menuDAO) {
		System.out.println("메뉴 삭제 처리");
		
		menuDAO.deleteMenu(vo);
		return "redirect:getMenuList.do";
	}
	
	@RequestMapping(value = "/getMenu.do")
	public String getMenu(MenuVO vo , Model model) {
		System.out.println("메뉴 상세 조회 처리");
		MenuVO menu = menuService.getMenu(vo);
		// 세션에 저장
		model.addAttribute("menu" , menu);
		return "getMenu";

	}
	@RequestMapping(value = "/getMenuList.do")
	public String getMenuList(MenuVO vo, Model model) {
		System.out.println("메뉴 목록 검색 처리");
		//DB 연동 처리
		List<MenuVO> menuList = menuService.getMenuList(vo);
		model.addAttribute("menuList",menuList);
		return "getMenuList";
		
	}
	
	@RequestMapping(value = "/insertMenu.do")
	public String insertMenu(MenuVO vo) throws IllegalStateException, IOException{
		System.out.println("메뉴 등록 처리");
		
		menuService.insertMenu(vo);
		return "redirect:getMenuList.do";
		
	}
	
	@RequestMapping(value = "/updateMenu.do")
	public String updateMenu(@ModelAttribute("menu")MenuVO vo) {
		System.out.println("메뉴 수정 처리");
		System.out.println(vo.toString());
		menuService.updateMenu(vo);
		return "redirect:getMenuList.do";
		
	}
}
