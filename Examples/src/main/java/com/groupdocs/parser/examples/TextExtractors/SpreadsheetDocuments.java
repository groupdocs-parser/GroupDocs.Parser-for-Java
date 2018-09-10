package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.CellsFormattedTextExtractor;
import com.groupdocs.parser.CellsSheetInfo;
import com.groupdocs.parser.CellsTextExtractor;
import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.Rectangle;
import com.groupdocs.parser.TextArea;
import com.groupdocs.parser.TextAreaSearchOptions;
import com.groupdocs.parser.examples.Common;

public class SpreadsheetDocuments {
	// ExStart:SourceCellsDocumentFilePath
	private final static String FILE_PATH = "sample.xlsx";

	// ExEnd:SourceCellsDocumentFilePath
	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholeCellsTextExtractor
			// Create a text extractor for spreadsheets
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Extract a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholeCellsTextExtractor
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
			// ExStart:extractTextByLinesCellsTextExtractor
			// Create a text extractor for spreadsheets
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextByLinesCellsTextExtractor
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
			// ExStart:extractFormattedTextCellsTextExtractor
			// Create a formatted text extractor for spreadsheets
			try (CellsFormattedTextExtractor extractor = new CellsFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Set a document formatter to Markdown
				extractor.setDocumentFormatter(new MarkdownDocumentFormatter());
				// Extact a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextCellsTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts sheet by rows from a spreadsheet document.
	 * 
	 */
	public static void extractSheetByRows() {
		try {
			// ExStart:extractSheetByRowsCellsTextExtractor
			// Create a text extractor for spreadsheets
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				int sheetIndex = 0;
				// Get the information of the sheet
				CellsSheetInfo sheetInfo = extractor.getSheetInfo(sheetIndex);
				// Print a header of the sheet
				System.out.println(sheetInfo.extractSheetHeader());
				// Iterate over sheet rows
				for (int rowIndex = 0; rowIndex < sheetInfo.getRowCount(); rowIndex++) {
					// Extract a text from the row
					System.out.println(sheetInfo.extractRow(rowIndex));
				}
			}
			// ExEnd:extractSheetByRowsCellsTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts selected columns from a spreadsheet document.
	 * 
	 */
	public static void extractSelectedColumns() {
		try {
			// ExStart:extractSelectedColumnsCellsTextExtractor
			// Create a text extractor for spreadsheets
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				int sheetIndex = 0;
				// Get the information of the sheet
				CellsSheetInfo sheetInfo = extractor.getSheetInfo(sheetIndex);
				// Extract a text from the sheet for B1 and C1 columns (other
				// columns are ignored)
				System.out.println(sheetInfo.extractSheet("B1", "A1"));
			}
			// ExEnd:extractSelectedColumnsCellsTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts selected columns by rows from a spreadsheet document.
	 * 
	 */
	public static void extractSelectedColumnsByRows() {
		try {
			// ExStart:extractSelectedColumnsByRowsCellsTextExtractor
			// Create a text extractor for spreadsheets
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				int sheetIndex = 0;
				// Get the information of the sheet
				CellsSheetInfo sheetInfo = extractor.getSheetInfo(sheetIndex);
				// Print a header of the sheet
				System.out.println(sheetInfo.extractSheetHeader());
				// Iterate over sheet rows
				for (int rowIndex = 0; rowIndex < sheetInfo.getRowCount(); rowIndex++) {
					// Extract a text from the row for B1 and C1 columns (other
					// columns are ignored)
					System.out.println(sheetInfo.extractRow(rowIndex, "A1", "C1"));
				}
			}
			// ExEnd:extractSelectedColumnsByRowsCellsTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	/**
	 * Extracts a text area from a spreadsheet document.
	 * 
	 */
	public static void extractTextAreaFromSpreadsheetDocument() {
		try {
			// ExStart:extractTextAreaFromSpreadsheetDocument_18.9
			// Create a text extractor for spreadsheets
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextAreaFromSpreadsheetDocument_18.9
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
