package com.kiosk.biz.menu;

import java.util.List;

public interface MenuService {

	void insertMenu(MenuVO vo);
	void updateMenu(MenuVO vo);
	void deleteMenu(MenuVO vo);
	MenuVO getMenu(MenuVO vo);
	List<MenuVO> getMenuList(MenuVO vo);
}
