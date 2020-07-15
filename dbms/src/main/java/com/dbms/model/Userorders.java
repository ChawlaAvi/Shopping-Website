package com.dbms.model;

import java.sql.Date;
import java.sql.Time;

public class Userorders {
	
	private int order_id;
	private String username;
	private String status;
	private Date orderdate;
	
	
	private Time ordertime;
	private double grand_total;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int orderid) {
		this.order_id = orderid;
	}
	public String getUsername() {
		return username;
	}
	
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Time getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Time ordertime) {
		this.ordertime = ordertime;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(double grand_total) {
		this.grand_total = grand_total;
	}
	
	
	
	

}
