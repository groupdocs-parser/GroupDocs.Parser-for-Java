package com.groupdocs.parser.examples.TextFormatters;

import com.groupdocs.parser.DocumentFormatter;
import com.groupdocs.parser.PlainDocumentFormatter;
import com.groupdocs.parser.PlainTableFrame;
import com.groupdocs.parser.PlainTableFrameAngle;
import com.groupdocs.parser.PlainTableFrameConfig;
import com.groupdocs.parser.PlainTableFrameEdge;
import com.groupdocs.parser.PlainTableFrameIntersection;
import com.groupdocs.parser.WordsFormattedTextExtractor;
import com.groupdocs.parser.examples.Common;

public class PlainText {
	private final static String FILE_PATH = "sample.docx";

	/**
	 * Extracts text from a document using PlainTextDocumentFormatter.
	 * 
	 */
	public static void extractTextUsingPlainTextDocumentFormatter() {
		try {
			// ExStart:extractTextUsingPlainTextDocumentFormatter
			// Create a formatted text extractor
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Set document formatter
				extractor.setDocumentFormatter(new PlainDocumentFormatter());
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextUsingPlainTextDocumentFormatter
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text from a document using PlainTextDocumentFormatter with
	 * PlainTableFrame.
	 * 
	 */
	public static void extractTextUsingPlainTextDocumentFormatterWithPlainTableFrame() {
		try {
			// ExStart:extractTextUsingPlainTextDocumentFormatterWithPlainTableFrame
			// Create a formatted text extractor
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(FILE_PATH))) {
				// Create a frame
				PlainTableFrame frame = new PlainTableFrame(PlainTableFrameAngle.ASCII, PlainTableFrameEdge.ASCII,
						PlainTableFrameIntersection.ASCII, new PlainTableFrameConfig(true, true, true, false));
				// Set a plain document formatter with the frame
				extractor.setDocumentFormatter(new PlainDocumentFormatter(frame));
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextUsingPlainTextDocumentFormatterWithPlainTableFrame
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
