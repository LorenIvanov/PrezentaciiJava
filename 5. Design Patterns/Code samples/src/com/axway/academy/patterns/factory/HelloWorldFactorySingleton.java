package com.axway.academy.patterns.factory;

/**
 * Factory class used for obtaining the correct object
 * based on a certain criteria - a string in our case but can be anything.
 * The factory class uses the Singleton pattern for its initialization.
 * 
 * @author aandreev
 *
 */
public class HelloWorldFactorySingleton {
	
	/**
	 * Static factory object insuring only one instance of the factory will be used.
	 */
	private static HelloWorldFactorySingleton factory = null;
	
	/**
	 * Mandatory private constructor.
	 */
	private HelloWorldFactorySingleton() {
		
	}
	
	/**
	 * Getting a factory instance.
	 * 
	 * @return a factory instance
	 */
	public static HelloWorldFactorySingleton getInstance() {
		if (factory == null) {
			factory = new HelloWorldFactorySingleton();
		}
		return factory;
	}
	
	/**
	 * Returns the correct object based on the criteria.
	 * 
	 * @param criteria - object type criteria
	 * @return object meeting the specified criteria
	 */
	public HelloWorld whichWorldIsMine(String criteria) {
		if ("bg".equals(criteria)) {
			return new  HelloWorldBulgaria();
		} else {
			return  new HelloWorldSpace();
		}
	}

}
