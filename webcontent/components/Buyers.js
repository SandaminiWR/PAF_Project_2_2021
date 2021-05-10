$(document).ready(function(){
	
	if ($("#alertSuccess").text().trim() == "") {
		 $("#alertSuccess").hide(); 
 	} 
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
 		$("#buyerdetails").submit(); 
});
 	 
 	 // UPDATE==========================================
 	 
	$(document).on("click", ".btnUpdate", function(event){ 
	$("#hidIDSave").val($(this).closest("tr").find('#hidupdatebuyerservice').val()); 
 	$("#FullName").val($(this).closest("tr").find('td:eq(0)').text()); 
	$("#PhoneNumber").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#Email").val($(this).closest("tr").find('td:eq(2)').text()); 
	$("#Address").val($(this).closest("tr").find('td:eq(3)').text());
	$("#Birthdate").val($(this).closest("tr").find('td:eq(4)').text()); 
});
 	 
 	 
 	 // CLIENT-MODEL================================================================
 	 function validateItemForm(){ 

	// name
	if ($("#FullName").val().trim() == ""){ 
 	return "Insert Full Name."; 
 	}
 	 
	// phone number
	if ($("#PhoneNumber").val().trim() == ""){ 
 	return "Insert Phone Number."; 
 	}
 	 
	// email
	if ($("#Email").val().trim() == ""){ 
 	return "Insert Email."; 
 	} 

	// address
	if ($("#Address").val().trim() == ""){ 
 	return "Insert Address."; 
 	}
 	
 	// Birthday
	if ($("#Birthdate").val().trim() == ""){ 
 	return "Insert Birth date."; 
 	}

 
}
 	 