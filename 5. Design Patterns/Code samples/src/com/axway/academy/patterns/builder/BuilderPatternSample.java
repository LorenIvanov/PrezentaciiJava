package com.axway.academy.patterns.builder;

/**
 * Test Builder pattern.
 * Used for constructing more complex objects that should be immutable(their state should not be changed)
 * and only some of the fields are mandatory
 * 
 * @author aandreev
 *
 */
public class BuilderPatternSample {

	public static void main(String[] args) {

		// construct a user with username and first name only
		User user1 = new User.UserBuilder("aandreev").assignFirstName("Andrey").build();
		user1.iAmTheBoss();
		
		// construct a user with username, last name and password
		User user2 = new User.UserBuilder("Grishata").assignLastName("Dimitrov").assignPassword("123").build();
		user2.iAmTheBoss();
	}

}
