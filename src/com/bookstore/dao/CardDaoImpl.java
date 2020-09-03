package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.pojo.Cart;
import com.bookstore.utility.DBUtility;

public class CardDaoImpl implements CardDao {

	Connection con = DBUtility.establishConnection();

	PreparedStatement ps = null;
	int ans;
	String query;
	ResultSet rs;

	@Override
	public boolean addToCart(Cart cart) {

		query="select bookName,Price from book22377 where bookId=?";
		try // bookId,emailId,bookQuantity-> provided by user
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setInt(1,cart.getBookId());
			ResultSet r=pr.executeQuery();
			String name=null;
			float price=0f;
			if(r.next())
				
			{
				name=r.getString(1);
				price=r.getFloat(2);
				
			}
			float tp=price*cart.getQuantity();
			query="insert into cart22377(bookId,emailId,bookName,Price,quantity,totalPrice) values(?,?,?,?,?,?)";
			pr=con.prepareStatement(query);
			pr.setInt(1, cart.getBookId());
			pr.setString(2, cart.getEmailId());
			pr.setString(3,name);
			pr.setFloat(4, price);
			pr.setInt(5, cart.getQuantity());
			pr.setFloat(6, tp);
			ans=pr.executeUpdate();
			if(ans > 0)
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
	public boolean updateCart(Cart cart) {

		float tp = cart.getPrice() * cart.getQuantity();

		query = "update cart22377 set quantity=?,totalPrice=?where cartId=?";

		try {
			ps = con.prepareStatement(query);

			ps.setInt(1, cart.getQuantity());
			ps.setFloat(2, tp);
			ps.setInt(3, cart.getCartId());
			ans = ps.executeUpdate();
			if (ans > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteCart(int cartId) {

		query = "delete from cart22377 where cartId=?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, cartId);

			ans = ps.executeUpdate();
			if (ans > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean clearCart(String emailId) {

		query = "delete from cart22377 where emailId=?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, emailId);

			ans = ps.executeUpdate();
			if (ans > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Cart> showMyCart(String emailId) {
		List<Cart> l = new ArrayList<Cart>();

		Cart c = null;
		query = "select cartId,BookId,bookName,price,quantity,totalPrice,emailId  from cart22377 where emailId=? ";

		try {
			ps = con.prepareStatement(query);

			ps.setString(1, emailId);
			rs = ps.executeQuery();
			while (rs.next()) {

				c=new Cart();
				c.setCartId(rs.getInt(1));
				c.setBookId(rs.getInt(2));
				c.setBookName(rs.getString(3));
				c.setPrice(rs.getLong(4));
				c.setQuantity(rs.getInt(5));
				c.setTotalPrice(rs.getLong(6));
				c.setEmailId(rs.getString(7));

				l.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public boolean deleteCartByBookId(int bookId) {
		query = "delete from cart22377 where bookId=?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1,bookId);

			ans = ps.executeUpdate();
			if (ans > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
