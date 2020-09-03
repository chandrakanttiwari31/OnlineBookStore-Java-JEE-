<%@page import="com.bookstore.pojo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
                        <h2>ORDER</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->

	<%
		Order o = (Order) session.getAttribute("order");
	
	%>

	<table align="center">
		<tr>

			<th>Order Id</th>
			<td><%=o.getOrderId()%></td>
		</tr>
		<tr>

			<th>Email Id</th>
			<td><%=o.getEmailId()%></td>
		</tr>
		<tr>

			<th>Total Bill</th>
			<td><%=o.getTotalBill()%></td>
		</tr>
		<tr>

			<th>Date</th>
			<td><%=o.getDate()%></td>
		</tr>
		<tr>

			<th>Status</th>
			<td><%=o.getStatus()%></td>
		</tr>

	</table>

	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>