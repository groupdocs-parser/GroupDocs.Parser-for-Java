// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_text;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to search a text by pages.
 **/
public class SearchTextByPages {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdf)) {
            // Search a keyword with page numbers
            Iterable<SearchResult> sr = parser.search("lorem", new SearchOptions(false, false, false, true));
            // Check if search is supported
            if (sr == null) {
                System.out.println("Search isn't supported");
                return;
            }

            // Iterate over search results
            for (SearchResult s : sr) {
                // Print an index, page number and found text:
                System.out.println(String.format("At %d (%d): %s", s.getPosition(), s.getPageIndex(), s.getText()));
            }
        }
    }
}