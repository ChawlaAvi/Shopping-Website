package com.dbms.model;

public class Orders {
	
	int order_id;
	Product product;
	
	double packet_size;
	int ordered_quantity;
	int amount;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public double getPacket_size() {
		return packet_size;
	}
	public void setPacket_size(double packet_size) {
		this.packet_size = packet_size;
	}
	public int getOrdered_quantity() {
		return ordered_quantity;
	}
	public void setOrdered_quantity(int ordered_quantity) {
		this.ordered_quantity = ordered_quantity;
	}
	

}
