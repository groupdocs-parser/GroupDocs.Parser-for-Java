// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.quick_start;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract a text form a document.
 **/
public class HelloWorld {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocx)) {
            // Extract a text to the reader
            try (TextReader reader = parser.getText()) {
                // Print an extracted text (or "not supported" message)
                System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
            }
        }
    }
}
