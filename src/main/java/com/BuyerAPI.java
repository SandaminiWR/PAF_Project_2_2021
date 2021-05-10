package com;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/BuyerAPI")
public class BuyerAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	Byer itemObj = new Byer();
	
    public BuyerAPI() {
        super();
        
    }
	
	

}
