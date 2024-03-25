package com.sathya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Regiteraervlet")
public class Regiteraervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Regiteraervlet() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1:-Read the data	
		String username=request.getParameter("Username");
		String password=request.getParameter("password");
		String gender=request.getParameter("Gender");
		int number=Integer.parseInt(request.getParameter("Mobile"));
		String email=request.getParameter("Email");
		//Step-2:-Process the data
	
	}

}
