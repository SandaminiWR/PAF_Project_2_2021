<%@page import="com.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>


</head>
<body>

<div class="jumbotron jumbotron-fluid">

<div class="container"><div class="row"><div class="col-10">
 
	<center><h1 style="font-size:380%;">ITEMS Management</h1></center>
	<br><br>







<div class="alert alert-success">
 <% out.print(session.getAttribute("statusMsg"));%>
</div>



<%
 out.print(session.getAttribute("statusMsg")); 
%>
<br>

<%
 Item itemObj = new Item(); 
 out.print(itemObj.readItems()); 
%>

</div>
 </div>
</div>


</body>
</html>