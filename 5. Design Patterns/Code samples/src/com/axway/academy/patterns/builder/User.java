package com.axway.academy.patterns.builder;

/**
 * User object definition.
 * 
 * @author aandreev
 *
 */
public class User {
	
	private String username; // mandatory
	private String firstName; // optional
	private String lastName; //optional
	private String address; // optional
	private String password; // optional
	
	/**
	 * Create a private constructor that accepts a builder object as parameter
	 * all of the User fields are populated with values from the builder object.
	 * 
	 * @param ub - builder object
	 */
	private User(UserBuilder  ub) {
		this.username = ub.username;
		this.firstName = ub.firstName;
		this.lastName = ub.lastName;
		this.address = ub.address;
		this.password = ub.password;
	}
	
	
	public String getUsername() {
		return username;
	}	

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	
	/**
	 * Prints a message.
	 */
	public  void iAmTheBoss()  {
		System.out.println("I am the boss " + this.username + " and  my name is " + this.firstName +
				" " + this.lastName + "  with  password "  + this.password);
	}
	
	/**
	 * A builder object.
	 * The object is used for building a User object.
	 * The builder object should contain each of the User fields.
	 * A public constructor should be available for first initialization - it should contain the mandatory fields only.
	 * If there are no mandatory fields the constructor should not contain any parameters.
	 * Then a method returning a UserBuilder object should be created for each optional field.
	 * Finally a build() method should be created that will call the private constructor of the User class.
	 * 
	 * It is not mandatory to have the builder class under the main class but this is 
	 * recommended for organizational purposes. it is easier for maintenance, having them both in one place.
	 * Separate classes can be created as well - the pattern will still be followed.
	 * 
	 * @author aandreev
	 *
	 */
	public static class UserBuilder {
		private String username; // mandatory
		private String firstName; // optional
		private String lastName; //optional
		private String address; // optional
		private String password; // optional
		
		/**
		 * Constructor containing the bare minimum of parameters needed for creating a user object.
		 * 
		 * @param username - name of the user
		 */
		public UserBuilder(String username) {
			this.username = username;
		}
		
		/**
		 * Method for assigning a first name to the object.
		 * 
		 * @param firstName - first name
		 * @return a builder object containing a first name as well.
		 */
		public UserBuilder assignFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		/**
		 * Method for assigning a last name to the object.
		 * 
		 * @param lastName - last name
		 * @return a builder object containing a last name as well
		 */
		public UserBuilder assignLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		/**
		 * Method for assigning an address to the object.
		 * 
		 * @param address - address
		 * @return a builder object containing an address as well
		 */
		public UserBuilder assignAddress(String address) {
			this.address = address;
			return this;
		}
		
		/**
		 * Method for assigning a password to the object.
		 * 
		 * @param password - user password
		 * @return a builder object containing a password as well
		 */
		public UserBuilder assignPassword(String password) {
			this.password = password;
			return this;
		}
		
		/**
		 * The method build a User object based on the builder object.
		 * 
		 * @return a User object
		 */
		public User build() {
			return new User(this);
		}
	}
	

}
