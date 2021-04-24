package model;

import java.sql.*;

public class Byer {
	
	//A common method to connect to the DB
	public Connection connect() {
		
		Connection con = null;
		
		try{
		 Class.forName("com.mysql.jdbc.Driver");
		 
		//Provide the correct details: DBServer/DBName
		 
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/paf", "root", "");
		  
			
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		 
		return con;

}
	//insert
	public String insertbuyerservice(String FullName, String PhoneNumber, String Email, String Address, String Birthdate)
	 {
		String output = "";
		 try{
		 Connection con = connect();
		 
		 if (con == null){
			 return "Error while connecting to the database for inserting."; 
		 }
		// create a prepared statement
		 String query = " INSERT INTO `buyerservice`(`ID`, `FullName`, `PhoneNumber`, `Email`, `Address`, `Birthdate`) VALUES (?,?,?,?,?,?)";
		 
		 
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		// binding values
		 
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, FullName);
		 preparedStmt.setString(3, PhoneNumber);
		 preparedStmt.setString(4, Email);
		 preparedStmt.setString(5, Address); 
		 preparedStmt.setString(6, Birthdate);
		 
		// execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Inserted successfully";
		 }
		 
		 catch (Exception e){
		 output = "Error while inserting the item.";
		 System.err.println(e.getMessage());
		 }
		 
		 return output;
		 
		 }
	public String readItems() {
	 String output = "";
	 
	 try{
	 Connection con = connect();
	 if (con == null){
		 return "Error while connecting to the database for reading.";
		 }
	// Prepare the html table to be displayed
	 
	 output = "<table border='1'><tr><th>Full_Name</th>"
	 		+ "<th>PhoneNumber</th>"
	 		+ "<th>Email</th>"
	 		+ "<th>Address</th>"
	 		+ "<th>Birthdate</th>"
	 		+" <th>Update</th>"
	 		+ "<th>Delete</th></tr>";
	 
	 String query = "select * from buyerservice";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 
	// iterate through the rows in the result set
	 while (rs.next()) {
		 String ID = Integer.toString(rs.getInt("ID"));
	 	 String FullName = rs.getString("FullName");
	 	 String PhoneNumber = rs.getString("PhoneNumber");
	 	 String Email = rs.getString("Email");
	 	 String Address = rs.getString("Address");
	 	 String Birthdate = rs.getString("Birthdate");
	 	 
	 	 
	 	// Add into the html table
	 	 
	 	 output += "<td>" + FullName + "</td>";
	 	 output += "<td>" + PhoneNumber + "</td>";
	 	 output += "<td>" + Email + "</td>"; 
	 	 output += "<td>" + Address + "</td>";
	 	 output += "<td>" + Birthdate + "</td>";
	 	 
	 	// buttons
	 	 
	 	output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
	 			 + "<td><form method='post' action='items.jsp'>"
	 			 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
	 			 + "<input name='ID' type='hidden' value='" + ID + "'>" + "</form></td></tr>";
	 	
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 
	 }
	
	catch (Exception e){
		output = "Error while reading the items.";
		System.err.println(e.getMessage());
	}
	return output;
		 
	}

	//update
	public String updatebuyerservice(String ID, String FullName, String PhoneNumber, String Email, String Address, String Birthdate) 
	{
	 
	 String output = "";
	 try{
	 Connection con = connect();
	 if (con == null){
		 return "Error while connecting to the database for updating."; 
		 }
	 
	// create a prepared statement
	 String query = "UPDATE buyerservice SET FullName =?, PhoneNumber=?, Email=?, Address =?, Birthdate =? WHERE ID= ?";
	 // String query = "UPDATE buyerservice SET FullName=?,PhoneNumber=?,Email=?,Address=?,Birthdate=?  WHERE ID=?";
			 		
		PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	// binding values
	 preparedStmt.setString(1, FullName);
	 preparedStmt.setString(2, PhoneNumber);
	 preparedStmt.setString(3, Email);
	 preparedStmt.setString(4, Address);
	 preparedStmt.setString(5, Birthdate);
	 preparedStmt.setInt(6, Integer.parseInt(ID));	
	 
	 
	// execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 
	catch (Exception e){
		
	 output = "Error while updating the item.";
	 System.err.println(e.getMessage());
	 
	 }
	 
	return output;
	}
	
	//delete
	public String deletebuyerservice(String ID){

	String output = "";

	try{
		Connection con = connect();
		if (con == null) {
			return "Error while connecting to the database for deleting."; 
			}
		
		// create a prepared statement
		 String query = "delete from buyerservice where ID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(ID));
		
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
		  

		
	}
	catch(Exception e){
		
		output = "Error while deleting the item.";
		 System.err.println(e.getMessage()); 

}
	return output;
	}
}