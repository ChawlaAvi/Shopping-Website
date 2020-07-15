package com.dbms.dao;

import java.util.List;

import com.dbms.model.Worker;

public interface Workerdao {
	
	
	public List<Worker> viewworkers();
	public Worker getworkerbyid(int worker_id);
	public void addworker(Worker worker);
	public void removeworkerbyid(int worker_id);
}
