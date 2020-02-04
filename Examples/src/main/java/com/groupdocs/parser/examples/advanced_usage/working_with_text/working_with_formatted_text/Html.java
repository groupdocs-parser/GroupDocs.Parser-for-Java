// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_text.working_with_formatted_text;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract a document text as HTML text.
 **/
public class Html {
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
