package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.pojo.Customer;
import com.bookstore.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao{

	String sql;
	int flag;
	PreparedStatement prp=null;
	Connection con=null;
	ResultSet rs=null;
	
	
	public boolean addCustomer(Customer cust) {
		// TODO Auto-generated method stub
	      
		try
		{
			con=DBUtility.establishConnection();
		    sql="insert into customer22377(emailId,name,contactNumber,address,password) values(?,?,?,?,?)";
	        prp=con.prepareStatement(sql);
			prp.setString(1, cust.getEmailId());
			prp.setString(2, cust.getName());
			prp.setLong(3, cust.getContactNumber());
			prp.setString(4, cust.getAddress());
			prp.setString(5, cust.getPassword());
			flag=prp.executeUpdate();
			if(flag > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		try
		{
			con=DBUtility.establishConnection();
			sql="update customer22377 set name=?,contactNumber=?,address=?,password=? where emailId=?";
			prp=con.prepareStatement(sql);
			
			prp.setString(1, cust.getName());
			prp.setLong(2,cust.getContactNumber());
			prp.setString(3, cust.getAddress());
			prp.setString(4, cust.getPassword());
			prp.setString(5, cust.getEmailId());
			flag=prp.executeUpdate();
			if(flag > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(String emailId) {
		// TODO Auto-generated method stub
		try
		{
			con=DBUtility.establishConnection();
			sql="delete from customer22377 where emailId=?";
			prp=con.prepareStatement(sql);
			prp.setString(1,emailId);
			flag=prp.executeUpdate();
			if(flag > 0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> showAllCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Customer> custlist=new ArrayList<Customer>();
		try
		{
			con=DBUtility.establishConnection();
			sql="select * from customer22377";
			prp=con.prepareStatement(sql);
			rs=prp.executeQuery();
			
			while(rs.next())
			{
				Customer customer=new Customer();
				customer.setEmailId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setContactNumber(rs.getLong(3));
				customer.setAddress(rs.getString(4));
				customer.setPassword(rs.getString(5));
				custlist.add(customer);
			}
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
		
		return custlist;
	}

	@Override
	public Customer searchCustomer(String emailId) {
		// TODO Auto-generated method stub

		Customer customer=null ;		
		

	 
		try
		{
			con=DBUtility.establishConnection();

			sql="select * from customer22377 where emailId=?";
			prp=con.prepareStatement(sql);
			prp.setString(1, emailId);
			rs=prp.executeQuery();
			if(rs.next())
			{
				customer=new Customer();	
				customer.setEmailId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setContactNumber(rs.getLong(3));
				customer.setAddress(rs.getString(4));
				customer.setPassword(rs.getString(5));
	           
				
		}
			
		}
		catch(Exception e)
		{
	e.printStackTrace();
		}
		return customer;
	}

}
