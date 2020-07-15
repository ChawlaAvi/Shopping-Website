package com.dbms.model;

import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.NotEmpty;

public class Product {

	private int product_id;
	
	@NotNull(message="required")
	private String product_name;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int productid) {
		this.product_id = productid;
	}

	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String productname) {
		this.product_name = productname;
	}
	
	
}
