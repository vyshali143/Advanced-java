package com.sathya.jdbc;

public class Employee1 {
	int EmpId;
	String EmpName;
	double EmpSalary;
	private double empSalary;
	public Employee1(int empId, String empName, int i) {
		super();
		this.EmpId = empId;
		this.EmpName = empName;
		this.EmpSalary = empSalary;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public Double getEmpSalary() {
		return EmpSalary;
	}
	public void setEmpSalary(Double empSalary) {
		EmpSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpSalary=" + EmpSalary + "]";
	}
	public Employee1() {
	}
	}
	

