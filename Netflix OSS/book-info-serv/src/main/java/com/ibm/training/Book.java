package com.ibm.training;

public class Book {

	String name, description;
	int id;

	public Book(String name, String description, int id) {
		this.name = name;
		this.description = description;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
