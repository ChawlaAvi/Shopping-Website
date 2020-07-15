package com.dbms.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.dbms.model.User;

public interface Userdao{
	@Autowired
	public void saveOrUpdate(User user);
	public void delete(String username);
	public User getUserbyusername(String username);
	public User getCustomerbyusername(String username);
	public void saveOrUpdateCustomer(User user);
	public List<User> allcustomers();
	
	
}