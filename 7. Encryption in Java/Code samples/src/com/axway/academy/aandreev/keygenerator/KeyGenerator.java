package com.axway.academy.aandreev.keygenerator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * A sample class that generates public-private key pairs.
 * This is used for asymmetric encryption.
 * 
 * @author aandreev
 *
 */
public class KeyGenerator {

	public static void main(String[] args) {

		try {
			// create a keypair generator and specify the algorithm with which keys are going to be used.
			// the provide SUN is optional
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
			
			// generate the public-private key pair
			KeyPair keyPair = keyGen.generateKeyPair();
			
			// obtain the private key from the keypair
			PrivateKey privateKey = keyPair.getPrivate();
			//obtain the public key from the keypair
			PublicKey publicKey = keyPair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Problems during key pair generation.");
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			System.out.println("Problems during key pair generation.");
			e.printStackTrace();
		}

	}

}
