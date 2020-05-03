package com.ibm.training;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookCatalogItem {

	@Id
	int id;
	String name, description;

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


}
