// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.MetadataItem;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract metadata from a document.
 **/
public class ExtractMetadataFromDocuments {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocx)) {
            // Extract metadata from the document
            Iterable<MetadataItem> metadata = parser.getMetadata();
            // Check if metadata extraction is supported
            if (metadata == null) {
                System.out.println("Metatada extraction isn't supported");
            }

            // Iterate over metadata items
            for (MetadataItem item : metadata) {
                // Print an item name and value
                System.out.println(String.format("%s: %s", item.getName(), item.getValue()));
            }
        }
    }
}
