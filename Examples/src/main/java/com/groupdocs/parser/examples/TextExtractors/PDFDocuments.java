package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.DocumentPage;
import com.groupdocs.parser.ImageArea;
import com.groupdocs.parser.ImageAreaSearchOptions;
import com.groupdocs.parser.PdfTextExtractor;
import com.groupdocs.parser.Rectangle;
import com.groupdocs.parser.TableArea;
import com.groupdocs.parser.TableAreaCell;
import com.groupdocs.parser.TableAreaDetector;
import com.groupdocs.parser.TableAreaDetectorParameters;
import com.groupdocs.parser.TableAreaLayout;
import com.groupdocs.parser.TableAreaParser;
import com.groupdocs.parser.examples.Common;

public class PDFDocuments {
	// ExStart:SourcePDFDocumentFilePath
	private final static String FILE_PATH = "sample.pdf";
	// ExEnd:SourcePDFDocumentFilePath

	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholePdfTextExtractor
			// Create a text extractor for Portable Document Format (PDF)
			// documents
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Extract a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholePdfTextExtractor
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
			// ExStart:extractTextByLinesPdfTextExtractor
			// Create a text extractor for Portable Document Format documents
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextByLinesPdfTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts data from PDF forms.
	 * 
	 */
	public static void extractDataFromPDFForms() {
		try {
			// ExStart:extractDataFromPDFForms_18.9
			// Create a text extractor for PDF documents
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				try {
					// Extract forms data
					java.util.Dictionary<String, String> fields = extractor.getFormData();
					// Iterate over fields
					java.util.Enumeration<String> e = fields.keys();
					while (e.hasMoreElements()) {
						String key = e.nextElement();
						// Print field name and value
						System.out.println(String.format("%s: %s", key, fields.get(key)));
					}
				} finally {
					extractor.dispose();
				}
			}
			// ExEnd:extractDataFromPDFForms_18.9
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts images from PDF document.
	 * 
	 */
	public static void extractImages() {
		try {
			// ExStart:extractImages_PDF_18.10
			// Create a text extractor for PDF documents
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractImages_PDF_18.10
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Extracts tables from PDF document manually.
	 * 
	 */
	public static void extractTablesManually() {
		try {
			// ExStart:extractTablesManually_PDF_18.12
			// Create a text extractor for PDF documents
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Get a table parser
		        TableAreaParser parser = extractor.getTableAreaParser();
		  
		        // Create a table layout
		        TableAreaLayout layout = new TableAreaLayout();
		  
		        // Add vertical separators (columns)
		        layout.getVerticalSeparators().add(72.0);
		        layout.getVerticalSeparators().add(125.0);
		        layout.getVerticalSeparators().add(333.0);
		        layout.getVerticalSeparators().add(454.0);
		        layout.getVerticalSeparators().add(485.0);
		  
		        // Add horizontal separators (rows)
		        layout.getHorizontalSeparators().add(390.0);
		        layout.getHorizontalSeparators().add(417.0);
		        layout.getHorizontalSeparators().add(440.0);
		        layout.getHorizontalSeparators().add(500.0);
		        layout.getHorizontalSeparators().add(521.0);
		  
		        // Extract a table area
		        TableArea tableArea = parser.parseTableArea(0, layout);
		  
		        // Iterate over rows
		        for (int row = 0; row < tableArea.getRowCount(); row++) {
		            System.out.print("| ");
		            // Iterate over columns
		            for (int column = 0; column < tableArea.getColumnCount(); column++) {
		                // Get a table cell
		                TableAreaCell cell = tableArea.get_Item(row, column);
		  
		                // If a cell is empty or it continues another cell
		                if (cell == null || cell.getColumn() != column || cell.getRow() != row) {
		                    // Skip this cell
		                    continue;
		                }
		  
		                // Write content of the cell
		                System.out.print(cell == null ? " " : cell.getTextArea().getText());
		                System.out.print(" | ");
		            }
		  
		            System.out.println();
		        }
			}
			// ExEnd:extractTablesManually_PDF_18.12
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	/**
	 * Extracts tables from PDF document using TableAreaDetector .
	 * 
	 */
	public static void extractTablesUsingTableAreaDetector() {
		try {
			// ExStart:extractTablesUsingTableAreaDetector_PDF_18.12
			// Create a text extractor for PDF documents
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Get a table detector
		        TableAreaDetector detector = extractor.getTableAreaDetector();
		  
		        int pageIndex = 0;
		  
		        // Get a page object
		        DocumentPage page = extractor.getDocumentContent().getPage(pageIndex);
		        // Create a parameter to help the detector to search a table
		        TableAreaDetectorParameters parameter = new TableAreaDetectorParameters();
		        // We assume that the table is placed in a middle of the page and has a half page height
		        parameter.setRectangle(new Rectangle(0, page.getHeight() / 3, page.getWidth(), page.getHeight() / 2));
		        // Table hasn't merged cells
		        parameter.setMergedCells(false);
		        // Table contains 3 or more rows
		        parameter.setMinRowCount(3);
		        // Table contains 4 or more columns
		        parameter.setMinColumnCount(4);
		  
		        // Detect layouts
		        java.util.List<TableAreaLayout> layouts = detector.detectLayouts(pageIndex, parameter);
		  
		        // If layouts collection is empty - exit
		        if (layouts.size() == 0) {
		            System.out.println("No tables found");
		            return;
		        }
		  
		        // Get a table parser
		        TableAreaParser parser = extractor.getTableAreaParser();
		        // Extract a table area. As we pass only one parameter, there is only one layout
		        TableArea tableArea = parser.parseTableArea(pageIndex, layouts.get(0));
		  
		        // Iterate over rows
		        for (int row = 0; row < tableArea.getRowCount(); row++) {
		            System.out.print("| ");
		            // Iterate over columns
		            for (int column = 0; column < tableArea.getColumnCount(); column++) {
		                // Get a table cell
		                TableAreaCell cell = tableArea.get_Item(row, column);
		  
		                // If a cell is empty or it continues another cell
		                if (cell == null || cell.getColumn() != column || cell.getRow() != row) {
		                    // Skip this cell
		                    continue;
		                }
		  
		                // Write content of the cell
		                System.out.print(cell == null ? " " : cell.getTextArea().getText());
		                System.out.print(" | ");
		            }
		  
		            System.out.println();
		        }
			}
			// ExEnd:extractTablesUsingTableAreaDetector_PDF_18.12
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
