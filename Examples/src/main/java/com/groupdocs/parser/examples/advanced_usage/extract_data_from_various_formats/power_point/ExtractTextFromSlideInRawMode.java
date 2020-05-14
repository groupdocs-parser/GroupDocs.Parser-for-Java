// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.power_point;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.IDocumentInfo;
import com.groupdocs.parser.options.TextOptions;

import java.io.IOException;

/**
 * This example shows how to extract a raw text from the page of Microsoft Office PowerPoint presentation.
 **/
public class ExtractTextFromSlideInRawMode {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePptx)) {
            // Get the presentation info
            IDocumentInfo presentationInfo = parser.getDocumentInfo();

            // Iterate over slides
            for (int p = 0; p < presentationInfo.getRawPageCount(); p++) {
                // Print a slide number
                System.out.println(String.format("Slide %d/%d", p + 1, presentationInfo.getRawPageCount()));

                // Extract a text into the reader
                try (TextReader reader = parser.getText(p, new TextOptions(true))) {
                    // Print a text from the presentation
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
