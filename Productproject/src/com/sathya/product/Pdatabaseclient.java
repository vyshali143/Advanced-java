package com.sathya.product;

import java.sql.SQLException;

public class Pdatabaseclient {
	public static void main(String args[]) throws SQLException {
	Productdao productdao=new Productdao();
	int pro=productdao.save(new Product(1001,"vyshali",116));
	System.out.println("Data inserted successfully...."+pro);
	
	int pro1=productdao.save(new Product(1002,"kanna",118));
	System.out.println("Data inserted successfully...."+pro1);
	Product pr=Productdao.findById(1001);
	System.out.println(pr);
	Product pr1=Productdao.findById(1003);
	System.out.println(pr1);
	
}
}