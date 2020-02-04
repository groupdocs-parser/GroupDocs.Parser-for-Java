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
 * This example shows how to extract a page text from a document.
 **/
public class ExtractTextFromPageInAccurateMode {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdf)) {
            // Check if the document supports text extraction
            if (!parser.getFeatures().isText()) {
                System.out.println("Document isn't supports text extraction.");
                return;
            }

            // Get the document info
            IDocumentInfo documentInfo = parser.getDocumentInfo();
            // Check if the document has pages
            if (documentInfo.getPageCount() == 0) {
                System.out.println("Document hasn't pages.");
                return;
            }

            // Iterate over pages
            for (int p = 0; p < documentInfo.getPageCount(); p++) {
                // Print a page number
                System.out.println(String.format("Page %d/%d", p + 1, documentInfo.getPageCount()));

                // Extract a text into the reader
                try (TextReader reader = parser.getText(p)) {
                    // Print a text from the document
                    // We ignore null-checking as we have checked text extraction feature support earlier
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
