
<%@page import="model.User"%>
<%@page import="model.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     
 <%
if (request.getParameter("name") != null) 
{ 
	
			 User user = new User(); 
 		     String stsMsg = "";
 		    
 		   
 		     //Insert----------------------
 		      if (request.getParameter("hidUserIDSave") == "") 
  			  { 
 		    	 
				 stsMsg = user.insertUser(request.getParameter("name"), 
				 					request.getParameter("phone"), 
					 				request.getParameter("address"), 
				 					request.getParameter("mail"), 
				 					request.getParameter("password"), 
					 				request.getParameter("confirmpassword")); 
 
				} 
 		      else//Update--------------------
 		      {
 		    	  
 		    	 
 				 stsMsg = user.updateUser(request.getParameter("hidUserIDSave"), 
 					    	request.getParameter("name"),	
 						    request.getParameter("phone"), 
			 				request.getParameter("address"), 
		 					request.getParameter("mail"), 
		 					request.getParameter("password"), 
			 				request.getParameter("confirmpassword")); 
 				 System.out.println(stsMsg);
			  }
 		     
 	 			session.setAttribute("statusMsg", stsMsg); 
 	 			
}
 //Delete------------------
 if (request.getParameter("hidUserIDDelete") != null) 
    { 
    
    User usr = new User(); 
    String stsMsg = usr.deleteUser(request.getParameter("hidUserIDDelete")); 
    session.setAttribute("statusMsg", stsMsg); 
    } 
  

%>

<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>User Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>

</head>
<body>

<div class="container"> 
 <div class="row">
 <div class="col-8"> 	
	
<h1 class="m-3">User Management</h1>
	<form id="formUser" name= "formUser" method="post" action="user.jsp">
	
 
Name : 
<input id="name" name="name" type="text" 
 class="form-control form-control-sm">
<br>
 Phone: 
<input id="phone" name="phone" type="tel" 
 class="form-control form-control-sm">
<br> 
Address : 
<input id="address" name="address" type="text" 
 class="form-control form-control-sm">
<br>
Email : 
<input id="mail" name="mail" type="email" 
 class="form-control form-control-sm">
<br>
Password : 
<input id="password" name="password" type="password" 
 class="form-control form-control-sm">
<br>
confirm Password: 
<input id="confirmpassword" name="confirmpassword" type="password" 
 class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="submit" value="Save" 
 class="btn btn-primary">
<input type="hidden" id="hidUserIDSave" name="hidUserIDSave" value="">

	</form>
	
	</div>
 </div>
 
 <br>
 
 <div class="row">
 <div class="col-12" id="colStudents">
 
 </div>
 </div>
</div>
 
	 
	 <body>
 
    <%
        if ("Insert Successfull".equals(session.getAttribute("statusMsg"))) {
    %>
        <div class="alert alert-success" id="alertSuccess">
        <% out.print(session.getAttribute("statusMsg")); %>	</div>
    <%
        } 
        else {
    %>
        <div id="alertError" class="alert alert-danger">
		<% out.print(session.getAttribute("statusMsg")); %>	</div>
    <%
        }
    %>
    
    <!-- 
    
     -->
     
      <%
        if ("Updated successfully".equals(session.getAttribute("statusMsg"))) {
    %>
        <div class="alert alert-success" id="alertSuccess">
        <% out.print(session.getAttribute("statusMsg")); %>	</div>
    <%
        } 
        else {
    %>
        <div id="alertError" class="alert alert-danger">
		<% out.print(session.getAttribute("statusMsg")); %>	</div>
    <%
        }
    %>
 
</body>
	 
	<br>
	<%
		 User userObj = new User(); 
		 out.print(userObj.readUser()); 
	%>

<br>
	<!--  <table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Mail</th>
			<th>Password</th>
			<th>Update</th>
			<th>Remove</th>
	
		</tr>
	
		<tr>
			<td><%out.print(session.getAttribute("id")); %></td>
			<td><%out.print(session.getAttribute("name")); %></td>
			<td><%out.print(session.getAttribute("phone")); %></td>
			<td><%out.print(session.getAttribute("address")); %></td>
			<td><%out.print(session.getAttribute("mail")); %></td>
			<td><%out.print(session.getAttribute("password")); %></td>
			<td><%out.print(session.getAttribute("confirmpassword")); %></td>
		
		
			
			<td><input name="btnUpdate" type="button" value="Update"></td> 
			<td><input name="btnRemove" type="button" value="Remove"></td>
		</tr>
		
		
	</table>
	
-->	

</body>
</html>