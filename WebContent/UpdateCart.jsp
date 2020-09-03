<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE CART</title>
<link rel="stylesheet" href="Tamplate.css">
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
                        <h2>UPDATE CART</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->
  
  
	<marquee id="marquee">WELCOME TO BOOK STORE - REGISTRATION</marquee>
	<div align="center">
		<form>
			<table class="td">
				<caption id="caption">UPDATE - CART</caption>

				<tr>
					<td>Book-ID</td>
					<td><input type="number"></td>
				</tr>
				

				<tr>
					<td>Book-Quantity</td>
					<td><input type="number"></td>
				</tr>

			</table>
			<input type="submit" value="Register">&emsp;<input
				type="reset">

		</form>

	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>