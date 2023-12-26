package com.kiosk.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨트롤은 이미 만들어져 있어서 지워도 되고 안지워도된다.
public interface Controller {
	String handleRequest(HttpServletRequest request , HttpServletResponse response);
}
