i<%@page import="com.bookstore.pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD CART</title>
<link rel="stylesheet" href="Tamplate.css">
<script type="text/javascript">
	function validation() {
		var v1 = document.getElementById("bookid").value;
		var v2 = document.getElementById("bookname").value;
		var v3 = document.getElementById("bookprice").value;
		var v4 = document.getElementById("emailid").value;
		var v5 = document.getElementById("bookquantity").value;

		if (v1 == "") {

			ducument.getElementById("bookiderr").innerHTML = "Provide the Book id";
			return false;
		}

		if (v2 == "") {

			ducument.getElementById("booknameerr").innerHTML = "Provide the Book id";
			return false;
		}

		if (v3 == "") {

			ducument.getElementById("bookpriceerr").innerHTML = "Provide the Book id";
			return false;
		}

		if (v4 == "") {

			ducument.getElementById("emailiderr").innerHTML = "Provide the Book id";
			return false;
		}

		if (v5 == "") {

			ducument.getElementById("bookwuantityerr").innerHTML = "Provide the Book id";
			return false;
		}

		return true;
	}
</script>
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
                        <h2>ADD CART</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->
  
  
<% Book book=(Book)session.getAttribute("bdata"); %>

	<marquee id="marquee">WELCOME TO BOOK STORE - REGISTRATION</marquee>
	<div align="center">
		<form method="post" onsubmit="return validation" action="CartServlet">
			<input type="hidden" name="action" value="addtocart">

			<table class="td">
				

				<tr>
					<td>Book-ID</td>
					<td><input type="text" id="bookid"  name="bookid" value="<%= book.getBookId()%>"readonly></td>
					<td><span id="bookiderr"></span></td>
				</tr>
				<tr>
					<td>Book Name</td>
					<td><input type="text" id="bookname"  name="bookname" value="<%= book.getBookName()%>" readonly></td>
					<td><span id="booknameerr"></span></td>
				</tr>
				<tr>
					<td>Book Price</td>
					<td><input type="Number" id="bookprice" name="bookprice" value="<%= book.getPrice()%>"readonly></td>
					<td><span id="bookpriceerr"></span></td>
				</tr>
				<tr>
					<td>Customer-EmailId</td>
					<td><input type="email" id="emailid"  name="emailid"  ></td>
					<td><span id="emailiderr"></span></td>
				</tr>

				<tr>
					<td>Book-Quantity</td>
					<td><input type="number" id="bookquantity"  name="bookquantity" value="1"></td>
					<td><span id="bookquatityerr"></span></td>
				</tr>

				

			</table>
			<input type="submit" value="submit">&emsp;<input type="reset">

		</form>

	</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>