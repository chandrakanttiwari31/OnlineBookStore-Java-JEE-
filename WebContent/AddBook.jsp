
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<script type="text/javascript">
	function validation(){
		var input=document.getElementsByTagName("input");
		//var price=isNaN(input[2].value);
		if(input[2].value=="")
			{
			document.getElementById("unbook").innerHTML="*please provide  Book Name "+input[2].value+",,,,,,,,,";
			return false;
			}
		
		if (input[3].value == "") {
			document.getElementById("unauthor").innerHTML = "*please provide Author Name"+input[1].value;
			return false;
		}
		
		if (input[4].value == "") {
			
			document.getElementById("unprice").innerHTML = "*please provide Book price";
			 return false;
		}
		/* if(price){

			document.getElementById("unprice").innerHTML = "*please provide only numbers";
			 return false;
		} */
		
		if (input[5].value == "") {
			document.getElementById("uncategory").innerHTML = "*please provide  category";
			return false;
		}
		if (input[6].value == "") {
			document.getElementById("unpublication").innerHTML = "*please provide Publication";
			return false;
		}
	
		return true;
	}
</script>
<!-- <link rel="stylesheet" href="Template.css"> -->
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
                        <h2>ADD BOOK</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->


<marquee style=" color: red;font-size: 30px;">WELCOME TO BOOK STORE-Add Books</marquee>
	<div align="center">
	  <div class="col-lg-8">
                        <form onsubmit="return validation()" action="BookServlet" method="post" class="form-contact contact_form" enctype="multipart/form-data" >
                            <div class="row">
                            <input type="hidden" name="action" value="add">
                             	<div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="bname" id="subject" type="text" 
                                        placeholder="Enter Book Name">
                                        <span id="unbook"></span>
                                   <br>
                                        <input class="form-control" name="aname" type="text" 
                                        placeholder="Enter Author Name">
                                        <span id="unauthor"></span>
                                     <br>
                                        <input class="form-control" name="bprice" type="number" 
                                         placeholder="Enter Book Price">
                                        <td><span id="unprice"></span></td>
                                    </div>
                                </div>                                                              
                                
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input class="form-control valid" name="bcategory" type="text"  placeholder="Catagory">
                                        <span id="uncategory"></span>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <select class="form-control valid" name="blanguage" placeholder="Language">
                                        <option selected>English</option>
											<option>Hindi</option>
											<option>Marathi</option>
											<option>Sanskut</option>
											<option>Gujrathi</option>
											<option>Other </option>
                                         </select>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="bpublication" type="text" placeholder="Enter Publication">
                                        <span id="unpublication"></span>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="image" id="bimage" type="file" placeholder="Enter Book Image">
                                        <span id="unimage"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <button type="submit" class="button button-contactForm boxed-btn">Add Book</button>
                            </div>
                        </form>
                    </div>
<!--  
	<marquee id="marquee">WELCOME TO BOOK STORE - REGISTRATION</marquee>
	<div align="center">
		<form onsubmit="return validation()" action="BookServlet"
			method="post" enctype="multipart/form-data">
					<input type="hidden"  name="action" value="addbook">
			
			<table class="td">
				<caption id="caption">Register New Book:-</caption>


				<tr>
					<td>Book-Name</td>
					<td><input type="text" id="bookname" name="bname"></td>
					<td><span id="booknameerr"></span></td>

				</tr>
				<tr>

					<td>Author-Name</td>
					<td><input type="text" id="authorname" name="aname"></td>
					<td><span id="authornameerr"></span></td>

				</tr>
				<tr>
					<td>Book-Price</td>
					<td><input type="number" id="bookprice" name="bprice"></td>
					<td><span id="bookpriceerr"></span></td>

				</tr>
				<tr>

					<td>Book-Category</td>
					<td><input type="text" id="bookcategory" name="bcategory"></td>
					<td><span id="bookcategoryerr"></span></td>

				</tr>
			<tr>
					<td>Book-Language</td>
					<td><select id="booklanguage" name="blanguage">
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

					<td>Book-Publication</td>
					<td><input type="text" id="bookpublicaton" name="bpublication"></td>
					<td><span id="bookpublicationerr"></span></td>

				</tr>
				
				<tr>

					<td>Book-Image</td>
					<td><input type="file" id="bookimage" name="image"></td>
					<td><span id="bookimageerr"></span></td>

				</tr>
				
			</table>
			<input type="submit" value="add">&emsp;<input
				type="reset" value="cencel">

		</form>
-->
	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

