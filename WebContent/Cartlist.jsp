<%@page import="com.bookstore.pojo.Cart"%>
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
                        <h2>CART LIST</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->

	<%
		List<Cart> cartlist = (List<Cart>) session.getAttribute("clist");
	String status = (String) request.getAttribute("status");
	if (status != null) {
		out.print("<b style='color:red'> you have" + status + "</b>");
	}
	%>

	<div align=center>
		<form action="Orderservlet" method="post">
			<input type="hidden" name="action" value="add">
			<table border="2px">
				
			

			<tr>

				<td>Cart Id</td>
				<td>Book Id</td>
				<td>Book Name</td>
				<td>Book Price</td>
				<td>book Quantity</td>
				<td>total Price</td>
				<td>Email id</td>
				<td>Action</td>
			</tr>

			<%
				for (Cart cart : cartlist) {
			%>

			<tr>
				<td><%=cart.getCartId()%></td>
				<td><%=cart.getBookId()%></td>
				<td><%=cart.getBookName()%></td>
				<td><%=cart.getPrice()%></td>
				<td><%=cart.getQuantity()%></td>
				<td><%=cart.getTotalPrice()%></td>
				<td><%=cart.getEmailId()%></td>
				<td><b><a href="CartServlet?action=delete&id=<%=cart.getCartId()%>" style="color:black">Delete</a></b></td>

			</tr>
			<%}%>
				
			



</table>

			<input type="submit" value="palce Order">
		</form>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>