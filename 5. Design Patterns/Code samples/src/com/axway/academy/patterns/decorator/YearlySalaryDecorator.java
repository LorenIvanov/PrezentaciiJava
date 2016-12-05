package com.axway.academy.patterns.decorator;

/**
 * Employee decorator describing the modified functionality.
 * This class should describe what the modification is.
 * 
 * @author aandreev
 *
 */
public class YearlySalaryDecorator extends EmployeeDecorator  {

	/**
	 * Constructor.
	 * 
	 * @param e - decorated object
	 */
	public YearlySalaryDecorator(Employee e) {
		super(e);
	}
	
	/**
	 * Prints the salary and uses the decorated object.
	 */
	public void printSalary()  {
		System.out.println("Before Decoration I earned:");
		e.printSalary();
		System.out.println("After decoration I earn:");
		System.out.println("100 000lv yearly.");
	}

}
