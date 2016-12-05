package com.axway.academy.patterns.command;

/**
 * Test Command pattern.
 * Command pattern is used when certain object functions are encapsulated into objects themselves - commands.
 * The pattern is used when the developer knows what command is used but does not know how it is performed by the object.
 * For example - uploading a file may be a command but the actual functions performed needed to upload a file
 * are authenticate, access the upload folder, upload the file and logout.
 * 
 * @author aandreev
 *
 */
public class CommandPatternSample {

	public static void main(String[] args) {

		// create an object
		User user = new User();
		
		// initialize commands that are going to be used
		LoginCommand lc = new LoginCommand(user);		
		LogoutCommand lo = new LogoutCommand(user);
		
		// create a broker and register commands
		CommandBroker cb = new CommandBroker();
		cb.registerCommand(lc);
		cb.registerCommand(lo);
		
		// execute commands through the broker
		// notice that we are not working with the User object at all
		cb.execute();		

	}

}
