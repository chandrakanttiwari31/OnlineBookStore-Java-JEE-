<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD CUSTOMER</title>
<script type="text/javascript">
	function validation() {
		var v1 = document.getElementById("email").value;
		var v2 = document.getElementById("name").value;
		var v3 = document.getElementById("contact").value;
		var v4 = document.getElementById("address").value;
		var v5 = document.getElementById("password").value;


		if (v1 == "") {

			document.getElementById("emailerr").innerHTML = "* Please Provide Email Address";
			return false;
		}
		if (v2 == "") {
			document.getElementById("nameerr").innerHTML = "* Please Provide Customer Name";
			return false;

		}
		if (v3.length != 10) {

			document.getElementById("contacterr").innerHTML = "* Please Provide Valid Mobile Number";
			return false;

		}
		if (v4 == "") {
			document.getElementById("addresserr").innerHTML = "* Please Provide Address";
			return false;

		}

		if (v5 == "")
			{
			
			document.getElementById("passworderr").innerHTML = "* Please Provide  Valid Password";
			return false;

			}
		return true;

	}
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script >

<script type="text/javascript" src="jquery-3.5.1.min.js"> </script>
<script>
$(document).ready(function() {
	$("#email").change(function() {
	
	var customerEmailId=$("#email").val();
	alert(customerEmailId);
		$.ajax
		({
			type : 'GET',
			data : {name:'checkemailid',customerEmailId:customerEmailId},
			url : 'CustomerServlet',
			success : function (result)
			{
				$("#emailerr").html(result);
			}
		});
	
	});
});
</script>  




 <!--   <link rel="stylesheet" href="Tamplate.css"> -->
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
                        <h2>ADD CUSTOMER</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->
	<marquee id="marquee">WELCOME TO BOOK STORE - REGISTRATION</marquee>
	<div align="center">
		<form onsubmit=" return validation()"  action="CustomerServlet" method="post">
							<input type="hidden"  name="action" value="add">
		
			<table class="td">
				

				<tr>
					<td>Email-Id</td>
					<td><input type="email" id="email" name="cemail"> </td>
					<td><span id="emailerr"></span></td>

				</tr>
				<tr>

					<td>Customer Name</td>
					<td><input type="text" id="name" name="cname"> </td>
					<td><span id="nameerr"></span></td>

				</tr>
				<tr>
					<td>Contact Number</td>
					<td><input type="text" id="contact" name="ccontact"></td>
					<td><span id="contacterr"></span></td>

				</tr>

				<tr>

					<td>Address</td>
					<td><textarea id="address" name="caddress"></textarea></td>
					<td><span id="addresserr"></span></td>


				</tr>

				<tr>

					<td>Password</td>
					<td><input type="password" id="password" name=cpassword></td>
					<td><span id="passworderr"></span></td>

				</tr>
			</table>
			<input type="submit" value="Register">&emsp;<input
				type="reset">

		</form>

	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>