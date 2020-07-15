package com.dbms.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.dbms.model.Listproducts;
import com.dbms.model.Orders;
import com.dbms.model.Userorders;

public interface Orderdao {
	
	
	public void placeorder(List<Listproducts> cartitems, int total, String username);
	public List<Userorders> getuserorders(String username);
	public List<Orders> getorderbyid(int order_id);
	public String getstatusforid(int order_id);
	public void cancelorder(List<Orders> orders, int order_id);
	public List<Userorders> getallorders();
	public void confirmorder(List<Orders> orders, int order_id);
	public Date getdateforid(int order_id);
    public Time gettimeforid(int order_id);
    public String getusernamebyorderid(int order_id);
}
