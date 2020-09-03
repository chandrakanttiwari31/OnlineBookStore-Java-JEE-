package com.bookstore.dao;

import java.util.List;

import com.bookstore.pojo.Customer;

public interface CustomerDao {
	

	boolean addCustomer(Customer cust);
	
	boolean updateCustomer(Customer cust);
	
	boolean deleteCustomer(String emailId);
	
	List<Customer> showAllCustomer();
	//list displays all the customer details 
	Customer searchCustomer(String emailId);
	//return type is object

}
