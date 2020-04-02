// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.*;

import java.io.IOException;

/**
 * This example shows how to extract a document text as HTML text.
 **/
public class ExtractFormattedTextFromDocuments {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocx)) {
            // Extract a formatted text into the reader
            try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
                // Print a formatted text from the document
                // If formatted text extraction isn't supported, a reader is null
                System.out.println(reader == null ? "Formatted text extraction isn't suppported" : reader.readToEnd());
            }
        }
    }
}
