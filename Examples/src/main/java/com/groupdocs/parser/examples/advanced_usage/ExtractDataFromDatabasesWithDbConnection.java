package com.groupdocs.parser.examples.advanced_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.data.TocItem;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to extract data from Sqlite database with {@link java.sql.Connection} object.
 **/
public class ExtractDataFromDatabasesWithDbConnection {
    public static void Run() throws java.sql.SQLException, IOException {
        // Create DbConnection object
        java.sql.Connection connection = java.sql.DriverManager.getConnection(String.format("jdbc:sqlite:%s", Constants.SampleDatabase));
        // Create an instance of Parser class to extract tables from the database
        try (Parser parser = new Parser(connection)) {
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
            for(TocItem i : toc)
            {
                // Print the table name
                System.out.println(i.extractText());
                // Extract a table content as a text
                try(TextReader reader = parser.getText(i.getPageIndex().intValue()))
                {
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
