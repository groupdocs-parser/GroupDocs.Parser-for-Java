// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.pdf;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This example shows how to extract images from Pdf document.
 **/
public class ExtractImages{
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
            // Extract images from document
            Iterable<PageImageArea> images = parser.getImages();

            // Create the options to save images in PNG format
            ImageOptions options = new ImageOptions(ImageFormat.Png);

            int imageNumber = 0;
            // Iterate over images
            for (PageImageArea image : images)
            {
                // Save the image to the png file
                image.save(Constants.getOutputFilePath(String.format("%d.png", imageNumber)), options);

                imageNumber++;
            }
        }
    }
}
