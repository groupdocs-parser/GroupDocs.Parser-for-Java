package com.groupdocs.parser.examples.advanced_usage.working_with_hyperlinks;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.PageHyperlinkArea;
import com.groupdocs.parser.data.Point;
import com.groupdocs.parser.data.Rectangle;
import com.groupdocs.parser.data.Size;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.PageAreaOptions;

/**
 * This example shows how to extract hyperlinks from the document page area.
 */
public class ExtractHyperlinksFromDocumentPageArea {
    public static void Run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.HyperlinksPdf)) {
            // Check if the document supports hyperlink extraction
            if (!parser.getFeatures().isHyperlinks()) {
                System.out.println("Document isn't supports hyperlink extraction.");
                return;
            }

            // Create the options which are used for hyperlink extraction
            PageAreaOptions options = new PageAreaOptions(new Rectangle(new Point(380, 90), new Size(150, 50)));

            // Extract hyperlinks from the document page area
            Iterable<PageHyperlinkArea> hyperlinks = parser.getHyperlinks(options);

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
