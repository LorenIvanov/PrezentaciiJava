package com.axway.academy.patterns.factory;

/**
 * Hello World from Space.
 * 
 * @author aandreev
 *
 */
public class HelloWorldSpace implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Hello from outer space.");
		
	}

}
