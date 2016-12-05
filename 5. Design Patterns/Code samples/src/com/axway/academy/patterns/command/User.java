package com.axway.academy.patterns.command;

/**
 * User object definition.
 * 
 * @author aandreev
 *
 */
public class User {
	
	/**
	 * Printing a login message.
	 */
	public void login() {
		System.out.println("I am logged in");
	}
	
	/**
	 * Printing a logout message.
	 */
	public void logout() {
		System.out.println("I am logged out.");
	}

}
