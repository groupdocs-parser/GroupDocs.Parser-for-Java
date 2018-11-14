package com.groupdocs.parser.examples;

import java.io.FileNotFoundException;

import com.groupdocs.parser.CellsMediaTypeDetector;
import com.groupdocs.parser.CellsTextExtractor;
import com.groupdocs.parser.CompositeMediaTypeDetector;
import com.groupdocs.parser.DocumentInfo;
import com.groupdocs.parser.EncodingDetector;
import com.groupdocs.parser.ExtractMode;
import com.groupdocs.parser.Extractor;
import com.groupdocs.parser.ExtractorFactory;
import com.groupdocs.parser.HighlightDirection;
import com.groupdocs.parser.HighlightOptions;
import com.groupdocs.parser.IDocumentContentExtractor;
import com.groupdocs.parser.IFastTextExtractor;
import com.groupdocs.parser.IPageTextExtractor;
import com.groupdocs.parser.ITextExtractorWithFormatter;
import com.groupdocs.parser.InvalidPasswordException;
import com.groupdocs.parser.ListSearchHandler;
import com.groupdocs.parser.LoadOptions;
import com.groupdocs.parser.MarkdownDocumentFormatter;
import com.groupdocs.parser.MediaTypeDetector;
import com.groupdocs.parser.MediaTypeNames;
import com.groupdocs.parser.MetadataNames;
import com.groupdocs.parser.PdfTextExtractor;
import com.groupdocs.parser.PersonalStorageContainer;
import com.groupdocs.parser.Rectangle;
import com.groupdocs.parser.SearchHighlightOptions;
import com.groupdocs.parser.SearchOptions;
import com.groupdocs.parser.TextArea;
import com.groupdocs.parser.TextAreaSearchOptions;
import com.groupdocs.parser.TextExtractor;
import com.groupdocs.parser.WordsFormattedTextExtractor;
import com.groupdocs.parser.WordsMediaTypeDetector;
import com.groupdocs.parser.WordsTextExtractor;

public class TextExtraction {
	// ExStart:SourceDocumentFilePath
	private final static String DOC_FILE_PATH = "sample.docx";
	private final static String EXCEL_FILE_PATH = "sample.xlsx";
	private final static String OST_FILE_PATH = "sample.ost";
	private final static String PDF_FILE_PATH = "sample.pdf";
	// ExEnd:SourceDocumentFilePath

