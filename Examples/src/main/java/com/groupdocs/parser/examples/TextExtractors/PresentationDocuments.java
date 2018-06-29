package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.SlidesFormattedTextExtractor;
import com.groupdocs.parser.SlidesTextExtractor;
import com.groupdocs.parser.examples.Common;

public class PresentationDocuments {
	// ExStart:SourcePresentationDocumentFilePath
	private final static String FILE_PATH = "sample.pptx";
	// ExEnd:SourcePresentationDocumentFilePath

	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholeSlidesTextExtractor
			// Create a text extractor for presentations
			try (SlidesTextExtractor extractor = new SlidesTextExtractor(Common.mapOutputFilePath(FILE_PATH))) {
				// Extract a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholeSlidesTextExtractor
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
			// ExStart:extractTextByLinesSlidesTextExtractor
			// Create a text extractor for presentations
			try (SlidesTextExtractor extractor = new SlidesTextExtractor(Common.mapOutputFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextByLinesSlidesTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text from a document.
	 * 
	 */
	public static void extractFormattedText() {
		try {
			// ExStart:extractFormattedTextSlidesTextExtractor
			// Create a text extractor for presentations
			try (SlidesFormattedTextExtractor extractor = new SlidesFormattedTextExtractor(
					Common.mapOutputFilePath(FILE_PATH))) {
				// Set a document formatter to Markdown
				extractor.setDocumentFormatter(new MarkdownDocumentFormatter());
				// Extact a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextSlidesTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
