<%@page import="com.bookstore.pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book..</title>
<script type="text/javascript">
	function validation() {
		var bid = document.getElementById("bookid").value;
		var bname = document.getElementById("bookname").value;
		var bauthor = document.getElementById("bookauthor").value;
		var bprice = document.getElementById("bookprice").value;
		var bcategory = document.getElementById("bookcategory").value;
		var blanguage = document.getElementById("booklanguage").value;
		var bpublisher = document.getElementById("bookpublisher").value;
		if (bid == "") {
			document.getElementById("iderror").innerHTML = "*provide book id";
			return false;
		}
		if (bname == "") {
			document.getElementById("nameerror").innerHTML = "*provide book name";
			return false;
		}
		if (bauthor == "..select..") {
			document.getElementById("authorerror").innerHTML = "*select book author";

			return false;
		}

		if (bprice == "") {
			document.getElementById("priceerror").innerHTML = "*provide book price ";
			return false;
		}

		if (bcategory == "..select..") {
			document.getElementById("categoryerror").innerHTML = "*select book category";

			return false;
		}

		if (blanguage == "..select..") {
			document.getElementById("languageerror").innerHTML = "*select book language ";
			return false;
		}

		if (bpublisher == "") {
			document.getElementById("publishererror").innerHTML = "*select publisher ";
			return false;
		}
		return true;
	}
</script>
<link rel="stylesheet" href="Tamplate.css">
<style type="text/css">
</style>
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
                        <h2>UPDATE BOOK</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->
	
	<marquee>Welcome To Book Store ...</marquee>


	<%
		Book book = (Book) session.getAttribute("bdata");
	%>


	<div align="center">
		<form onsubmit="return validation()" action="BookServlet"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name="action" value="updatebook">

			<table border="2">
				
				<tr>
					<td>Book-Id</td>
					<td><input type="text" id="bookid" name="bid"
						value="<%=book.getBookId()%>" readonly></td>
					<td><span id="iderror"></span></td>
				</tr>
				<tr>
					<td>Book Name</td>
					<td><input type="text" id="bookname" name="bname"
						value="<%=book.getBookName()%>"></td>
					<td><span id="nameerror"></span></td>
				</tr>
				<tr>
					<td>Book Author</td>
					<td><input type="text" id=bookauthor name="aname"
						value="<%=book.getBookAuthorName()%>"></td>
					<td><span id="authorerror"></span></td>

				</tr>
				<tr>
					<td>Book Price</td>
					<td><input type="number" id="bookprice" name="bprice"
						value="<%=book.getPrice()%>"></td>
					<td><span id="priceerror"></span></td>
				</tr>
				<tr>
					<td>Book Category</td>
					<td><input type="text " id="bookcategory" name="bcategory"
						value="<%=book.getBookCategory()%>"></td>
					<td><span id="categoryerror"></span></td>

				</tr>
				<tr>
					<td>Book Language</td>
					<td><select id="booklanguage" name="blanguage"
						value="<%=book.getLanguage()%>">
							<option selected>..select..</option>
							<option>English</option>
							<option>Hindi</option>
							<option>Marathi</option>
							<option>Japanese</option>
							<option>French</option>
					</select></td>
					<td><span id="languageerror"></span></td>
				</tr>
				<tr>
					<td>Publisher</td>
					<td><input type="text" id="bookpublisher" name="bpublication"
						value="<%=book.getBookPublication()%>"></td>
					<td><span id="publishererror"></span></td>
				</tr>
				

				<tr>
					<td>Book Image</td>
					<td><input type="file" id="image" name="image"></td>
					<td><span id="imageerror"></span></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Book"></td>
					<td><input type="reset" value="Reset"> <input
						type="submit" value="Cancel"></td>

				</tr>



			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>