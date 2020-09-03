package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.pojo.Book;
import com.bookstore.utility.DBUtility;

public class BookDaoImpl implements BookDao {

	Connection con = null;

	PreparedStatement ps = null;
	int ans;
	String query;
	ResultSet rs = null;

	@Override
	public boolean addBook(Book book) {

		try {
			con = DBUtility.establishConnection();
			query = "insert into book22377(bookName,bookAuthorName,price,bookPublication ,bookCategory,language,image) values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);

			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookAuthorName());
			ps.setLong(3, book.getPrice());
			ps.setString(4, book.getBookPublication());
			ps.setString(5, book.getBookCategory());
			ps.setString(6, book.getLanguage());
			ps.setBinaryStream(7, book.getImage());
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

	
	
	public boolean updateBook(Book book) {

		con = DBUtility.establishConnection();
		query = "update book22377 set bookName=?,bookAuthorName=?,price=?,bookPublication=?,bookCategory=?,language=? ,image=?where bookId=?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookAuthorName());
			ps.setLong(3, book.getPrice());
			ps.setString(4, book.getBookPublication());
			ps.setString(5, book.getBookCategory());
			ps.setString(6, book.getLanguage());
			ps.setBinaryStream(7, book.getImage());
			ps.setInt(8, book.getBookId());
		
			ans = ps.executeUpdate();
			if (ans > 0)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	

	public boolean deleteBook(int bookId) {

		con = DBUtility.establishConnection();
		query = "delete from book22377 where bookId=?";
		try {
			ps = con.prepareStatement(query);

			ps.setInt(1, bookId);
			ans = ps.executeUpdate();
			if (ans > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public List<Book> showAllBook() {
		List<Book> l = new ArrayList<Book>();
		con = DBUtility.establishConnection();
		Book b = null;
		query = "select bookId,bookName,bookAuthorName,price,bookPublication,bookCategory,language,image from book22377";
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {

				b = new Book();
				b.setBookId(rs.getInt(1));

				b.setBookName(rs.getString(2));
				b.setBookAuthorName(rs.getString(3));
				b.setPrice(rs.getLong(4));
				b.setBookPublication(rs.getString(5));
				b.setBookCategory(rs.getString(6));
				b.setLanguage(rs.getString(7));
				b.setImage(rs.getBinaryStream(8));
				l.add(b);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public List<Book> searchBookByName(String bookName) {
		List<Book> l = new ArrayList<Book>();
		Book b = null;
		con = DBUtility.establishConnection();
		query = "select bookId,bookName,bookAuthorName,price,bookPublication,bookCategory,language,image from book22377 where bookName like ? or bookAuthorName like ? or bookCategory like ?";

		try {
			ps = con.prepareStatement(query);
			 ps.setString(1, "%"+bookName+"%");
			 ps.setString(2,  "%"+bookName+"%"); 
			 ps.setString(3,  "%"+bookName+"%");

			rs = ps.executeQuery();
			while (rs.next()) {

				b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthorName(rs.getString(3));
				b.setPrice(rs.getLong(4));
				b.setBookPublication(rs.getString(5));
				b.setBookCategory(rs.getString(6));
				b.setLanguage(rs.getString(7));
				b.setImage(rs.getBinaryStream(8));

				l.add(b);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public List<Book> searchBookByAuthor(String bookAuthorName) {
		List<Book> l = new ArrayList<Book>();
		Book b = null;
		con = DBUtility.establishConnection();
		query = "select bookId ,bookName,bookAuthorName,price,bookPublication,bookCategory,language,image from book22377 where bookAuthorName=?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, bookAuthorName);

			rs = ps.executeQuery();
			while (rs.next()) {

				b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthorName(rs.getString(3));
				b.setPrice(rs.getLong(4));
				b.setBookPublication(rs.getString(5));
				b.setBookCategory(rs.getString(6));
				b.setLanguage(rs.getString(7));				b.setImage(rs.getBinaryStream(8));

				l.add(b);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public Book searchBookById(int bookId) {

		Book b = null;

		con = DBUtility.establishConnection();
		query = "select bookId,bookName,bookAuthorName,price,bookPublication,bookCategory,language,image from book22377 where bookId=?";

		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, bookId);

			rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthorName(rs.getString(3));
				b.setPrice(rs.getLong(4));
				b.setBookPublication(rs.getString(5));
				b.setBookCategory(rs.getString(6));
				b.setLanguage(rs.getString(7));
				b.setImage(rs.getBinaryStream(8));


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public List<Book> searchBookByCategory(String bookCategory) {

		Book b = null;
		List<Book> l = new ArrayList<Book>();

		con = DBUtility.establishConnection();
		query = "select  bookId,bookName,bookAuthorName,price,bookPublication,bookCategory,language,image from book22377 where bookCategory=?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, bookCategory);

			rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthorName(rs.getString(3));
				b.setPrice(rs.getLong(4));
				b.setBookPublication(rs.getString(5));
				b.setBookCategory(rs.getString(6));
				b.setLanguage(rs.getString(7));
				b.setImage(rs.getBinaryStream(8));

				l.add(b);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}


}
