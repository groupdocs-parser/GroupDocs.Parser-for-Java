// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.epub;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to search with a regular expression in EPUB e-book.
 **/
public class SearchTextByRegularExpression {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleEpub)) {
            // Search with a regular expression with case matching
            Iterable<SearchResult> sr = parser.search("\\slist", new SearchOptions(true, false, true));

            // Iterate over search results
            for (SearchResult s : sr) {
                // Print an index and found text:
                System.out.println(String.format("At %d: %s", s.getPosition(), s.getText()));
            }
        }
    }
}
