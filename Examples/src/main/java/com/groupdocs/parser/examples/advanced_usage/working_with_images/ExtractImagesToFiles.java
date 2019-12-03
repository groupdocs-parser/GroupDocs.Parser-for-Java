// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2019 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_images;

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
 * This example shows how to save extracted images to files.
 **/
public class ExtractImagesToFiles {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleZip)) {
            // Extract images from document
            Iterable<PageImageArea> images = parser.getImages();

            // Check if images extraction is supported
            if (images == null) {
                System.out.println("Page images extraction isn't supported");
                return;
            }

            int imageNumber = 0;
            // Iterate over images
            for (PageImageArea image : images) {
                // Open the image stream
                try (InputStream imageStream = image.getImageStream()) {
                    // Create the file to save image
                    try (OutputStream destStream = new FileOutputStream(imageNumber + image.getFileType().getExtension())) {
                        byte[] buffer = new byte[4096];
                        int readed = 0;

                        do {
                            // Read data from the image stream
                            readed = imageStream.read(buffer, 0, buffer.length);

                            if (readed > 0) {
                                // Write data to the file stream
                                destStream.write(buffer, 0, readed);
                            }
                        }
                        while (readed > 0);
                    }

                    imageNumber++;
                }
            }
        }
    }
}
