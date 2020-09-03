package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookstore.pojo.Order;
import com.bookstore.utility.DBUtility;

public class OrderDaoImpl implements OrderDao {

	ResultSet rs=null;
	PreparedStatement ps=null;
	String query;
	int ans;
	Order order;
	Connection con=DBUtility.establishConnection();
	@Override
	public Order placeOrder(String emailId) {

		query="select sum(totalPrice) as finalPrice from cart22377 where emailId=?";
		try
		{
			float fp=0.0f;
			 ps=con.prepareStatement(query);
			ps.setString(1,emailId);
			ResultSet r=ps.executeQuery();
			if(r.next())
			{
				fp=r.getFloat("finalPrice");
				
			}
			String date=new Date().toString();
			
			query="insert into order22377(emailId,totalBill,date) values(?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, emailId);
			ps.setFloat(2, fp);
			ps.setString(3, date);
			ans=ps.executeUpdate();
			if(ans>0)
			{
				ps=con.prepareStatement("select * from order22377 where emailId=? and date=?");
				ps.setString(1, emailId);
				ps.setString(2, date);
				rs=ps.executeQuery();
				while(rs.next())
					
				{
					
					order=new Order(rs.getInt("orderId"),
							rs.getString("emailId"),
							rs.getLong("totalBill"),
							rs.getString("date"),
							rs.getString("status"));
					
				}
			}
			
			
			
		}
		catch(Exception e)
		{
			
	    e.printStackTrace();
		}
		return order;
	}

	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		query="update order22377 set status=? where orderId=?";
		try {
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1, order.getStatus());
			prp.setInt(2, order.getOrderId());
			ans=prp.executeUpdate();
			if(ans>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteOrder(int orderId) {

		//query="delete from order22377 where orderId=?";
		query="update order22377 set status='Cancelled' where orderId=?";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setInt(1, orderId);
			
			ans=ps.executeUpdate();
			if(ans>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean clearOrder(String emailId) {

		query="delete from order22377 where emailId=?";
		
		try {
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, emailId);
			
			ans=ps.executeUpdate();
			if(ans>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Order> showMyOrder(String emailId) {
  List<Order> l=new ArrayList<Order>();
  Order o=null;
		query=" select orderId,emailId,totalBill,date,status  from order22377  where emailId=? ";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, emailId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				 o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setEmailId(rs.getString(2));
				o.setTotalBill(rs.getLong(3));
				o.setDate(rs.getString(4));
				o.setStatus(rs.getString(5));
				
				l.add(o);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public List<Order> showAllOrder() {
		List<Order> l=new ArrayList<Order>();
		Order o=null;
		query=" select orderId,emailId,totalBill,date,status from order22377  ";
		
		try {
			ps=con.prepareStatement(query);
			
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				
			 o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setEmailId(rs.getString(2));
				o.setTotalBill(rs.getLong(3));
				o.setDate(rs.getString(4));
				o.setStatus(rs.getString(5));
				
				l.add(o);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public Order orderbyId(int orderId) {
	 query="select * from order22377 where orderId=? ";
		PreparedStatement prp;
		try {
			prp = con.prepareStatement(query);
			prp.setInt(1, orderId);
			ResultSet rs=prp.executeQuery();
			while(rs.next()) {
			  order=new Order(rs.getInt("orderId"),
					  rs.getString("emailId"),
					  rs.getLong("totalBill"),
					  rs.getString("date"),
					  
					  rs.getString("status")
					  );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}
}
