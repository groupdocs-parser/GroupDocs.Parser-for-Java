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
 * This example shows how to extract barcodes from a document.
 **/
public class ExtractBarcodesFromDocument {
    public static void run() {
        // Create an instance of Parser class
        try(Parser parser = new Parser(Constants.SamplePdfWithBarcodes))
        {
            // Check if the document supports barcodes extraction
            if (!parser.getFeatures().isBarcodes()) {
                System.out.println("Document doesn't support barcodes extraction.");
                return;
            }

            // Extract barcodes from the document.
            Iterable<PageBarcodeArea> barcodes = parser.getBarcodes();

            // Iterate over barcodes
            for(PageBarcodeArea barcode : barcodes)
            {
                // Print the page index
                System.out.println("Page: " + barcode.getPage().getIndex());
                // Print the barcode value
                System.out.println("Value: " + barcode.getValue());
            }
        }
    }
}