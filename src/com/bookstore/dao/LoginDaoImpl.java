package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.utility.DBUtility;
import com.mysql.cj.xdevapi.DbDoc;

public class LoginDaoImpl implements LoginDao {

	ResultSet rs;
	PreparedStatement ps = null;
	String query;
	int ans;

	String pass;

	@Override
	public boolean customerLogin(String emailId, String password) {

		query = "select password   from customer22377 where emailId=?";

		Connection con = DBUtility.establishConnection();

		try {
			ps = con.prepareStatement(query);

			ps.setString(1, emailId);

			rs = ps.executeQuery();
			if (rs.next()) {
				pass = rs.getString(1);
			}

			if (password.equals(pass)) {

				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean adminLogin(String adminId, String password) {

		query = "select password   from admin22377 where username=?";

		Connection con = DBUtility.establishConnection();

		try {
			ps = con.prepareStatement(query);

			ps.setString(1, adminId);

			rs = ps.executeQuery();
			if (rs.next()) {
				pass = rs.getString(1);
			}

			if (password.equals(pass)) {

				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean changeCustomerPassword(String emailId, String newPassword) {

		Connection con = DBUtility.establishConnection();
		query = "update customer22377 set password=? where emailId=?";
		try {
			ps = con.prepareStatement(query);

			ps.setString(1, newPassword);
			ps.setString(2, emailId);

			ans = ps.executeUpdate();
			if (ans > 0) {

				return true;
			}

			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean changeAdminPassword(String adminId, String newPassword) {

		Connection con = DBUtility.establishConnection();

		query = "update admin22377 set password=? where username=?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, adminId);
			ps.setString(2, newPassword);

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
