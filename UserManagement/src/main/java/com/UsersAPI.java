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


@WebServlet("/UsersAPI")
public class UsersAPI extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	User userObj = new User();
	
    public UsersAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = userObj.insertUser(request.getParameter("name"),
								request.getParameter("phone"),
								request.getParameter("address"),
								request.getParameter("mail"),
								request.getParameter("password"),
								request.getParameter("confirmpassword"));

		response.getWriter().write(output);
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

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		
	{ 
			 Map paras = getParasMap(request); 
			 
			 String output = userObj.updateUser(paras.get("hidUserIDSave").toString(), 
					 			paras.get("name").toString(), 
					 			paras.get("phone").toString(), 
					 			paras.get("address").toString(),
					 			paras.get("mail").toString(), 
					 			paras.get("password").toString(),
					 			paras.get("confirmpassword").toString()); 
			
			 response.getWriter().write(output); 
			
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		
	{
		 Map paras = getParasMap(request); 
		
		 String output = userObj.deleteUser(paras.get("id").toString()); 
		
		 response.getWriter().write(output);
	}
	

}
