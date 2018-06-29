package com.groupdocs.parser.examples.TextExtractors;

import com.groupdocs.parser.EmailTextExtractor;
import com.groupdocs.parser.ExtractorFactory;
import com.groupdocs.parser.TextExtractor;
import com.groupdocs.parser.examples.Common;

public class EmailMessages {
	// ExStart:SourceEmailFilePath
	private final static String FILE_PATH = "sample.msg";

	// ExEnd:SourceEmailFilePath
	/**
	 * Extracts email's attachments
	 * 
	 */
	public static void extractAttachments() {
		try {
			// ExStart:extractAttachments
			// Create an extractor factory
			ExtractorFactory factory = new ExtractorFactory();
			// Create an email text extractor
			try (EmailTextExtractor extractor = new EmailTextExtractor(Common.mapSourceFilePath(FILE_PATH))) {
				// Iterate over attachments
				for (int i = 0; i < extractor.getEntities().size(); i++) {
					// Try to create a text extractor for the attachment
					TextExtractor attachmentExtractor = factory
							.createTextExtractor(extractor.getEntities().get(i).openStream());
					// If the text extractor is supported (extractor != null),
					// then extract a text from the attachment
					System.out.println(attachmentExtractor == null ? "Document format isn't supported"
							: attachmentExtractor.extractAll());
				}
			}
			// ExEnd:extractAttachments
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
