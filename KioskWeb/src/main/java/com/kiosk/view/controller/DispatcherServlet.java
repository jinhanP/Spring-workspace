package com.kiosk.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public DispatcherServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException{
		//1. controller 객체를 만든다.
	 handlerMapping	= new HandlerMapping();
	 	//2. viewResolver 객체를 만들고 , 경로를 배정한다.
	 viewResolver = new ViewResolver();
	 viewResolver.setPrefix("./");
	 viewResolver.setSuffix(".jsp");
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 1. 클라이언트의 요청 path 정보를 추출한다.
		// http://localhost:8080/BoardWeb/login.do => /login.do 추출된다.
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		//2. 해당된 controller 진행한다.
		Controller controller = handlerMapping.getController(path);

		//3. 검색된 controller 실행해서 문자열 리턴받는다. request response 전달 받는다.
		String viewName = controller.handleRequest(request, response);

		//4. 화면전환을 받는다.
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		response.sendRedirect(view);
	} 

}
