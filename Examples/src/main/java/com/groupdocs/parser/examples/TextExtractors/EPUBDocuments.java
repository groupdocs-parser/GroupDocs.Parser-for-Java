package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.EpubFormattedTextExtractor;
import com.groupdocs.parser.EpubPackage;
import com.groupdocs.parser.EpubTextExtractor;
import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.TableOfContentsItem;
import com.groupdocs.parser.examples.Common;

public class EPUBDocuments {
	// ExStart:SourceEPUBDocumentFilePath
	private final static String FILE_PATH = "sample.epub";
	// ExEnd:SourceEPUBDocumentFilePath

	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholeEpubTextExtractor
			// Create a text extractor for EPUB documents
			try (EpubTextExtractor extractor = new EpubTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Extact a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholeEpubTextExtractor
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
			// ExStart:extractTextByLinesEpubTextExtractor
			// Create a text extractor for EPUB documents
			try (EpubTextExtractor extractor = new EpubTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextByLinesEpubTextExtractor
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
			// ExStart:extractFormattedTextEpubTextExtractor
			// Create a text extractor for EPUB documents
			try (EpubFormattedTextExtractor extractor = new EpubFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Set a document formatter to Markdown
				extractor.setDocumentFormatter(new MarkdownDocumentFormatter());
				// Extact a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextEpubTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Gets EPUB packages
	 * 
	 */
	public static void getEPUBPackages() {
		try {
			// ExStart:getEPUBPackages
			// Create a text extractor for EPUB documents
			try (EpubTextExtractor extractor = new EpubTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Get total number of packages
				System.out.println(extractor.getCount());

				// Get EPUB package
				EpubPackage epubPackage = extractor.get_Item(0);
			}
			// ExEnd:getEPUBPackages
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Gets content document from EPUB package
	 * 
	 */
	public static void getContentDocument() {
		try {
			// ExStart:getContentDocumentEPUBPackages
			// Create a text extractor for EPUB documents
			try (EpubTextExtractor extractor = new EpubTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Get EPUB package
				EpubPackage epubPackage = extractor.get_Item(0);
				// Get total number of content documents
				System.out.println(epubPackage.getCount());
			}
			// ExEnd:getContentDocumentEPUBPackages
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text from content document
	 * 
	 */
	public static void extractTextFromContentDocument() {
		try {
			// ExStart:extractTextFromContentDocument
			// Create a text extractor for EPUB documents
			try (EpubTextExtractor extractor = new EpubTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Get EPUB package
				EpubPackage epubPackage = extractor.get_Item(0);
				// Etract text
				System.out.println(epubPackage.extractItem(0));
			}
			// ExEnd:extractTextFromContentDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts table of content
	 * 
	 */
	// ExStart:extractTableOfContentEpubDocument
	public static void extractTableOfContent() {
		try {
			// Create a text extractor for EPUB documents
			try (EpubTextExtractor extractor = new EpubTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Print TOC on the screen
				for (TableOfContentsItem item : extractor.get_Item(0).getTableOfContents()) {
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
	// ExEnd:extractTableOfContentEpubDocument

	/**
	 * Extracts text of items in table of content
	 * 
	 */
	public static void extractTextOfItemInTOC() {
		try {
			// ExStart:extractTextOfItemInTOCEpubDocument
			// Create a text extractor for EPUB documents
			try (EpubTextExtractor extractor = new EpubTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Print a content of the third sub-item of the second item
				System.out.println(extractor.get_Item(0).getTableOfContents().get(0).get_Item(1).extractPage());
			}		
			// ExEnd:extractTextOfItemInTOCEpubDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
