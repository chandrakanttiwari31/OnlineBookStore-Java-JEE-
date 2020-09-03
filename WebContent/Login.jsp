<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
  <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function validation() {
		var uname = document.getElementById("name").value;
		var password = document.getElementById("password").value;
      var login=document.getElementById("login").value;
      
   if(login=="")
		   {
	   document.getElementById("loginerr").innerHTML = "* Please  Choose The Option";
		return false;
	   
		   }
		if (uname == "") {
			document.getElementById("nameerr").innerHTML = "* Please Provide User Name";
			return false;

		}

		if (password== "") {

			document.getElementById("passworderr").innerHTML = "* Please Provide  Valid Password";
			return false;

		}
		else if(password.length<8)
		{
			
           alert("Password Atleast 8 character Long");
			return false;
			
		}

		

		return true;

	}
</script>




    <!--  <link rel="stylesheet" href="Tamplate.css">  -->

</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	<marquee id="marquee">WELCOME TO BOOK STORE - REGISTRATION</marquee>
	<div align="center">
		<form onsubmit=" return validation()" action="LoginServlet" method="post">
		<input type="hidden" name="action" value="addlogin">
		<%
		String status=(String)request.getAttribute("status");
		if(status !=null)
		{
			out.print("<h2 style='color:red'>"+status+"</h2>");
			
		}
		
		%>		<table class="td">
			
				

				<tr>
					<td>Login-as</td>
					<td><select id="login" name="type">
							<option value="select"  selected>Select</option>
							<option value="Admin">Admin</option>
							<option value="Customer">Customer</option>

					</select></td>
					<td><span id="loginerr"></span></td>
				</tr>

				<tr>

					<td>User Name</td>
					<td><input type="text" id="name" name="uname"></td>
					<td><span id="nameerr"></span></td>

				</tr>

				<tr>

					<td>Password</td>
					<td><input type="password" id="password" name="upass"></td>
					<td><span id="passworderr"></span></td>
					

				</tr>
			</table>
			<input type="submit" value="Login">&emsp;<input type="button"
				value="cancel">

		</form>

	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>