package com.axway.aandreev.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Create an FTP sample that downloads files.
 * 
 * @author aandreev
 *
 */
public class FtpClient {

	public static void main(String[] args) {
		
		// login credentials
		String server = "10.232.15.27";
		String username = "test";
		String password = "123";

		// create an instance of the client
		FTPClient f = new FTPClient();
		OutputStream out = null;
		try {
			// connect to the server adn authenticate
			f.connect(server);
			f.login(username, password);
			out = new FileOutputStream(new File("testFile.txt"));
			
			// list files on the server
			// please note that the code depends on having at least one element in the array
			// this should be handled more properly
			FTPFile[] files = f.listFiles();
			String fileName = files[0].getName();
			
			// downloads a specific file
			boolean success = f.retrieveFile(fileName, out);
			System.out.println(success ? "Downloading file [" + fileName + "] was OK" : "Downloading failed");
			
		} catch (SocketException e) {
			System.out.println("Problem establishing FTP connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem establishing FTP connection");
			e.printStackTrace();
		} finally {
			// closing streams and disconnect
			try {
				if (out != null) {
					out.close();
				}
				
				if (f != null) {
					f.disconnect();
				}				
			} catch (IOException e) {
				System.out.println("Problem disconnecting");
				e.printStackTrace();
			}
		}

	}

}
