package com.bookstore.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDaoImpl;
import com.bookstore.pojo.Book;


@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	BookDaoImpl bdao=new BookDaoImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int bookId=Integer.parseInt(request.getParameter("id"));
	
	Book book=bdao.searchBookById(bookId);
   InputStream bookImage =book.getImage();
   OutputStream output=response.getOutputStream();
   
   int i;
   while((i=bookImage.read())!=-1)
   {
	   
	   output.write(i);
   }
	
	bookImage.close();
	output.close();
	}

	}
