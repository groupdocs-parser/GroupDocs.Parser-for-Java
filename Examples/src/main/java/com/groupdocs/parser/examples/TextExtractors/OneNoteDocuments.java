package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.NoteTextExtractor;
import com.groupdocs.parser.examples.Common;

public class OneNoteDocuments {
	// ExStart:SourceOneNoteDocumentFilePath
	private final static String FILE_PATH = "sample.one";
	// ExEnd:SourceOneNoteDocumentFilePath

	/**
	 * Extracts whole text from a document.
	 * 
	 */
	public static void extractTextAsWhole() {
		try {
			// ExStart:extractTextAsWholeNoteTextExtractor
			// Create a text extractor for OneNote (one) documents
			try (NoteTextExtractor extractor = new NoteTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Extact a text and print it to the console
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextAsWholeNoteTextExtractor
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
			// ExStart:extractTextByLinesNoteTextExtractor
			// Create a text extractor for OneNote (one) documents
			try (NoteTextExtractor extractor = new NoteTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
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
			// ExEnd:extractTextByLinesNoteTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
