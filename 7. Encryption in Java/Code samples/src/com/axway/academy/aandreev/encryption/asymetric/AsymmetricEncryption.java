package com.axway.academy.aandreev.encryption.asymetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;

/**
 * A sample class to perform asymmetric encryption.
 * The algorithm used is RSA.
 * 
 * @author aandreev
 *
 */
public class AsymmetricEncryption {

	public static void main(String[] args) {
		
		// the text to be encrypted.
		// any data can be encrypted as long as it is in a bytes array format
		String text = "This is the original text to encrypt";
		
		try {			
			// Key generation logic START
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			KeyPair keyPair = keyGen.generateKeyPair();

			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();
			// Key generation logic END
			
			// perform encryption
			byte[] encryptedText = encrypt(text, publicKey);
			System.out.println("Encrypted string:" + new String(encryptedText));
			// providing the encrypted content in base64 encoded format - used to represent binary data as text
			Encoder encoder = Base64.getEncoder();
			System.out.println("Base64 encoded encrypted string: " + encoder.encodeToString(encryptedText));
			
			// perform decryption
			String decryptedStringWithOriginalKey = decrypt(encryptedText, privateKey);
			System.out.println("Decrypted string with correct key:" + decryptedStringWithOriginalKey.trim());

		} catch (Exception e) {
			System.out.println("Eror during encryption/decryption.");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Performs asymmetric encryption.
	 * 
	 * @param text - text to be encrypted
	 * @param encryptionKey - key sued for encryption
	 * @return the encrypted content
	 * @throws Exception
	 */
	public static byte[] encrypt(String text, PublicKey encryptionKey) throws Exception {
		// create the cipher with the correct asymmetric algorithm used
	    Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
	    
	    // initialize the cipher by providing the encryption key and encryption mode
	    // no initialization vector used this time as it provides no sensible value
	    cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
	    
	    // perform encryption
	    return cipher.doFinal(text.getBytes("UTF-8"));
	  }

	/**
	 * Performs asymmetric decryption.
	 * 
	 * @param encryptedContent - encrypted content
	 * @param encryptionKey - key used for decryption
	 * @return the decrypted text
	 * @throws Exception
	 */
	  public static String decrypt(byte[] encryptedContent, PrivateKey encryptionKey) throws Exception{
		// create the cipher with the correct asymmetric algorithm used
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
		
		// initialize the cipher by providing the encryption key and encryption mode
	    // no initialization vector used this time as it provides no sensible value
	    cipher.init(Cipher.DECRYPT_MODE, encryptionKey);
	    
	    // perform decryption
	    return new String(cipher.doFinal(encryptedContent),"UTF-8");
	  }

}
