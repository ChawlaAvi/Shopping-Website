package com.dbms.model;

public class Listproducts {
	
	private Product product;
	private Double packet_size;
	private int quantity;
	private int price;
	private String available;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Double getPacket_size() {
		return packet_size;
	}
	public void setPacket_size(Double productsize) {
		this.packet_size = productsize;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}

}
