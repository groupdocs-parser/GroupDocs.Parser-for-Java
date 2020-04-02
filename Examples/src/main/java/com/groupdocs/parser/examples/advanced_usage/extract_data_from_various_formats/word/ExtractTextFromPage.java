// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.word;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract a text from the page of Microsoft Office Word document.
 **/
public class ExtractTextFromPage {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocxWithToc)) {
            // Get the document info
            IDocumentInfo documentInfo = parser.getDocumentInfo();

            // Iterate over pages
            for (int p = 0; p < documentInfo.getPageCount(); p++) {
                // Print a page number
                System.out.println(String.format("Page %d/%d", p + 1, documentInfo.getPageCount()));

                // Extract a text into the reader
                try (TextReader reader = parser.getText(p)) {
                    // Print a text from the document
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
