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
 * This example how to extract all text areas from the whole document.
 **/
public class ExtractTextAreas {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
            // Extract text areas
            Iterable<PageTextArea> areas = parser.getTextAreas();
            // Check if text areas extraction is supported
            if (areas == null) {
                System.out.println("Page text areas extraction isn't supported");
                return;
            }

            // Iterate over page text areas
            for (PageTextArea a : areas) {
                // Print a page index, rectangle and text area value:
                System.out.println(String.format("Page: %d, R: %s, Text: %s", a.getPage().getIndex(), a.getRectangle(), a.getText()));
            }
        }
    }
}
