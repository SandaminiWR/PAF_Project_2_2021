package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemsAPI
 */
@WebServlet("/ItemsAPI")
public class ItemsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Item itemObj = new Item();
	
	
    public ItemsAPI() {
        super();
        
    }

    
	// Read Operation
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Not Used
	}

	
	
	// Insert Operation
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String output = itemObj.insertItem(request.getParameter("itemCode"), 
									       request.getParameter("itemCategory"), 
									       request.getParameter("itemName"), 
								           request.getParameter("itemBrand"), 
								           request.getParameter("itemDesc"), 
								           request.getParameter("itemPrice")); 

		response.getWriter().write(output);	
		
	}

	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		
	}

	
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
		Map<String, String> map = new HashMap<String, String>(); 
		try
		{ 
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
				String queryString = scanner.hasNext() ? 
						             scanner.useDelimiter("\\A").next() : ""; 
				
			    scanner.close(); 
			    
			    String[] params = queryString.split("&"); 
			    for (String param : params) 
			   { 
					String[] p = param.split("=");
			    	map.put(p[0], p[1]); 
			   } 
		 } 
		 catch (Exception e) 
		 { 
		 } 
		
		 return map; 
	}
	
	
}
