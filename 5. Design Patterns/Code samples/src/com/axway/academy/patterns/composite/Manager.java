package com.axway.academy.patterns.composite;

import java.util.ArrayList;

/**
 * A manager object definition.
 * The manager contains a list of objects of the same type - Employee.
 * There should be methods for maintaining the list of employees - add, remove, create, etc.
 * 
 * @author aandreev
 *
 */
public class Manager implements Employee {
	
	/**
	 * List containing employees assigned to this manager.
	 */
	private ArrayList<Employee> list  =  new ArrayList<Employee>();

	@Override
	public void printSalary() {
		System.out.println("Ho ho ho - 10lv");
		System.out.println("I have " + list.size() + "people assigned to me.");
		
		// an example how to use the list of employees and execute a method for the complete group
		for (Employee e : list) {
			e.printSalary();
		}
		System.out.println("No more people assigned to me");
	}
	
	/**
	 * Adds an employee to the list.
	 * 
	 * @param e - employee
	 */
	public void addEmployee(Employee e)  {
		list.add(e);
	}

}
