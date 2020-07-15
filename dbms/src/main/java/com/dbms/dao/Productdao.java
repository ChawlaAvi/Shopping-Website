package com.dbms.dao;

import java.util.List;

import com.dbms.model.Listproducts;
import com.dbms.model.Product;

public interface Productdao {
	
	public List<Product> showallproducts();
	public List<Product> showallproductsbycategory(int categoryid);
	public Product getproductbyid(int productid);
	public boolean checkproductexists(Product product);
	public Product getproductbyname(String product_name);
	public void addproducttoproducttable(Product product);
	public void updatecarttable(Listproducts lp, String username);
	public void updatefullcarttable();
	public void removeproductbyid(int product_id);


	
}
