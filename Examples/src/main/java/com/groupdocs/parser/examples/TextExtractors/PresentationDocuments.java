package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.Rectangle;
import com.groupdocs.parser.SlidesFormattedTextExtractor;
import com.groupdocs.parser.SlidesTextExtractor;
import com.groupdocs.parser.TextArea;
import com.groupdocs.parser.TextAreaSearchOptions;
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
	
	/**
	 *  Extracts a text area from a presentation document.
	 * 
	 */
	public static void extractTextAreaFromPresentationDocument() {
		try {
			// ExStart:ExtractTextAreaFromPresentationDocument_18.9
			// Create a text extractor for presentations
			try (SlidesTextExtractor  extractor = new SlidesTextExtractor (
					Common.mapOutputFilePath(FILE_PATH))) {
				// Create search options
				TextAreaSearchOptions searchOptions = new TextAreaSearchOptions();
				// Set a regular expression to search 'Published: XXXX.XX.XX' text
				searchOptions.setExpression("\\s?Published\\:\\s?[0-9]{4}\\.[0-9]{2}\\.[0-9]{2}");
				// Limit the search with a rectangle
				searchOptions.setRectangle(new Rectangle(10, 10, 300, 150));
				  
				// Get text areas
				java.util.List<TextArea> texts = extractor.getDocumentContent().getTextAreas(0, searchOptions);
				  
				for (TextArea area : texts) {
				    // Print a text
				    System.out.println(area.getText());
				}
			}
			// ExEnd:ExtractTextAreaFromPresentationDocument_18.9
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
