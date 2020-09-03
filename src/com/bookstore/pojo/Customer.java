package com.bookstore.pojo;

public class Customer {

	
	private String emailId;
	private String name;
	private long contactNumber;
	
	private String address;
	private String  password;
	
	public Customer() {
		super();
	}

	public Customer(String emailId, String name, long contactNumber, String address, String password) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
		this.password = password;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [emailId=" + emailId + ", name=" + name + ", contactNumber=" + contactNumber + ", address="
				+ address + ", password=" + password + "]";
	}
	
	
}





//create table customer22377(emailid varchar(250) primary key,name varchar(100) not null,contactNumber bigint not null,
//address varchar(200) not null,password varchar(255) not null );