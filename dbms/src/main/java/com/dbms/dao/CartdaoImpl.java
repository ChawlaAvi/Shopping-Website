package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Cart;
import com.dbms.model.Category;
import com.dbms.model.Listproducts;
import com.dbms.model.Product;

public class CartdaoImpl implements Cartdao{

	@Autowired
    DataSource datasource;
	
	@Autowired
    Productdao productdao;

	@Autowired
    Categorydao categorydao;
	
    @Autowired
	JdbcTemplate jdbcTemplate;
	


	@Override
	public List<Listproducts> showCart(String username) {
		
		String sql = "select * from CART where username='"+username+"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Listproducts>>() {
			
				@Override
				public List<Listproducts> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Listproducts> cartproducts = new ArrayList<Listproducts>();
						if(!rs.isBeforeFirst())
							return null;
						while(rs.next()) {
							Listproducts lp = new Listproducts();
							Product p = productdao.getproductbyid(rs.getInt("product_id"));
							
							lp.setPacket_size(rs.getDouble("packet_size"));
							lp.setProduct(p);
							lp.setQuantity(rs.getInt("quantity_in_cart"));
							lp.setPrice(rs.getInt("price"));
							Integer i = categorydao.getquantitybysizeandid(p.getProduct_id(), lp.getPacket_size());
							if(i!=null) {
								if(lp.getQuantity()>i.intValue())
								{	lp.setAvailable("NOT IN STOCK");
								
								}	
								
								else
									lp.setAvailable("IN STOCK");
								cartproducts.add(lp);
							}
							
							
							
							
							
							
						}
							productdao.updatefullcarttable();
							return cartproducts;
						}
						
					});
				
}

	@Override
	public Listproducts getcartitembyusername_pid_psize(String username, int product_id, double packet_size) {
		String sql = "select * from CART where username='"+username+"' and product_id="+Integer.toString(product_id)+" and packet_size="+Double.toString(packet_size);
		return jdbcTemplate.query(sql,new ResultSetExtractor<Listproducts>() {
			
			public Listproducts extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Listproducts lp = new Listproducts();
					lp.setPacket_size(packet_size);
					lp.setQuantity(rs.getInt("quantity_in_cart"));
					lp.setProduct(productdao.getproductbyid(product_id));
//					lp.setPrice(categorydao.getpricebyidandsize(product_id, packet_size));
					lp.setPrice(rs.getInt("price"));
					lp.setAvailable(rs.getString("available"));
					
					return lp;
				}
				return null;
			}
			
		});                  	
		
	}
	
	@Transactional
	@Override
	public void updateitemincart(String username, Listproducts lp, String action, String removerecord) {
		String sql;
		if(action.equals("add"))
		{
		sql = "UPDATE CART SET quantity_in_cart=quantity_in_cart+? where username=? and product_id=? and packet_size=?";
		jdbcTemplate.update(sql, new Object[] {	lp.getQuantity(),
				username,
				lp.getProduct().getProduct_id(),
				lp.getPacket_size()});
		}
		else
		{
			if(removerecord.equals("no")) {
			sql = "UPDATE CART SET quantity_in_cart=quantity_in_cart-? where username=? and product_id=? and packet_size=?";
			jdbcTemplate.update(sql, new Object[] {	lp.getQuantity(),
					username,
					lp.getProduct().getProduct_id(),
					lp.getPacket_size()});
			}
			else
			{
			sql = "DELETE FROM CART where username=? and product_id=? and packet_size=?";
			jdbcTemplate.update(sql, new Object[] {	username,
													lp.getProduct().getProduct_id(),
													lp.getPacket_size()});

			}
		}
		
		
		
		productdao.updatefullcarttable();
		
	}
	
	@Transactional
	@Override
	public void additemincart(String username, Listproducts lp) {
		String sql="insert into CART values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {	username, 
												lp.getProduct().getProduct_id(),
												lp.getPacket_size(),
												lp.getQuantity(),
												lp.getPrice(),
												lp.getAvailable()});
		productdao.updatefullcarttable();
	
	}
	
	@Transactional
	@Override
	public void emptycart(String username)
	{
		String sql = "DELETE FROM CART where username=?";
		jdbcTemplate.update(sql, new Object[] {username});
		
		
		
	}
	
	@Transactional
	@Override
	public void emptycartavailable(String username)
	{
		String sql = "DELETE FROM CART where username=? and available=?";
		jdbcTemplate.update(sql, new Object[] {username,"IN STOCK"});
		
		
		
	}

	
}
