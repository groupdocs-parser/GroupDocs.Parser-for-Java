package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.FictionBookFormattedTextExtractor;
import com.groupdocs.parser.FictionBookTextExtractor;
import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.examples.Common;

public class FictionBookDocuments {
	// ExStart:SourceFB2DocumentFilePath
	private final static String FILE_PATH = "sample.fb2";
	// ExEnd:SourceFB2DocumentFilePath

	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholeFictionBookTextExtractor
			// Create a text extractor for FictionBook (fb2) documents
			try (FictionBookTextExtractor extractor = new FictionBookTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholeFictionBookTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text by lines from a document.
	 * 
	 */
	public static void extractTextByLines() {
		try {
			// ExStart:extractTextByLinesFictionBookTextExtractor
			// Create a text extractor for FictionBook (fb2) documents
			try (FictionBookTextExtractor extractor = new FictionBookTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Extract a line of the text
				String line = extractor.extractLine();
				// If the line is null, then the end of the file is reached
				while (line != null) {
					// Print a line to the console
					System.out.println(line);
					// Extract another line
					line = extractor.extractLine();
				}
			}
			// ExEnd:extractTextByLinesFictionBookTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text a document.
	 * 
	 */
	public static void extractFormattedText() {
		try {
			// ExStart:extractFormattedTextFictionBookTextExtractor
			// Create a text extractor for FictionBook (fb2) documents
			try (FictionBookFormattedTextExtractor extractor = new FictionBookFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Set a document formatter to Markdown
				extractor.setDocumentFormatter(new MarkdownDocumentFormatter());
				// Extact a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextFictionBookTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
