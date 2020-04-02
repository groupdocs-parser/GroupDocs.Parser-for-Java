// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.epub;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.data.TocItem;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example how to extract a text by the an item of table of contents.
 */
public class ExtractTableOfContents {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleEpub)) {
            // Get table of contents
            Iterable<TocItem> tocItems = parser.getToc();

            // Iterate over items
            for (TocItem tocItem : tocItems) {
                // Print the text of the chapter
                try (TextReader reader = tocItem.extractText()) {
                    System.out.println("----");
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
