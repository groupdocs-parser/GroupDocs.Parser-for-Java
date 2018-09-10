package com.groupdocs.parser.examples;

import com.groupdocs.parser.examples.StructuredHandlers.Headers;
import com.groupdocs.parser.examples.TextExtractors.CHMDocuments;
import com.groupdocs.parser.examples.TextExtractors.EPUBDocuments;
import com.groupdocs.parser.examples.TextExtractors.EmailMessages;
import com.groupdocs.parser.examples.TextExtractors.FictionBookDocuments;
import com.groupdocs.parser.examples.TextExtractors.MarkdownDocuments;
import com.groupdocs.parser.examples.TextExtractors.OneNoteDocuments;
import com.groupdocs.parser.examples.TextExtractors.PDFDocuments;
import com.groupdocs.parser.examples.TextExtractors.PresentationDocuments;
import com.groupdocs.parser.examples.TextExtractors.SpreadsheetDocuments;
import com.groupdocs.parser.examples.TextExtractors.TextDocuments;
import com.groupdocs.parser.examples.TextFormatters.HTML;
import com.groupdocs.parser.examples.TextFormatters.Markdown;
import com.groupdocs.parser.examples.TextFormatters.PlainText;
import com.groupdocs.parser.examples.Tools.EncodingDetector;
import com.groupdocs.parser.examples.Tools.Indexer;
import com.groupdocs.parser.examples.Tools.Loggers;
import com.groupdocs.parser.examples.Tools.MediaTypeDetectors;

