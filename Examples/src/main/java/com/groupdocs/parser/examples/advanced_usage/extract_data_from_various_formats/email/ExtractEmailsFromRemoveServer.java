// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.email;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract emails from Exchange Server.
 **/
public class ExtractEmailsFromRemoveServer {
    public static void run() throws IOException {
        // Create the connection object for Exchange Web Services protocol
        EmailConnection connection = new EmailEwsConnection(
                "https://outlook.office365.com/ews/exchange.asmx",
                "email@server",
                "password");

        // Create an instance of Parser class to extract emails from the remote server
        try (Parser parser = new Parser(connection)) {
            // Check if container extraction is supported
            if (!parser.getFeatures().isContainer()) {
                System.out.println("Container extraction isn't supported.");
                return;
            }

            // Extract email messages from the server
            Iterable<ContainerItem> emails = parser.getContainer();

            // Iterate over attachments
            for (ContainerItem item : emails) {
                // Create an instance of Parser class for email message
                try (Parser emailParser = item.openParser()) {
                    // Extract the email text
                    try (TextReader reader = emailParser.getText()) {
                        // Print the email text
                        System.out.println(reader == null ? "Text extraction isn't supported." : reader.readToEnd());
                    }
                }
            }
        }
    }
}
