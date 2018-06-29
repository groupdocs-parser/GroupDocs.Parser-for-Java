package com.groupdocs.parser.examples.TextFormatters;

import com.groupdocs.parser.HtmlDocumentFormatter;
import com.groupdocs.parser.WordsFormattedTextExtractor;
import com.groupdocs.parser.examples.Common;

public class HTML {
	private final static String FILE_PATH = "sample.docx";

	/**
	 * Extracts text from a document using HTMLDocumentFormatter.
	 * 
	 */
	public static void extractTextUsingHTMLDocumentFormatter() {
		try {
			// ExStart:extractTextUsingHTMLDocumentFormatter
			// Create a formatted text extractor
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Set Markdown document formatter
				extractor.setDocumentFormatter(new HtmlDocumentFormatter());
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextUsingHTMLDocumentFormatter
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
