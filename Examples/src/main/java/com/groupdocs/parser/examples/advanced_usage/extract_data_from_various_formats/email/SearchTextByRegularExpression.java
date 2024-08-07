// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.email;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to search with a regular expression in an email.
 **/
public class SearchTextByRegularExpression {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleMsg)) {
            // Search with a regular expression with case matching
            Iterable<SearchResult> sr = parser.search("\\sthe\\s", new SearchOptions(true, false, true));

            // Iterate over search results
            for (SearchResult s : sr) {
                // Print an index and found text:
                System.out.println(String.format("At %d: %s", s.getPosition(), s.getText()));
            }
        }
    }
}
