// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.word;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.MetadataItem;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract metadata from a Microsoft Office document.
 **/
public class ExtractMetadata {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocx)) {
            // Extract metadata from the document
            Iterable<MetadataItem> metadata = parser.getMetadata();

            // Iterate over metadata items
            for (MetadataItem item : metadata) {
                // Print an item name and value
                System.out.println(String.format("%s: %s", item.getName(), item.getValue()));
            }
        }
    }
}
