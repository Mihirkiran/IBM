package com.ibm.eis.bean;

public class Employee {
	int id, salary;
	String name, designation, scheme;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	@Override
	public String toString() {
		return "Name: " + this.name + "\n" + 
				"Salary: " + this.salary + "\n" +
				"Designation: " + this.designation + "\n" +
				"Scheme: " + this.scheme;
	}
}
