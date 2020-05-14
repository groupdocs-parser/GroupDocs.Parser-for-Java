// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract data from Sqlite database with connection string.
 **/
public class ExtractDataFromDatabases {
    public static void run() throws IOException {
        String connectionString = String.format("jdbc:sqlite:%s", Constants.SampleDatabase);
        // Create an instance of Parser class to extract tables from the database
        // As filePath connection parameters are passed; LoadOptions is set to Database file format
        try (Parser parser = new Parser(connectionString, new LoadOptions(FileFormat.Database))) {
            // Check if text extraction is supported
            if (!parser.getFeatures().isText()) {
                System.out.println("Text extraction isn't supported.");
                return;
            }
            // Check if toc extraction is supported
            if (!parser.getFeatures().isToc()) {
                System.out.println("Toc extraction isn't supported.");
                return;
            }
            // Get a list of tables
            Iterable<TocItem> toc = parser.getToc();
            // Iterate over tables
            for (TocItem i : toc) {
                // Print the table name
                System.out.println(i.getText());
                // Extract a table content as a text
                try (TextReader reader = parser.getText(i.getPageIndex())) {
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
