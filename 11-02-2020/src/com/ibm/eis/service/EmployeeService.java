package com.ibm.eis.service;

import com.ibm.eis.bean.Employee;
import com.ibm.eis.dao.EmployeeDatabase;

public class EmployeeService implements EmployeeServiceInterface{
	EmployeeDatabase empd = new EmployeeDatabase();
	public void add(int id, String name, int salary) {
		String d, s;
		if(salary >= 40000) {
			d = "Manager";
			s = "Scheme A";
		}
		else if(salary < 40000 && salary >= 20000) {
			s = "Scheme B";
			d = "Programmer";
		}
		else if(salary < 20000 && salary >= 5000) {
			d = "System Associate";
			s = "Scheme C";
		}
		else {
			d = "Clerk";
			s = "No Scheme";
		}
		Employee e = new Employee();
		e.setDesignation(d);
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		e.setScheme(s);
		empd.storeIntoList(e);
	}
	@Override
	public void findScheme(int id) {
		Employee emp1 = empd.displayEmployee(id);
		if(emp1 != null)
			System.out.println(emp1.getScheme());
		else
			System.out.println("Not Found!!!");
	}
	@Override
	public Employee displayEmployee(int id) {
		Employee emp = empd.displayEmployee(id);
		return emp;
	}
}
