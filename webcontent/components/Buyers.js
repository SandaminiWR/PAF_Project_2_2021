
$(document).ready(function(){
	
	//if ($("#alertSuccess").text().trim() == "") {
		 $("#alertSuccess").hide(); 
 	//} 
 		 $("#alertError").hide(); 
});

// SAVE ============================================

$(document).on("click", "#btnSave", function(event){ 
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
 	 $("#alertError").text(""); 
 	 $("#alertError").hide();
 	 
 	 
 	 // Form validation-------------------
	var status = validateItemForm(); 
	if (status != true){ 
 		
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
		
		 return; 
	 } 
	
	// If valid-------------------------
 		//$("#buyerdetails").submit();
 		
 		var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
 		
		 $.ajax( 
	     { 
				 url : "BuyersAPI", 
 				 type : type, 
                 data : $("#buyerdetails").serialize(), 
                 dataType : "text", 
                 complete : function(response, status) 
 				 {
 				 	onItemSaveComplete(response.responseText, status); 
 				 } 
 		}); 
  }); 


//Save Button View (Response Algorithm)--------------------------------------------------------------------------------------

		function onItemSaveComplete(response, status){ 
 
 			if (status == "success"){ 
 	   		 	var resultSet = JSON.parse(response); 
 	   	 
			 	if (resultSet.status.trim() == "success"){ 
 
 					$("#alertSuccess").text("Successfully saved."); 
 					$("#alertSuccess").show(); 
 					$("#divItemsGrid").html(resultSet.data);
 	 	 	
 	 	 	} 
 	 	 	else if (resultSet.status.trim() == "error"){ 
 	  			
 				$("#alertError").text(resultSet.data); 
 				$("#alertError").show(); 
		    } 
	 
 	    } 
 	    else if (status == "error"){
   	     	
 			    $("#alertError").text("Error while saving."); 
 		        $("#alertError").show(); 
 		} 
 		else{ 
			    $("#alertError").text("Unknown error while saving.."); 
	 	 		$("#alertError").show(); 
 		} 
 		
	    $("#hidItemIDSave").String(""); 
	    $("#formItem")[0].reset();
 
   }
 		 

 	 
 	 // UPDATE==========================================
 	 
	$(document).on("click", ".btnUpdate", function(event){ 
	
	$("#hidIDSave").var($(this).closest("tr").find('#hidupdatebuyerservice').val()); 
 	$("#FullName").var($(this).closest("tr").find('td:eq(0)').text()); 
	$("#PhoneNumber").var($(this).closest("tr").find('td:eq(1)').text()); 
	$("#Email").var($(this).closest("tr").find('td:eq(2)').text()); 
	$("#Address").var($(this).closest("tr").find('td:eq(3)').text());
	$("#Birthdate").var($(this).closest("tr").find('td:eq(4)').text()); 
});



// REMOVE Button handler(Request Algorithm)=======================================================================================

		$(document).on("click", ".btnRemove", function(event)
		{ 
			 $.ajax( 
 		 	{ 
				 url : "BuyerAPI", 
				 type : "DELETE", 
		   		 data : "itemID=" + $(this).data("id"),
 		 		 dataType : "text", 
			 	complete : function(response, status) 
		 		{
		  			onItemDeleteComplete(response.responseText, status); 
 			
 	    		}
 	  
 		}); 
 
	});
	
	
	
	//Remove Button View (Response Algorithm)-----------------------------------------------------------------------------

		function onItemDeleteComplete(response, status){ 
			if (status == "success"){ 
		 		var resultSet = JSON.parse(response); 
		 		
 				if (resultSet.status.trim() == "success"){ 
		 			 $("#alertSuccess").text("Successfully deleted."); 
	 		 		 $("#alertSuccess").show(); 
 					 $("#divItemsGrid").html(resultSet.data); 
 	
	  			} 
	  			else if (resultSet.status.trim() == "error"){ 
 					$("#alertError").text(resultSet.data); 
 					$("#alertError").show(); 
 	 		    } 
 		
	 	   } 
	 	   else if (status == "error"){ 
 	  
 				$("#alertError").text("Error while deleting."); 
 				$("#alertError").show(); 
 	  	   } 
 	  	   else{ 
 				$("#alertError").text("Unknown error while deleting.."); 
 				$("#alertError").show(); 
 	   	   }
 	  
	}


 	 
 	 
 	 // CLIENT-MODEL================================================================
 	 function validateItemForm(){ 

	// name
	if ($("#FullName").var().trim() == ""){ 
 	return "Insert Full Name."; 
 	}
 	 
	// phone number
	if ($("#PhoneNumber").var().trim() == ""){ 
 	return "Insert Phone Number."; 
 	}
 	 
	// email
	if ($("#Email").var().trim() == ""){ 
 	return "Insert Email."; 
 	} 

	// address
	if ($("#Address").var().trim() == ""){ 
 	return "Insert Address."; 
 	}
 	
 	// Birthday
	if ($("#Birthdate").var().trim() == ""){ 
 	return "Insert Birth date."; 
 	}

 
}
 	 