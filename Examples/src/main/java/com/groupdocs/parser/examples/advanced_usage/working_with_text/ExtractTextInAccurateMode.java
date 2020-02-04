// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_text;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract a text from a document.
 **/
public class ExtractTextInAccurateMode {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdf)) {
            // Extract a text into the reader
            try (TextReader reader = parser.getText()) {
                // Print a text from the document
                // If text extraction isn't supported, a reader is null
                System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
            }
        }
    }
}
