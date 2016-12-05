package com.axway.academy.patterns.command;

/**
 * A command that triggers the logout() method of the User object.
 * 
 * @author aandreev
 *
 */
public class LogoutCommand implements Command {

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
	public LogoutCommand(User user) {
		this.user = user;
	}

	/**
	 * Executes the command.
	 */
	@Override
	public void execute() {
		user.logout();

	}

}
