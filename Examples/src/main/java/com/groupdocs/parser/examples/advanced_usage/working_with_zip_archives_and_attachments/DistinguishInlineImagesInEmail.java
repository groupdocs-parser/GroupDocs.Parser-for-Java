// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_zip_archives_and_attachments;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.ContainerItem;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to distinguish inline images and other attachments in emails.
 **/
public class DistinguishInlineImagesInEmail {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.InlineImages)) {
            // Extract attachments from the container
            Iterable<ContainerItem> attachments = parser.getContainer();
            // Check if container extraction is supported
            if (attachments == null) {
                System.out.println("Container extraction isn't supported");
            }

            // Iterate over attachments
            for (ContainerItem item : attachments) {
                // Check metadata for 'disposition' item
                if (item.getMetadataValue("disposition") == "inline") {
                    // If it's 'inline' then print an item name
                    System.out.println(String.format("%s", item.getName()));
                }
            }
        }
    }
}
