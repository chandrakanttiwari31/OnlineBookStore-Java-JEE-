package com.bookstore.pojo;

import java.io.InputStream;

public class Book {

	
	private  int bookId;
	private String bookName;
	private String bookAuthorName;
	private long price;
	private String bookPublication ;
	private String bookCategory;
	private String language;
	private InputStream image;
	
	public Book() {
		super();
	}
	public Book(int bookId, String bookName, String bookAuthorName, long price, String bookPublication,
			String bookCategory, String language) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthorName = bookAuthorName;
		this.price = price;
		this.bookPublication = bookPublication;
		this.bookCategory = bookCategory;
		this.language = language;
	}
	
	
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthorName() {
		return bookAuthorName;
	}
	public void setBookAuthorName(String bookAuthorName) {
		this.bookAuthorName = bookAuthorName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getBookPublication() {
		return bookPublication;
	}
	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthorName=" + bookAuthorName + ", price="
				+ price + ", bookPublication=" + bookPublication + ", bookCategory=" + bookCategory + ", language="
				+ language + "]";
	}
	
	
	
}




///create table Book22377( bookId int(50) primary key auto_increment,bookName varchar(100) not null,bookAuthorName varchar(100) not null,price float not null,bookPublication varchar(100) not null,bookCategory varchar(100) default 'education' ,language varchar(100) default 'english');