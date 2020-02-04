// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract table of contents from EPUB ebook.
 **/
public class ExtractTableOfContents {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleEpub)) {
            // Check if text extraction is supported
            if (!parser.getFeatures().isText()) {
                System.out.println("Text extraction isn't supported.");
                return;
            }
            // Check if toc extraction is supported
            if (!parser.getFeatures().isToc()) {
                System.out.println("Toc extraction isn't supported.");
                return;
            }
            // Get table of contents
            Iterable<TocItem> toc = parser.getToc();
            // Iterate over items
            for (TocItem i : toc) {
                // Print the Toc text
                System.out.println(i.getText());

                // Check if page index has a value
                if (i.getPageIndex() == null) {
                    continue;
                }

                // Extract a page text
                try (TextReader reader = parser.getText(i.getPageIndex())) {
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
