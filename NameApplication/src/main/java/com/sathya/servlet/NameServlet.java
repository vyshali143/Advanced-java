package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login1servlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public NameServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Firstname=request.getParameter("Firstname");
		String Middlename=request.getParameter("Middlename");
		String Lastname=request.getParameter("Lastname");
		
		String Fullname;
		     Fullname=Firstname+" "+Middlename+" "+Lastname;
		
					PrintWriter writer=response.getWriter();
					response.setContentType("text/html");
					writer.println("<html>");
					writer.println("<h1>your Fullname....</h1>"+Fullname);
					writer.println("</html>");
					
	}

}






















package com.sathya.propro;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/ProServlet")
@MultipartConfig
public class ProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ProServlet(){
    super();
    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				//read the data
				String proId=request.getParameter("proId");
				String proName=request.getParameter("ProName");
				double proPrice=Double.parseDouble(request.getParameter("proPrice"));
				String proBrand=request.getParameter("proBrand");
				String proMadeIn=request.getParameter("proMadeIn");
				Date Manufacture=Date.valueOf(request.getParameter("Manufacture"));
				Date Expire=Date.valueOf(request.getParameter("Expiry"));
				Part part=request.getPart("proImage");
				InputStream proImage=part.getInputStream();
				
				//conversion of InputStream into byte[]
				byte[] proImage1=IOUtils.toByteArray(proImage);
				
				//using above details create the product object
				Product pro=new Product();
				pro.setProId(proId);
				pro.setProName(proName);
				pro.setProPrice(proPrice);
				pro.setProBrand(proBrand);
				pro.setProMadeIn(proMadeIn);
				pro.setManufacture(Manufacture);
				pro.setExpiry(Expire);
				pro.setProImage(proImage1);
				
			    //Giving the product object to productdao layer
				ProductDao prod=new ProductDao();
				int result =prod.save(pro);
				
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("Data inserted sucessfully..........."+result);
					}
	
		}


function  validateForm()
{
	//Read the form data
	var proId=document.getElementbyId("proId").value;
	var proName=document.getElementbyId("proName").value;
	var proPrice=document.getElementbyId("proPrice").value;
	var proBrand=document.getElementbyId("proBrand").value;
	var proMadeIn=document.getElementById("proMadeIn").value;
     if(proId.trim()===""||proName.trim()===""||proPrice.trim()===""||proBrand.trim()===""||proMadeIn.trim==="")
	    {
		alert("All fields must be filled out");
		return false;
		}
		if(parseFloat(proPrice)<0)
		{
			alert("proPrice must be a non-negative value");
			return false;
		}
		if(proName.length >50||proBrand.length >50)
		{
			alert("product name and proBrand must be less than 50");
			return false;
		}
		//get the mfg & exp dates
		var proMfgDate =document.getElementById("Manufacture").value;
		var proExpDate =document.getElementById("Expiry").value;
	
	    //convert into date format
	    var manufacturingDateObj =new Date(proMfgDate);
	    var expiryDateObj =new Date(proExpDate);
	    
	    //check the validation of dates
	    if(manufacturingDateObj > expiryDateObj)
	    {
			alert("manufacturing date cannot be greater than expiry date.");
			return false;
		}
		return true;
}

