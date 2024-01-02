package com.kiosk.biz.menu;

public class MenuVO {
	
	private int seq;
	private String title;
	private String price;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuVO [seq=" + seq + ", title=" + title + ", price=" + price + "]";
	}
}
