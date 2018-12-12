package com.groupdocs.parser.examples;

import com.groupdocs.parser.EpubMetadataExtractor;
import com.groupdocs.parser.Extractor;
import com.groupdocs.parser.ExtractorFactory;
import com.groupdocs.parser.LoadOptions;
import com.groupdocs.parser.MetadataCollection;
import com.groupdocs.parser.MetadataExtractor; 
import com.groupdocs.parser.WordsMetadataExtractor;

public class MetadataExtraction {
	// ExStart:SourceDocumentFilePath
	private final static String FILE_PATH = "sample.docx";
	private final static String EPUB_FILE_PATH = "sample.epub";
	// ExEnd:SourceDocumentFilePath
	
	/**
	 * Shows how to create metadata extractor using ExtractFactory
	 * 
	 */
	public static void createMetadataExtractor() {
		try {
			// ExStart:createMetadataExtractorUsingExtractorFactory
			// Create a factory
			ExtractorFactory factory = new ExtractorFactory();

			// Try to create a metadata extractor from the file
			MetadataExtractor extractor = factory.createMetadataExtractor(Common.mapSourceFilePath(FILE_PATH));
			if (extractor == null) {
			    System.out.println("The document format is not supported");
			}

			// Try to create a metadata extractor from the stream
			MetadataExtractor extractor2 = factory.createMetadataExtractor(new java.io.FileInputStream(Common.mapSourceFilePath(FILE_PATH)));
			if (extractor == null) {
			    System.out.println("The document format is not supported");
			}

			// Create load options
			LoadOptions loadOptions = new LoadOptions("text/plain", java.nio.charset.Charset.forName("UTF-8"));
			// Try to create a metadata extractor from the stream with load options
			MetadataExtractor extractor3 = factory.createMetadataExtractor(new java.io.FileInputStream(Common.mapSourceFilePath(FILE_PATH)), loadOptions);
			if (extractor == null) {
			    System.out.println("The document format is not supported");
			}
			// ExEnd:createMetadataExtractorUsingExtractorFactory
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Extracts metadata from a document using MetadataExtractor.
	 * 
	 */
	public static void extractMetadataUsingMetadataExtractor() {
		try {
			// ExStart:extractMetadataUsingMetadataExtractor
			String fileName = Common.mapSourceFilePath(FILE_PATH);
			// Create a metadata extractor
			WordsMetadataExtractor extractor = new WordsMetadataExtractor();
			// Extract metadata from the file
			MetadataCollection metadata = extractor.extractMetadata(fileName);
			// Iterate over metadata keys
			for (String key : metadata.getKeys()) {
				// Write a value of the metadata key
				System.out.println(String.format("%s = %s", key, metadata.get_Item(key)));
			}
			// ExEnd:extractMetadataUsingMetadataExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts metadata from a document using ExtractorFactory.
	 * 
	 */
	public static void extractMetadataUsingExtractorClass() {
		try {
			// ExStart:extractMetadataUsingExtractorClass
			String fileName = Common.mapSourceFilePath(FILE_PATH);
			// Create an extractor
			Extractor extractor = new Extractor();
			// Try to extract metadata
			MetadataCollection metadata = extractor.extractMetadata(fileName);
			// If metadata extractor is supported
			if (metadata != null) {
				// Iterate over metadata keys
				for (String key : metadata.getKeys()) {
					// Write a value of the metadata key
					System.out.println(String.format("%s = %s", key, metadata.get_Item(key)));
				}
			} else {
				System.out.println("The document format is not supported");
			}
			// ExEnd:extractMetadataUsingExtractorClass
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts metadata from EPUB document using ComplexMetadataExtractor.
	 * 
	 */
	public static void extractMetadataUsingComplexMetadataExtractor() {
		try {
			// ExStart:extractMetadataUsingComplexMetadataExtractor
			// Create an extractor
			EpubMetadataExtractor metadataExtractor = new EpubMetadataExtractor();
			// Get an enumerator for all metadata collections of the document
			java.util.Enumeration<MetadataCollection> enumerator = metadataExtractor
					.extractComplexMetadata(Common.mapSourceFilePath(EPUB_FILE_PATH));
			// Get the metadata collection
			MetadataCollection metadata = enumerator.nextElement();
			// Iterate over metadata collections
			while (metadata != null) {
				// Iterate over metadata keys
				for (String key : metadata.getKeys()) {
					// Write a value of the metadata key
					System.out.println(String.format("%s = %s", key, metadata.get_Item(key)));
				}

				// Get the metadata collection for the next iteration
				metadata = enumerator.nextElement();
			}
			// ExEnd:extractMetadataUsingComplexMetadataExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Extracts metadata using Default Extractor
	 * 
	 */
	public static void extractMetadataUsingDefaultExtractor() {
		try {
			// ExStart:extractMetadataUsingDefaultExtractor_18.12
			// Extract metadata from the file
		    MetadataCollection metadata = Extractor.DEFAULT.extractMetadata(Common.mapSourceFilePath(FILE_PATH));
		    // Print extracted metadata
		    for (String key : metadata.getKeys()) {
		        // Print a metadata key
		        System.out.print(key);
		        System.out.print(": ");
		        // Print a metadata value
		        System.out.println(metadata.get_Item(key));
		    }
			// ExEnd:extractMetadataUsingDefaultExtractor_18.12
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
