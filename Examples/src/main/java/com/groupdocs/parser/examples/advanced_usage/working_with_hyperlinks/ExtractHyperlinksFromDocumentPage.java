package com.groupdocs.parser.examples.advanced_usage.working_with_hyperlinks;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.PageHyperlinkArea;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.IDocumentInfo;

/**
 * This example shows how to extract hyperlinks from the document page.
 */
public class ExtractHyperlinksFromDocumentPage {
    public static void Run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.HyperlinksPdf)) {
            // Check if the document supports hyperlink extraction
            if (!parser.getFeatures().isHyperlinks()) {
                System.out.println("Document isn't supports hyperlink extraction.");
                return;
            }

            // Get the document info
            IDocumentInfo documentInfo = parser.getDocumentInfo();
            // Check if the document has pages
            if (documentInfo.getPageCount() == 0) {
                System.out.println("Document hasn't pages.");
                return;
            }

            // Iterate over pages
            for (int pageIndex = 0; pageIndex < documentInfo.getPageCount(); pageIndex++) {
                // Print a page number
                System.out.println(String.format("Page %d/%d", pageIndex + 1, documentInfo.getPageCount()));

                // Extract hyperlinks from the document page
                Iterable<PageHyperlinkArea> hyperlinks = parser.getHyperlinks(pageIndex);

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
}
