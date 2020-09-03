<%@page import="com.bookstore.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Orderservlet" method="post">
	<input type="hidden" name="action" value="update">
	<% Order order=(Order)session.getAttribute("oData"); %>
	<div align="center">
	<table>
		<tr>
			<td> OrderId </td>
			<td> <input type="number" name="orderId" value="<%=order.getOrderId()%>" readonly> </td>
		</tr>
		<tr>
			<td> Email Id </td>
			<td> <input type="email" name="emailId" value="<%=order.getEmailId()%>" readonly> </td>
		</tr>
		<tr>
			<td> Total Bill </td>
			<td> <input type="number" name="totalBill" value="<%=order.getTotalBill()%>"readonly> </td>
		</tr>
		<tr>
			<td> Order Date</td>
			<td> <input type="datetime" name="orderDate" value="<%=order.getDate()%>" readonly> </td>
		</tr>
		<tr>
			<td> Order Status </td>
			<td> <select name="orderStatus" value="<%=order.getStatus()%>">
				  <option >Pending</option>
				  <option >Dispatched</option>
				  <option >Shipped</option>
				  <option >Deliverd</option>
				</select> </td>
			
		</tr>
		
	</table>
	
	<input type="submit" value="Update">&emsp;<input type="reset">
	</div>
	</form>
</body>
</html>