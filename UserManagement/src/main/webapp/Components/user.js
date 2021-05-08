/**
 * 
 */

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
 $("#formUser").submit() ; 
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidUserIDSave").val($(this).closest("tr").find('#hidUserIDUpdate').val()); 
 $("#name").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#phone").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#address").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#mail").val($(this).closest("tr").find('td:eq(4)').text()); 
 $("#password").val($(this).closest("tr").find('td:eq(5)').text()); 
 $("#confirmpassword").val($(this).closest("tr").find('td:eq(6)').text()); 
});

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


