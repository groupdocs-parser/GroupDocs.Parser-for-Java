package com.groupdocs.parser.examples.TextExtractors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.groupdocs.parser.DocumentData;
import com.groupdocs.parser.DocumentDataField;
import com.groupdocs.parser.DocumentDataTable;
import com.groupdocs.parser.DocumentPage;
import com.groupdocs.parser.DocumentParser;
import com.groupdocs.parser.DocumentTemplate;
import com.groupdocs.parser.ImageArea;
import com.groupdocs.parser.ImageAreaSearchOptions;
import com.groupdocs.parser.PdfTextExtractor;
import com.groupdocs.parser.Rectangle;
import com.groupdocs.parser.Size;
import com.groupdocs.parser.TableArea;
import com.groupdocs.parser.TableAreaCell;
import com.groupdocs.parser.TableAreaDetector;
import com.groupdocs.parser.TableAreaDetectorParameters;
import com.groupdocs.parser.TableAreaLayout;
import com.groupdocs.parser.TableAreaParser;
import com.groupdocs.parser.TemplateField;
import com.groupdocs.parser.TemplateFieldPosition;
import com.groupdocs.parser.TemplateFieldRelatedPositionType;
import com.groupdocs.parser.TemplateTable;
import com.groupdocs.parser.examples.Common;

public class PDFDocuments {
	// ExStart:SourcePDFDocumentFilePath
	private final static String FILE_PATH = "Invoice.pdf";
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
	
