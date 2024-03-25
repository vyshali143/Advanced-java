package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public int save (Employee1 emp) throws SQLException {
//Declare the Resources
	Connection connection =null;
	PreparedStatement preparedStatement=null;
	int count=0 ;
	try 
	{
		//get the connection
		connection=DbConnection.createConnection();
	//create the ps object
			preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
	//Read the data from emp object and set to parameters
			preparedStatement.setInt(1,emp.getEmpId());
			preparedStatement.setString(2,emp.getEmpName());
			preparedStatement.setDouble(3,emp.getEmpSalary());
			count =preparedStatement.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally {
		//before release connection check the connection present or not.
		if(connection!=null)
			connection.close();
		if(preparedStatement!=null)
			preparedStatement.close();
	}
	return count;
}
public Employee1 findById(int empId)
{
	Employee1 Employee=null;
	//try with resources: once the try block is connected the resources automatically closed.
	try(Connection connection=DbConnection.createConnection();
			PreparedStatement preParedStatement=connection.prepareStatement("select*from emp where empId=?"))
					{
				//set the data to parameter
				preParedStatement.setInt(1,empId);
				//execute the query
				ResultSet resultSet=preParedStatement.executeQuery();
				//If the record is present execute below code,if the record is not present it returns null.
				if(resultSet.next()) {
					//reading the data from result set setting to Employee
					Employee =new Employee1();
					Employee.setEmpId(resultSet.getInt(1));
					Employee.setEmpName(resultSet.getString(2));
					Employee.setEmpSalary(resultSet.getDouble(3));
				}
					}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return Employee;
}
public int deleteById(int EmpId)
{
	int count1=0;
	try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empId=?"))
	{	
				//set the data to parameter
				preparedStatement.setInt(1,EmpId);
			count1=preparedStatement.executeUpdate();
}
catch(SQLException e)
{
	e.printStackTrace();
}
	return count1;
}
public int deleteBySalary(double empSalary) 
{
	int count=0;
	try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empSalary=?"))
	{	
				//set the data to parameter
				preparedStatement.setDouble(1,empSalary);
			 count=preparedStatement.executeUpdate();
}
catch(SQLException e)
{
	e.printStackTrace();
}
	return count;
	
}
public List<Employee1> findAll()
{
	List<Employee1> emps=new ArrayList<Employee1>();
	
	try(Connection connection=DbConnection.createConnection();
			Statement statement=connection.createStatement())
			{
				ResultSet resultSet=statement.executeQuery("select*from emp");
				Employee1 employee=new Employee1();
				while(resultSet.next())
				{
					employee.setEmpId(resultSet.getInt(1));
					employee.setEmpName(resultSet.getString(1));
					employee.setEmpSalary(resultSet.getDouble(1));
					emps.add(employee);
				}
			}
			catch(SQLException e)
	      {
	        	e.printStackTrace();
	      }
		return emps;
}	
}