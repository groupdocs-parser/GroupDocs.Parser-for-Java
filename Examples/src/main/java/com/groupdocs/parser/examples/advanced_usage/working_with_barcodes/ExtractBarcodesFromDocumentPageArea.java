// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2022 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_barcodes;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract barcodes from the upper-right corner.
 **/
public class ExtractBarcodesFromDocumentPageArea {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdfWithBarcodes)) {
            // Check if the document supports barcodes extraction
            if (!parser.getFeatures().isBarcodes()) {
                System.out.println("Document doesn't support barcodes extraction.");
                return;
            }

            // Create the options which are used for barcodes extraction
            PageAreaOptions options = new PageAreaOptions(new Rectangle(new Point(590, 80), new Size(150, 150)));
            // Extract barcodes from the upper-right corner.
            Iterable<PageBarcodeArea> barcodes = parser.getBarcodes(options);

            // Iterate over barcodes
            for (PageBarcodeArea barcode : barcodes) {
                // Print the page index
                System.out.println("Page: " + barcode.getPage().getIndex());
                // Print the barcode value
                System.out.println("Value: " + barcode.getValue());
            }
        }
    }
}
