package com.dbms.dao;

import java.util.List;

import com.dbms.model.Cart;
import com.dbms.model.Listproducts;
import com.dbms.model.Product;

public interface Cartdao {

	public List<Listproducts> showCart(String username);
	public Listproducts getcartitembyusername_pid_psize(String username, int product_id, double packet_size);
	
	public void updateitemincart(String username, Listproducts lp, String action, String removerecord);
	public void additemincart(String username, Listproducts lp);
	public void emptycart(String username);
	public void emptycartavailable(String username);
	
}
