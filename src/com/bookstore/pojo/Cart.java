package com.bookstore.pojo;


public class Cart {

	
	private int cartId;
	
	private int bookId;
	private  String bookName;
	private long price;
	private int quantity;
	private long totalPrice;
	private  String emailId;
	
	
	
	public Cart() {
		super();
	}
	public Cart(int cartId, int bookId, String bookName, long price, int quantity, long totalPrice, String emailId) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.emailId = emailId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", bookName=" + bookName + ", price=" + price
				+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", emailId=" + emailId + "]";
	}
	
	
	
}


//create table cart22377
// (  cartId int(100) primary key auto_increment,bookId int(100) REFERENCES book22377(bookId),bookName varchar(100) not null,
// price float not null,quantity int(20) default 1,
// totalPrice float not null,emailId varchar(250) REFERENCES customer22377(emaild))
