package com.sathya.jdbc;

import java.sql.SQLException;
import java.util.List;

public class DataBaseClient 
{
	public static void main(String args[]) throws SQLException
	{
		EmployeeDao employeeDao=new EmployeeDao();
		int res1=employeeDao.save(new Employee1(1001,"vyshali",116));
		System.out.println("Data inserted successfully...."+res1);
		
		int res2=employeeDao.save(new Employee1(1002,"kanna",118));
		System.out.println("Data inserted successfully...."+res2);
		
		//Reading the data from Database
		Employee1 emp=employeeDao.findById(1001);
		System.out.println(emp);
		
		Employee1 emp1=employeeDao.findById(1003);
		System.out.println(emp1);
	
		//Deleting record from DataBase based on Id
		int deleteCount=employeeDao.deleteById(1001);
		if(deleteCount==1)
			System.out.println("Data Deleted Successfully....");
		else
			System.out.println("Data Deletion fail...");

		//Deleting records based on salary
		int deletecount=employeeDao.deleteBySalary(25000);
		System.out.println(deletecount+"records deleted Successfully.....");
	//Display all records
	List<Employee1> l=employeeDao.findAll();
	l.forEach(e->System.out.println(e));
	}

}
