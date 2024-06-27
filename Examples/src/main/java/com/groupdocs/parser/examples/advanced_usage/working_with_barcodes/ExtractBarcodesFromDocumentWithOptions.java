// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_barcodes;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.PageBarcodeArea;
import com.groupdocs.parser.options.BarcodeOptions;
import com.groupdocs.parser.options.QualityMode;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract barcodes with additional options from a document.
 **/
public class ExtractBarcodesFromDocumentWithOptions {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdfWithBarcodes))
        {
            // Check if the document supports barcodes extraction
            if (!parser.getFeatures().isBarcodes())
            {
                System.out.println("Document doesn't support barcodes extraction.");
                return;
            }

            // Create the options which are used for barcodes extraction
            BarcodeOptions options = new BarcodeOptions(QualityMode.Low, QualityMode.Low, "QR");

            // Extract barcodes from the document.
            Iterable<PageBarcodeArea> barcodes = parser.getBarcodes(options);

            // Iterate over barcodes
            for (PageBarcodeArea barcode : barcodes)
            {
                // Print the page index
                System.out.println("Page: " + String.valueOf(barcode.getPage().getIndex()));
                // Print the barcode value
                System.out.println("Value: " + barcode.getValue());
            }
        }
    }
}
