// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_text;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract a highlight that contains 3 words.
 **/
public class ExtractHighlight {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdf)) {
            // Extract a highlight:
            HighlightItem hl = parser.getHighlight(2, true, new HighlightOptions(10,3));
            // Check if highlight extraction is supported
            if (hl == null) {
                System.out.println("Highlight extraction isn't supported");
                return;
            }
            // Print an extracted highlight
            System.out.println(String.format("At %d: %s", hl.getPosition(), hl.getText()));
        }
    }
}
