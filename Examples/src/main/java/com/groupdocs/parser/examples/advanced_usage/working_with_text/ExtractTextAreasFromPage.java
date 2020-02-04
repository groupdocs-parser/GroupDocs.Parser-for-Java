// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_text;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract text areas from a document page.
 **/
public class ExtractTextAreasFromPage {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
            // Check if the document supports text areas extraction
            if (!parser.getFeatures().isTextAreas()) {
                System.out.println("Document isn't supports text areas extraction.");
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
            for (int pageIndex = 0; pageIndex < documentInfo.getPageCount(); pageIndex++) {
                // Print a page number
                System.out.println(String.format("Page %d/%d", pageIndex + 1, documentInfo.getPageCount()));

                // Iterate over page text areas
                // We ignore null-checking as we have checked text areas extraction feature support earlier
                for (PageTextArea a : parser.getTextAreas(pageIndex)) {
                    // Print a rectangle and text area value:
                    System.out.println(String.format("R: %s, Text: %s", a.getRectangle(), a.getText()));
                }
            }
        }
    }
}
