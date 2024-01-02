package com.kiosk.biz.menu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiosk.biz.board.BoardService;
import com.kiosk.biz.board.BoardVO;
import com.kiosk.biz.menu.MenuService;
import com.kiosk.biz.menu.MenuVO;


@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;
	
	public void insertMenu(MenuVO vo) {
		menuDAO.insertMenu(vo);
	}

	public void updateMenu(MenuVO vo) {
		menuDAO.updateMenu(vo);

	}

	public void deleteMenu(MenuVO vo) {
		menuDAO.deleteMenu(vo);

	}

	public MenuVO getMenu(MenuVO vo) {
		return menuDAO.getMenu(vo);

	}

	public List<MenuVO> getMenuList(MenuVO vo) {
		
		return menuDAO.getMenuList(vo);
	}

}
