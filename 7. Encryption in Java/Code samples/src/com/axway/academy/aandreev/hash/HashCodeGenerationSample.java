package com.axway.academy.aandreev.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * A sample class describing the creation of hashes.
 * Possible algorithms MD5, SHA-1, SHA-2.
 * 
 * @author aandreev
 *
 */
public class HashCodeGenerationSample {
	
	public static void main (String[] args) throws NoSuchAlgorithmException {
		
		// some text to be hashed
		String someText = "This is a sample text that will be hashed.";
		
		// create an instance of the MessageDigest object
		// it is responsible for creating a hash by using the provided algorithm
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		// add the text for hashing
		md.update(someText.getBytes());
		
		// generate the hash
		byte[] hash = md.digest();
		
		// display Base64 encoded value of the hash
		String hashString = Base64.getEncoder().encodeToString(hash);
		System.out.println("Hash is: " + hashString);
		
	}

}
