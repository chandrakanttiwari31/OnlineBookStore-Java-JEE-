<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bookstore.pojo.Book"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Gallery....</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		List<Book> blist = (List<Book>) request.getAttribute("blist");
		
		
		
		
	String status = (String) request.getAttribute("status");
	if (status != null) {
		out.print("<b style='color:red'> you have" + status + "</b>");
	}

	
	 String user=(String)session.getAttribute("user");
     String admin=(String)session.getAttribute("Admin");
	%>


<!-- slider Area Start-->
  <div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="single-slider slider-height2 d-flex align-items-center" data-background="assets/img/hero/bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="hero-cap text-center">
                        <h2>BOOK LIST</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <br>
  		<br>
        <!-- Latest Products Start -->
        
            <div class="container">

                <!-- Nav Card -->
                <div class="tab-content" id="nav-tabContent">
                    <!-- card one -->
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <div class="row">
                        <%
							Iterator<Book> b = blist.iterator();
							while(b.hasNext())
							{
								Book book = b.next();
						%>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single-product mb-60">
                                    <div class="product-img">
                                        <a href="BookServlet?action=details&id=<%= book.getBookId() %>" style="color:black">
                                        <img src="ImageServlet?id=<%= book.getBookId() %>"  alt="Loading" width="150" height="150"></a>

                                    </div>
                                    <div class="product-caption">
                                    	
                                        <h5><a href="BookServlet?action=details&id=<%= book.getBookId() %>" style="color:black"><%=book.getBookName() %> </a></h5>
                                       	<h6><%=book.getBookAuthorName() %></h6>

                                        <div class="price">
                                            <ul>
                                                <li>Rs. <%=book.getPrice() %></li>
                                            </ul>
                                        </div>
                                        <br>
                                     
			<%if(user !=null && admin==null){ %>
			<td><b><a href="CartServlet?action=addtocart&id=<%=book.getBookId()%>"><button  style="color:red">AddToCart</button></a></b></td>
			 <%} %>
					
					 <%if(user ==null && admin!=null){ %>
			<td><b><a href="BookServlet?action=edit&id=<%=book.getBookId()%>" >><button style="color:red">Edit</button></a></b></td>
			<td><b><a href="BookServlet?action=delete&id=<%=book.getBookId()%>" >><button style="color:red">Delete</button></a></b></td>
			 <%} %>
                                    </div>
                                </div>
                            </div>
                            
                            <%} %>
                            
                            
                        </div>
                    </div>
                    
                <!-- End Nav Card -->
            </div>
            </div>
     
        <!-- Latest Products End -->
  
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>