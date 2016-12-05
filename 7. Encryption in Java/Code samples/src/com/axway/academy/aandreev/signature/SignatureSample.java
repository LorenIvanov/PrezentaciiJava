package com.axway.academy.aandreev.signature;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * A sample class describing the usage of signatures.
 * The digital signature is a form of asymmetric encryption.
 * 
 * @author aandreev
 *
 */
public class SignatureSample {

	public static void main(String[] args) throws Exception {
		
		// generate keys
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = kpg.genKeyPair();
		PrivateKey prk = keyPair.getPrivate();
		PublicKey puk = keyPair.getPublic();

		// some text data to be signed and later on converted to an array of bytes
		String data = "This is my text that has to be signed";
		byte[] binaryData = data.getBytes("UTF8");

		// creates a signature of the data
		byte[] signature = createSignature(prk, binaryData);
		System.out.println("======================");

		// validate the signature agaisnt the correct data
		System.out.println("Proper data provided.");
		verifySignature(puk, binaryData, signature);
		System.out.println();
		
		// validate the signature against wrong data
		System.out.println("Providing wrong data.");
		verifySignature(puk, "I am not almost the same".getBytes(), signature);
		System.out.println();
		
		// providing a wrong signature for the data
		System.out.println("Providing wrong signature.");
		System.out.println("Generating signature for different data.");
		byte[] signature2 = createSignature(prk, "Some wrong data here.".getBytes());
		verifySignature(puk, binaryData, signature2);

	}
	
	/**
	 * Creates a signature of a document.
	 * 
	 * @param prk - private key sued for encryption of the document hash
	 * @param binaryData - data to be signed
	 * @return the digital signature of the document
	 * @throws Exception
	 */
	public static byte[] createSignature(PrivateKey prk, byte[] binaryData) throws Exception {
		// get an instance of the signature object by specifying the used hashing algorithm
		Signature sig = Signature.getInstance("MD5WithRSA");
		
		// initialize the key that will be used for signing
		// it is important that this is done before update()
		sig.initSign(prk);
		
		// add the data to eb signed as part fo the signature object by using the update() method
		sig.update(binaryData);
		
		// generate the signature
		byte[] signatureBytes = sig.sign();
		System.out.println("Signature is prepared: " + new String(signatureBytes));
		return signatureBytes;
	}
	
	/**
	 * Verifies a signature against.
	 * The data for which the signature was provided along with the public key should be present.
	 * 
	 * @param puk - public key sued for decryption of the signature
	 * @param binaryData - binary data for which the signature was issued
	 * @param signature - the signature
	 * @throws Exception
	 */
	public static void verifySignature(PublicKey puk, byte[] binaryData, byte[] signature) throws Exception {
		// get an instance of the signature object by specifying the used hashing algorithm
		Signature sig = Signature.getInstance("MD5WithRSA");
		
		// initialize the key that will be used for signing
		// it is important that this is done before update()
		sig.initVerify(puk);
		sig.update(binaryData);
		
		// verify the signature
		boolean result = sig.verify(signature);
		System.out.println("Signature verification result: " + result);
	}

}
