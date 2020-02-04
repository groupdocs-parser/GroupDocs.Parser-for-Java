// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to receive the information via ILogger interface.
 **/
public class Logging {
    public static void run() {
        try {
            // Create an instance of Logger class
            Logger logger = new Logger();

            // Create an instance of Parser class with the parser settings
            try (Parser parser = new Parser(Constants.SamplePassword, null, new ParserSettings(logger))) {
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
        } catch (InvalidPasswordException | IOException ex) {
            ; // Ignore the exception
        }
    }
}

class Logger implements ILogger {
    public void error(String message, Exception exception) {
        // Print error message
        System.out.println("Error: " + message);
    }

    public void trace(String message) {
        // Print event message
        System.out.println("Event: " + message);
    }

    public void warning(String message) {
        // Print warning message
        System.out.println("Warning: " + message);
    }
}
