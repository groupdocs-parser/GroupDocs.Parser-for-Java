// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_zip_archives_and_attachments;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to iterate through container items.
 **/
public class IterateThroughContainerItems {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleZip)) {
            // Extract attachments from the container
            Iterable<ContainerItem> attachments = parser.getContainer();
            // Check if container extraction is supported
            if (attachments == null) {
                System.out.println("Container extraction isn't supported");
            }

            // Iterate over attachments
            for (ContainerItem item : attachments) {
                // Print an item name and size
                System.out.println(String.format("%s: %s", item.getName(), item.getSize()));
            }
        }
    }
}
