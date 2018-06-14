package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.HtmlDocumentFormatter;
import com.groupdocs.parser.MarkdownFormattedTextExtractor;
import com.groupdocs.parser.MarkdownTextExtractor;
import com.groupdocs.parser.TextExtractor; 

public class MarkdownDocuments {
	// ExStart:SourceCHMDocumentFilePath
	private final static String FILE_PATH = "sample.md";
	// ExEnd:SourceCHMDocumentFilePath

	/**
	 * Extracts single line of characters as raw text from Markdown document
	 */
	public static void extractSingleLineAsRawText() {
		try {
			// ExStart:ExtractSingleLineAsRawTextMarkdown_18.2
			// Create a text extractor for Markdown documents
			try (TextExtractor extractor = new MarkdownTextExtractor(FILE_PATH)) {
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
			// ExEnd:ExtractSingleLineAsRawTextMarkdown_18.2
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts all characters as raw text from Markdown document
	 */
	public static void extractAllCharactersAsRawText() {
		try {
			// ExStart:ExtractAllCharactersAsRawTextMarkdown_18.2
			// Create a text extractor for Markdown documents
			try (TextExtractor extractor = new MarkdownTextExtractor(FILE_PATH)) {
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:ExtractAllCharactersAsRawTextMarkdown_18.2
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts a line of characters as formatted text from Markdown document
	 */
	public static void extractSingleLineAsFormattedText() {
		try {
			// ExStart:ExtractSingleLineAsFormattedTextMarkdown_18.2
			// Create a text extractor for Markdown documents
			try (TextExtractor extractor = new MarkdownFormattedTextExtractor(FILE_PATH)) {
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
			// ExEnd:ExtractSingleLineAsFormattedTextMarkdown_18.2
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts a line of characters as formatted text from Markdown document
	 */
	public static void extractAllCharactersAsFormattedText() {
		try {
			// ExStart:ExtractAllCharactersAsFormattedTextMarkdown_18.2
			// Create a text extractor for Markdown documents
			try (TextExtractor extractor = new MarkdownFormattedTextExtractor(FILE_PATH)) {
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:ExtractAllCharactersAsFormattedTextMarkdown_18.2
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text using DocumentFormatter from Markdown document
	 */
	public static void extractFormattedTextUsingDocumentFormatter() {
		try {
			// ExStart:ExtractFormattedTextUsingDocumentFormatterMarkdown_18.2
			// Create a text extractor for Markdown documents
			try (MarkdownFormattedTextExtractor extractor = new MarkdownFormattedTextExtractor(FILE_PATH)) {
				// Set a HTML formatter for formatting
				extractor.setDocumentFormatter(new HtmlDocumentFormatter()); // all the text will be formatted as HTML
			}
			// ExEnd:ExtractFormattedTextUsingDocumentFormatterMarkdown_18.2
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts structured text from Markdown document
	 */
	public static void extractStructuredText() {
		try {
			// ExStart:ExtractStructuredTextMarkdown_18.2
			// Create a text extractor for Markdown documents
			try (TextExtractor extractor = new MarkdownTextExtractor(FILE_PATH)) {

			}
			// ExEnd:ExtractStructuredTextMarkdown_18.2
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
