package com.dbms.dao;

import java.util.List;

import com.dbms.model.Category;
import com.dbms.model.Listproducts;
import com.dbms.model.Product;

public interface Categorydao {
	
	public List<Category> getcategorybyid(int product_id);
	public Category getcategorybysizeandid(int product_id, double packet_size);
	public void updatequantity(Category category);
	public void addcategorytoproduct(Category category);
	public Integer getpricebyidandsize(int product_id, double packet_size);
	public Integer getquantitybysizeandid(int product_id, double packet_size);
	public void removefromstock(List<Listproducts> cartitems);
	public void removecategory(int product_id, double packet_size);
}
