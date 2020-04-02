// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.exceptions.UnsupportedDocumentFormatException;

import java.io.IOException;

/**
 * This example shows how to extract a text from zip entities.
 **/
public class ExtractDataFromAttachmentsAndZipArchives {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleZip)) {
            // Extract attachments from the container
            Iterable<ContainerItem> attachments = parser.getContainer();
            // Check if container extraction is supported
            if (attachments == null) {
                System.out.println("Container extraction isn't supported");
            }

            // Iterate over zip entities
            for (ContainerItem item : attachments) {
                // Print the file path
                System.out.println(item.getFilePath());
                try {
                    // Create Parser object for the zip entity content
                    try (Parser attachmentParser = item.openParser()) {
                        // Extract an zip entity text
                        try (TextReader reader = attachmentParser.getText()) {
                            System.out.println(reader == null ? "No text" : reader.readToEnd());
                        }
                    }
                } catch (UnsupportedDocumentFormatException ex) {
                    System.out.println("Isn't supported.");
                }
            }
        }
    }
}
