package com.ibm.eis.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
//import com.ibm.eis.bean.*;
import com.ibm.eis.service.*;

public class Main {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		EmployeeService es = new EmployeeService();
		while(true) {
			System.out.println("\n1. Add employee details\n2. Find insurance scheme\n3. Display details of an employee\nEnter your option: ");
			n = sc.nextInt();
			switch(n) {
			case 1:
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				System.out.println("Enter Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Salary: ");
				int salary = sc.nextInt();
				es.add(id, name, salary);
				break;
			case 2:
				System.out.println("Enter the ID of employee whose scheme is to be found: ");
				es.findScheme(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter ID of employee: ");
				int a = sc.nextInt();
				if(es.displayEmployee(a) != null)
					System.out.print(es.displayEmployee(a));
				else
					System.out.println("Not Found");
				break;
			default:
				System.out.println("Enter correct option!!!");
				break;
			}
		}
//		sc.close();
	}

}
