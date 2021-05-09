
// Hide the alerts on page load-------------------------------------------------------------------	
	$(document).ready(function()
	 { 
 
		 $("#alertSuccess").hide(); 
		 $("#alertError").hide(); 
	}); 


// SAVE button click handler(Request Algorithm)-----------------------------------------------------------------------

	$(document).on("click", "#btnSave", function(event) 
	{ 
		 // Clear alerts---------------------
 		 $("#alertSuccess").text(""); 
 	     $("#alertSuccess").hide(); 
 	     $("#alertError").text(""); 
	     $("#alertError").hide(); 
	 
	 
		// Form validation-------------------
		var status = validateItemForm(); 
		if (status != true) 
    	{ 
 			$("#alertError").text(status); 
 			$("#alertError").show(); 
 	        return; 
	    } 
 
 
        // If valid----------------------------------------------------------------------------------
 		var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
 		
		 $.ajax( 
	     { 
				 url : "ItemsAPI", 
 				 type : type, 
                 data : $("#formItem").serialize(), 
                 dataType : "text", 
                 complete : function(response, status) 
 				{
 				 
					 onItemSaveComplete(response.responseText, status); 
 				} 
 		}); 
  }); 


	    
	    //Save Button View (Response Algorithm)-----------------------------------------------------------------------------
		function onItemSaveComplete(response, status)
		{ 
 
 			if (status == "success") 
 			{ 
 	   		 	var resultSet = JSON.parse(response); 
 	   	 
			 	if (resultSet.status.trim() == "success") 
	 			{ 
 
 					$("#alertSuccess").text("Successfully saved."); 
 					$("#alertSuccess").show(); 
 		
 					$("#divItemsGrid").html(resultSet.data);
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
 		
	    $("#hidItemIDSave").val(""); 
	    $("#formItem")[0].reset();
 
   }

