package com.axway.academy.aandreev.encryption.symetric;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * A sample class to perform symmetric encryption. AES algorithm will be used
 * meaning the key would be 128 bit and the data for encryption should have a
 * size multiple of 128 bits. That is why some text padding should be performed
 * because in our case we work with text.
 * 
 * @author aandreev
 *
 */
public class SymetricEncryption {

	/**
	 * Initialization vector value - initial value to be used for encryption of
	 * the first block of data.
	 */
	public static String IV = "AAAAAAAAAAAAAAAA";

	public static void main(String[] args) {

		// here we initialize the text and pad it
		// in real world the data for encryption may not be a text but some
		// other array of bytes
		String text = "This is the original text to encrypt";
		text = padTextToBeMultipleTo16(text);

		// the key used for encryption - it should be 128 bit
		String encryptionKey = "0123456789abcdef";
		try {
			// encrypting text
			byte[] encryptedText = encrypt(text, encryptionKey);
			System.out.println("Encrypted string:" + new String(encryptedText));

			// trying to decrypt it with a correct key
			String decryptedStringWithOriginalKey = decrypt(encryptedText, encryptionKey);
			System.out.println("Decrypted string with correct key:" + decryptedStringWithOriginalKey.trim());

			// trying to decrypt it with a wrong key
			String decryptedStringWithFalseKey = decrypt(encryptedText, "0123456789abcdff");
			System.out.println("Decrypted string with correct key:" + decryptedStringWithFalseKey.trim());
		} catch (Exception e) {
			System.out.println("Problems encrypting/decrypting text.");
			e.printStackTrace();
		}

	}

	/**
	 * Performs text padding with whitespaces to be multiple of 16 bytes.
	 * 
	 * @param text
	 *            - text to be padded
	 * @return the padded text
	 */
	public static String padTextToBeMultipleTo16(String text) {
		int textSize = text.getBytes().length;
		int leftover = textSize % 16;
		if (leftover > 0) {
			for (int i = 0; i < 16 - leftover; i++) {
				text = text + " ";
			}
		}
		return text;
	}

	/**
	 * Encrypts some data using a symmetric key.
	 * 
	 * @param text
	 *            - text to be encrypted
	 * @param encryptionKey
	 *            - key used for encryption
	 * @return the encrypted data
	 * @throws Exception
	 */
	public static byte[] encrypt(String text, String encryptionKey) throws Exception {
		// create an instance of the Cipher
		// specify the algorithm sued for encryption
		// the provider SunJCE is optional
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");

		// transform the key in the needed format by specifying the algorithm
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");

		// initialize the cipher
		// not that an initialization vector is also provided - it is also optional
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));

		// perform encryption
		return cipher.doFinal(text.getBytes("UTF-8"));
	}

	/**
	 * Decrypts a cipher text with a symmetric key.
	 * 
	 * @param cipherText
	 *            - the encrypted content
	 * @param encryptionKey
	 *            - key used for decryption
	 * @return the decrypted content
	 * @throws Exception
	 */
	public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception {
		// create an instance of the Cipher
		// specify the algorithm sued for encryption
		// the provider SunJCE is optional
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		
		// transform the key in the needed format by specifying the algorithm
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
		
		// initialize the cipher
		// not that an initialization vector is also provided - it is also optional
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		
		// perform decryption
		return new String(cipher.doFinal(cipherText), "UTF-8");
	}

}
