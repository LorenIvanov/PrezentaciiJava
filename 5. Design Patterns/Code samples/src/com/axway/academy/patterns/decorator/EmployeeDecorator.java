package com.axway.academy.patterns.decorator;

/**
 * Employee decorator object definition.
 * The purpose of this class is to decorate the object.
 * It needs access to the object that will be decorated and describes the modification that will be made.
 * 
 * This class is an abstract but this is not mandatory. It is added for additional level of abstraction
 * in case there are multiple decorators sharing a same additional functionality.
 * Although it may not be needed in a certain case it is good to stick to the actual pattern
 * because systems change and there is no guarantee that such an abstract class will not be needed later.
 * 
 * @author aandreev
 *
 */
public abstract class EmployeeDecorator implements  Employee {
	
	/**
	 * Decorated object.
	 */
	protected Employee e;
	
	/**
	 * Constructor.
	 * 
	 * @param e - decorated object
	 */
	public EmployeeDecorator(Employee e) {
		this.e = e;
	}
	
	/**
	 * Prints the salary.
	 */
	public void printSalary() {
		System.out.println("I am just going to sit here unless someone really needs me.");
	}

}