public class MainClass {
	public static void main(String[] args) throws Throwable {

		// Uncomment following code if you have license file
		Common.applyLicenseFromStream();

		// Using metered license
		// Common.useDynabicMeteredAccount();

		//// Extract plain text
		// TextExtraction.extractTextUsingExtractorClass();
		// TextExtraction.extractTextWithMediaTypeUsingExtractorClass();
		// TextExtraction.extractTextUsingExtractorClassWithConstructor();
		// TextExtraction.extractTextUsingTextExtractor();
		// TextExtraction.extractTextWithMediaTypeDetection();
		// TextExtraction.extractTextWithCompositeMediaTypeDetection();
		// TextExtraction.extractTextUsingExtractorFactory();
		// TextExtraction.extractTextFromDocumentsContainedInOSTContainer();
		// TextExtraction.extractTextInSimpleExtractMode();

		//// Extract formatted text
		// TextExtraction.extractFormattedTextUsingExtractorClass();
		// TextExtraction.extractFormattedTextUsingFormattedTextExtractor();
		// TextExtraction.extractFormattedTextUsingExtractorFactory();
		// TextExtraction.extractFormattedTextWithTextFormatter();
		// TextExtraction.extractFormattedTextWithTextFormatterUsingITextExtractorWithFormatter();
		// TextExtraction.extractFormattedTextWithTextFormatterUsingExtractorFactory();
		// TextExtraction.extractFormattedTextUsingExtractorClassWithConstructor();
		// TextExtraction.extractFormattedTextWithMediaTypeUsingExtractorClass();

		//// Extract highlights
		// TextExtraction.extractHighlights();
		// TextExtraction.extractHighlightsWithLineOptions();
		// TextExtraction.extractHighlightsWithWordsCountOptions();
		// TextExtraction.extractHighlightsWithSearchHighlightOptions();

		//// Extract document pages
		// TextExtraction.extractDocumentPagesUsingIPageTextExtractor();
		// Extract text from password protected document
		// TextExtraction.extractTextFromPasswordProtectedDocument();

		//// Text search
		// TextSearch.searchText();
		// TextSearch.searchWholeWord();
		// TextSearch.searchWithRegularExpression();

		//// Metadata extraction
		// MetadataExtraction.createMetadataExtractor();
		// MetadataExtraction.extractMetadataUsingComplexMetadataExtractor();
		// MetadataExtraction.extractMetadataUsingExtractorFactory();
		// MetadataExtraction.extractMetadataUsingMetadataExtractor();

		//// region Text extractors
		//// Working with text documents
		// TextDocuments.extractFormattedText();
		// TextDocuments.extractTextAsWhole();
		// TextDocuments.extractTextByLines();

		//// Working with spreadsheet documents
		// SpreadsheetDocuments.extractFormattedText();
		// SpreadsheetDocuments.extractSelectedColumns();
		// SpreadsheetDocuments.extractSelectedColumnsByRows();
		// SpreadsheetDocuments.extractSheetByRows();
		// SpreadsheetDocuments.extractTextAsWhole();
		// SpreadsheetDocuments.extractTextByLines();

		//// Working with presentation documents
		// PresentationDocuments.extractFormattedText();
		// PresentationDocuments.extractTextAsWhole();
		// PresentationDocuments.extractTextByLines();

		//// Working with PDF documents
		// PDFDocuments.extractTextAsWhole();
		// PDFDocuments.extractTextByLines();
		//PDFDocuments.extractDataFromPDFForms();

		//// Working with OneNote documents
		// OneNoteDocuments.extractTextAsWhole();
		// OneNoteDocuments.extractTextByLines();

		//// Working with FB2 documents
		// FictionBookDocuments.extractFormattedText();
		// FictionBookDocuments.extractTextAsWhole();
		// FictionBookDocuments.extractTextByLines();

		//// Working with EPUB documents
		// EPUBDocuments.extractFormattedText();
		// EPUBDocuments.extractTextAsWhole();
		// EPUBDocuments.extractTextByLines();
		// EPUBDocuments.extractTextFromContentDocument();
		// EPUBDocuments.getContentDocument();
		// EPUBDocuments.getEPUBPackages();
		// EmailMessages.extractAttachments();

		//// Working with CHM documents
		// CHMDocuments.extractTextAsWhole();
		// CHMDocuments.extractTextByLines();
		// CHMDocuments.extractFormattedText();
		// CHMDocuments.extractFormattedTextByLines();
		// CHMDocuments.extractFormattedTextUsingTextFormatter();
		// CHMDocuments.extractTableOfContent();
		// CHMDocuments.extractTextOfItemInTOC();

		//// Working with markdown documents
		// MarkdownDocuments.extractSingleLineAsRawText();
		// MarkdownDocuments.extractAllCharactersAsRawText();
		// MarkdownDocuments.extractSingleLineAsFormattedText();
		// MarkdownDocuments.extractAllCharactersAsFormattedText();
		// MarkdownDocuments.extractFormattedTextUsingDocumentFormatter();
		// MarkdownDocuments.extractStructuredText();
		// endregion

		//// Text formatters
		// HTML.extractTextUsingHTMLDocumentFormatter();
		// Markdown.extractTextUsingMarkdownDocumentFormatter();
		// PlainText.extractTextUsingPlainTextDocumentFormatter();
		// PlainText.extractTextUsingPlainTextDocumentFormatterWithPlainTableFrame();

		//// Tools
		// EncodingDetector.detectEncoding();
		// Loggers.extractTextWithNotificationReceiver();
		// Loggers.extractTextWithNotificationReceiverAllNotifications();
		// Loggers.extractTextWithNotificationReceiverManualExceptionHandling();
		// Loggers.extractTextWithNotificationReceiverUsingExtractFactory();
		// MediaTypeDetectors.detectMediaTypeByContent();
		// MediaTypeDetectors.detectMediaTypeByExtension();
		// MediaTypeDetectors.IsMediaTypeSupportedByDetector();
		
		// This feature allows providing a password for protected documents on-demand
		//ExStart:requestPasswordForProtectedDocument_usage_18.9
		// Indexer indexer = new Indexer();
		// indexer.process(new java.io.File(Common.STORAGE_PATH.toString()));
		//ExEnd:requestPasswordForProtectedDocument_usage_18.9
		
		//// Containers
		// Containers.createEmailConnectionInfo();
		// Containers.enumerateAllEntitiesOfGroupOfContainers();
		// Containers.extractMessagesFromOST();
		// Containers.getListOfEmailsFromEWS();
		// Containers.retrieveAnEmailFromEWS();
		//Containers.extractTextFromDatabase();

		//// Structured handlers
		// StructuredHandlers.Headers hd = new Headers();
		// hd.extractHeader(new
		//// java.io.FileInputStream(Common.mapSourceFilePath("sample.docx")));

		// StructuredHandlers.Hyperlinks hl = new
		// StructuredHandlers.Hyperlinks();
		// hl.extract(new
		// java.io.FileInputStream(Common.mapSourceFilePath("sample.docx")));

		System.out.println("Operation Completed...");
	}
}
