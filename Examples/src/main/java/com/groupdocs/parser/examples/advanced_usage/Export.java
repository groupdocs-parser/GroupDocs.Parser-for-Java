// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage;

import java.io.IOException;
import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.export.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to export data to XML file.
 **/
public class Export {
    public static void run() throws IOException {
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

            // Extract barcodes from the document
            Iterable<PageBarcodeArea> barcodes = parser.getBarcodes(options);

            // Export data to "data.xml" file
            XmlExporter exporter = new XmlExporter();
            exporter.exportBarcodes(barcodes, "data.xml");
        }
    }
}