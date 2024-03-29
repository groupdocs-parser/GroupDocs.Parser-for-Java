// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.using_ocr;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract text areas from the image file.
 **/
public class OcrUsageBasicsTextAreas {
    public static void run() {
        try {
            // Create an instance of ParserSettings class with OCR Connector
            ParserSettings settings = new ParserSettings(new AsposeOcrOnPremise());

            // Create an instance of Parser class with settings
            try (Parser parser = new Parser(Constants.SampleScan, settings)) {
                // Create an instance of PageTextAreaOptions to use OCR
                PageTextAreaOptions options = new PageTextAreaOptions(true);

                // Extract text areas
                java.lang.Iterable<PageTextArea> areas = parser.getTextAreas(options);

                // Check if text areas extraction is supported
                if (areas == null) {
                    System.out.println("Text areas extraction isn't supported");
                    return;
                }

                // Iterate over text areas
                for (PageTextArea a : areas) {
                    // Print a text, position and size for an each text area
                    System.out.println(a.getText());
                    System.out.println(String.format("\tPosition: (%d; %d)",
                            a.getRectangle().getLeft(),
                            a.getRectangle().getTop()));
                    System.out.println(String.format("\tSize: (%d; %d)",
                            a.getRectangle().getSize().getWidth(),
                            a.getRectangle().getSize().getHeight()));
                }
            }
        } catch (java.lang.Exception ex) {
            System.out.println("An error occurs: " + ex.getMessage());
        }
    }
}