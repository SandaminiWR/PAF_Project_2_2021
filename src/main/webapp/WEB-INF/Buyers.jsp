<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	//initialize
	session.setAttribute("statusMsg","");
	System.out.println("Trying to process...");

	//Save---------------------------------
	if (request.getParameter("FullName") != null) 
	{ 
	 Byer itemObj = new Byer(); 
	 String stsMsg = ""; 
	//Insert--------------------------
	if (request.getParameter("hidItemIDSave") == "") 
	 { 
	 stsMsg = itemObj.insertItem(request.getParameter("FullName"), 
	 request.getParameter("PhoneNumber"), 
	 request.getParameter("Email"), 
	 request.getParameter("Address"),
	 request.getParameter("Birthdate")); 
	 } 
	else//Update----------------------
	 { 
	 stsMsg = itemObj.updateItem(request.getParameter("hidItemIDSave"), 
	 request.getParameter("FullName"), 
	 request.getParameter("PhoneNumber"), 
	 request.getParameter("Email"),
	 request.getParameter("Address"),
	 request.getParameter("Birthdate")); 
	 } 
	 session.setAttribute("statusMsg", stsMsg); 
	} 
	//Delete-----------------------------
	if (request.getParameter("hidIDDelete") != null) 
	{ 
	 Byer itemObj = new Byer(); 
	 String stsMsg = itemObj.deleteItem(request.getParameter("hidItemIDDelete")); 
	 session.setAttribute("statusMsg", stsMsg); 
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer manager</title>
<link rel="stylesheet" href="views/Bootstrap.min.css">
<script src="components/jquery-3.2.1.min.js"></script>
<script src="components/Buyers.js"></script>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
<div class="container">
<div class="row">
<div class="col-8">
	
	<h1>Buyer Manager</h1>
	<p>
	</p>
	
	

	<form id=" buyerdetails" name="buyerdetails" method="post" action="Buyers.jsp">
	
 
 	FullName: 
	<input id="fullname" name="fullname" type="text" class="form-control form-control-sm">
	<br>

	PhoneNumber: 
	<input id="phonenumber" name="phonenumber" type="number" class="form-control form-control-sm">
	<br> 

	Email: 
	<input id="email" name="email" type="text" class="form-control form-control-sm">
	<br>

	Address: 
	<input id="address" name="address" type="text" class="form-control form-control-sm">
	<br>

	Birthdate: 
	<input id="birthdate" name="birthdate" type="text" class="form-control form-control-sm">
	<br>

	<input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
	<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">

	</form>

	<div id="alertSuccess" class=alert alert-success></div>
	
	<div id="alertError" class = alert alert-danger></div>
	<br>
	
	<div id="divBuyersGrid">
	<%
	Byer itemObj = new Byer();
	out.print(itemObj.readbuyerservice());
	%>
	</div>
</div>
</div>
</div>
</div>



</body>
</html>