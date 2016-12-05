package com.axway.academy.patterns.decorator;

/**
 * A developer object definition.
 * 
 * @author aandreev
 *
 */
public class Developer implements Employee {

	@Override
	public void printSalary() {
		System.out.println("I am a developer. I earn 2lv a minute");
		
	}

}
