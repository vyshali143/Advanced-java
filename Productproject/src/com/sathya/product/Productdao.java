package com.sathya.product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
public class Productdao {

public  int save (Product pro) throws SQLException  {
	int count=0;
Connection connect=null;
PreparedStatement pps=null;
	try {

	connect=Pdbonnection.createConnection1();
    pps=connect.prepareStatement("insert into pro values(?,?,?,?,?,?,?,?)");
	
pps.setInt(1, pro.getProId());
pps.setString(2,pro.getProName());
pps.setDouble(3,pro.getProPrice());
pps.setString(4,pro.getProBrand());
pps.setString(5,pro.getProMadeIn());
pps.setDate(6,pro.getManufacture());
pps.setDate(7,pro.getExpiry());
pps.setBinaryStream(8,pro.getproImage());

int count1= pps.executeUpdate();
	}
catch(SQLException e)
{
	e.printStackTrace();
}
	finally {
		
		if(connect!=null)
			connect.close();
		
		
		if(pps!=null)
			pps.close();
	}
	return count;
}


}
