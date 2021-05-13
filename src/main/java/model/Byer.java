package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Byer {
	
	//A common method to connect to the DB
private Connection connect(){

			
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		 
			//Provide the correct details: DBServer/DBName
		 
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/paf", "root", "");
			System.out.print("Successfully Connected");
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		 
			return con;

}
	
	//read
public String readBuyer(){
	
	String output = "";
	try{
				 
		Connection con = connect();
		if (con == null)
		{
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
		while (rs.next()){
			String ID = Integer.toString(rs.getInt("ID"));
			String FullName = rs.getString("FullName");
			String PhoneNumber = rs.getString("PhoneNumber");
			String Email = rs.getString("Email");
			String Address = rs.getString("Address");
			String Birthdate = rs.getString("Birthdate");
	 
	 
			// Add into the html table
			output += "<tr><td><input id='hidBuyerIDUpdate' name='hidBuyerIDUpdate' type='hidden' value='" + ID + "'>" + FullName + "</td>";
			output += "<td>" + PhoneNumber + "</td>";
			output += "<td>" + Email + "</td>"; 
			output += "<td>" + Address + "</td>";
			output += "<td>" + Birthdate + "</td>";
			
			
	 
			// buttons
			output += "<td><input name='btnUpdate' type='button' value='Update' class='btnupdate btn btn-secondary'>data-ID='" + ID +"'></td>"
				   + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-ID='" + ID + "'></td></tr>";
	
	
	
	
		}
		con.close();
			// Complete the html table
	 		output += "</table>";
	 	}


		catch (Exception e){
			output = "Error while reading the Details.";
			System.err.println(e.getMessage());
		}
	return output;
	 
}

//insert
public String insertbuyer(String FullName, String PhoneNumber, String Email, String Address, String Birthdate){
	
		String output = "";
		
		 try{
			 Connection con = connect();
			 
			 if (con == null)
			 {
				 return "Error while connecting to the database for inserting."; 
			 }
			 
			 
			 // create a prepared statement
			 String query = " INSERT INTO buyerservice(`ID`, `FullName`, `PhoneNumber`, `Email`, `Address`, `Birthdate`)"+" VALUES (?,?,?,?,?,?)";
		 
		 
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
			 
			 String newBuyer = readBuyer(); 
			 output = "{\"status\":\"success\", \"data\": \"" + newBuyer + "\"}"; 
		 	 
		 }catch (Exception e){
			 
			 output = "{\"status\":\"error\", \"data\": \"Error while inserting the Details.\"}";
			 System.err.println(e.getMessage());
		  }
		 
		  return output;
		 
}
	

	//update
public String updatebuyer(String ID, String FullName, String PhoneNumber, String Email, String Address, String Birthdate){
	 
	 String output = "";
	 try{
		 Connection con = connect();
		 if (con == null)
		 {
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
		 
		 String newbuyer = readBuyer();
		 output = "{\"status\":\"success\", \"data\": \"" + newbuyer + "\"}";
		 //output = "Updated successfully";
	 		
	 }catch (Exception e){
		
		 //output = "Error while updating the Details.";
		 output = "{\"status\":\"error\", \"data\": \"Error while updating the Details.\"}";
		 System.err.println(e.getMessage());
	 }
	 
	return output;
}
	
	//delete
public String deletebuyer(String ID){

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
		 //output = "Deleted successfully";
		 String newbuyer = readBuyer();
		 output = "{\"status\":\"success\", \"data\": \"" + newbuyer + "\"}";

		
	}catch(Exception e){
		
		//output = "Error while deleting the Details.";
		output = "{\"status\":\"error\", \"data\": \"Error while deleting the Details.\"}"; 
		System.err.println(e.getMessage()); 

	}
	return output;
}
}

