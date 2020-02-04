// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.loading;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to process password protected documents.
 **/
public class PasswordProtectedDocuments {
    public static void run() throws IOException {
        try {
            String password = "123456";

            // Create an instance of Parser class with the password:
            try (Parser parser = new Parser(Constants.SamplePassword, new LoadOptions(password))) {
                // Check if text extraction is supported
                if (!parser.getFeatures().isText()) {
                    System.out.println("Text extraction isn't supported.");
                    return;
                }
                // Print the document text
                try (TextReader reader = parser.getText()) {
                    System.out.println(reader.readToEnd());
                }
            }
        } catch (InvalidPasswordException ex) {
            // Print the message if the password is incorrect or empty
            System.out.println("Invalid password");
        }
    }
}
