// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
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

/**
 * This example how to specify the file format when loading the document.
 **/
public class LoadingSpecificFileFormats {
    public static void run() throws IOException {
        try (InputStream stream = new FileInputStream(Constants.SampleMd)) {
            // Create an instance of Parser class for markdown document
            try (Parser parser = new Parser(stream, new LoadOptions(FileFormat.Markup))) {
                // Check if text extraction is supported
                if (!parser.getFeatures().isText()) {
                    System.out.println("Text extraction isn't supported.");
                    return;
                }
                try (TextReader reader = parser.getText()) {
                    // Print the document text
                    // Markdown is detected; text without special symbols is printed
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
