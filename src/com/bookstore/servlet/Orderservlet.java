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

import com.bookstore.dao.CardDaoImpl;
import com.bookstore.dao.OrderDaoImpl;
import com.bookstore.pojo.Order;

@WebServlet("/Orderservlet")
public class Orderservlet extends HttpServlet {
	Order order=new Order();
	OrderDaoImpl odao=new OrderDaoImpl();
	CardDaoImpl cdao=new CardDaoImpl();
	List<Order> orderList=new ArrayList();
	boolean flag;
	
	String act;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session=req.getSession();
		 
		 String user=(String)session.getAttribute("user");
		 String admin=(String)session.getAttribute("Admin");
		 
		 	act=req.getParameter("action");
		
		 	if(act!=null && act.equals("cancel")) {
		 		int OrderId=Integer.parseInt(req.getParameter("OrderId"));
				
				if(odao.deleteOrder(OrderId)) {
					
					List<Order>olist=odao.showMyOrder(user)	;
					req.setAttribute("orderList", olist); 
					
					
					  req.setAttribute("status", " been successfully cancelled!!");
					  
				}
				else {
					List<Order>olist=odao.showMyOrder(user)	;
					req.setAttribute("orderList", olist); 
					req.setAttribute("status", " been not successfully cancelled!!");
					  
				}
				RequestDispatcher rd=req.getRequestDispatcher("OrderList.jsp"); 
				rd.forward(req, resp);
						
			}
		 	else if(act!=null && act.equals("orderstatus")) {
		 		int orderId=Integer.parseInt(req.getParameter("OrderId"));
		 		Order order=odao.orderbyId(orderId);
		 		
		 		session.setAttribute("oData", order);
		 		resp.sendRedirect("UpdateOrder.jsp");
		 	}
		 	else {	
		 if(user==null && admin!=null){
				List<Order>olist=odao.showAllOrder();		
				req.setAttribute("orderList", olist); 
				RequestDispatcher rd=req.getRequestDispatcher("OrderList.jsp"); 
				rd.forward(req, resp);
		 }
		 else if(user!=null && admin==null){
			 	List<Order>olist=odao.showMyOrder(user)	;
				req.setAttribute("orderList", olist); 
				RequestDispatcher rd=req.getRequestDispatcher("OrderList.jsp"); 
				rd.forward(req, resp);
		}
		 	}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("user");
		
	String status=req.getParameter("orderStatus");
		order.setStatus(status);
		
		if(action!=null && action.equals("add")) {
			order=odao.placeOrder(email);
			if(order!=null) {
				cdao.clearCart(email);
				
				session.setAttribute("order", order);
				resp.sendRedirect("Order.jsp");
			}
			else {
				resp.sendRedirect("fail.jsp");
			}
		}
		else if(action!=null && action.equals("update")) {
			int orderId=Integer.parseInt(req.getParameter("orderId"));
			order.setOrderId(orderId);
			flag=odao.updateOrder(order);
			if(flag) {
				List<Order>olist=odao.showAllOrder();		
				req.setAttribute("orderList", olist); 
				req.setAttribute("status", " been successfully updated!!");
			}
			else {
				List<Order>olist=odao.showAllOrder();		
				req.setAttribute("orderList", olist); 
				req.setAttribute("status", " not successfully updated!!");
			}
			RequestDispatcher rd=req.getRequestDispatcher("OrderList.jsp"); 
			rd.forward(req, resp);
		}
	}

	}


