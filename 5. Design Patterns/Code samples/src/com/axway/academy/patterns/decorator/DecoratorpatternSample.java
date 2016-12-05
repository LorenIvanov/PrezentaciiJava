package com.axway.academy.patterns.decorator;

/**
 * Test Decorator pattern.
 * The pattern is used when there is a need for assigning new functionality to already existing object definitions
 * dynamically, without a need to modify them - changing methods, adding methods, etc.
 * 
 * @author aandreev
 *
 */
public class DecoratorpatternSample {

	public static void main(String[] args) {
		
		// create objects
		Manager  manager = new Manager();
		Developer dev = new Developer();
		
		// print their salaries
		manager.printSalary();
		dev.printSalary();
		
		// create a decorated object and print its salary
		YearlySalaryDecorator dev2 = new YearlySalaryDecorator(new Developer());
		dev2.printSalary();

	}

}
