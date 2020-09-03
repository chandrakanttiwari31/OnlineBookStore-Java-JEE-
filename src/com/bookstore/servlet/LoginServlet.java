package com.bookstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.CustomerDaoImpl;
import com.bookstore.dao.LoginDaoImpl;
import com.bookstore.pojo.Customer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	LoginDaoImpl ld = new LoginDaoImpl();

	String uname, upass, type, act;
	boolean flag;
	CustomerDaoImpl cdao = new CustomerDaoImpl();
	Customer customer;
	String customerName;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("index.jsp");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		act = req.getParameter("action");
		uname = req.getParameter("uname");
		upass = req.getParameter("upass");
		type = req.getParameter("type");

		if (act != null && act.equals("addlogin")) {
			if (type != null && type.equals("Admin")) {
				flag = ld.adminLogin(uname, upass);
				if (flag) {

					session.setAttribute("Admin", uname);

					resp.sendRedirect("index.jsp");
					System.out.println("flag is =" + flag);

				} else {

					req.setAttribute("status", "your credential are incorrect!!!");
					RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
					rd.forward(req, resp);
				}
			}

			else if (type != null && type.equals("Customer")) {

				flag = ld.customerLogin(uname, upass);
				if (flag) {
					customer = cdao.searchCustomer(uname);
					customerName = customer.getName();
					session.setAttribute("user", uname);
					session.setAttribute("cname", customerName);

					resp.sendRedirect("index.jsp");
				} else {

					req.setAttribute("status", "your credential are incorrect!!!");
					RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
					rd.forward(req, resp);
				}

			}
		}

		if (act != null && act.equals("updatelogin")) {
			if (type != null && type.equals("Admin")) {
				flag = ld.changeAdminPassword(uname, upass);
				if (flag) {
					resp.sendRedirect("Done.html");
				} else {
					resp.sendRedirect("Fail.html");
				}
			} else if (type != null && type.equals("Customer")) {

				flag = ld.changeCustomerPassword(uname, upass);
				if (flag) {
					resp.sendRedirect("Done.html");
				} else {
					resp.sendRedirect("Fail.html");
				}
			}

		}

	}
}
