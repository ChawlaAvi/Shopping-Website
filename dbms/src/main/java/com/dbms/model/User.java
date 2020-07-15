package com.dbms.model;

import javax.validation.constraints.NotNull;


public class User{
	@NotNull(message="required")
	private String username;
	
	@NotNull(message="required")
	private String name;
	
	@NotNull(message="required")
	private String password;
	
	@NotNull(message="required")
	private String mpassword;
	
	@NotNull(message="required")
	private String sex;
	

	@NotNull(message="required")
	private String address;
	
	@NotNull(message="required")
	private String aadharnumber;
	
	@NotNull(message="required")
	private String phone_number;
	
	
	@NotNull(message="required")
//	@Email(message="Invalid mail")
	private String email;
	
	public User() {
		
	}
	
	public User(String uname, String name, String pass,String mpass, String sex,String address,String pan,String aadharnumber,String phone, String mail) {
		this.username=uname;
		this.name = name;
		this.password=pass;
		this.mpassword=mpass;
		this.address=address;
//		this.dob=date;
		this.sex=sex;
		this.aadharnumber=aadharnumber;
		this.phone_number=phone;
		this.email=mail;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public Date getDOB() {
//		return dob;
//	}
//
//	public void setDOB(Date dob) {
//		this.dob = dob;
//	}

	public String getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone) {
		this.phone_number = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public User(String uname,String pass) {
		this.username=uname;
		this.password=pass;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	
	
}