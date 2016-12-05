package com.axway.academy.aandreev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Working with files and exceptions sample code.
 * The main method first creates a file and then reads its content.
 * This is performed 3 times - one for each implementation approach.
 * 
 * @author aandreev
 *
 */
public class WorkingWithFiles {

	public static void main(String[] args) {

		writeToFileUsingOutputStreams();
		readFromFileUsingInputStreams();

		writeToFileUsingFileWriter();
		readFromFileUsingFileReader();

		writeToFileUsingFileAbstractionLayer();
		readFromFileUsingFileAbstractionLayer();

	}

	/**
	 * Reads content of a file by using java.nio.files.
	 */
	private static void readFromFileUsingFileAbstractionLayer() {

		String fileName = "file3.txt";
		Path filePath = Paths.get(fileName);
		try {
			if (Files.exists(filePath)) {
				byte[] fileBytes = Files.readAllBytes(filePath);
				System.out.println("Reading of file was successful. File content: " + new String(fileBytes));
			} else {
				System.out.println("File does not exist - do nothing");
			}
		} catch (IOException ioe) {
			System.out.println("Cannot read from file." + ioe);
		}

	}

	/**
	 * Reads content of a file with FileReader.
	 */
	private static void readFromFileUsingFileReader() {

		String fileName = "file2.txt";
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				System.out.println("Reading of file was successful. File content: " + sb.toString());
			} else {
				System.out.println("File does not exist - do nothing");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Cannot read from file." + fnfe);
		} catch (IOException ioe) {
			System.out.println("Cannot read from file." + ioe);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ioe) {
				System.out.println("Cannot close streams." + ioe);
			}
		}

	}

	/**
	 * Standard way to read file content.
	 */
	private static void readFromFileUsingInputStreams() {

		String fileName = "file1.txt";
		File file = new File(fileName);
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			if (file.exists()) {
				in = new FileInputStream(file);
				isr = new InputStreamReader(in);
				br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				System.out.println("Reading of file was successful. File content: " + sb.toString());
			} else {
				System.out.println("File does not exist - do nothing");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Cannot read from file." + fnfe);
		} catch (IOException ioe) {
			System.out.println("Cannot read from file." + ioe);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ioe) {
				System.out.println("Cannot close streams." + ioe);
			}
		}

	}

	/**
	 * Write to a file by using java.nio.file.Files.
	 */
	private static void writeToFileUsingFileAbstractionLayer() {

		String fileName = "file3.txt";
		Path filePath = Paths.get(fileName);
		try {
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			}
			String textToBeWritten = "Write this text to my file.";
			Files.write(filePath, textToBeWritten.getBytes());
			System.out.println("Successfully written to file.");
		} catch (IOException ioe) {
			System.out.println("Cannot write to file." + ioe);
		}
	}

	/**
	 * Write to file using File Writer.
	 */
	private static void writeToFileUsingFileWriter() {

		String fileName = "file2.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write("Write this text to my file.");
			System.out.println("Successfully written to file.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException ioe) {
				System.out.println("Cannot close streams." + ioe);
			}
		}

	}

	/**
	 * Standard way to write into a file by using output streams.
	 */
	public static void writeToFileUsingOutputStreams() {

		String fileName = "file1.txt";
		File file = new File(fileName);
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			bw.write("Write this text to my file.");
			System.out.println("Successfully written to file.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (osw != null) {
					osw.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				System.out.println("Cannot close streams." + ioe);
			}
		}

	}

}
