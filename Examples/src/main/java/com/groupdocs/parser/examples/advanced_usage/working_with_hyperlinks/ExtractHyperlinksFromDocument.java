package com.groupdocs.parser.examples.advanced_usage.working_with_hyperlinks;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.PageHyperlinkArea;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract hyperlinks from the whole document.
 */
public class ExtractHyperlinksFromDocument {
    public static void Run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.HyperlinksPdf)) {
            // Check if the document supports hyperlink extraction
            if (!parser.getFeatures().isHyperlinks()) {
                System.out.println("Document isn't supports hyperlink extraction.");
                return;
            }

            // Extract hyperlinks from the document
            Iterable<PageHyperlinkArea> hyperlinks = parser.getHyperlinks();

            // Iterate over hyperlinks
            for (PageHyperlinkArea h : hyperlinks) {
                // Print the hyperlink text
                System.out.println(h.getText());
                // Print the hyperlink URL
                System.out.println(h.getUrl());

                System.out.println();
            }
        }
    }
}