	/**
	 * Extracts Data from PDF document by Field-Name.
	 * 
	 */
	public static void extractDataFromDocumentByFieldName() {
		// ExStart:extractDataFromDocumentByFieldName
		// Create a collection of template fields
		TemplateField[] templateFields = new TemplateField[]
		{
		    new TemplateField("FromCompany", TemplateFieldPosition.createFixed(new Rectangle(35, 135, 100, 10))),
		    new TemplateField("FromAddress", TemplateFieldPosition.createFixed(new Rectangle(35, 150, 100, 35))),
		    new TemplateField("FromEmail", TemplateFieldPosition.createFixed(new Rectangle(35, 190, 150, 2))),
		    new TemplateField("ToCompany", TemplateFieldPosition.createFixed(new Rectangle(35, 250, 100, 2))),
		    new TemplateField("ToAddress", TemplateFieldPosition.createFixed(new Rectangle(35, 260, 100, 15))),
		    new TemplateField("ToEmail", TemplateFieldPosition.createFixed(new Rectangle(35, 290, 150, 2))),
		    new TemplateField("InvoiceNumber", TemplateFieldPosition.createRegex("Invoice Number")),
		    new TemplateField("InvoiceNumberValue", TemplateFieldPosition.createRelated(
		            "InvoiceNumber",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("InvoiceOrder", TemplateFieldPosition.createRegex("Order Number")),
		    new TemplateField("InvoiceOrderValue", TemplateFieldPosition.createRelated(
		            "InvoiceOrder",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("InvoiceDate", TemplateFieldPosition.createRegex("Invoice Date")),
		    new TemplateField("InvoiceDateValue", TemplateFieldPosition.createRelated(
		            "InvoiceDate",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("DueDate", TemplateFieldPosition.createRegex("Due Date")),
		    new TemplateField("DueDateValue", TemplateFieldPosition.createRelated(
		            "DueDate",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("TotalDue", TemplateFieldPosition.createRegex("Total Due")),
		    new TemplateField("TotalDueValue", TemplateFieldPosition.createRelated(
		            "TotalDue",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		};
		  
		// Create detector parameters for "Details" table
		TableAreaDetectorParameters detailsTableParameters = new TableAreaDetectorParameters();
		detailsTableParameters.setRectangle(new Rectangle(35, 320, 530, 55));
		  
		// Create detector parameters for "Summary" table
		TableAreaDetectorParameters summaryTableParameters = new TableAreaDetectorParameters();
		summaryTableParameters.setRectangle(new Rectangle(330, 385, 220, 65));
		  
		// Create a collection of template tables
		TemplateTable[] templateTables = new TemplateTable[]
		{
		    new TemplateTable("details", detailsTableParameters),
		    new TemplateTable("summary", summaryTableParameters)
		};
		  
		// Create a document template
		DocumentTemplate template = new DocumentTemplate(Arrays.asList(templateFields), Arrays.asList(templateTables));
		  
		// Extract data from PDF
		DocumentData data = DocumentParser.DEFAULT.parseByTemplate(Common.mapSourceFilePath(FILE_PATH), template);
		// Get all the fields with "Address" name
		List<DocumentDataField> addressFields = data.getDataFieldsByName("Address");
		if (addressFields.size() == 0) {
		    System.out.println("Address not fount");
		} else {
		    System.out.println("Address");
		    // Iterate over the fields collection
		    for (int i = 0; i < addressFields.size(); i++) {
		        System.out.println(addressFields.get(i).getValue());
		        // If it's a related field:
		        if (addressFields.get(i).getRelatedDataField() != null) {
		            System.out.print("Linked to ");
		            System.out.println(addressFields.get(i).getRelatedDataField().getValue());
		        }
		    }
		}
		// ExEnd:extractDataFromDocumentByFieldName
	}

	/**
	 * Extracts Data Table from PDF document
	 * 
	 */
	public static void extractDataTableFromDocument() {
		// ExStart:extractDataTableFromDocument
		// Create a collection of template fields
		TemplateField[] templateFields = new TemplateField[]
		{
		    new TemplateField("FromCompany", TemplateFieldPosition.createFixed(new Rectangle(35, 135, 100, 10))),
		    new TemplateField("FromAddress", TemplateFieldPosition.createFixed(new Rectangle(35, 150, 100, 35))),
		    new TemplateField("FromEmail", TemplateFieldPosition.createFixed(new Rectangle(35, 190, 150, 2))),
		    new TemplateField("ToCompany", TemplateFieldPosition.createFixed(new Rectangle(35, 250, 100, 2))),
		    new TemplateField("ToAddress", TemplateFieldPosition.createFixed(new Rectangle(35, 260, 100, 15))),
		    new TemplateField("ToEmail", TemplateFieldPosition.createFixed(new Rectangle(35, 290, 150, 2))),
		    new TemplateField("InvoiceNumber", TemplateFieldPosition.createRegex("Invoice Number")),
		    new TemplateField("InvoiceNumberValue", TemplateFieldPosition.createRelated(
		            "InvoiceNumber",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("InvoiceOrder", TemplateFieldPosition.createRegex("Order Number")),
		    new TemplateField("InvoiceOrderValue", TemplateFieldPosition.createRelated(
		            "InvoiceOrder",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("InvoiceDate", TemplateFieldPosition.createRegex("Invoice Date")),
		    new TemplateField("InvoiceDateValue", TemplateFieldPosition.createRelated(
		            "InvoiceDate",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("DueDate", TemplateFieldPosition.createRegex("Due Date")),
		    new TemplateField("DueDateValue", TemplateFieldPosition.createRelated(
		            "DueDate",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		    new TemplateField("TotalDue", TemplateFieldPosition.createRegex("Total Due")),
		    new TemplateField("TotalDueValue", TemplateFieldPosition.createRelated(
		            "TotalDue",
		            TemplateFieldRelatedPositionType.Right,
		            new Size(200, 15))),
		};
		  
		// Create detector parameters for "Details" table
		TableAreaDetectorParameters detailsTableParameters = new TableAreaDetectorParameters();
		detailsTableParameters.setRectangle(new Rectangle(35, 320, 530, 55));
		  
		// Create detector parameters for "Summary" table
		TableAreaDetectorParameters summaryTableParameters = new TableAreaDetectorParameters();
		summaryTableParameters.setRectangle(new Rectangle(330, 385, 220, 65));
		  
		// Create a collection of template tables
		TemplateTable[] templateTables = new TemplateTable[]
		{
		    new TemplateTable("details", detailsTableParameters),
		    new TemplateTable("summary", summaryTableParameters)
		};
		  
		// Create a document template
		DocumentTemplate template = new DocumentTemplate(Arrays.asList(templateFields), Arrays.asList(templateTables));
		  
		// Extract data from PDF
		DocumentData data = DocumentParser.DEFAULT.parseByTemplate(Common.mapSourceFilePath(FILE_PATH), template);
		// Get all the tables
		List<DocumentDataTable> dataTables = data.getDataTables();
		// Iterate over tables
		for (DocumentDataTable table : dataTables) {
		    // Print a table name
		    System.out.println(table.getTableName());
		    // Iterate over rows
		    for (int r = 0; r < table.getRowCount(); r++) {
		        // Iterate over columns
		        for (int c = 0; c < table.getColumnCount(); c++) {
		            // Print a value of the cell
		            System.out.print(table.get_Item(r, c));
		            System.out.print(" ");
		        }
		  
		        System.out.println();
		    }
		}
		// ExEnd:extractDataTableFromDocument
	}
	
	/**
	 * Move Table Layout
	 * 
	 */
	public static void moveTableLayout() {
		// ExStart:moveTableLayout
		// Create a table layout
		TableAreaLayout templateLayout = new TableAreaLayout();
		  
		// with 4 columns:
		templateLayout.getVerticalSeparators().add(0.0);
		templateLayout.getVerticalSeparators().add(25.0);
		templateLayout.getVerticalSeparators().add(150.0);
		templateLayout.getVerticalSeparators().add(180.0);
		templateLayout.getVerticalSeparators().add(230.0);
		  
		// and with 5 rows:
		templateLayout.getHorizontalSeparators().add(0.0);
		templateLayout.getHorizontalSeparators().add(15.0);
		templateLayout.getHorizontalSeparators().add(30.0);
		templateLayout.getHorizontalSeparators().add(45.0);
		templateLayout.getHorizontalSeparators().add(60.0);
		templateLayout.getHorizontalSeparators().add(75.0);
		  
		// Print a rectangle
		Rectangle rect = templateLayout.getTableRectangle();
		// Prints: pos: (0, 0) size: (230, 75)
		System.out.printf("pos: (%f, %f) size: (%f, %f) \r", rect.getLeft(), rect.getTop(), rect.getWidth(), rect.getHeight());
		  
		  
		// Move layout to the definite table location
		TableAreaLayout movedLayout = templateLayout.moveTo(315, 250.0);
		  
		// Ensure that the first separators are moved:
		System.out.println(movedLayout.getVerticalSeparators().get(0)); // prints: 315
		System.out.println(movedLayout.getHorizontalSeparators().get(0)); // prints: 250
		  
		Rectangle movedRect = movedLayout.getTableRectangle();
		// Prints: pos: (315, 250) size: (230, 75)
		System.out.printf("pos: (%f, %f) size: (%f, %f) \r", movedRect.getLeft(), movedRect.getTop(), movedRect.getWidth(), movedRect.getHeight());
		  
		// movedLayout object is a copy of templateLayout object, thus we can tune separators without the impact on the original layout:
		movedLayout.getHorizontalSeparators().add(90.0);
		  
		System.out.println(movedLayout.getHorizontalSeparators().size()); // prints: 7
		System.out.println(templateLayout.getHorizontalSeparators().size()); // prints: 6
		// ExEnd:moveTableLayout
	}
	
	/**
	 * Detect Table in a Rectangular Area using Column Separators
	 * 
	 */
	
	public static void detectTableInRectangularAreaUsingColumnSeparators() {
		try {
			// ExStart:detectTableInRectangularAreaUsingColumnSeparators
			// Create a text extractor for PDF documents
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Create table detector parameters
			    TableAreaDetectorParameters parameters = new TableAreaDetectorParameters();
			  
			    // Set vertical separators
			    parameters.setVerticalSeparators(new ArrayList());
			    parameters.getVerticalSeparators().add(185.0);
			    parameters.getVerticalSeparators().add(370.0);
			    parameters.getVerticalSeparators().add(425.0);
			    parameters.getVerticalSeparators().add(485.0);
			    parameters.getVerticalSeparators().add(545.0);
			  
			    // Set a rectangular area that bounds a table
			    parameters.setRectangle(new Rectangle(175, 350, 400, 200));
			  
			    // Create a table detector
			    TableAreaDetector detector = new TableAreaDetector(extractor.getDocumentContent());
			  
			    // Detect a table on the first page with detector parameters
			    List<TableAreaLayout> layout = detector.detectLayouts(0, parameters);		        
			}
			// ExEnd:detectTableInRectangularAreaUsingColumnSeparators
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
