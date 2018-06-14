package com.groupdocs.parser.examples.Tools;

import com.groupdocs.parser.CellsTextExtractor;
import com.groupdocs.parser.ExtractorFactory;
import com.groupdocs.parser.LoadOptions;
import com.groupdocs.parser.NotificationMessage;
import com.groupdocs.parser.examples.Common;

public class Loggers {

	private final static String FILE_PATH = "sample.xlsx";

	/**
	 * Uses NotificationReceiver with extractor.
	 * 
	 */
	public static void extractTextWithNotificationReceiver() {
		try {
			// ExStart:extractTextWithNotificationReceiver
			// Create a notification receiver
			NotificationReceiver receiver = new NotificationReceiver();
			// Create load options
			LoadOptions loadOptions = new LoadOptions();
			// Set the notification receiver
			loadOptions.setNotificationReceiver(receiver);

			// Create a text extractor and pass the notification receiver via
			// loadOptions
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH),
					loadOptions)) {
				// Try to extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextWithNotificationReceiver
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * If any exception is thrown during object initialization, logger gets no
	 * notification. This is one way to handle exception.
	 * 
	 */
	public static void extractTextWithNotificationReceiverManualExceptionHandling() {
		try {
			// ExStart:extractTextWithNotificationReceiverManualExceptionHandling
			// Create a notification receiver
			NotificationReceiver receiver = new NotificationReceiver();
			// Create load options
			LoadOptions loadOptions = new LoadOptions();
			// Set the notification receiver
			loadOptions.setNotificationReceiver(receiver);

			try {
				// Create a text extractor and pass the notification receiver
				// via loadOptions
				try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH),
						loadOptions)) {
					// Try to extract a text
					System.out.println(extractor.extractAll());
				}
			}
			// This exception is thrown in the extractor's constructor
			catch (Exception ex) {
				// Manually send the message to the receiver
				receiver.processMessage(NotificationMessage.createErrorMessage(ex.getMessage(), ex));
			}
			// ExEnd:extractTextWithNotificationReceiverManualExceptionHandling
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * If any exception is thrown during object initialization, logger gets no
	 * notification. This is one way to handle exception.
	 * 
	 */
	public static void extractTextWithNotificationReceiverUsingExtractFactory() {
		try {
			// ExStart:extractTextWithNotificationReceiverUsingExtractFactory
			// Create a notification receiver for the factory
			NotificationReceiver receiverForFactory = new NotificationReceiver();
			// Create a factory with the notification receiver
			ExtractorFactory factory = new ExtractorFactory(null, null, null, receiverForFactory);

			// Create a text extractor
			try (CellsTextExtractor extractor = new CellsTextExtractor("document.xls")) {
				// Try to extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextWithNotificationReceiverUsingExtractFactory
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Extracts text with NotificationReceiver handling all notifications
	 * 
	 */
	public static void extractTextWithNotificationReceiverAllNotifications() {
		try {
			// ExStart:extractTextWithNotificationReceiverAllNotifications
			// Create a notification receiver for the factory
			NotificationReceiver receiverForFactory = new NotificationReceiver();
			// Create a factory with the notification receiver
			ExtractorFactory factory = new ExtractorFactory(null, null, null, receiverForFactory);

			// Create a notification receiver for the text extractor
			NotificationReceiver receiver = new NotificationReceiver();
			// Create load options
			LoadOptions loadOptions = new LoadOptions();
			// Set the notification receiver
			loadOptions.setNotificationReceiver(receiver);

			// Create a text extractor and pass the notification receiver via
			// loadOptions
			try (CellsTextExtractor extractor = new CellsTextExtractor(Common.mapSourceFilePath(FILE_PATH),
					loadOptions)) {
				// Try to extract a text
				System.out.println(extractor.extractAll());
			}
			// ExEnd:extractTextWithNotificationReceiverAllNotifications
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
