package com.bookstore.dao;

public interface LoginDao {

	
	boolean customerLogin(String emailId, String password);
	boolean adminLogin(String adminId, String password);
	boolean changeCustomerPassword(String emailId, String newPassword);
	boolean changeAdminPassword(String adminId, String newPassword);
}
