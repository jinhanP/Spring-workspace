package com.mire.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV extends Object implements TV {
	// 멤버변수
//	@Resource(name = "sonySpeaker")
//	@Qualifier("sonySpeaker") // 특정 객체의 이름을 이용하여 의존성 주입할 때 사용
	@Autowired // = setter, 객체를 찾아서 자동으로 연결 해준다.
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("samsungTv 생성자객체만들어짐");
	}

	public void powerOn() {
		System.out.println("SamsungTV on price=" + price);
	}

	public void powerOff() {
		System.out.println("SamsungTV off price=" + price);
	}

	public void volumeUp() {
//		System.out.println("SamsungTV volumeUp");
		this.speaker.volumeUp();
	}

	public void volumeDown() {
//		System.out.println("SamsungTV volumeDown");
		this.speaker.volumeDown();
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice 호출");
		this.price = price;
	}

}