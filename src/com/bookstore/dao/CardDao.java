package com.bookstore.dao;

import java.util.List;

import com.bookstore.pojo.Cart;

public interface CardDao {
	
	

	boolean addToCart(Cart cart);
	
	boolean updateCart(Cart cart);
	
	boolean deleteCart(int cartId);
	
	boolean clearCart(String emailId);
	
	List<Cart> showMyCart(String emailId);
	//one customer can have more than one book that can be added in cart.
	boolean deleteCartByBookId(int bookId);

}
