package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.CellsTextExtractor;
import com.groupdocs.parser.ImageArea;
import com.groupdocs.parser.ImageAreaSearchOptions;
import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.Rectangle;
import com.groupdocs.parser.TextArea;
import com.groupdocs.parser.TextAreaSearchOptions;
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

	/**
	 * Extracts a text area from a text document.
	 * 
	 */
	public static void extractTextAreaFromTextDocument() {
		try {
			// ExStart:extractTextAreaFromTextDocument_18.9
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Create search options
				TextAreaSearchOptions searchOptions = new TextAreaSearchOptions();
				// Set a regular expression to search 'Invoice # XXX' text
				searchOptions.setExpression("\\s?INVOICE\\s?#\\s?[0-9]+");
				// Limit the search with a rectangle
				searchOptions.setRectangle(new Rectangle(10, 10, 300, 150));

				// Get text areas
				java.util.List<TextArea> texts = extractor.getDocumentContent().getTextAreas(0, searchOptions);

				// Iterate over a list
				for (TextArea area : texts) {
					// Print a text
					System.out.println(area.getText());
				}
			}
			// ExEnd:extractTextAreaFromTextDocument_18.9
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts images from text document.
	 * 
	 */
	public static void extractImages() {
		try {
			// ExStart:extractImages_textdocuments_18.10
			// Create a text extractor for text documents
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Create search options
				ImageAreaSearchOptions searchOptions = new ImageAreaSearchOptions();
				// Limit the search with the rectangle: position (0; 0), size
				// (300; 300)
				searchOptions.setRectangle(new Rectangle(0, 0, 300, 300));

				// Get images from the first page
				java.util.List<ImageArea> imageAreas = extractor.getDocumentContent().getImageAreas(0, searchOptions);

				// Iterate over the images
				for (int i = 0; i < imageAreas.size(); i++) {
					try (java.io.OutputStream fs = new java.io.FileOutputStream(String.format("%d.jpg", i))) {
						// Save the image to the file
						Common.copyStream(imageAreas.get(i).getRawStream(), fs);
					}
				}
			}
			// ExEnd:extractImages_textdocuments_18.10
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
