package com.ibm.eis.service;

import com.ibm.eis.bean.*;

public interface EmployeeServiceInterface {
	public void add(int id, String name, int salary);
	public void findScheme(int id);
	public Employee displayEmployee(int id);
}
