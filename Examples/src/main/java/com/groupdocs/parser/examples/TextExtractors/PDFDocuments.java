package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.ImageArea;
import com.groupdocs.parser.ImageAreaSearchOptions;
import com.groupdocs.parser.PdfTextExtractor;
import com.groupdocs.parser.Rectangle;
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

}
