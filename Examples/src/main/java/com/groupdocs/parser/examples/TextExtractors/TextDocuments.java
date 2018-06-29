package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.WordsFormattedTextExtractor;
import com.groupdocs.parser.WordsTextExtractor;
import com.groupdocs.parser.examples.Common;

public class TextDocuments {
	// ExStart:SourceDocDocumentFilePath
	private final static String FILE_PATH = "sample.docx";

	// ExEnd:SourceDocDocumentFilePath
	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholeWordTextExtractor
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Extract a text from the document
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholeWordTextExtractor
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
			// ExStart:extractTextByLinesWordTextExtractor
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextByLinesWordTextExtractor
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
			// ExStart:extractFormattedTextWordTextExtractor
			// Create a formatted text extractor for text documents
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Set a document formatter to Markdown
				extractor.setDocumentFormatter(new MarkdownDocumentFormatter());
				// Extact a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextWordTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
