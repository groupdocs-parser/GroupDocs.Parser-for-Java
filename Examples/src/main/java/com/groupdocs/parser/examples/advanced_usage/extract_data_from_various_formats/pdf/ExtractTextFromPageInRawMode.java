// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.pdf;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.IDocumentInfo;
import com.groupdocs.parser.options.TextOptions;

import java.io.IOException;

/**
 * This example shows how to extract a raw text from the page of Pdf document.
 **/
public class ExtractTextFromPageInRawMode {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdf)) {
            // Get the document info
            IDocumentInfo documentInfo = parser.getDocumentInfo();

            // Iterate over pages
            for (int p = 0; p < documentInfo.getRawPageCount(); p++) {
                // Print a page number
                System.out.println(String.format("Page %d/%d", p + 1, documentInfo.getRawPageCount()));

                // Extract a text into the reader
                try (TextReader reader = parser.getText(p, new TextOptions(true))) {
                    // Print a text from the document page
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
