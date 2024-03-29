// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.loading;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * This example shows how to load a document from the stream.
 **/
public class LoadDocumentFromUrl {

    public static void run() throws java.io.IOException, java.net.MalformedURLException {
        URL url = new URL("https://www.bu.edu/csmet/files/2021/03/Getting-Started-with-SQLite.pdf");

        // Create an instance of Parser class with the url
        try (Parser parser = new Parser(url)) {
            // Extract a text into the reader
            try (TextReader reader = parser.getText()) {
                // Print a text from the document
                // If text extraction isn't supported, a reader is null
                System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
            }
        }
    }
}

