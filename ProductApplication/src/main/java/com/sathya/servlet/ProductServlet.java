package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	                                                                                                                                                    
    public ProductServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Step-1:-Read the requested data
		int proId=Integer.parseInt(request.getParameter("proId"));
		 String proName=request.getParameter("proName");
		 Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		 int  proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		  Double totalBill =Double.parseDouble(request.getParameter("proPrice"))*Double.parseDouble(request.getParameter("proQuantity"));
		  Double discount=0.0;
		  Double netPrice=0.0;
		  //Step-2 Process the data
		  if(totalBill<1000)
		  {
			  discount=0.0;
		  }
		  else if(totalBill>1000 && totalBill<5000)
		  {
			  discount=(5*totalBill)/100;
		  }
		  else if(totalBill>5000 && totalBill<10000)
		  {
			  discount=0.01*totalBill;
		  }
		  
		  else if(totalBill>10000)
		  {
			  discount=(15*totalBill)/100;
		  }
		  netPrice=totalBill-discount;
		  
		  //Step-3:-Render the response
		  response.setContentType("text/html");
		  PrintWriter writer=response.getWriter();
		  writer.println("<html>");
		  writer.println("<body bgcolor=pink");
		  writer.println("<h1><b>product Bill Invoice:</b></h1>");
		  writer.println("<p><i>productId:</i>"+proId);
		  writer.println("<p><i>productName:</i>"+proName);
		  writer.println("<p><i>productPrice:</i>"+proPrice);
		  writer.println("<p><i>productQuantity:</i>"+proQuantity);
		  writer.println("<p><i>TotalBill:</i>"+totalBill);
		  writer.println("<p><i>Discount:</i>"+discount);
		  writer.println("<p><i>NetPrice:</i>"+netPrice);
		  writer.println("</body>");
		  writer.println("</html>");
	}
}















package com.sathya.propro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

public  int save(Product pro){
	int count1=0;
Connection connect=null;
PreparedStatement pps=null;	
	try {
	connect=Databasepro.createConnection();
    pps=connect.prepareStatement("insert into product values(?,??,?,?,?,?,?,?,?)");
	
pps.setString(1, pro.getProId());
pps.setString(2,pro.getProName());
pps.setDouble(3,pro.getProPrice());
pps.setString(4,pro.getProBrand());
pps.setString(5,pro.getProMadeIn());
pps.setDate(6,pro.getManufacture());
pps.setDate(7,pro.getExpiry());
pps.setBytes(8,pro.getProImage());
pps.setBytes(9,pro.getProAudio());
pps.setBytes(10,pro.getProVideo());


count1= pps.executeUpdate();
	}
catch(SQLException e)
{
	e.printStackTrace();
}
	finally {
		
		if(connect!=null)
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	return count1;
}
public List<Product> findAll() throws SQLException
{
	List<Product> products =new ArrayList<Product>();
	  
	try(Connection connect=Databasepro.createConnection(); 
			Statement statement=connect.createStatement()) 
	{
	ResultSet rs=statement.executeQuery("select * from product");
	while(rs.next())
	{
		 Product product=new Product();
		product.setProId(rs.getString("proId"));
		product.setProName(rs.getString("ProName"));		
		product.setProPrice(rs.getDouble("ProPrice"));
		product.setProBrand(rs.getString("proBrand"));
		product.setProMadeIn(rs.getString("proMadeIn"));
		product.setManufacture(rs.getDate("Manufacture"));
		product.setExpiry(rs.getDate("Expiry"));
		product.setProImage(rs.getBytes("proImage"));
		product.setProAudio(rs.getBytes("proAudio"));
		product.setProVideo(rs.getBytes("proVideo"));
		
		products.add(product);
	}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return products;
}
public int deleteById(String id) 
{
	int count=0;
	try(Connection connect=Databasepro.createConnection();
			PreparedStatement pps=connect.prepareStatement("delete from Product where proId=?"))
	{
	pps.setString(1, id);
	count=pps.executeUpdate();
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return count;
}
public Product findById(String proId)
{
	Product product=null;
	Connection connect=null;
	PreparedStatement pps=null;
	try {
		connect=Databasepro.createConnection();
		pps=connect.prepareStatement("select * from Product where proId=?");
		
		pps.setString(1, proId);
		
		ResultSet rs=pps.executeQuery();
		
		while(rs.next())
		{
			 product=new Product();
			product.setProId(rs.getString("proId"));
			product.setProName(rs.getString("ProName"));		
			product.setProPrice(rs.getDouble("ProPrice"));
			product.setProBrand(rs.getString("proBrand"));
			product.setProMadeIn(rs.getString("proMadeIn"));
			product.setManufacture(rs.getDate("Manufacture"));
			product.setExpiry(rs.getDate("Expiry"));
			product.setProImage(rs.getBytes("proImage"));
			product.setProAudio(rs.getBytes("proAudio"));
			product.setProVideo(rs.getBytes("proVideo"));
			
		}
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	return product;
}
public int findById(Product product)
{
	
	String sql="UPDATE Product SET    proName=?,ProPrice=?,ProBrand=?,Manufacture=?,Expiry=?,proImage=? WHERE proId=?,proAudio=?,proVideo=?";
			int updateResult=0;
		try(Connection connect=Databasepro.createConnection();
			PreparedStatement pps=connect.prepareStatement(sql))
				{
			Product pro=new Product();
			pps.setString(1,pro.getProName());
			pps.setDouble(2,pro.getProPrice());
			pps.setString(3,pro.getProBrand());
			pps.setString(4,pro.getProMadeIn());
			pps.setDate(5,pro.getManufacture());
			pps.setDate(6,pro.getExpiry());
			pps.setBytes(7,pro.getProImage());
			pps.setString(8,pro.getProId());
			pps.setBytes(9,pro.getProAudio());
			pps.setBytes(10,pro.getProVideo());
			updateResult = pps.executeUpdate();
			
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return updateResult;		
}



}

		 
