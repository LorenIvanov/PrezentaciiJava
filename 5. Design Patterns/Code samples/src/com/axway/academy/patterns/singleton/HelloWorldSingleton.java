package com.axway.academy.patterns.singleton;

/**
 * Singleton design pattern.
 * This is how to construct a singleton class.
 * 
 * @author aandreev
 *
 */
public class HelloWorldSingleton {
	
	// use static variable to assure that only one instance would be used each time
	// for validation purposes initialize the object with a null value
	private static HelloWorldSingleton hw = null;
	
	/**
	 * This constructor exists only to ensure that objects would not be instantiated.
	 * That is why it is private. If not created by default there would be a public constructor available.
	 */
	private HelloWorldSingleton() {
		
	}
	
	/**
	 * Prints Hello World by using the object.
	 */
	public void  sayHello() {
		System.out.println("Hello World");
	}
	
	/**
	 * Used to return an instance of the object.
	 * @return the one and only single instance of the object
	 */
	public static HelloWorldSingleton getInstance() {
		// a check if an instance already exists
		// such construction is useful because a new object is not created until requested to
		if (hw == null) {
			hw = new  HelloWorldSingleton();
		}
		return hw;
	}

}
