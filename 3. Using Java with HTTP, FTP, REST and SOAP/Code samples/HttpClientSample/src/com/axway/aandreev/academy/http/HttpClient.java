package com.axway.aandreev.academy.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Creating a sample program that executes a REST request.
 * 
 * @author aandreev
 *
 */
public class HttpClient {

	public static void main(String[] args) {

		// Some SSL Handshake magic stuff happening here that you do not care
		// about
		// This code segment makes connections over SSL possible
		// SSL Handshake will be discussed in future topics
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (Exception e) {
		}
		// SSL handshake magic ends here
		// SSL handshake will be subject to future topics

		// Set to perform authentication
		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("test", "123".toCharArray());
			}
		});

		BufferedReader br = null;
		InputStreamReader ir = null;
		InputStream is = null;
		HttpURLConnection connection = null;
		try {
			// initialize the resource
			URL url = new URL("https://10.232.15.27/api/v1.4/files");
			connection = (HttpURLConnection) url.openConnection();

			// set request method
			connection.setRequestMethod("GET");

			// execute the request and get status code and message
			int statusCode = connection.getResponseCode();
			System.out.println("The status code is " + statusCode);
			System.out.println("Response message is " + connection.getResponseMessage());

			// read the response and print it
			is = connection.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (MalformedURLException e) {
			System.out.println("Cannot form URL");
		} catch (IOException e) {
			System.out.println("Problems openning connection.");
			e.printStackTrace();
		} finally {
			// close all streams
			try {
				if (br != null) {
					br.close();
				}				
				if (ir != null) {
					ir.close();
				}
				if (is != null) {
					is.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (IOException e) {
				System.out.println("Error closing streams.");
				e.printStackTrace();
			}
		}

	}

}
