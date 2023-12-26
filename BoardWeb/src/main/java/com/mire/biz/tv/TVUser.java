package com.mire.biz.tv;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) throws InterruptedException {
		// 스프링컨테이너 객체를 만들어서 작동을 시켰다.
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml");

		TV tv = (TV) beanFactory.getBean("stv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

		beanFactory.close();
	}
}