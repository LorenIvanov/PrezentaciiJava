package com.axway.academy.patterns.composite;

/**
 * Test Composite pattern.
 * Used for hierarchical representation of objects. This is a powerful mechanism when the same
 * method needs to be executed for a huge amount of identical objects.
 * 
 * @author aandreev
 *
 */
public class CompositePatternSample {

	public static void main(String[] args) {
		
		// creating different objects
		Employee dev1 = new Developer();
		Employee dev2  = new Developer();
		Employee dev3 = new Developer();
		Manager manager = new Manager();
		Manager  grandManager  = new  Manager();
		
		// add developers as part of the manager
		manager.addEmployee(dev1);
		manager.addEmployee(dev2);
		
		// add employees as part of the grand manager
		grandManager.addEmployee(manager);
		grandManager.addEmployee(dev3);
		
		// test the composite objects structure by invoking a method
		System.out.println("=======Grand Manager Start=======");
		grandManager.printSalary();
		System.out.println("=======Grand Manager End=======");
		System.out.println();
		System.out.println("=======Manager Start=======");
		manager.printSalary();	
		System.out.println("=======Manager End=======");

	}

}
