package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Jdbcex1 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		//Step-1: load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded successfully...........");
		//Step-2:  create the  mconnection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:Xe","vyshali","welcome");
		System.out.println("Driver connected successfully...........");
		//step-4: close the resourses 
		connection.close();
		System.out.println("Driver closed successfully...........");
	}
}
