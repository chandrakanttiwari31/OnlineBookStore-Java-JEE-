<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Book Store</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
		<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

		<!-- CSS here -->
            <link rel="stylesheet" href="assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
            <link rel="stylesheet" href="assets/css/flaticon.css">
            <link rel="stylesheet" href="assets/css/slicknav.css">
            <link rel="stylesheet" href="assets/css/animate.min.css">
            <link rel="stylesheet" href="assets/css/magnific-popup.css">
            <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="assets/css/themify-icons.css">
            <link rel="stylesheet" href="assets/css/slick.css">
            <link rel="stylesheet" href="assets/css/nice-select.css">
            <link rel="stylesheet" href="assets/css/style.css">

</head>
<body>

<%
     String user=(String)session.getAttribute("user");
     String Admin=(String)session.getAttribute("Admin");
%>
<header>
    
    
        <!-- Header Start -->
       <div class="header-area">
            <div class="main-header ">
               
               <div class="header-bottom  header-sticky">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <!-- Logo -->
                            <div class="col-xl-1 col-lg-1 col-md-1 col-sm-3">
                                <div class="logo">
                                  <a href="index.html"><img src="assets/img/logo/icon.jpg" alt=""></a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-8 col-md-7 col-sm-5">
                                <!-- Main-menu -->
                                <div class="main-menu f-right d-none d-lg-block">
                                    <nav>  
                                    <% if(user!=null && Admin==null){ %>                                              
                                        <ul id="navigation">                                                                                                                                     
                                            <li><a href="index.jsp">Home</a></li>
                                            <li><a href="BookServlet">Product</a></li>
                                            <li><a href="Orderservlet?action=myorders&emailId=<%=user%> ">My Order</a></li>
                                            <li><a href="CustomerServlet">Edit Profile</a></li>
                                            <li><a href="Aboutus.jsp">about us</a></li>
                                            <li><a href="Contact.jsp">Contact Us</a></li>
                                            
                                        </ul>
                                        <%} %>
                                        
                                        <% if(user==null && Admin!=null){ %>                                              
                                        <ul id="navigation">                                                                                                                                     
                                            <li><a href="index.jsp">Home</a></li>
                                            <li><a href="BookServlet">Product</a></li>
                                             <li><a href="AddBook.jsp">Add Book </a></li>
                                            
                                            <li><a href="CustomerServlet">Customer List</a></li>
                                            <li><a href="Orderservlet">Order List</a></li>
                                            <li><a href="Aboutus.jsp">about us</a></li>
                                            <li><a href="Contact.jsp">Contact Us</a></li>
                                           
                                        </ul>
                                        <%} %>
                                        
                                        
                                        <% if(user==null && Admin==null){ %>                                              
                                        <ul id="navigation">                                                                                                                                     
                                            <li><a href="index.jsp">Home</a></li>
                                            <li><a href="BookServlet">Product</a></li>
                                            <li><a href="AddCustomer.jsp">Register</a></li>
                                          
                                            <li><a href="Aboutus.jsp">about us</a></li>
                                            <li><a href="Contact.jsp">Contact Us</a></li>
                                            
                                        </ul>
                                        <%} %>
                                        <% if(user!=null && Admin!=null){ %>                                              
                                        <ul id="navigation">                                                                                                                                     
                                            <li><a href="LoginServlet">Log Out</a></li>
                                          
                                        </ul>
                                        <%} %>
                                        <%!String customerName; %>
                                        <%
                                        if(user!=null && Admin==null)
                                        {
                                        	
                                        	customerName=(String)session.getAttribute("cname");
                                        }
                                        
                                        %>
                                        
                                        <%if(customerName !=null){ %>
                                        
                                        <h5>Hii...<%=customerName %></h5>
                                        <%} %>
                                        
                                    </nav>
                                </div>
                            </div> 
                              <div class="col-xl-5 col-lg-3 col-md-3 col-sm-3 fix-card">
                                <ul class="header-right f-right d-none d-lg-block d-flex justify-content-between">
                                    <li class="d-none d-xl-block">
                                    
                                        <div class="form-box f-right ">
                                        <form action="BookServlet">
                                        <input type="hidden" name="action" value="search">
                                            <input type="text" name="Search" placeholder="Search products">
                                            <div class="search-icon">
                                                <i class="fas fa-search special-tag"></i>
                                            </div>
                                            </form>
                                        </div>
                                     </li>
                                   
                                   <% if (user!=null && Admin==null){ %>
                                    <li>
                                    
                                        <div class="shopping-card">
                                            <a href="CartServlet"><i class="fas fa-shopping-cart"></i></a>
                                        </div>
                                    </li>
                                    <%} %>
                                    
                                    <%if(user==null && Admin==null){ %>
                                   <li class="d-none d-lg-block"> <a href="Login.jsp" class="btn header-btn">Sign in</a></li>
                                   <%} %>
                                   
                                    <%if(user!=null || Admin!=null){ %>
                                   <li class="d-none d-lg-block"> <a href="LoginServlet" class="btn header-btn">Log Out</a></li>
                                   <%} %>
                                   
                                   
                                  
                                </ul>
                            </div>
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
               </div>
            </div>
       </div>
        <!-- Header End -->
        </header>
        
        
</body>
</html>