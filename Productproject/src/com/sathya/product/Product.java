package com.sathya.product;

import java.io.InputStream;
import java.sql.Date;

public class Product {
int ProId;
String ProName;
double ProPrice;
public Product(int proId, String proName, double proPrice) {
	super();
	ProId = proId;
	ProName = proName;
	ProPrice = proPrice;
}
public int getProId() {
	return ProId;
}
public void setProId(int proId) {
	ProId = proId;
}
public String getProName() {
	return ProName;
}
public void setProName(String proName) {
	ProName = proName;
}
public double getProPrice() {
	return ProPrice;
}
public void setProPrice(double proPrice) {
	ProPrice = proPrice;
}
public InputStream getproImage() {
	// TODO Auto-generated method stub
	return null;
}
public Date getExpiry() {
	// TODO Auto-generated method stub
	return null;
}
public Date getManufacture() {
	// TODO Auto-generated method stub
	return null;
}
public String getProMadeIn() {
	// TODO Auto-generated method stub
	return null;
}
public String getProBrand() {
	// TODO Auto-generated method stub
	return null;
}

}
