package com.mire.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV extends Object implements TV {
	// �������
//	@Resource(name = "sonySpeaker")
//	@Qualifier("sonySpeaker") // Ư�� ��ü�� �̸��� �̿��Ͽ� ������ ������ �� ���
	@Autowired // = setter, ��ü�� ã�Ƽ� �ڵ����� ���� ���ش�.
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("samsungTv �����ڰ�ü�������");
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
		System.out.println("setSpeaker ȣ��");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice ȣ��");
		this.price = price;
	}

}