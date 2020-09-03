<!DOCTYPE html>
<%@page import="com.bookstore.pojo.Customer"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE CUSTOMER</title>
  <!-- <link  rel="stylesheet" href="Tamplate.css"> -->  
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
                        <h2>UPDATE CUSTOMER</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->

<marquee id="marquee">WELCOME TO BOOK STORE -  UPDATE CUSTOMER</marquee>
<% Customer c=(Customer)session.getAttribute("clist"); %>
	<div align="center">
		<form action="CustomerServlet" method="post">
							<input type="hidden"  name="action" value="update">
		
			<table class="td">
			

				<tr>
					<td>Email-Id</td>
					<td><input type="text" name ="cemail"  value="<%=c.getEmailId()%>" readonly></td>
				</tr>
				<tr>

					<td>Customer Name</td>
					<td><input type="text" name="cname"  value="<%= c.getName()%>"></td>
				</tr>
				<tr>
					<td>Contact Number</td>
					<td><input type="number" name="ccontact"   value="<%= c.getContactNumber()%>" ></td>
				</tr>

				<tr>

					<td>Address</td>
					<td><textarea name="caddress"     value="<%= c.getAddress()%>" ></textarea></td>
				</tr>

				<tr>

					<td>Password</td>
					<td><input type="password" name="cpassword"   value="<%= c.getPassword()%>" ></td>
				</tr>
			</table>
			<input type="submit" value="UPDATE">&emsp;<input type="reset">

		</form>

	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>