package com.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDaoImpl;
import com.bookstore.dao.CardDaoImpl;
import com.bookstore.pojo.Book;
import com.bookstore.pojo.Cart;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	boolean flag;
	int bookid, bquant;
	String bname, email;
	long price;
	BookDaoImpl bookdao = new BookDaoImpl();
	Cart cart = new Cart();
	CardDaoImpl cartdao = new CardDaoImpl();
	List<Cart> cartlist = new ArrayList<>();
	String emailId;
	int cartId;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String action = req.getParameter("action");
		emailId = (String) session.getAttribute("user");
		
		
		if (action != null && action.equals("addtocart")) {
			int bookid = Integer.parseInt((req.getParameter("id")));
			Book book = bookdao.searchBookById(bookid);
			session.setAttribute("bdata", book);
			resp.sendRedirect("AddCart.jsp");
		}

		else if (action != null && action.equals("delete")) {
			cartId = Integer.parseInt(req.getParameter("id"));
			flag = cartdao.deleteCart(cartId);
			if (flag) {

				cartlist = cartdao.showMyCart(emailId);
				session.setAttribute("clist", cartlist);
				req.setAttribute("status", "Your Item  has Been Deleted From  Cart....");

			} else {
				cartlist = cartdao.showMyCart(emailId);
				session.setAttribute("clist", cartlist);
				req.setAttribute("status", "Your Item  has not Been Deleted From Cart....");

			}
			RequestDispatcher rd = req.getRequestDispatcher("Cartlist.jsp");
			rd.forward(req, resp);

		}

		else {

			cartlist = cartdao.showMyCart(emailId);
			session.setAttribute("clist", cartlist);
			resp.sendRedirect("Cartlist.jsp");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		bookid = Integer.parseInt(req.getParameter("bookid"));
		bname = req.getParameter("bookname");
		email = req.getParameter("emailid");
		bquant = Integer.parseInt(req.getParameter("bookquantity"));
		price = Long.parseLong(req.getParameter("bookprice"));

		cart.setBookId(bookid);
		cart.setBookName(bname);
		cart.setEmailId(email);
		cart.setQuantity(bquant);
		cart.setPrice(price);

		HttpSession session = req.getSession();
		flag = cartdao.addToCart(cart);

		if (flag) {

			cartlist = cartdao.showMyCart(emailId);
			session.setAttribute("clist", cartlist);
			req.setAttribute("status", "Your Item  has Been Added in Cart....");

		} else {
			cartlist = cartdao.showMyCart(emailId);
			session.setAttribute("clist", cartlist);
			req.setAttribute("status", "Your Item  has not Been Added in Cart....");

		}
		RequestDispatcher rd = req.getRequestDispatcher("Cartlist.jsp");
		rd.forward(req, resp);

	}

}
