package com.sathya.project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasepro {
	public static Connection createConnection(){
	Connection connect=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connect=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vyshali","welcome");
		}
	catch(ClassNotFoundException| SQLException e)
	{
		e.printStackTrace();
	}
	return connect;
}
}


     
	


