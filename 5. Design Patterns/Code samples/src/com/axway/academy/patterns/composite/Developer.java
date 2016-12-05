package com.axway.academy.patterns.composite;

/**
 * A developer object definition.
 * 
 * @author aandreev
 *
 */
public class Developer implements   Employee{

	@Override
	public void printSalary() {
		System.out.println("I am a developer - 2lv");
		
	}

}
