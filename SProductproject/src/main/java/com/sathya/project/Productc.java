package com.sathya.project;

import java.sql.Date;
public class Productc {
	private String proId;
	private String proName;
	private double ProPrice;
	private String ProBrand;
	
	private String ProMadeIn;
	private Date Manufacture;
	private Date Expiry;
	private byte[] ProImage;
	private byte[]ProAudio;
	private byte[] ProVideo;
	public Productc(String proId, String proName, double proPrice, String proBrand, String proMadeIn, Date manufacture,
			Date expiry, byte[] proImage, byte[] proAudio, byte[] proVideo) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.ProPrice = proPrice;
		this.ProBrand = proBrand;
		this.ProMadeIn = proMadeIn;
		this.Manufacture = manufacture;
		this.Expiry = expiry;
		this.ProImage = proImage;
		this.ProAudio = proAudio;
		this.ProVideo = proVideo;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return ProPrice;
	}
	public void setProPrice(double proPrice) {
		this.ProPrice = proPrice;
	}
	public String getProBrand() {
		return ProBrand;
	}
	public void setProBrand(String proBrand) {
		this.ProBrand = proBrand;
	}
	public String getProMadeIn() {
		return ProMadeIn;
	}
	public void setProMadeIn(String proMadeIn) {
		this.ProMadeIn = proMadeIn;
	}
	public Date getManufacture() {
		return Manufacture;
	}
	public void setManufacture(Date manufacture) {
		this.Manufacture = manufacture;
	}
	public Date getExpiry() {
		return Expiry;
	}
	public void setExpiry(Date expiry) {
		this.Expiry = expiry;
	}
	public byte[] getProImage() {
		return ProImage;
	}
	public void setProImage(byte[] proImage) {
		this.ProImage = proImage;
	}
	public byte[] getProAudio() {
		return ProAudio;
	}
	public void setProAudio(byte[] proAudio) {
		this.ProAudio = proAudio;
	}
	public byte[] getProVideo() {
		return ProVideo;
	}
	public void setProVideo(byte[] proVideo) {
		this.ProVideo = proVideo;
	}
	public Productc()
	{
		
	}
}



