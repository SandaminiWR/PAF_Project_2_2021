package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Role;

@Path("/Role")
public class RollService {
	
	Role role  = new Role();
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readUser() 
	 { 
	 return role.readRole(); 
	 }
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)

public String insertrole
		(@FormParam("id") String id,
		@FormParam("name") String name, 
		 @FormParam("description") String des 
		)
		{
	String output = role.insertRole(id,name, des);
		return output;
		}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)

public String updaterole(String userData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject roleObj = new JsonParser().parse(userData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String RoleID = roleObj.get("id").getAsString(); 
		 String userName = roleObj.get("name").getAsString(); 
		 String description = roleObj.get("description").getAsString(); 
		
		 String output = role.updateRole(RoleID, userName, description);
		return output; 
	}

	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	
public String deleterole(String userData) 
	{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <ID>
		 String RoleID = doc.select("id").text(); 
		 String output = role.deleteRole(RoleID); 
		return output; 
	}
	
}
