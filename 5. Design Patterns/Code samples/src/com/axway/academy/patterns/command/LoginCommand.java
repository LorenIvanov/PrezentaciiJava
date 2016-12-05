package com.axway.academy.patterns.command;

/**
 * A command that triggers the login() method of the User object.
 * 
 * @author aandreev
 *
 */
public class LoginCommand implements  Command {
	
	/**
	 * User object. The user is passed to the command and the command
	 * executes whatever method is needed from the object.
	 */
	private User user;
	
	/**
	 * Constructor.
	 * 
	 * @param user - user object
	 */
	public LoginCommand(User user) {
		this.user = user;
	}

	/**
	 * Executes the command.
	 */
	@Override
	public void execute() {
		user.login();		
	}

}
