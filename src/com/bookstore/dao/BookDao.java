package com.bookstore.dao;

import java.util.List;

import com.bookstore.pojo.Book;

public interface BookDao {
	boolean addBook(Book book);

	
	
	 boolean updateBook(Book book);
	 

	boolean deleteBook(int bookId);
	

	List<Book> showAllBook();

	List<Book> searchBookByName(String bookName);

	List<Book> searchBookByAuthor(String bookAuthorName);

	Book searchBookById(int bookId);

	List<Book> searchBookByCategory(String bookCategory);


}
