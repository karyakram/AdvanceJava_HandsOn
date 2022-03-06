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
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{  			  
		    response.setContentType("text/html");  
		    PrintWriter pw = response.getWriter();  
		      
		    Cookie c[]=request.getCookies();  
		    pw.print("Hello "+"User"+ " " + " Smile Please"); 
		    
		    pw.close();  
		  
		         }catch(Exception e){
		        	 e.printStackTrace();
		         }  
		    }  
	}


