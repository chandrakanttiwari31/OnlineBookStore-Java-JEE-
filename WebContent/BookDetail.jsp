<%@page import="com.bookstore.pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	String user=(String)session.getAttribute("user");
 	String admin=(String)session.getAttribute("admin");
	%>
	 <!-- slider Area Start-->
  <div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="single-slider slider-height2 d-flex align-items-center" data-background="assets/img/hero/bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="hero-cap text-center">
                        <h2>Book Details</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->
  
  <br>
  <br>
  		
	<% Book book = (Book)session.getAttribute("book"); %>
	
	<div align="center">
    <div class="container">
      <div class="cart_inner">
        <div class="table-responsive">
          <table class="table">
              <tr>
               	<th scope="col">Book Name</th>
              	<td>
                	<div class="media">
                   	<div class="media-body">
                    	<p><%=book.getBookName() %></p>
                   	</div>
                	</div>
              	</td>
              </tr>
              
              <tr>
               	<th scope="col">Author Name</th>
              	<td>
                	<div class="media">
                   	<div class="media-body">
                    	<p><%=book.getBookAuthorName() %></p>
                   	</div>
                	</div>
              	</td>
              </tr>
              
              <tr>
               	<th scope="col">Category</th>
              	<td>
                	<div class="media">
                   	<div class="media-body">
                    	<p><%=book.getBookCategory() %></p>
                   	</div>
                	</div>
              	</td>
              </tr>
              
              <tr>
               	<th scope="col">Language</th>
              	<td>
                	<div class="media">
                   	<div class="media-body">
                    	<p><%=book.getLanguage() %></p>
                   	</div>
                	</div>
              	</td>
              </tr>
              
              <tr>
               	<th scope="col">Book Publisher</th>
              	<td>
                	<div class="media">
                   	<div class="media-body">
                    	<p><%=book.getBookPublication() %></p>
                   	</div>
                	</div>
              	</td>
              </tr>
              
              <tr>
               	<th scope="col">Book Price</th>
              	<td>
                	<div class="media">
                   	<div class="media-body">
                    	<p><%=book.getPrice() %></p>
                   	</div>
                	</div>
              	</td>
              </tr>
              <%if(user!=null && admin==null){ %>
              <tr>
               	<th scope="col" colspan="2">
            		<div align="center"> <a class="btn_1" href="CartServlet?action=AddCart&id=<%=book.getBookId() %>">Add To Cart</a>   </div> 	
               	</th>
              </tr>
            <%} %>
            <%if(user==null && admin!=null){ %>
             <tr>
               	<th scope="col" colspan="2">
               	
            <div align="center"> <a class="btn_1" href="BookServlet?action=edit&id=<%=book.getBookId() %>"> Edit </a>   </div>
			<div align="center"> <a class="btn_1" href="BookServlet?action=delete&id=<%=book.getBookId() %>"> Delete </a>   </div>
			</th>
              </tr>
		<%} %>
          </table>
          
        </div>
      </div>
      </div>
      </div>
      
  
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>