package com.dbms.model;

import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotNull;

public class Worker {
	
	private Integer worker_id;	
	
	@NotNull(message="required")
	private String name;
	
	@NotNull(message="required")
	private String sex;
	
	@NotNull(message="required")
	private String address;
	
	@NotNull(message="required")
	private Integer salary;
	
	@NotNull(message="required")
	private String bank_name;

	@NotNull(message="required")
	private String IFSC;
	
	@NotNull(message="required")
	private String account_no;
	
	@NotNull(message="required")
	private String aadhar_number;
	
//	@Email(message="Invalid mail")
	@NotNull(message="required")
	private String email;
	
	@NotNull(message="required")
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadhar_number() {
		return aadhar_number;
	}
	public void setAadhar_number(String aadhar_number) {
		this.aadhar_number = aadhar_number;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	

	
	public Integer getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(Integer workerid) {
		this.worker_id = workerid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bankname) {
		this.bank_name = bankname;
	}
	
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String ifsc) {
		this.IFSC = ifsc;
	}
	
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String accountnumber) {
		this.account_no = accountnumber;
	}
	
	
}
