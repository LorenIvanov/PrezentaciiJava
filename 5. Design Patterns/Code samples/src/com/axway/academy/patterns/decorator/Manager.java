package com.axway.academy.patterns.decorator;

/**
 * Manager object definition.
 * 
 * @author aandreev
 *
 */
public class Manager implements Employee {

	@Override
	public void printSalary() {
		System.out.println("I am a manager. I earn 10lv a minute");
		
	}

}