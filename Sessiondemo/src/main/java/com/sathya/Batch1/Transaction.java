package com.sathya.Batch1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
public class Transaction {
public static void main(String args[]) {
	Connection conn=null;
	Statement state=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vyshali","welcome");
	state=conn.createStatement();
	conn.setAutoCommit(false);
	state.executeUpdate("insert into emp values(1003,'ashok',10000.45)");
	state.executeUpdate("insert into emp values(1005,'anil',20000.45)");
	state.executeUpdate("insert into emp values(1009,'anish',30000.45)");
	state.executeUpdate("delete from  emp values whereempid=1002");
	conn.commit();
	
	
	catch(ClassNotFoundException | SQlException e)
	{
		conn.rollback();
		 e.printStackTrace();
	}
	finally {
	if(state!=null)
		state.close();
	if(conn!=null)
		conn.close();
	}
	}