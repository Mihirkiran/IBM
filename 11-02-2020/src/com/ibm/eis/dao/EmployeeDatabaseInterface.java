package com.ibm.eis.dao;

import com.ibm.eis.bean.*;

public interface EmployeeDatabaseInterface {
	
	void storeIntoList(Employee e);
	Employee displayEmployee(int id);
	
}