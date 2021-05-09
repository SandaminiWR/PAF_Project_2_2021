package com;

import java.io.IOException;
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

	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
