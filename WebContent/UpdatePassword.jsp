<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Login Page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#usernameerror").hide();
		$("#newpassworderror").hide();
		$("#confpassworderror").hide();
		$("#passnotmatch").hide();	
		$("#passwordmatch").hide();
		$("#usererror").hide();

		$("#change").click(function() 
		{
			var username = $("#username").val();
			var newpassword = $("#newpassword").val();
			var confpassword=$("#confpassword").val();

			if (username == "") {
				$("#usernameerror").show();
				return false;
			}
			
			if (newpassword == "") 
			{
			$("#newpassworderror").show();
			return false;
			}
			 if(confpassword=="")
				{
				$("#confpassworderror").show();
				return false;
				}
			
				if(newpassword==confpassword)
					{
					return true;
					}
				else
					{
					$("#confpassworderror").hide();					
					$("#passnotmatch").show();
					return false;
					}		
			return true;

		});
 
	});
</script>

<marquee id="marquee">Welcome To Update Login Form
	....</marquee>
<link rel="stylesheet" href="Tamplate.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<form action="LoginServlet" method="post">
			<input type="hidden" name="action" value="updatelogin">
			<table>
				
				<tr>
					<td>Login As</td>
					<td><select id="select" name="type">
							<option selected>-select-</option>
							<option>Admin</option>
							<option>Customer</option>
					</select></td>
					<td><span id="usererror">*select user </span></td>
				</tr>
				<tr>
					<td>username</td>
					<td><input type="text" id="username" name="uname"></td>
					<td><span id="usernameerror">*username required</span></td>
				<tr>
					<td>New Password</td>
					<td><input type="password" id="newpassword" name="upass"></td>
					<td><span id="newpassworderror">*new password required
					</span></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" id="confpassword" name="cpass"></td>
					<td><span id="confpassworderror">*confirm passwordrequired</span> 
					<span id="passnotmatch">*password does not match</span>
						<span id="passwordmatch">*password match</span></td>

				</tr>
				<tr>
					<td><input type="submit" value="change" id="change"></td>
					<td><input type="reset" value="reset"> <input
						type="submit" value="Cancel"></td>
					<td></td>
				</tr>
			</table>

		</form>


	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>