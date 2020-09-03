<%@page import="com.bookstore.pojo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
 
    
	  <!-- slider Area Start-->
  <div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="single-slider slider-height2 d-flex align-items-center" data-background="assets/img/hero/bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="hero-cap text-center">
                        <h2>ORDER LIST</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->
  
  
 	<div align="center">
 	<% List<Order> olist=(List<Order>)request.getAttribute("orderList");
 		String user=(String)session.getAttribute("user");
		 String admin=(String)session.getAttribute("Admin");%>
	


	
	<table border="1">
		
	<% String status=(String)request.getAttribute("status");
	if(status!=null){
		out.print("<b> <h3> your customer have "+status);
	}
	%>
	<tr>
		<th> Order Id: </th> 
	<% if(user==null && admin!=null){ %>
		<th> Email Id: </th>
	<%} %>
		<th> Total Bill: </th> 
		<th>Order Date: </th> 
		<th>Order Status: </th>
		<th>Action </th>
	</tr>
	<%
		for(Order order: olist)
		{		
	%>
	

	<tr>
		<td> <%= order.getOrderId() %> </td>
	<% if(user==null && admin!=null){ %>
		<td> <%= order.getEmailId() %> </td>
	<%} %>
		<td> <%= order.getTotalBill() %> </td>
		<td> <%= order.getDate() %> </td>
		<td> <%= order.getStatus() %> </td>
	<% if(user!=null && admin==null){ %>
		<td> <a href="Orderservlet?action=cancel&OrderId=<%=order.getOrderId()%>" style="color:blue;"> Cancel order </a> </td>
	<%} %>
	<% if(user==null && admin!=null){ %>
		<td> <a href="Orderservlet?action=orderstatus&OrderId=<%=order.getOrderId()	%>"style="color: blue;"> Status </a> </td>
		
	<%} %>
	</tr>

	<%} %>
	</table>
	
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>