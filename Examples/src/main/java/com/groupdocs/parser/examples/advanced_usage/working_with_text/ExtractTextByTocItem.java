package com.groupdocs.parser.examples.advanced_usage.working_with_text;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.data.TocItem;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example how to extract a text by the an item of table of contents.
 */
public class ExtractTextByTocItem {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocxWithToc)) {
            // Get table of contents
            Iterable<TocItem> tocItems = parser.getToc();

            // Check if toc extraction is supported
            if (tocItems == null) {
                System.out.println("Table of contents extraction isn't supported");
            }

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
