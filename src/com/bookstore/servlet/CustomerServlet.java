package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.CustomerDaoImpl;
import com.bookstore.pojo.Book;
import com.bookstore.pojo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

	Customer c = new Customer();
	CustomerDaoImpl cdi = new CustomerDaoImpl();
	boolean flag;
	String email, name, address, password, act;
	long contact;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// get session from login servlet
		String user = (String) session.getAttribute("user");
		String Admin = (String) session.getAttribute("Admin");

		act = req.getParameter("action");

		List<Customer> clist = cdi.showAllCustomer();

		// comming from customer list
		if (act != null && act.equals("edit")) {
			String email = req.getParameter("email");
			Customer c = cdi.searchCustomer(email);
			session.setAttribute("clist", c);
			resp.sendRedirect("UpdateCustomer.jsp");
		}

		// comming from customer list

		else if (act != null && act.equals("delete")) {
			String email = req.getParameter("email");
			flag = cdi.deleteCustomer(email);

			if (flag) {
				List<Customer> custlist = cdi.showAllCustomer();
				req.setAttribute("custlist", custlist);
				req.setAttribute("status", " successfully Deleted.....");

			}

			else {
				List<Customer> custlist = cdi.showAllCustomer();
				req.setAttribute("custlist", custlist);
				req.setAttribute("status", " not  successfully Deleted.....");
			}
			RequestDispatcher rd = req.getRequestDispatcher("CustomerList.jsp");
			rd.forward(req, resp);

		}

		// showing cstomer in admin panel
		else {
			if (user == null && Admin != null) {
				List<Customer> custlist = cdi.showAllCustomer();
				req.setAttribute("custlist", custlist);
				RequestDispatcher rd = req.getRequestDispatcher("CustomerList.jsp");
				rd.forward(req, resp);
			}

			// edit profile in customer panel
			if (user != null && Admin == null) {

				c = cdi.searchCustomer(user);
				session.setAttribute("clist", c);
				resp.sendRedirect("UpdateCustomer.jsp");
			}
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		act = req.getParameter("action");

		email = req.getParameter("cemail");
		name = req.getParameter("cname");
		contact = Long.parseLong(req.getParameter("ccontact"));
		address = req.getParameter("caddress");
		password = req.getParameter("cpassword");

		c.setEmailId(email);
		c.setName(name);
		c.setContactNumber(contact);
		c.setAddress(address);
		c.setPassword(password);

		if (act != null && act.equals("add")) {
			flag = cdi.addCustomer(c);

			if (flag) {
				List<Customer> custlist = cdi.showAllCustomer();
				req.setAttribute("custlist", custlist);
				req.setAttribute("status", " successfully added.....");

			}

			else {
				List<Customer> custlist = cdi.showAllCustomer();
				req.setAttribute("custlist", custlist);
				req.setAttribute("status", " not  successfully added....");
			}
			RequestDispatcher rd = req.getRequestDispatcher("CustomerList.jsp");
			rd.forward(req, resp);
		}

		else if (act != null && act.equals("update")) {
			String email = req.getParameter("cemail");
			c.setEmailId(email);
			flag = cdi.updateCustomer(c);
			if (flag) {
				List<Customer> custlist = cdi.showAllCustomer();
				req.setAttribute("custlist", custlist);
				req.setAttribute("status", " successfully updated.....");

			}

			else {
				List<Customer> custlist = cdi.showAllCustomer();
				req.setAttribute("custlist", custlist);
				req.setAttribute("status", " not  successfully updated .....");
			}
			RequestDispatcher rd = req.getRequestDispatcher("CustomerList.jsp");
			rd.forward(req, resp);
		}

	}

}
