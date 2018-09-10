package com.groupdocs.parser.examples;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import com.groupdocs.parser.License;
import com.groupdocs.parser.Metered;

public class Common {

	public static final Path STORAGE_PATH = getProjectBaseDir().resolve("Data/Source");
	public static final Path OUTPUT_PATH = getProjectBaseDir().resolve("Data/Output");

	// public static final String ATTACHMENTS_PATH =
	// getProjectBaseDir().resolve("Data/Attachments/").toString();
	public static final String LICENSE_PATH = "D:\\GroupDocs.Total.Java.lic";
	public static final String PUBLIC_KEY = "Public key for your account";
	public static final String PRIVATE_KEY = "Private key for your account";

	// applies product license
	public static void applyLicenseFromFile() {
		try {
			// ExStart:ApplyLicenseFromFile
			// Setup license
			License lic = new License();
			lic.setLicense(LICENSE_PATH);
			// ExEnd:ApplyLicenseFromFile
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// applies product license
	public static void applyLicenseFromStream() {
		try {
			// ExStart:ApplyLicenseFromStream
			// Setup license
			License lic = new License();
			lic.setLicense(new java.io.FileInputStream(LICENSE_PATH));
			// ExEnd:ApplyLicenseFromStream
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// returns project base directory
	public static Path getProjectBaseDir() {
		Properties props = new Properties();
		try {
			InputStream i = Common.class.getResourceAsStream("/project.properties");
			props.load(i);
		} catch (IOException x) {
			throw new RuntimeException(x);
		}
		return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
	}

	// returns source file path
	public static String mapSourceFilePath(String inputFileName) {
		try {
			return STORAGE_PATH + "/" + inputFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	// returns output file path
	public static String mapOutputFilePath(String outputFileName) {
		try {
			return OUTPUT_PATH + "/" + outputFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	// shows how to use library in licensed mode using Dynabic.Metered account
	public static void useDynabicMeteredAccount() {
		// ExStart:ApplyMeteredLicense
		// initialize Metered API
		Metered metered = new Metered();
		// set-up credentials
		try {
			metered.setMeteredKey(PUBLIC_KEY, PRIVATE_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// do some work:
		// ExEnd:ApplyMeteredLicense

	}

	// gets connection string
	public static String getConnectionString(String inputFileName) {
		try {
			String connectionString = "jdbc:sqlite:" + STORAGE_PATH + "/" + inputFileName;
			return connectionString;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
