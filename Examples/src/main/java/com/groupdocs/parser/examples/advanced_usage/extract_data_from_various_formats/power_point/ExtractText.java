// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.power_point;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract a text from Microsoft Office PowerPoint presentation.
 **/
public class ExtractText {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePptx)) {
            // Extract a text into the reader
            try (TextReader reader = parser.getText()) {
                // Print a text from the presentation
                System.out.println(reader.readToEnd());
            }
        }
    }
}
