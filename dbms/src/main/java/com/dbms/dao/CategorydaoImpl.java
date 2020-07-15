package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Category;
import com.dbms.model.Listproducts;
import com.dbms.model.Product;
import com.dbms.model.User;

public class CategorydaoImpl implements Categorydao{

	  @Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  @Autowired 
	  Productdao productdao;


	  @Override
	  public Category getcategorybysizeandid(int product_id, double packet_size) {
		   String sql = "select * from BATCH_PRODUCT where product_id="+Integer.toString(product_id)+" and packet_size="+Double.toString(packet_size);
		   
		    return jdbcTemplate.query(sql,new ResultSetExtractor<Category>() {
				
				public Category extractData(ResultSet rs) throws SQLException,DataAccessException{
					if(rs.next()) {
						Category cat = new Category();
						cat.setProduct_id(rs.getInt("product_id"));
						cat.setPacket_size(rs.getDouble("packet_size"));
						cat.setQuantity(rs.getInt("quantity"));
						cat.setPrice(rs.getDouble("price"));
						
						
						return cat;
					}
					return null;
				}
				
			});
		    		}

	@Override
	public List<Category> getcategorybyid(int product_id) {
		String sql = "select * from BATCH_PRODUCT where product_id="+Integer.toString(product_id);
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Category>>() {
			
		public List<Category> extractData(ResultSet rs) throws SQLException,DataAccessException{
			List<Category> batch_products = new ArrayList<Category>();
			if(!rs.isBeforeFirst())
				return null;
			
			while(rs.next()) {
				Category category = new Category();
				
				category.setProduct_id(rs.getInt("product_id"));
				category.setPrice(rs.getDouble("price"));
				category.setPacket_size(rs.getDouble("packet_size"));
				category.setQuantity(rs.getInt("quantity"));	
				
				batch_products.add(category);
			}
			return batch_products;
		}
		
	});
	}
	
	
	@Transactional
	@Override
	public void updatequantity(Category category) {
		String sql = "UPDATE BATCH_PRODUCT SET quantity=quantity+? where product_id=? and packet_size=?";
		jdbcTemplate.update(sql, new Object[] {category.getQuantity(), category.getProduct_id(), category.getPacket_size()});
				
		productdao.updatefullcarttable();

	}
	
	@Transactional
	@Override
	public void addcategorytoproduct(Category category) {
		String sql = "INSERT INTO BATCH_PRODUCT VALUES(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {category.getProduct_id(), category.getPacket_size(), category.getQuantity(), category.getPrice()});
		productdao.updatefullcarttable();
	
		
	}

	@Override
	public Integer getpricebyidandsize(int product_id, double packet_size) {
		String sql = "select price from BATCH_PRODUCT where product_id="+Integer.toString(product_id)+" and packet_size="+Double.toString(packet_size);
		   
	    return jdbcTemplate.query(sql,new ResultSetExtractor<Integer>() {
			
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Integer a = new Integer(rs.getInt("price"));
					
					return a;
				}
				return null;
			}
			
		});
		
		
	}


	@Override
	public Integer getquantitybysizeandid(int product_id, double packet_size) {
		String sql = "select quantity from BATCH_PRODUCT where product_id="+Integer.toString(product_id)+" and packet_size="+Double.toString(packet_size);
		return jdbcTemplate.query(sql,new ResultSetExtractor<Integer>() {
			
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Integer a = new Integer(rs.getInt("quantity"));
					
					return a;
				}
				return null;
			}
			
		});
		
		
	}
	
	@Transactional
	@Override
	public void removefromstock(List<Listproducts> cartitems) {
		
		String sql = "UPDATE BATCH_PRODUCT SET quantity=quantity-? where product_id=? and packet_size=?";
		for(int i=0;i<cartitems.size();i++) {
			Listproducts lp = cartitems.get(i);
			
			jdbcTemplate.update(sql, new Object[] {lp.getQuantity(), lp.getProduct().getProduct_id(), lp.getPacket_size()});
					
		}
		

	}

	@Transactional
	@Override
	public void removecategory(int product_id, double packet_size) {
			String sql ="UPDATE BATCH_PRODUCT SET quantity=? WHERE product_id=? and packet_size=?";
		
		jdbcTemplate.update(sql, new Object[] {	0, product_id, packet_size});
		
		
		
		
	}
	

}
