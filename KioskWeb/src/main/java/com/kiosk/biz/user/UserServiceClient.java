package com.kiosk.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class UserServiceClient {
	public static void main(String[] args) {
	AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml"); 
	
	UserService userService = (UserService) beanFactory.getBean("userService");
	
	UserVO vo = new UserVO();
	vo.setId("test");
	vo.setPassword("test123");

	
	UserVO userVO = userService.getUser(vo);
	if(userVO != null) {
		System.out.println(userVO.getName()+"님 환영.");
	}else{
		System.out.println("실패");
	}
	beanFactory.close();
}

}