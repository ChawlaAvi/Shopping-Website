package com.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Category;
import com.dbms.model.Listproducts;
import com.dbms.model.Orders;
import com.dbms.model.Product;
import com.dbms.model.Userorders;

public class OrderdaoImpl implements Orderdao{
	
	@Autowired
    DataSource datasource;
	
	@Autowired
    Productdao productdao;

	@Autowired
    Categorydao categorydao;
	
    @Autowired
	JdbcTemplate jdbcTemplate;
    
    @Autowired
	Cartdao cartdao;
	
    @Transactional
	@Override
	public void placeorder(List<Listproducts> cartitems, int total, String username) {
		
		categorydao.removefromstock(cartitems);
				
		cartdao.emptycartavailable(username);
		
		String sql1 = "INSERT INTO USER_ORDERS(username, status, grand_total,order_date, order_time ) VALUES(?,?,?,?,?)";
		
		Date dt = new Date();
		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdfd.format(dt);
		SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
		String currentTime = sdft.format(dt);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(new PreparedStatementCreator() {
		   public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
		   {
		    PreparedStatement ps = connection.prepareStatement(sql1, new String[] { "order_id" });
		    ps.setString(1, username);
		    ps.setString(2, "Pending Confirmation");
		    ps.setInt(3, total);
		    ps.setString(4,currentDate );
		    ps.setString(5,currentTime );
		    return ps;
		   }
		   }, keyHolder);

		  int key= keyHolder.getKey().intValue();
		
		String sql = "INSERT INTO ORDERS(order_id,product_id, packet_size, ordered_quantity, amount) VALUES(?,?,?,?,?)";
		
		for(int i=0;i<cartitems.size();i++) 
		{
			Listproducts l = cartitems.get(i);
			jdbcTemplate.update(sql,new Object[] {	key,
													l.getProduct().getProduct_id(),
													l.getPacket_size(),
													l.getQuantity(),
													l.getPrice()});
		}
			
		
		productdao.updatefullcarttable();

	}


	@Override
	public List<Userorders> getuserorders(String username) {
		
		String sql = "select * from USER_ORDERS where username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Userorders>>() {
			
		public List<Userorders> extractData(ResultSet rs) throws SQLException,DataAccessException{
			List<Userorders> orders = new ArrayList<Userorders>();
			if(!rs.isBeforeFirst())
				return null;
			
			while(rs.next()) {
				Userorders order = new Userorders();
				order.setOrder_id(rs.getInt("order_id"));
				order.setUsername(username);
				order.setStatus(rs.getString("status"));
				order.setGrand_total(rs.getInt("grand_total"));
				order.setOrderdate(rs.getDate("order_date"));
				order.setOrdertime(rs.getTime("order_time"));
				orders.add(order);
			}
			return orders;
		}
		
	});
	}


	@Override
	public List<Orders> getorderbyid(int order_id) {
		String sql = "select * from ORDERS where order_id="+Integer.toString(order_id);
		   
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Orders>>() {
			
			public List<Orders> extractData(ResultSet rs) throws SQLException,DataAccessException{
				List<Orders> batch_products = new ArrayList<Orders>();
				if(!rs.isBeforeFirst())
					return null;
				
				while(rs.next()) {
					Orders category = new Orders();
					category.setOrder_id(order_id);
					category.setProduct(productdao.getproductbyid(rs.getInt("product_id")));
					category.setPacket_size(rs.getDouble("packet_size"));
					category.setOrdered_quantity(rs.getInt("ordered_quantity"));
					category.setAmount(rs.getInt("amount"));
					
					batch_products.add(category);
				}
				return batch_products;
			}
			
		});
		
		
	}


	@Override
	public String getstatusforid(int order_id) {
		String sql = "select * from USER_ORDERS where order_id="+Integer.toString(order_id);
		return jdbcTemplate.query(sql,new ResultSetExtractor<String>() {
			
		public String extractData(ResultSet rs) throws SQLException,DataAccessException{
			
			if(rs.next()) {
				String s = rs.getString("status");		
				return s;

				}
			return null;

		}
		
	});
	}

	@Transactional
	@Override
	public void cancelorder(List<Orders> orders, int order_id) {

		String sql = "UPDATE USER_ORDERS SET status=? where status=? and order_id="+Integer.toString(order_id);
		jdbcTemplate.update(sql, new Object[] {"Cancelled","Pending Confirmation"});
		
		String sql1 = "UPDATE BATCH_PRODUCT,ORDERS SET BATCH_PRODUCT.quantity=BATCH_PRODUCT.quantity+? "
				+ "where BATCH_PRODUCT.product_id=? and BATCH_PRODUCT.packet_size=? and "
				+ "ORDERS.order_id="+Integer.toString(order_id);
		
		
		for(int i=0;i<orders.size();i++) {
			Orders order = orders.get(i);
			jdbcTemplate.update(sql1, new Object[] {order.getOrdered_quantity(),
													order.getProduct().getProduct_id(),
													order.getPacket_size()});
		
		}
		
		productdao.updatefullcarttable();
		
	}
	
	@Transactional
	@Override
	public void confirmorder(List<Orders> orders, int order_id) {

		String sql = "UPDATE USER_ORDERS SET status=? where status=? and order_id="+Integer.toString(order_id);
		jdbcTemplate.update(sql, new Object[] {"Confirmed","Pending Confirmation"});
		
		productdao.updatefullcarttable();
		
	}

	
	@Override
	public List<Userorders> getallorders() {
		String sql = "select * from USER_ORDERS";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Userorders>>() {
			
		public List<Userorders> extractData(ResultSet rs) throws SQLException,DataAccessException{
			List<Userorders> orders = new ArrayList<Userorders>();
			if(!rs.isBeforeFirst())
				return null;
			
			while(rs.next()) {
				Userorders order = new Userorders();
				order.setOrder_id(rs.getInt("order_id"));
				order.setUsername(rs.getString("username"));
				order.setStatus(rs.getString("status"));
				order.setGrand_total(rs.getInt("grand_total"));
				order.setOrderdate(rs.getDate("order_date"));
				order.setOrdertime(rs.getTime("order_time"));	
				orders.add(order);
			}
			return orders;
		}
		
	});
		
	
	
	
	}


	@Override
	public Date getdateforid(int order_id) {
		String sql = "select * from USER_ORDERS where order_id="+Integer.toString(order_id);
		return jdbcTemplate.query(sql,new ResultSetExtractor<Date>() {
			
		public Date extractData(ResultSet rs) throws SQLException,DataAccessException{
			
			if(rs.next()) {
				Date s = rs.getDate("order_date");		
				return s;

				}
			return null;

		}
		
	});
		
		
		
	}


	@Override
	public Time gettimeforid(int order_id) {
	
		String sql = "select * from USER_ORDERS where order_id="+Integer.toString(order_id);
		return jdbcTemplate.query(sql,new ResultSetExtractor<Time>() {
			
		public Time extractData(ResultSet rs) throws SQLException,DataAccessException{
			
			if(rs.next()) {
				Time s = rs.getTime("order_time");		
				return s;

				}
			return null;

		}
		
	});
	}


	@Override
	public String getusernamebyorderid(int order_id) {
		String sql = "select username from USER_ORDERS where order_id="+Integer.toString(order_id);
		return jdbcTemplate.query(sql,new ResultSetExtractor<String>() {
			
		public String extractData(ResultSet rs) throws SQLException,DataAccessException{
			
			if(rs.next()) {
				String s = rs.getString("username");		
				return s;

				}
			return null;

		}
		
	});			
		
	}
	
	
	

	
	
	

}
