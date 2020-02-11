package com.ibm.eis.dao;

import java.util.*;
import com.ibm.eis.bean.*;
//import com.ibm.eis.service.*;

public class EmployeeDatabase implements EmployeeDatabaseInterface {
	ArrayList<Employee> arr = new ArrayList<Employee>();
	public void storeIntoList(Employee e) {
		arr.add(e);
//		System.out.println(arr);
	}
	public Employee displayEmployee(int id) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getId() == id) {
//				System.out.println(arr.get(i));
				return arr.get(i);
			}
		}
		return null;	
	}
}
