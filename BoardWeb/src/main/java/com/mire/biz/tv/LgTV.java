package com.mire.biz.tv;

public class LgTV implements TV{
	
	
	public LgTV() {
		System.out.println("LgTV �������۵��ؼ� ��ü�������");
	}
	
	public void initMethod() {
		System.out.println("LgTV initMethod �Լ��Դϴ�.");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV on");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV off");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV volumeUp");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV volumeDown");
		
	}
	
	public void destroyMethod() {
		System.out.println("LgTV destroyMethod �Լ��Դϴ�.");
	}
}
