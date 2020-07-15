package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.dbms.model.User;
import com.dbms.model.Userorders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

public class UserdaoImpl implements Userdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserdaoImpl() {
		
	}
	
	
	public UserdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	@Override
	public void saveOrUpdate(User user) {
		 String sql = "INSERT INTO USERS(username, password, role) VALUES (?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getPassword(),"ROLE_USER"});
		 saveOrUpdateCustomer(user);
		 //System.out.println("EROOR");
	}
	
	@Transactional
	@Override
	public void delete(String username) {
		String sql = "DELETE FROM USERS WHERE username=?";
		jdbcTemplate.update(sql,username);
	}
	
	@Override
	public User getUserbyusername(String username) {
		String sql = "SELECT * FROM USERS WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		}
		
	});
		
	}
	
	@Transactional
	@Override
	public void saveOrUpdateCustomer(User user) {
		String sql="INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getName(),user.getAddress(),user.getSex()
				,user.getAadharnumber(),user.getEmail(),user.getPhone_number()});
	}
	
	@Override
	public User getCustomerbyusername(String username) {
		String sql = "SELECT * FROM CUSTOMER WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
	public User extractData(ResultSet rs) throws SQLException,DataAccessException{
		if(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setAddress(rs.getString("address"));
			user.setAadharnumber(rs.getString("aadhar_number"));
			user.setPhone_number(rs.getString("phone_number"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getString("sex"));
			return user;
		}
		return null;
	}
	});
	}
	
	
	@Override
	public List<User> allcustomers() {
		String sql = "select * from CUSTOMER";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<User>>() {
			
		public List<User> extractData(ResultSet rs) throws SQLException,DataAccessException{
			List<User> Users = new ArrayList<User>();
			if(!rs.isBeforeFirst())
				return null;
			
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setAddress("address");
				user.setSex(rs.getString("sex"));
				user.setAadharnumber(rs.getString("aadhar_number"));
				user.setEmail(rs.getString("email"));
				user.setPhone_number(rs.getString("phone_number"));
				Users.add(user);
	
				
			}
			return Users;
		}
		
	});
		
	}
}