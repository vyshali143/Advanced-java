package com.sathya.Batch1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {
			
	    	public static void main(String args[])throws ClassNotFoundException,SQLException{
	    		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vyshali","welcome");
			
		    Statement statement=connection.createStatement();
		    statement.addBatch("create table stu(id number,name varchar2(20))");
		    statement.addBatch("insert into stu values(111,'ratan')");
		    statement.addBatch("insert into stu values(222,'anu')");
		    statement.addBatch("delete from stu where id in(111,222)");
		    statement.addBatch("drop table stu");
		    int[] results= statement.executeBatch();
		    for(int result :results)
		    	System.out.println(result);
		connection.close();
	}	    
}




