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
 * This example shows how to handle warning messages.
 **/
public class OcrUsageBasicsHandler {
    public static void run() {
        try {
            // Create an instance of ParserSettings class with OCR Connector
            ParserSettings settings = new ParserSettings(new AsposeOcrOnPremise());

            // Create an instance of Parser class with settings
            try (Parser parser = new Parser(Constants.SampleScan, settings)) {
                // Create an instance of OcrEventHandler to handle warnings
                OcrEventHandler handler = new OcrEventHandler();

                // Create an instance of OcrOptions to set a handler
                OcrOptions ocrOptions = new OcrOptions(null, handler);

                // Create an instance of TextOptions to use OCR
                TextOptions options = new TextOptions(false, true, ocrOptions);
                // Extract a text using OCR
                try (TextReader reader = parser.getText(options)) {
                    // Print a text or 'not supported' message
                    System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
                }

                if (handler.hasWarnings()) {
                    System.out.println("The following warnings occur while text recognition:");

                    for (String w : handler.getWarnings()) {
                        System.out.println("\\t* " + w);
                    }
                } else {
                    System.out.println("Text recognition was performed without any warning.");
                }
            }
        } catch (java.lang.Exception ex) {
            System.out.println("An error occurs: " + ex.getMessage());
        }
    }
}