package com.bookstore.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDaoImpl;
import com.bookstore.dao.CardDaoImpl;
import com.bookstore.pojo.Book;


@MultipartConfig
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet
{
	   String bn,ba,bc,bl,bpub,act;
       Long bp;
       int bi;
       Book book=new Book();
       boolean flag;
       BookDaoImpl bdi=new BookDaoImpl();
       CardDaoImpl cdi=new CardDaoImpl();
       Part part=null;
       InputStream image;
     
       

       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
       {
    	   HttpSession session=req.getSession();
    	   act=req.getParameter("action");
   		if(act!=null && act.equals("edit"))    		
   		{
   			int bookId=Integer.parseInt(req.getParameter("id"));
   			Book book=bdi.searchBookById(bookId);
   			session.setAttribute("bdata",book);
   			resp.sendRedirect("UpdateBook.jsp");			
   		}
   		
   		
   		
   		
   		else if(act!=null && act.equals("delete")){
			bi=Integer.parseInt(req.getParameter("id"));
			flag= bdi.deleteBook(bi);
			
			if(flag) 
			{
				List<Book> booklist= bdi.showAllBook();
		   		req.setAttribute("blist", booklist);
		   		req.setAttribute("status", " successfully Deleted.....");
		   		 
			}
			
			else
			{
				List<Book> booklist= bdi.showAllBook();
		   		req.setAttribute("blist", booklist);
		   		req.setAttribute("status", " not  successfully Deleted.....");
			}
			 RequestDispatcher rd=req.getRequestDispatcher("BookList.jsp"); 
	   		  rd.forward(req, resp);
		}
   		
   		else if(act!=null && act.equals("search"))
		{
			
			String data=req.getParameter("Search");
			List<Book> blist=bdi.searchBookByName(data);
			req.setAttribute("blist",blist);
			 RequestDispatcher rd=req.getRequestDispatcher("BookList.jsp"); 
	   		  rd.forward(req, resp);
			
		}
   		
   		else if(act!=null && act.equals("details")) {
			 session= req.getSession();
			int bookId=Integer.parseInt(req.getParameter("id"));
			Book book= bdi.searchBookById(bookId);
			session.setAttribute("book", book);
			resp.sendRedirect("BookDetail.jsp");
   		
   		
   		}
   		else {
   		
   		List<Book> booklist= bdi.showAllBook();
   		req.setAttribute("blist", booklist); 
   		  RequestDispatcher rd=req.getRequestDispatcher("BookList.jsp"); 
   		  rd.forward(req, resp);
   		}
   		 
   		/*
   		 * HttpSession session=req.getSession(); 
   		 * session.setAttribute("bookList",
   		 * blist); resp.sendRedirect("BookList.jsp");
   		 */
   		}
   		  
   	
			  //2nd way
    	   
			/*
			 * HttpSession session=req.getSession(); session.setAttribute("blist",booklist);
			 * resp.sendRedirect("BookList.jsp");
			 */    	   
       

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		act=req.getParameter("action");
		if(act!=null && act.equals("add"))
		{
		//fetching content from web-client.........
		bn=req.getParameter("bname");
		ba=req.getParameter("aname");
		bp=Long.parseLong(req.getParameter("bprice"));
		bc=req.getParameter("bcategory");	
		bl=req.getParameter("blanguage");
		bpub=req.getParameter("bpublication");
		part=req.getPart("image");
	  image=part.getInputStream();
		
		
		//storing in book pojo......
		book.setBookName(bn);
		book.setBookAuthorName(ba);
		book.setBookCategory(bc);
		book.setBookPublication(bpub);
		book.setPrice(bp);
		book.setLanguage(bl);
		book.setImage(image);
		
			
			flag=bdi.addBook(book);
			//sending to DB through dao
			if(flag)
			{
				List<Book> booklist= bdi.showAllBook();
		   		req.setAttribute("blist", booklist);
		   		req.setAttribute("status", "been successfully added......");
		   		 
			}
			else
			{
				List<Book> booklist= bdi.showAllBook();
		   		req.setAttribute("blist", booklist);
		   		req.setAttribute("status", " not been successfully added......");
			}
			 RequestDispatcher rd=req.getRequestDispatcher("BookList.jsp"); 
	   		  rd.forward(req, resp);
		}
		
		
		else if(act!=null && act.equals("updatebook"))
		{
			int bid=Integer.parseInt(req.getParameter("bid"));
			System.out.println(bid);
			bn=req.getParameter("bname");
			ba=req.getParameter("aname");
			bp=Long.parseLong(req.getParameter("bprice"));
			bc=req.getParameter("bcategory");	
			bl=req.getParameter("blanguage");
			bpub=req.getParameter("bpublication");
			
			part=req.getPart("image");
			
			if(part.getSize()!=0)
			{
		  image=part.getInputStream();
			}
			
			else
			{
				
				Book book=bdi.searchBookById(bid);
				image=book.getImage();
			}
			
			//storing in book pojo......
		  book.setBookId(bid);
			book.setBookName(bn);
			book.setBookAuthorName(ba);
			book.setBookCategory(bc);
			book.setBookPublication(bpub);
			book.setPrice(bp);
			book.setLanguage(bl);
			book.setImage(image);
			
			
			
			flag=bdi.updateBook(book);
			if(flag)
			{
				List<Book> booklist= bdi.showAllBook();
		   		req.setAttribute("blist", booklist);
		   		req.setAttribute("status", "been successfully updated......");
		   		
		   		 
			}
			else
			{
				List<Book> booklist= bdi.showAllBook();
		   		req.setAttribute("blist", booklist);
		   		req.setAttribute("status", " not been successfully updated......");
			}
			 RequestDispatcher rd=req.getRequestDispatcher("BookList.jsp"); 
	   		  rd.forward(req, resp);
		}
			
	}
	
}
