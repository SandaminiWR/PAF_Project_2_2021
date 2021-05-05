package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Role {

	
	public String insertRole(String id, String name, String description) 
	{
		
		String output="";
		
		try {
			
			Connection con = DBConnection.getConnection();
			
			if (con == null) 
			{ 
				return "Error while connecting to the database"; 
			}
		
		// create a prepared statement
		String query = " insert into role (`id`,`name`,`description`)"
		 + " values (?, ?, ?)"; 
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		// binding values
		
		
			try {
				preparedStmt.setInt(1, Integer.parseInt(id)); 
				preparedStmt.setString(2, name); 
				preparedStmt.setString(3, description);
				output = "Role Insert Successfull"; 
			}catch(Exception e){
				output = "please enter valid Data"; 
			}
			 
					
			//execute the statement
			preparedStmt.execute(); 
			//con.close();
			
		
		} 
		catch (Exception e) 
		{ 
			output = "Error while inserting"; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	
	
	
	public String readRole()
	{ 
		 String output = ""; 
		 
		 try {
				
				Connection con = DBConnection.getConnection();
				
				if (con == null) 
				{ 
					return "Error while connecting to the database"; 
				}
				
				// Prepare the html table to be displayed
				output = "<table border='1'>" 
				+ "<tr><th>Role ID</th><th>Name</th><th>Description</th></tr>";

				
				String query = "select * from role";
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query); 
				
				
				// iterate through the rows in the result set
				while (rs.next()) 
				{ 
					 String RoleID = Integer.toString(rs.getInt(1)); 
					 String roleName = rs.getString(2); 
					 String description = rs.getString(3);
					 
					// Add into the html table
					output += "<tr><td>" + RoleID + "</td>"; 
					output += "<td>" + roleName + "</td>"; 
					output += "<td>" + description + "</td>"; 
					 
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'></td>"
					 + "<td><form method='post' action='user.jsp'>"
							
					 + "<input name='btnRemove' type='submit' value='Remove'>"
					 + "<input name='rid' type='hidden' value='" + RoleID + "'>" 
					 + "</form></td></tr>"; 
				}
				
		 }catch (Exception e) 
		 { 
				output = "Error while Reading Data"; 
				System.err.println(e.getMessage()); 
		 } 
		 
		 
		 
		 return output; 
	}
	
	
	
	
	
	public String updateRole(String ID,String name, String description) 

	 {
		 String output = "";
		 try
		 {
			 Connection con = DBConnection.getConnection();
		 if (con == null)
		 	{return "Error while connecting to the database for updating.";
		 	
		 }
		 
		 // create a prepared statement
		 
			 
				 String query = "UPDATE role SET name=?,description=? WHERE id=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setString(1, name);
				 preparedStmt.setString(2, description);
				 preparedStmt.setInt(3, Integer.parseInt(ID));
				 // execute the statement
				 preparedStmt.execute();
				 //con.close();
				 output = "Updated Role successfully";
		
			
		 }
		 catch (Exception e)
		 {
			 output = "Error while updating the role.";
			 System.err.println(e.getMessage());
		 }
		 return output;
		 }


	public String deleteRole(String id)
	{ 
		 String output = ""; 
		try
		{ 
			Connection con = DBConnection.getConnection();
		
			if (con == null) { 
		      return "Error while connecting to the database for deleting."; 
		    } 
			
			// create a prepared statement
			String query = "delete from role where id=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id)); 
			 
			// execute the statement
			preparedStmt.execute(); 
			//con.close(); 
			output = "Deleted Role successfully";

		} 
		catch (Exception e) 
		{ 
		output = "Error while deleting the role."; 
		 System.err.println(e.getMessage()); 
		}
	
	 return output; 
	}
	
}
