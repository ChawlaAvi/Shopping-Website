package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Listproducts;
import com.dbms.model.Product;

public class ProductdaoImpl implements Productdao{

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	  @Override
	  public List<Product> showallproducts() {
	    String sql = "select * from PRODUCT";
	    List<Product> allproducts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
	    return allproducts;
	 }
	
	@Override
	public List<Product> showallproductsbycategory(int categoryid) {
		String sql = "select * from PRODUCTS where categoryid="+Integer.toString(categoryid);
		List<Product> categoryproducts= jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return categoryproducts;
	}

	@Override
	public Product getproductbyid(int productid) {
		String sql = "select * from PRODUCT where product_id="+Integer.toString(productid);
		return jdbcTemplate.query(sql,new ResultSetExtractor<Product>() {
			
			public Product extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Product product = new Product();
					product.setProduct_id(rs.getInt("product_id"));
					product.setProduct_name(rs.getString("product_name"));
					return product;
				}
				return null;
			}
			
		});
	}


	@Override
	public boolean checkproductexists(Product product) {
		String sql = "select count(*) from PRODUCTS where product_id=?";
		int count = jdbcTemplate.queryForObject(sql, new Object [] {product.getProduct_id()}, Integer.class);
		if(count>0) return true;
		return false;
	}



	@Override
	public Product getproductbyname(String product_name) {
		
		
		
		String sql = "select * from PRODUCT where product_name='"+product_name+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Product>() {
			
			public Product extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Product product = new Product();
					product.setProduct_id(rs.getInt("product_id"));
					product.setProduct_name(rs.getString("product_name"));
					return product;
				}
				return null;
			}
			
		});
		
			}

	@Override
	public void addproducttoproducttable(Product product) {
		
		product.setProduct_name(product.getProduct_name().toLowerCase());
		
		
		String sql = "INSERT INTO PRODUCT(product_name) VALUES(?)";
		jdbcTemplate.update(sql,new Object[] {product.getProduct_name()});
			
	}
	
	@Transactional
	@Override
	public void updatecarttable(Listproducts lp, String username) {
		String sql = "UPDATE CART SET available=? where username=? and product_id=? and packet_size=?";
		jdbcTemplate.update(sql, new Object[] {	lp.getAvailable(),
												username,
												lp.getProduct().getProduct_id(),
												lp.getPacket_size()});
		
	}

	@Transactional
	@Override
	public void updatefullcarttable() {
		String sql1 = "UPDATE CART SET available=?";
		jdbcTemplate.update(sql1, new Object[] {"IN STOCK"});

		String sql = "UPDATE CART, BATCH_PRODUCT SET available=? WHERE BATCH_PRODUCT.product_id=CART.product_id and BATCH_PRODUCT.packet_size=CART.packet_size and BATCH_PRODUCT.quantity<CART.quantity_in_cart";
		jdbcTemplate.update(sql, new Object[] {"NOT IN STOCK"});

	
	}

	@Transactional
	@Override
	public void removeproductbyid(int product_id) {
		String sql ="update BATCH_PRODUCT SET quantity=? WHERE product_id=?";
		
		jdbcTemplate.update(sql, new Object[] {	0, product_id});
		
	}
	
	
}
