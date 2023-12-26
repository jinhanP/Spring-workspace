package com.kiosk.view.controller;

import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	// 생성자에 Map<String, Controller> 핸들러를 등록
	public HandlerMapping() {
		super();
// 		~ .do 라고 쓰면 불러온다.
//		mappings = new HashMap<String, Controller>();
//		mappings.put("/login.do", new LoginController());
//		mappings.put("/getBoardList.do", new GetBoardListController());
//		mappings.put("/getBoard.do", new GetBoardController());
//		mappings.put("/insertBoard.do", new InsertBoardController());
//		mappings.put("/updateBoard.do", new UpdateBoardController());
//		mappings.put("/deleteBoard.do", new DeleteBoardController());
//		mappings.put("/logout.do", new LogoutController());

	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

}
