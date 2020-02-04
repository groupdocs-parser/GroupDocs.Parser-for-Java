// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to check if text extraction feature is supported.
 **/
public class GetSupportedFeatures {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleZip)) {
            // Check if text extraction is supported for the document
            if (!parser.getFeatures().isText()) {
                System.out.println("Text extraction isn't supported");
                return;
            }

            // Extract a text from the document
            try (TextReader reader = parser.getText()) {
                System.out.println(reader.readToEnd());
            }
        }
    }
}