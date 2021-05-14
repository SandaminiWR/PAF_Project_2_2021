
$(document).ready(function()
{ 
if ($("#alertSuccess").text().trim() == "") 
 { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validateUserForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid-------------------------
var type = ($("#hidUserIDSave").val() == "") ? "POST" : "PUT";
 
 $.ajax( 
 { 
		
 	 url : "UsersAPI", 
	 type : type, 
 	 data : $("#UsersAPI").serialize(), 
	 dataType : "text", 
  	 complete : function(response, status) 
	 { 
 		onUserSaveComplete(response.responseText, status); 
	 } 
 	}); 
});

function onUserSaveComplete(response, status)
{ 
	if (status == "success") 
 	{ 
 		var resultSet = JSON.parse(response); 
	
		 if (resultSet.status.trim() == "success") 
		 { 
			 $("#alertSuccess").text("Successfully saved."); 
			 $("#alertSuccess").show(); 
 
			$("#divUsersGrid").html(resultSet.data); 
 		
		} else if (resultSet.status.trim() == "error") 
 		{ 
 			$("#alertError").text(resultSet.data); 
		    $("#alertError").show(); 
 		} 
	
	 } else if (status == "error") 
 		{ 
 			$("#alertError").text("Error while saving."); 
 			$("#alertError").show(); 
	 } else
		 { 
 			$("#alertError").text("Unknown error while saving.."); 
		    $("#alertError").show(); 
 		} 
		    $("#hidUserIDSave").val(""); 
 			$("#formUser")[0].reset(); 
};

// UPDATE==========================================

$(document).on("click", ".btnUpdate", function(event) 
{ 
	 $("#hidUserIDSave").val($(this).data("id")); 
	 $("#name").val($(this).closest("tr").find('td:eq(1)').text()); 
	 $("#phone").val($(this).closest("tr").find('td:eq(2)').text()); 
	 $("#address").val($(this).closest("tr").find('td:eq(3)').text()); 
	 $("#mail").val($(this).closest("tr").find('td:eq(4)').text()); 
	 $("#password").val($(this).closest("tr").find('td:eq(5)').text()); 
	 $("#confirmpassword").val($(this).closest("tr").find('td:eq(6)').text()); 
});

// DELETE==========================================

$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "UsersAPI", 
 type : "DELETE", 
 data : "id=" + $(this).data("id"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onUserDeleteComplete(response.responseText, status); 
 } 
 }); 
});

function onUserDeleteComplete(response, status)
{ 
	if (status == "success") 
	 { 
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") 
	 { 
		 $("#alertSuccess").text("Successfully deleted."); 
		 $("#alertSuccess").show(); 
		 $("#divItemsGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
		 $("#alertError").text(resultSet.data); 
		 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
		 $("#alertError").text("Error while deleting."); 
		 $("#alertError").show(); 
	 } else
	 { 
		 $("#alertError").text("Unknown error while deleting.."); 
		 $("#alertError").show(); 
	 } 
}
// CLIENT-MODEL================================================================
function validateUserForm() 
{ 
// CODE
if ($("#name").val().trim() == "") 
 { 
 return "Insert name."; 
 } 
// NAME
if ($("#phone").val().trim() == "") 
 { 
 return "Insert Item Name."; 
 } 
// PRICE-------------------------------
if ($("#address").val().trim() == "") 
 { 
 return "Insert Item Price."; 
 } 
if ($("#mail").val().trim() == "") 
 { 
 return "Insert Item Price."; 
 } 
if ($("#password").val().trim() == "") 
 { 
 return "Insert Item Price."; 
 } 
if ($("#confirmpasswprd").val().trim() == "") 
 { 
 return "Insert Item Price."; 
 } 

return true; 
}


