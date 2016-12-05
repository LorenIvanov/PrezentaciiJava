package com.axway.academy.patterns.factory;

/**
 * Factory class used for obtaining the correct object
 * based on a certain criteria - a string in our case but can be anything.
 * 
 * @author aandreev
 *
 */
public class HelloWorldFactory {
	
	public HelloWorldFactory() {
		
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
