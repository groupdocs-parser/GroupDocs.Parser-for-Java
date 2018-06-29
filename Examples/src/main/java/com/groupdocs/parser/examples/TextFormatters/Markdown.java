package com.groupdocs.parser.examples.TextFormatters;

import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.WordsFormattedTextExtractor;
import com.groupdocs.parser.examples.Common;

public class Markdown {
	private final static String FILE_PATH = "sample.docx";

	/**
	 * Extracts text from a document using MarkdownDocumentFormatter.
	 * 
	 */
	public static void extractTextUsingMarkdownDocumentFormatter() {
		try {
			// ExStart:extractTextUsingMarkdownDocumentFormatter
			// Create a formatted text extractor
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Set Markdown document formatter
				extractor.setDocumentFormatter(new MarkdownDocumentFormatter());
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextUsingMarkdownDocumentFormatter
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
