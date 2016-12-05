package com.axway.academy.patterns.factory;

import java.util.Scanner;

/**
 * Test how the Factory pattern is being used.
 * Factory pattern is used when an object has to be created but only certain criteria
 * is known for the object, not everything - for example an object constructed from a database entry,
 * e.g. some user when only the name of the user is known but not the address, telephone number, etc.
 * 
 * @author aandreev
 *
 */
public class FactoryPatternSample {

	public static void main(String[] args) {
		
		// ask for some input so that we can use some criteria in order to obtain the correct object type
		// the criteria can be anything - not a string explicitly
		Scanner scan = new Scanner(System.in);
		String where = scan.next();

		// Creation of a standard factory
		HelloWorldFactory hwf =  new HelloWorldFactory();
		HelloWorld  hw = hwf.whichWorldIsMine(where);
		hw.sayHello();
		
		// Creation of factory that uses singleton - recommended approach
		// Since the job of the Factory is only to supply the correct object instance, most of the time
		// there is no use having multiple factory instances
		HelloWorld hwWithSingleton = HelloWorldFactorySingleton.getInstance().whichWorldIsMine(where);
		hwWithSingleton.sayHello();		

	}

}
