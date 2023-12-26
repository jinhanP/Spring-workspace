package com.mire.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		//�����������̳� ��ü�� ���� �۵��� ���״�. 
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml"); 
		
		UserService userService = (UserService) beanFactory.getBean("userServiceImpl");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
	
		
		UserVO userVO = userService.getUser(vo);
		if(userVO != null) {
			System.out.println(userVO.getName()+"ȯ���մϴ�.");
		}else{
			System.out.println("�α��� ����");
		}
		beanFactory.close();
	}

}
