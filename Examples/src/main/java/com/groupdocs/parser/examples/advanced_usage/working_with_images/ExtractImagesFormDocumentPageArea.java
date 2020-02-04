// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_images;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract only images from the upper-right corner.
 **/
public class ExtractImagesFormDocumentPageArea {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
            // Create the options which are used for images extraction
            PageAreaOptions options = new PageAreaOptions(new Rectangle(new Point(340, 150), new Size(300, 100)));
            // Extract images from the upper-left corner of a page:
            Iterable<PageImageArea> images = parser.getImages(options);
            // Check if images extraction is supported
            if (images == null) {
                System.out.println("Page images extraction isn't supported");
                return;
            }
            // Iterate over images
            for (PageImageArea image : images) {
                // Print a page index, rectangle and image type:
                System.out.println(String.format("Page: %d, R: %s, Type: %s", image.getPage().getIndex(), image.getRectangle(), image.getFileType()));
            }
        }
    }
}
