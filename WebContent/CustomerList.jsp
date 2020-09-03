<%@page import="java.util.Iterator"%>
<%@page import="com.bookstore.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Customer</title>
  <!--  <link rel="stylesheet" href="Tamplate.css"> -->
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
                        <h2>CUSTOMER LIST</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->

	<%
		List<Customer> clist = (List<Customer>) request.getAttribute("custlist");
	String status=(String)request.getAttribute("status");
	if(status!=null)
	{
		out.print("<b style='color:red'> you have"+status+"</b>");
	}

	%>
	
	<%
	String user=(String)session.getAttribute("user");
	String admin=(String)session.getAttribute("Admin");
	%>
	<table border="2" align="center">
		<tr>
			<th>Email Id</th>
			<th>Customer Name</th>
			<th>Contact Number</th>
			<th>Address</th>
			<th>Password</th>
			<%if(user==null&& admin!=null){%>
			<th colspan="2">Action</th>
		<%	} %>
		</tr>
		<%
			Iterator<Customer> b = clist.iterator();
		while (b.hasNext()) {

			Customer cust = b.next();
		%>
		<tr>
			<td><%=cust.getEmailId()%></td>
			<td><%=cust.getName()%></td>
			<td><%=cust.getContactNumber()%></td>
			<td><%=cust.getAddress()%></td>
			<td><%=cust.getPassword()%></td>
				<%if(user==null&& admin!=null){%>
			<td><a href="CustomerServlet?action=edit&email=<%=cust.getEmailId()%>"><button style="color:red">Edit</button></a></td>
			<td><a href="CustomerServlet?action=delete&email=<%=cust.getEmailId()%>"><button style="color:red">Delete</button></a></td>
<%	} %>

		</tr>
		<%
			}
		%>
	</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>