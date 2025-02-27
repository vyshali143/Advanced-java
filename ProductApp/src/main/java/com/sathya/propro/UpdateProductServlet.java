
package com.sathya.propro;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public UpdateProductServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updatedproId=request.getParameter("proId");
		String updatedproName=request.getParameter("ProName");
		
		double updatedproPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updatedproBrand=request.getParameter("proBrand");
		
		String updatedproMadeIn=request.getParameter("proMadeIn");
		Date updatedManufacture=Date.valueOf(request.getParameter("Manufacture"));
		Date updatedExpire=Date.valueOf(request.getParameter("Expiry"));
		
		
		
		Product pro=new Product();
		pro.setProId(updatedproId);
		pro.setProName(updatedproName);
		pro.setProPrice(updatedproPrice);
		pro.setProBrand(updatedproBrand);
		pro.setProMadeIn(updatedproMadeIn);
		pro.setManufacture(updatedManufacture);
		pro.setExpiry(updatedExpire);
		
		
		
		Part filePart=request.getPart("newProImage");//new page is the name of your file input field
		if(filePart!= null && filePart.getSize()>0) {
			InputStream inputStream=filePart.getInputStream();
			byte[] newProImageData =IOUtils.toByteArray(inputStream);
			pro.setProImage(newProImageData);
		}
		else 
		{
			String s=request.getParameter("existingProImage");
			byte[] existingProImage =Base64.getDecoder().decode(s);
			pro.setProImage(existingProImage);
		}
		
		Part filePart1=request.getPart("newProAudio");//new page is the name of your file input field
		if(filePart1 !=null && filePart1.getSize()>0) {
			InputStream inputStream=filePart1.getInputStream();
			byte[] newProAudioData =IOUtils.toByteArray(inputStream);
			pro.setProAudio(newProAudioData);
		}
		else 
		{
			String s=request.getParameter("existingProAudio");
			byte[] existingProAudio =Base64.getDecoder().decode(s);
			
			pro.setProImage(existingProAudio);
		}
		
		Part filePart2=request.getPart("newProVideo");//new page is the name of your file input field
		if(filePart2 !=null && filePart2.getSize()>0) {
			InputStream inputStream=filePart2.getInputStream();
			byte[] newProVideoData =IOUtils.toByteArray(inputStream);
			pro.setProVideo(newProVideoData);
		}
		else 
		{
			String s=request.getParameter("existingProVideo");
			byte[] existingProVideo =Base64.getDecoder().decode(s);
			pro.setProVideo(existingProVideo);
		}
		ProductDao dao=new ProductDao();
		int result=dao.updateById(pro);
		
		if(result==1)
		{
			RequestDispatcher dsp=request.getRequestDispatcher("Product.jsp");
			dsp.forward(request,response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data Updation failed check once...........");
			
			RequestDispatcher dsp=request.getRequestDispatcher("EditProductt.jsp");
			dsp.include(request,response);
			
		}
		
	}

}
