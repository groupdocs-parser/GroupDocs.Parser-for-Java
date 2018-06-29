package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.ChmFormattedTextExtractor;
import com.groupdocs.parser.ChmTextExtractor;
import com.groupdocs.parser.HtmlDocumentFormatter;
import com.groupdocs.parser.TableOfContentsItem;
import com.groupdocs.parser.examples.Common;

public class CHMDocuments {
	// ExStart:SourceCHMDocumentFilePath
	private final static String FILE_PATH = "sample.chm";
	// ExEnd:SourceCHMDocumentFilePath

	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholeChmTextExtractor
			// Create a text extractor for CHM documents 
			try (ChmTextExtractor extractor = new ChmTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholeChmTextExtractor
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
			// ExStart:extractTextByLinesChmTextExtractor
			// Create a text extractor for CHM documents
			try (ChmTextExtractor extractor = new ChmTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextByLinesChmTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	/**
	 * Extracts formatted text by lines from a document.
	 * 
	 */
	public static void extractFormattedTextByLines() {
		try {
			// ExStart:extractFormattedTextByLinesChmFormattedTextExtractor
			// Create a text extractor for CHM documents
			try (ChmFormattedTextExtractor extractor = new ChmFormattedTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractFormattedTextByLinesChmFormattedTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Extracts all text from a document.
	 * 
	 */
	public static void extractFormattedText() {
		try {
			// ExStart:extractAllCharactersOfFormattedTextChmFormattedTextExtractor
			// Create a text extractor for CHM documents
			try (ChmFormattedTextExtractor extractor = new ChmFormattedTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractAllCharactersOfFormattedTextChmFormattedTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	/**
	 * Extracts text from chm file using text formatter
	 * 
	 */
	public static void extractFormattedTextUsingTextFormatter() {
		try {
			// ExStart:ExtractFormattedTextUsingTextFormatterChmFormattedTextExtractor
			// Create a text extractor for CHM documents
			try (ChmFormattedTextExtractor extractor = new ChmFormattedTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				extractor.setDocumentFormatter(new HtmlDocumentFormatter()); // all the text will be formatted as HTML
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:ExtractFormattedTextUsingTextFormatterChmFormattedTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Extracts table of content from chm document
	 * 
	 */
	// ExStart:extractTableOfContentCHMDocument
	public static void extractTableOfContent() {
		try {			
			// Create a text extractor for CHM documents
			try (ChmTextExtractor extractor = new ChmTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Print TOC on the screen
				for (TableOfContentsItem item : extractor.getTableOfContents()) {
				    PrintToc(item, 0);
				}
			}		
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	private static void PrintToc(TableOfContentsItem tableOfContents, int depth) {
	    // Use spaces to indicate the depth of the TOC item
	    String spaces = new String(new char[depth]).replace("\0", " ");

	    // Iterate over items
	    for (int i = 0; i < tableOfContents.getCount(); i++) {
	        TableOfContentsItem item = tableOfContents.get_Item(i);
	        System.out.print(spaces);
	        // Print the item's text
	        System.out.print(item.getText());

	        // If item has a text (it's not just a node)
	        if (item.getPageIndex() != null) {
	            // Print the text length
	            System.out.print(String.format(" (%d)", item.extractPage().length()));
	        }

	        System.out.println();

	        // If the item has children
	        if (item.getCount() > 0) {
	            // Print them
	            PrintToc(item, depth + 1);
	        }
	    }
	}
	// ExEnd:extractTableOfContentCHMDocument
	
	/**
	 * Extracts item in TOC in chm document
	 * 
	 */
	public static void extractTextOfItemInTOC() {
		try {
			// ExStart:extractTextOfItemInTOCCHMDocument
			// Create a text extractor for CHM documents
			try (ChmTextExtractor extractor = new ChmTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Print a content of the third sub-item of the second item
				System.out.println(extractor.getTableOfContents().get(1).get_Item(2).extractPage());
			}
			// ExEnd:extractTextOfItemInTOCCHMDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
