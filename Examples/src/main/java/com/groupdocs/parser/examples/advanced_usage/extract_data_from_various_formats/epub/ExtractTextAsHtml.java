// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.epub;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract a text from EPUB e-book as HTML.
 **/
public class ExtractTextAsHtml {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleEpub)) {
            // Extract a formatted text into the reader
            try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
                // Print a formatted text from the e-book
                System.out.println(reader.readToEnd());
            }
        }
    }
}
