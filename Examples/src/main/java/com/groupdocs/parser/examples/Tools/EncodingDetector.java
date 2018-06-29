package com.groupdocs.parser.examples.Tools;

public class EncodingDetector {
	private final static String FILE_PATH = "sample.docx";

	/**
	 * Detects document encoding.
	 * 
	 */
	public static void detectEncoding() {
		try {
			// ExStart:detectEncoding
			// Create a charset detector
			com.groupdocs.parser.EncodingDetector detector = new com.groupdocs.parser.EncodingDetector(
					java.nio.charset.Charset.forName("windows-1251"));
			// Detect a charset by BOM
			System.out.println(detector.detect(new java.io.FileInputStream(FILE_PATH)));
			// Detect a charset by BOM and content (if BOM is not presented)
			System.out.println(detector.detect(new java.io.FileInputStream(FILE_PATH), true));
			// ExEnd:detectEncoding
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
