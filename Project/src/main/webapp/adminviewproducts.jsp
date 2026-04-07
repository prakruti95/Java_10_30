<%@page import="com.dao.Dao"%>
<%@page import="com.model.ProductModel"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Panel</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Custom CSS -->
 
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Custom CSS -->
  <style>
    /* Add custom styles here */
    body {
      background-color: #f4f4f4;
    }
    .sidebar {
      background-color: #343a40;
      color: white;
      height: 100vh;
    }
    .content {
      padding: 20px;
    }
  </style>

  
</head>
<body>

	<%
    
	    response.setHeader("cache-control", "no-cache");
	    response.setHeader("cache-control", "no-store");
	    response.setHeader("pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
    
    %>

<%
	if(session.getAttribute("projectadmin")!=null)
	{
		
	
	

%>
  
    <div class="row">
      <!-- Sidebar -->
      <div class="col-md-3 col-lg-2 sidebar">
        <div class="pt-3">
          <h2>Admin Panel</h2>
          
          
          
          <ul class="nav flex-column mt-3">
            <li class="nav-item">
              <a class="nav-link" href="adminaddproducts.jsp" style="color: white;">Add Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="adminviewproducts.jsp" style="color: white;">View All Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="adminplacedorder.jsp" style="color: white;">Placed Order</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="admincontacted.jsp" style="color: white;">Queries</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="adminlogout.jsp" style="color: red;">Logout</a>
            </li>
            
          </ul>
        </div>
      </div>

      <!-- Main Content -->
      <div class="col-md-9 col-lg-10 content">
       
        <h2>Welcome to the Admin Panel</h2>
       	  <table class="scroll table table-bordered  " style="background-color:#343a40; color: white; ">
         <thead>
            <th>Product Name</th>
			<th>Product Price</th>
			<th>Product Description</th>
			<th>Product Image</th>
			<th colspan="2"><b>Actions</b></th>
         </thead>
         <tbody >
           <%
			List<ProductModel> list = Dao.viewproducts();
			for(ProductModel m : list)
			{
			%>
			<tr>
				</td><td><%=m.getP_name() %></td><td><%=m.getP_price() %></td><td><%=m.getP_des() %></td><td><img src="data:image/jpeg;base64,<%=m.getP_image()%>" width="150px" height="200px" /></td>
				 <td>
                   <%--  <form action="" method="get">
                        <input type="hidden" name="id" value="<%= m.getId() %>">
                        <a href=""><img src="images/edit1.png" width="20px" height="20px"/></a>
                    </form> --%>
                    
           <a href="adminproductedit.jsp?id=<%=m.getId()%>"><img src="images/edit1.png" width="20px" height="20px"/></a></input>
                    
            	</td>
            	<td>
                   
                    <a href="adminproductdelete.jsp?id=<%=m.getId()%>"><img src="images/delete1.png" width="20px" height="20px"/></a></input>
                 </td>	
			</tr>	
			
			<%
				}
			%>
         </tbody>
      </table>
      <%
		}
		else
		{
			response.sendRedirect("adminlogin.jsp");
		}
      %> 	 
       
      </div>
    </div>
  </div>
 <div class="container ">
     
   </div>

</body>
</html>
    