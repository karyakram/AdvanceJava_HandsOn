package com.org.gen.day15.que1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{  
			  
		    response.setContentType("text/html");  
		    PrintWriter pw = response.getWriter();  
		    String id = request.getParameter("uid"); 
		    
		    if(id.equals("123")) {
		    pw.print("Welcome "+"User");  
		 
		    //creating cookie
		   Cookie c = new Cookie("uid",id);
		 //adding cookie in response
		   response.addCookie(c);  
		   
		    //creating submit button  
		    pw.print("<form action='servlet2' method='post'>");  
		    pw.print("<input type='submit' value='OK'>");  
		    pw.print("</form>"); 
		    }
		    else {
		    	pw.println("MyServlet1");
		    }
		     
		    pw.close();
		        }catch(Exception e) {
		        	e.printStackTrace();
	 
		  }  

	}

}
