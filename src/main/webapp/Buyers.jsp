<%@page import="model.Byer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 

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
	
	

	<form id="formBuyer" name="formBuyer" method="post" action="Buyers.jsp">
	
 
 	FullName: 
	<input id="FullName" name="FullName" type="text" 
				  class="form-control form-control-sm">
	

	<br> PhoneNumber: 
	<input id="PhoneNumber" name="PhoneNumber" type="text" 
				  class="form-control form-control-sm">
	 

	<br>Email: 
	<input id="Email" name="Email" type="text"
				 class="form-control form-control-sm">
	<br>

	<br>Address: 
	<input id="Address" name="Address" type="text" 
				class="form-control form-control-sm">
	<br>

	<br>Birthdate: 
	<input id="Birthdate" name="Birthdate" type="text" 
				 class="form-control form-control-sm">
	
	<br>
	<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
	<input type="hidden" id="hidBuyerIDSave" name="hidBuyerIDSave" value="">

	</form>

	<div id="alertSuccess" class="alert alert-success"></div>
	
	<div id="alertError" class = "alert alert-danger"></div>
	<br>
	
	<div id="divBuyersGrid">
	<%
		Byer itemObj = new Byer();
		out.print(itemObj.readBuyer());
	%>
	</div>
</div>
</div>
</div>
</div>



</body>
</html>