package com.groupdocs.parser.examples.Tools;

import com.groupdocs.parser.INotificationReceiver;
import com.groupdocs.parser.NotificationMessage;

//ExStart:SimpleLogger
// Class to process notification messages
class NotificationReceiver implements INotificationReceiver {
	// This method accepts any messages
	public void processMessage(NotificationMessage message) {
		// Just write message's description to the console
		System.out.println(message.getDescription());
	}
}
// ExEnd:SimpleLogger
