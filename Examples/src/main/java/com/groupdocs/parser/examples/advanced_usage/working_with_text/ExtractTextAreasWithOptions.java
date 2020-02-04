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
 * This example shows how to extract only text areas with digits from the upper-left corner.
 **/
public class ExtractTextAreasWithOptions {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
            // Create the options which are used for text area extraction
            PageTextAreaOptions options = new PageTextAreaOptions("\\s[a-z]{2}\\s", new Rectangle(new Point(0, 0), new Size(300, 100)));

            // Extract text areas which contain only digits from the upper-left corner of a page:
            Iterable<PageTextArea> areas = parser.getTextAreas(options);
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