	/**
	 * Shows how to create text extractor using ExtractFactory
	 * 
	 */
	public static void createTextExtractor() {
		try {
			// ExStart:createTextExtractor
			// Create a factory
			ExtractorFactory factory = new ExtractorFactory();

			// Try to create a text extractor from the file
			try (TextExtractor extractor = factory.createTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				if (extractor == null) {
					System.out.println("The document format is not supported");
				}
			}
			// Try to create a text extractor from the stream
			try (TextExtractor extractor2 = factory
					.createTextExtractor(new java.io.FileInputStream(Common.mapSourceFilePath(DOC_FILE_PATH)))) {
				if (extractor2 == null) {
					System.out.println("The document format is not supported");
				}
			}
			// Create load options
			LoadOptions loadOptions = new LoadOptions("text/plain", java.nio.charset.Charset.forName("UTF-8"));
			// Try to create a text extractor with load options
			try (TextExtractor extractor3 = factory.createTextExtractor(
					new java.io.FileInputStream(Common.mapSourceFilePath(DOC_FILE_PATH)), loadOptions)) {
				if (extractor3 == null) {
					System.out.println("The document format is not supported");
				}
			}
			// ExEnd:createTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Shows how to create formatted text extractor using ExtractFactory
	 * 
	 */
	public static void createFormattedTextExtractor() {
		try {
			// ExStart:createFormattedTextExtractor
			// Create a factory
			ExtractorFactory factory = new ExtractorFactory();

			// Try to create a formatted text extractor from the file
			try (TextExtractor extractor = factory
					.createFormattedTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				if (extractor == null) {
					System.out.println("The document format is not supported");
				}
			}
			// Try to create a formatted text extractor from the stream
			try (TextExtractor extractor2 = factory.createFormattedTextExtractor(
					new java.io.FileInputStream(Common.mapSourceFilePath(DOC_FILE_PATH)))) {
				if (extractor2 == null) {
					System.out.println("The document format is not supported");
				}
			}
			// Create load options
			LoadOptions loadOptions = new LoadOptions("text/plain", java.nio.charset.Charset.forName("UTF-8"));
			// Try to create a formatted text extractor with load options
			try (TextExtractor extractor3 = factory.createFormattedTextExtractor(
					new java.io.FileInputStream(Common.mapSourceFilePath(DOC_FILE_PATH)), loadOptions)) {
				if (extractor3 == null) {
					System.out.println("The document format is not supported");
				}
			}
			// ExEnd:createFormattedTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Shows how to create text extractor using ExtractFactory
	 * 
	 */
	public static void createConcreteTextExtractor() {
		try {
			// ExStart:createConcreteTextExtractor
			// Create a text extractor from the file
			CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(EXCEL_FILE_PATH));
			// Extract a text
			System.out.println(extractor.extractAll());

			// Create load options
			LoadOptions loadOptions = new LoadOptions("text/plain", java.nio.charset.Charset.forName("UTF-8"));
			// Create a text extractor from the stream with load options
			CellsTextExtractor extractor2 = new CellsTextExtractor(Common.mapSourceFilePath(EXCEL_FILE_PATH),
					loadOptions);
			// Extract a text
			System.out.println(extractor.extractAll());

			// ExEnd:createConcreteTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text from a document using Extractor class.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void extractTextUsingExtractorClass() throws FileNotFoundException {
		// ExStart:extractTextUsingExtractorClass
		// Extract a text from the stream
		System.out.println(
				Extractor.DEFAULT.extractText(new java.io.FileInputStream(Common.mapSourceFilePath(DOC_FILE_PATH))));

		// Extract a text from the file
		System.out.println(Extractor.DEFAULT.extractText(Common.mapSourceFilePath(DOC_FILE_PATH)));
		// ExEnd:extractTextUsingExtractorClass
	}

	/**
	 * Extracts formatted text from a document using Extractor class.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void extractFormattedTextUsingExtractorClass() throws FileNotFoundException {
		// ExStart:extractFormattedTextUsingExtractorClass
		// Extract a text from the stream
		System.out.println(Extractor.DEFAULT
				.extractFormattedText(new java.io.FileInputStream(Common.mapSourceFilePath(DOC_FILE_PATH))));

		// Extract a text from the file
		System.out.println(Extractor.DEFAULT.extractFormattedText(Common.mapSourceFilePath(DOC_FILE_PATH)));
		// ExEnd:extractFormattedTextUsingExtractorClass
	}

	/**
	 * Extracts text from a document with media type using Extractor class.
	 * Setting {loadOptions}} will increase text extraction (because detecting
	 * media type is skipped).
	 * 
	 * @throws FileNotFoundException
	 */
	public static void extractTextWithMediaTypeUsingExtractorClass() throws FileNotFoundException {
		// ExStart:extractTextWithMediaTypeUsingExtractorClass
		// Create load options
		LoadOptions loadOptions = new LoadOptions(MediaTypeNames.Application.WORD_OPEN_XML);
		// Extract a text from the file
		System.out.println(Extractor.DEFAULT.extractText(Common.mapSourceFilePath(DOC_FILE_PATH), loadOptions));
		// ExEnd:extractTextWithMediaTypeUsingExtractorClass
	}

	/**
	 * Extracts formatted text from a document with media type using Extractor
	 * class. Setting {loadOptions}} will increase text extraction (because
	 * detecting media type is skipped).
	 * 
	 */
	public static void extractFormattedTextWithMediaTypeUsingExtractorClass() {
		// ExStart:extractFormattedTextWithMediaTypeUsingExtractorClass
		// Create load options
		LoadOptions loadOptions = new LoadOptions(MediaTypeNames.Application.WORD_OPEN_XML);
		// Extract a text from the file
		System.out
				.println(Extractor.DEFAULT.extractFormattedText(Common.mapSourceFilePath(DOC_FILE_PATH), loadOptions));
		// ExEnd:extractFormattedTextWithMediaTypeUsingExtractorClass
	}

	/**
	 * Extracts text from a document defining Extractor constructor.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void extractTextUsingExtractorClassWithConstructor() throws FileNotFoundException {
		// ExStart:extractTextUsingExtractorClassWithConstructor
		WordsMediaTypeDetector detector = new WordsMediaTypeDetector();
		// Create an encoding detector
		EncodingDetector encodingDetector = new EncodingDetector(java.nio.charset.Charset.forName("windows-1251"));
		// Create an instance of Extractor
		Extractor extractor = new Extractor(detector, encodingDetector, null);
		// Extract a text from the stream
		System.out.println(extractor.extractText(Common.mapSourceFilePath(DOC_FILE_PATH)));
		// ExEnd:extractTextUsingExtractorClassWithConstructor
	}

	/**
	 * Extracts formatted text from a document defining Extractor constructor.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void extractFormattedTextUsingExtractorClassWithConstructor() throws FileNotFoundException {
		// ExStart:extractTextUsingExtractorClassWithConstructor
		// Create an instance of Extractor with a custom document formatter
		Extractor extractor = new Extractor(null, null, null, new MarkdownDocumentFormatter());
		// Extract a Markdown-formatted text
		System.out.println(extractor.extractFormattedText(Common.mapSourceFilePath(DOC_FILE_PATH)));
		// ExEnd:extractFormattedTextUsingExtractorClassWithConstructor
	}

	/**
	 * Extracts text from a document using Text Extractor.
	 * 
	 */
	public static void extractTextUsingTextExtractor() {
		try {
			// ExStart:extractTextUsingWordTextExtractor
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Extract a text from the document
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextUsingWordTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text from a document using text mode.
	 * 
	 */
	public static void extractTextInSimpleExtractMode() {
		try {
			// ExStart:extractTextInSimpleExtractMode
			// Create a text extractor
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(EXCEL_FILE_PATH))) {
				// Set ExtractMode for the faster text extraction
				extractor.setExtractMode(ExtractMode.Simple);
				// Extract a text from the document
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextInSimpleExtractMode
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Detects source document's media type and extracts text.
	 * 
	 */
	public static void extractTextWithMediaTypeDetection() {
		try {
			// ExStart:extractTextWithMediaTypeDetection
			// Create a media type detector
			WordsMediaTypeDetector detector = new WordsMediaTypeDetector();
			String fileName = Common.mapSourceFilePath(DOC_FILE_PATH);
			// Detect a media type of the file
			String mediaType = detector.detect(fileName);
			// If media type is docx
			if (mediaType.equals(MediaTypeNames.Application.WORD_OPEN_XML)) {
				// Create a text extractor
				try (WordsTextExtractor extractor = new WordsTextExtractor(fileName)) {
					// Extract a text from the document
					System.out.println(extractor.extractAll());
				}
			}
			// ExEnd:extractTextWithMediaTypeDetection
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Detects source document's media type using CompositeMediaTypeDetector and
	 * extracts text using appropriate text extractor.
	 * 
	 */
	public static void extractTextWithCompositeMediaTypeDetection() {
		try {
			// ExStart:extractTextWithCompositeMediaTypeDetection
			// Create a composite media type detector
			CompositeMediaTypeDetector detector = new CompositeMediaTypeDetector(
					new MediaTypeDetector[] { new WordsMediaTypeDetector(), // Detector
																			// for
																			// Words
																			// documents
							new CellsMediaTypeDetector(), // Detector for Cells
															// documents
					});
			String fileName = Common.mapSourceFilePath(DOC_FILE_PATH);
			// Detect a media type of the file
			String mediaType = detector.detect(fileName);
			// If media type is docx
			if (mediaType.equals(MediaTypeNames.Application.WORD_OPEN_XML)) {
				// Create a text extractor
				try (WordsTextExtractor extractor = new WordsTextExtractor(fileName)) {
					// Extract a text from the document
					System.out.println(extractor.extractAll());
				}
			}
			// If media type is xlxs
			else if (mediaType.equals(MediaTypeNames.Application.EXCEL_OPEN_XML)) {
				// Create a text extractor
				try (CellsTextExtractor extractor = new CellsTextExtractor(fileName)) {
					// Extract a text from the document
					System.out.println(extractor.extractAll());
				}
			}
			// ExEnd:extractTextWithCompositeMediaTypeDetection
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text from a document using ExtractorFactory. ExtractorFactory
	 * automatically detects the document's format and creates the proper text
	 * extractor.
	 * 
	 */
	public static void extractTextUsingExtractorFactory() {
		try {
			// ExStart:extractTextUsingExtractorFactor
			String fileName = Common.mapSourceFilePath(DOC_FILE_PATH);
			// Create an extractor factory
			ExtractorFactory factory = new ExtractorFactory();
			// Try to create a text extractor
			try (TextExtractor extractor = factory.createTextExtractor(fileName)) {
				// If text extractor is supported (extractor != null), then
				// extract
				// a text from the document
				System.out.println(extractor != null ? extractor.extractAll() : "The document format is not supported");
			}
			// ExEnd:extractTextUsingExtractorFactory
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text and metadata information from the documents contained by
	 * OST container
	 * 
	 */
	public static void extractTextFromDocumentsContainedInOSTContainer() {
		try {
			// ExStart:extractTextFromDocumentsContainedInOSTContainer
			// Create an extractor factory
			ExtractorFactory factory = new ExtractorFactory();
			// Create a container
			try (PersonalStorageContainer container = new PersonalStorageContainer(
					Common.mapSourceFilePath(OST_FILE_PATH))) {
				// Iterate over container's entities
				for (int i = 0; i < container.getEntities().size(); i++) {
					System.out.println("Name: " + container.getEntities().get(i).getName()); // name
																								// of
																								// the
																								// file
					System.out.println("Path: " + container.getEntities().get(i).getPath().toString()); // path
																										// of
																										// the
																										// file
					System.out.println("MediaType :" + container.getEntities().get(i).getMediaType()); // media
																										// type
																										// of
																										// the
																										// file
					System.out.println("Date: " + container.getEntities().get(i).getDate().toString()); // date
																										// when
																										// the
																										// file
																										// was
																										// added
																										// to
																										// the
																										// archive
					System.out.println("Size: " + container.getEntities().get(i).getSize()); // uncompressed
																								// size
																								// of
																								// the
																								// file
					System.out.println("Subject: " + container.getEntities().get(i).get_Item(MetadataNames.SUBJECT)); // subject
																														// of
																														// the
																														// email
					System.out.println("From: " + container.getEntities().get(i).get_Item(MetadataNames.EMAIL_FROM)); // "from"
																														// addresses
																														// of
																														// the
																														// email
					System.out.println("To: " + container.getEntities().get(i).get_Item(MetadataNames.EMAIL_TO)); // "to"
																													// addresses
																													// of
																													// the
																													// email

					// Try to create a text extractor for the file of the
					// container
					try (TextExtractor extractor = factory
							.createTextExtractor(container.getEntities().get(i).openStream())) {
						System.out.println("Content:");
						// If text extractor is supported (extractor != null)
						// then extract a text from the document
						System.out.println(
								extractor != null ? extractor.extractAll() : "The document format is not supported");
					}
				}
			}
			// ExEnd:extractTextFromDocumentsContainedInOSTContainer
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text from a document using Formatted Text Extractor.
	 * 
	 */
	public static void extractFormattedTextUsingFormattedTextExtractor() {
		try {
			// ExStart:extractFormattedTextUsingFormattedTextExtractor
			// Create a formatted text extractor
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Extract a formatted text from the document
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextUsingFormattedTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text from a document using ExtractorFactory.
	 * 
	 */
	public static void extractFormattedTextUsingExtractorFactory() {
		try {
			// ExStart:extractFormattedTextUsingExtractorFactory
			String fileName = Common.mapSourceFilePath(DOC_FILE_PATH);
			// Create an extractor factory
			ExtractorFactory factory = new ExtractorFactory();
			// Try to create a formatted text extractor
			try (TextExtractor extractor = factory.createFormattedTextExtractor(fileName)) {
				// If text extractor is supported (extractor != null), then
				// extract a formatted text from the document
				System.out.println(extractor != null ? extractor.extractAll() : "The document format is not supported");
			}
			// ExEnd:extractFormattedTextUsingExtractorFactory
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text from a document with text formatter.
	 * 
	 */
	public static void extractFormattedTextWithTextFormatter() {
		try {
			// ExStart:extractFormattedTextUsingTextFormatter
			// Create a formatted text extractor
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Set a Markdown text formatter (now the text is formatted as
				// Markdown)
				extractor.setDocumentFormatter(new MarkdownDocumentFormatter());
				// Extract a formatted text from the document
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextUsingTextFormatter
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text from a document with text formatter using
	 * ITextExtractorWithFormatter. This is helpful you want to check if the
	 * extractor supports ITextExtractorWithFormatter on runtime.
	 * 
	 */
	public static void extractFormattedTextWithTextFormatterUsingITextExtractorWithFormatter() {
		try {
			// ExStart:extractFormattedTextWithTextFormatterUsingITextExtractorWithFormatter
			// Create a formatted text extractor
			try (WordsFormattedTextExtractor extractor = new WordsFormattedTextExtractor(
					Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// If the extractor supports ITextExtractorWithFormatter
				// interface
				if (extractor instanceof ITextExtractorWithFormatter) {
					// Set MarkdownDocumentFormatter formatter
					((ITextExtractorWithFormatter) extractor).setDocumentFormatter(new MarkdownDocumentFormatter());
				}
				// Extract a formatted text from the document
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractFormattedTextWithTextFormatterUsingITextExtractorWithFormatter
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts formatted text from a document with text formatter using
	 * Extractor Factory.
	 * 
	 */
	public static void extractFormattedTextWithTextFormatterUsingExtractorFactory() {
		try {
			// ExStart:extractFormattedTextWithTextFormatterUsingExtractorFactory
			String fileName = Common.mapSourceFilePath(DOC_FILE_PATH);
			// Create an extractor factory with a markdown text formatter as
			// default
			ExtractorFactory factory = new ExtractorFactory(new MarkdownDocumentFormatter());
			// Try to create a formatted text extractor
			try (TextExtractor extractor = factory.createFormattedTextExtractor(fileName)) {
				// If text extractor is supported (extractor != null), then
				// extract
				// a formatted text from the document
				System.out.println(extractor != null ? extractor.extractAll() : "The document format is not supported");
			}
			// ExEnd:extractFormattedTextWithTextFormatterUsingExtractorFactory
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts highlights.
	 * 
	 */
	public static void extractHighlights() {
		try {
			// ExStart:extractHighlights
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Extract highlights
				java.util.List<String> highlights = extractor.extractHighlights(
						HighlightOptions.createFixedLengthOptions(HighlightDirection.Left, 15, 10), // highlight
																									// from
																									// position
																									// 15
																									// to
																									// position
																									// 5
																									// (15
																									// -
																									// 10)
						HighlightOptions.createFixedLengthOptions(HighlightDirection.Right, 20, 10) // highlight
																									// from
																									// position
																									// 20
																									// to
																									// position
																									// 30
																									// (20
																									// +
																									// 10)
				);

				// Iterate over highlights
				for (int i = 0; i < highlights.size(); i++) {
					// Print the highlight
					System.out.println(highlights.get(i));
				}
			}
			// ExEnd:extractHighlights
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts highlights with CreateLineOptions. This way, highlight can be
	 * limited to line's start/end.
	 * 
	 */
	public static void extractHighlightsWithLineOptions() {
		try {
			// ExStart:extractHighlightsWithLineOptions
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Extract highlights
				java.util.List<String> highlights = extractor.extractHighlights(
						HighlightOptions.createLineOptions(HighlightDirection.Left, 15), // highlight
																							// from
																							// position
																							// 15
																							// to
																							// the
																							// beginning
																							// of
																							// the
																							// line
						HighlightOptions.createLineOptions(HighlightDirection.Right, 20) // highlight
																							// from
																							// position
																							// 20
																							// to
																							// the
																							// end
																							// of
																							// the
																							// line
				);

				// Iterate over highlights
				for (int i = 0; i < highlights.size(); i++) {
					// Print the highlight
					System.out.println(highlights.get(i));
				}
			}
			// ExEnd:extractHighlightsWithLineOptions
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts highlights with CreateWordsCountOptions. This way, highlight can
	 * be limited to the words count.
	 * 
	 */
	public static void extractHighlightsWithWordsCountOptions() {
		try {
			// ExStart:extractHighlightsWithWordsCountOptions
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Extract highlights
				java.util.List<String> highlights = extractor.extractHighlights(
						HighlightOptions.createWordsCountOptions(HighlightDirection.Left, 15, 5), // highlight
																									// with
																									// no
																									// more
																									// than
																									// 5
																									// words
																									// before
																									// position
																									// 15
						HighlightOptions.createWordsCountOptions(HighlightDirection.Right, 20, 5) // highlight
																									// with
																									// no
																									// more
																									// than
																									// 5
																									// words
																									// after
																									// position
																									// 20
				);

				// Iterate over highlights
				for (int i = 0; i < highlights.size(); i++) {
					// Print the highlight
					System.out.println(highlights.get(i));
				}
			}
			// ExEnd:extractHighlightsWithWordsCountOptions
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts highlights with SearchHighlightOptions. This way, you can find
	 * the left highlight (a text on the left side of the found text) and the
	 * right highlight (a text on the left side of the found text).
	 * 
	 */
	public static void extractHighlightsWithSearchHighlightOptions() {
		try {
			// ExStart:extractHighlightsWithSearchHighlightOptions
			// Create a text extractor
			try (WordsTextExtractor extractor = new WordsTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Create a search handler. It is used to store search results
				ListSearchHandler handler = new ListSearchHandler();
				// Create highlight options to extract a highlight with a search
				// result
				SearchHighlightOptions highlightOptions = SearchHighlightOptions.createLineOptions(100, 100);
				// Perform the search for two keywords
				extractor.search(new SearchOptions(highlightOptions), handler,
						java.util.Arrays.asList(new String[] { "test", "keyword" }));

				// If the handler contains data
				if (handler.getList().size() > 0) {
					/// Iterate over search results
					for (int i = 0; i < handler.getList().size(); i++) {
						System.out.println(handler.getList().get(i).getLeftText()); // text
																					// before
																					// the
																					// found
																					// text
						System.out.println("_");
						System.out.println(handler.getList().get(i).getFoundText()); // found
																						// text
																						// ("test
																						// text"
																						// or
																						// "keyword")
						System.out.println("_");
						System.out.println(handler.getList().get(i).getRightText()); // text
																						// after
																						// the
																						// found
																						// text
						System.out.println("---");
					}
				} else {
					System.out.println("Not found");
				}
			}
			// ExEnd:extractHighlightsWithSearchHighlightOptions
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts document pages using IPageTextExtractor
	 * 
	 */
	public static void extractDocumentPagesUsingIPageTextExtractor() {
		try {
			// ExStart:extractDocumentPagesUsingIPageTextExtractor
			// Create an extractor factory
			ExtractorFactory factory = new ExtractorFactory();
			// Create an instance of text extractor class
			try (TextExtractor extractor = factory
					.createFormattedTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH))) {
				// Check if IPageTextExtractor is supported
				IPageTextExtractor pageTextExtractor = (IPageTextExtractor) extractor;
				if (pageTextExtractor != null) {
					// Iterate over all pages
					for (int i = 0; i < pageTextExtractor.getPageCount(); i++) {
						// Print a page number
						System.out.println(String.format("%d/%d", i, pageTextExtractor.getPageCount()));
						// Extract a text from the page
						System.out.println(pageTextExtractor.extractPage(i));
					}
				}
			}
			// ExEnd:extractDocumentPagesUsingIPageTextExtractor
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text from password protected document. If the password is not
	 * set or incorrect InvalidPasswordException is thrown.
	 * 
	 */
	public static void extractTextFromPasswordProtectedDocument() {
		// ExStart:extractTextFromPasswordProtectedDocument
		// Create an instance of LoadOptions
		LoadOptions loadOptions = new LoadOptions();
		// Set the wrong document password
		loadOptions.setPassword("4321"); // or comment this line

		WordsTextExtractor extractor = null;
		try {
			// Create a text extractor for the password-protected document
			extractor = new WordsTextExtractor(Common.mapSourceFilePath(DOC_FILE_PATH), loadOptions);
			// Extract all the text from the document
			System.out.println(extractor.extractAll());
		} catch (InvalidPasswordException ex) {
			// Print the message if the password is incorrect (or empty)
			System.out.println("Invalid password.");
		}
		// ExEnd:extractTextFromPasswordProtectedDocument
	}

	/**
	 * Extracts text area from PDF document.
	 * 
	 */
	public static void extractTextAreaFromDocument() {
		// ExStart:extractTextAreaFromDocument_18.7
		try {
			// Create a text extractor
			PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(PDF_FILE_PATH));

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
		} catch (Exception ex) {
			// Print the message if the password is incorrect (or empty)
			System.out.println("Invalid password.");
		}
		// ExEnd:extractTextAreaFromDocument_18.7
	}

	/**
	 * Gets supported extractors for document
	 * 
	 */
	public static void getDocumentInfoForSupportedExtractors() {
		try {
			// ExStart:GetDocumentInfoForSupportedExtractors_18.11
			// Create a factory
			ExtractorFactory factory = new ExtractorFactory();

			// Get the document info
			DocumentInfo info = factory.getDocumentInfo(Common.mapSourceFilePath(DOC_FILE_PATH));
			System.out.println("This document contains:");

			// Check if a user can extract a plain text from a document
			if (info.hasText()) {
				System.out.println("text");
			}

			// Check if a user can extract a formatted text from a document
			if (info.hasFormattedText()) {
				System.out.println("formatted text");
			}

			// Check if a user can extract metadata from a document
			if (info.hasMetadata()) {
				System.out.println("metadata");
			}

			// Check if the document contains other documents
			if (info.isContainer()) {
				System.out.println("other documents");
			}
			// ExEnd:GetDocumentInfoForSupportedExtractors_18.11
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts a text from a file or stream using IFastTextExtractor
	 * 
	 */
	public static void extractTextUsingIFastTextExtractor() {
		try {
			// ExStart:extractTextUsingIFastTextExtractor_18.11
			try (PdfTextExtractor extractor = new PdfTextExtractor(Common.mapSourceFilePath(PDF_FILE_PATH))) {
				// Check if extractor supports IFastTextExtractor interface
				if (extractor instanceof IFastTextExtractor) {
					// Set the mode of text extraction
					((IFastTextExtractor) extractor).setExtractMode(ExtractMode.Simple);
				}
				// Extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextUsingIFastTextExtractor_18.11
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	/**
	 * Extracts a text from a file using IDocumentContentExtractor
	 * 
	 */
	public static void extractTextFromDocumentUsingIDocumentContentExtractor() {
		try {
			// ExStart:ExtractTextFromDocumentUsingIDocumentContentExtractor_caller_18.11
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(EXCEL_FILE_PATH))) {
				extractTextUsingIDocumentContentExtractor(extractor);
			}
			// ExEnd:ExtractTextFromDocumentUsingIDocumentContentExtractor_caller_18.11
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	/**
	 * Extracts text areas from the document using IDocumentContentExtractor
	 * 
	 */
	public static void extractTextUsingIDocumentContentExtractor(TextExtractor extractor) {
		try {
			// ExStart:extractTextUsingIDocumentContentExtractor_18.11
			// Check if extractor supports IDocumentContentExtractor interface
		    if (extractor instanceof IDocumentContentExtractor) {
		        IDocumentContentExtractor contentExtractor = (IDocumentContentExtractor) extractor;
		        // Iterate over pages
		        for (int i = 0; i < contentExtractor.getDocumentContent().getPageCount(); i++) {
		            // Iterate over text areas of the page
		            for (TextArea textArea : contentExtractor.getDocumentContent().getTextAreas(i)) {
		                System.out.println(textArea.getText());
		            }
		        }
		    }
			// ExEnd:extractTextUsingIDocumentContentExtractor_18.11
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
