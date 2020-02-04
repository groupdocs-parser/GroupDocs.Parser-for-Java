// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.loading;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to load a document from the local disk.
 **/
public class LoadDocumentFromLocalDisk {
    public static void run() throws IOException {
        // Set the filePath
        String filePath = Constants.SamplePdf;
        // Create an instance of Parser class with the filePath
        try (Parser parser = new Parser(filePath)) {
            // Extract a text into the reader
            try (TextReader reader = parser.getText()) {
                // Print a text from the document
                // If text extraction isn't supported, a reader is null
                System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
            }
        }
    }
}
