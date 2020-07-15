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

import com.dbms.model.Product;
import com.dbms.model.Worker;

public class WorkerdaoImpl implements Workerdao{
	
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Worker> viewworkers() {
		String sql = "select * from WORKER";
		List<Worker> allworkers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Worker>(Worker.class));
	    return allworkers;
	
	}

	@Override
	public Worker getworkerbyid(int worker_id) {
		String sql = "select * from WORKER where worker_id="+Integer.toString(worker_id);
		return jdbcTemplate.query(sql,new ResultSetExtractor<Worker>() {
			
			public Worker extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					Worker worker = new Worker();
					
					worker.setWorker_id(worker_id);
					worker.setAadhar_number(rs.getString("aadhar_number"));
					worker.setName(rs.getString("name"));
					worker.setAddress(rs.getString("address"));
					worker.setSalary(rs.getInt("salary"));
					worker.setEmail(rs.getString("email"));
					worker.setBank_name(rs.getString("bank_name"));
					worker.setIFSC(rs.getString("IFSC"));
					worker.setSex(rs.getString("sex"));
					worker.setAccount_no(rs.getString("account_no"));
					worker.setStatus(rs.getString("status"));
					
					
					return worker;
				}
				return null;
			}
		
	});
	

}
	@Transactional
	@Override
	public void addworker(Worker worker) {
		String sql = "INSERT INTO WORKER(name, address, aadhar_number, salary, email, bank_name, IFSC,account_no, sex,status) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql,new Object[] {	worker.getName(), 
												worker.getAddress(),
												worker.getAadhar_number(),
												worker.getSalary(),
												worker.getEmail(),
												worker.getBank_name(),
												worker.getIFSC(),
												worker.getAccount_no(),
												worker.getSex(),
												"Working"
	
		});
		
		
	}

	@Transactional
	@Override
	public void removeworkerbyid(int worker_id) {
		String sql = "UPDATE WORKER SET status=? where worker_id="+Integer.toString(worker_id);
		
		jdbcTemplate.update(sql,new Object[] {"Left Job"});
		
	}
}