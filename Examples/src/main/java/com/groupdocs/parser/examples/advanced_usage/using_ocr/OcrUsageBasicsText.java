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
 * This example shows how to extract a text from the image file.
 **/
public class OcrUsageBasicsText {
    public static void run() {
        try {
            // Create an instance of ParserSettings class with OCR Connector
            ParserSettings settings = new ParserSettings(new AsposeOcrOnPremise());

            // Create an instance of Parser class with settings
            try (Parser parser = new Parser(Constants.SampleScan, settings)) {
                // Create an instance of TextOptions to use OCR
                TextOptions options = new TextOptions(false, true);
                // Extract a text using OCR
                try (TextReader reader = parser.getText(options)) {
                    // Print a text or 'not supported' message
                    System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
                }
            }
        } catch (java.lang.Exception ex) {
            System.out.println("An error occurs: " + ex.getMessage());
        }
    }
}