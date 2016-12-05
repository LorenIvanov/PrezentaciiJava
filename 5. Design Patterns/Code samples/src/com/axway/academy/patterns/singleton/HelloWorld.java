package com.axway.academy.patterns.singleton;

/**
 * Testing the usage of Singleton design pattern.
 * Only one instance of the HelloWorldSingleton can be created.
 * 
 * @author aandreev
 *
 */
public class HelloWorld {

	public static void main(String[] args) {

		HelloWorldSingleton hw = HelloWorldSingleton.getInstance();
		hw.sayHello();

	}

}
