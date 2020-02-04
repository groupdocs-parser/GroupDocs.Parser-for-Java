// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_images;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract images from a document page.
 **/
public class ExtractImagesFromDocumentPage {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
            // Check if the document supports images extraction
            if (!parser.getFeatures().isImages()) {
                System.out.println("Document isn't supports images extraction.");
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
                // Iterate over images
                // We ignore null-checking as we have checked images extraction feature support earlier
                for (PageImageArea image : parser.getImages(pageIndex)) {
                    // Print a rectangle and image type
                    System.out.println(String.format("R: %s, Text: %s", image.getRectangle(), image.getFileType()));
                }
            }
        }
    }
}
