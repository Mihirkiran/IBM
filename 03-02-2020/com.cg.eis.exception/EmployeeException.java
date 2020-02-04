package com.cg.eis.exception;

class EmployeeException extends Exception{
	void PrintMessage(){
		System.out.println("Salary less than 3000!!!");
	}
}