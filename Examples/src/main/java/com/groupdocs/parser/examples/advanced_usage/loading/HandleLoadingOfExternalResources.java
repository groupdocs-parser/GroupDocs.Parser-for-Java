// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2023 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.loading;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.IOException;

/**
 * This example shows how to handle loading of external resources.
 **/
public class HandleLoadingOfExternalResources {
    public static void run() throws IOException {
        // Create an instance of ParserSettings to pass External Resource Handler
        ParserSettings settings = new ParserSettings(new Handler());

        // Create an instance of Parser class to generate spreadsheet page previews
        try (Parser parser = new Parser(Constants.SampleHtmlWithImages, settings)) {
            // Extract images from HTML document
            Iterable<PageImageArea> images = parser.getImages();

            // Iterate over extracted images
            for (PageImageArea i : images) {
                // Print the type of image
                System.out.println(i.getFileType());
            }
        }
    }
}

/**
 * This class provides the ability to filter extracted images.
 **/
class Handler extends ExternalResourceHandler {
    // Called before any external resource loads. It allows to skip unnecessary file loading.
    @Override
    public void onLoading(ExternalResourceLoadingArgs args) {
        // Check if the file name ends with installation.png
        if (!args.getUri().endsWith("installation.png")) {
            // Otherwise skip this file
            args.setSkipped(true);
        }

        super.onLoading(args);
    }
}
