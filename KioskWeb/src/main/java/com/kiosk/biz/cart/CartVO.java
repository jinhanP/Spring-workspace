package com.kiosk.biz.cart;

public class CartVO {
	private int seq;
	private String name;
	private String title;
	private String price;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "CartDAO [seq=" + seq + ", name=" + name + ", title=" + title + ", price=" + price + "]";
	}
	
}
