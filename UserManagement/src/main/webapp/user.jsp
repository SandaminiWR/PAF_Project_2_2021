<%@page import="com.User"%>
<%@page import="com.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
	<form id="formUser" name= "formUser">	
 
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
<input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
<input type="hidden" id="hidUserIDSave" name="hidUserIDSave" value="">

	</form>
	
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

	<br>
	<div id="divUsersGrid">
	<%
		 User userObj = new User(); 
		 out.print(userObj.readUser()); 
	%>
</div>
</div>
	</div>
 </div>
 
</body>
</html>