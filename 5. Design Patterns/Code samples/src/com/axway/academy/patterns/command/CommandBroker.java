package com.axway.academy.patterns.command;

import java.util.ArrayList;

/**
 * Used to handle commands - register them, delete them, execute them, etc.
 * Any method or functionality that works with commands can be created here.
 * Developers should not work with commands directly - the Broker should maintain them,
 * the developer should only initialize commands and instruct the broker what to do with them.
 * 
 * @author aandreev
 *
 */
public class CommandBroker {
	
	/**
	 * A list of all the commands passed to the broker.
	 */
	private ArrayList<Command>  commands = new ArrayList<Command>();
	
	/**
	 * Adds a command to the list.
	 * 
	 * @param c - the command that is to be added to the list
	 */
	public void registerCommand(Command c) {
		commands.add(c);
	}
	
	/**
	 * Executes all commands in the list.
	 */
	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}			

}
