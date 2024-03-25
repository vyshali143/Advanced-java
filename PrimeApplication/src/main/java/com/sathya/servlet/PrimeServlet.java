package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrimeServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start=Integer.parseInt(request.getParameter("Enter First Number"));
		int end=Integer.parseInt(request.getParameter("Enter Second Number"));
		String operation=request.getParameter("operation");
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		switch(operation)
		{
		case "Even":
		for(int i=start;i<=end;i++)
		{
		if(i%2==0)
			a.add(i);
		} 
		break;
	    case "odd" :
		   for(int i=start;i<=end;i++)
		   {
		    if(i%2==1)
		     a.add(i);
		   }
		}
		   response.setContentType("text/html");
	        PrintWriter writer = response.getWriter();
	        writer.println("<html>");
	        writer.println("<body>");
	        writer.println("<p>Enter First Number:"+start+"</p>");
	        writer.println("<p>Enter Second Number:"+end+"</p>");
	        writer.println("<p>your operation Symbol:"+operation+ "</p>");
	        writer.println("<p>Your Result:"+a+"</p>");
	        writer.println("</body>");
	        writer.println("</html>");
	}
}