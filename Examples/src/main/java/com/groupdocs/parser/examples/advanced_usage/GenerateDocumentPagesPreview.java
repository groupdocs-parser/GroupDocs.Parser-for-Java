package com.groupdocs.parser.examples.advanced_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.ICreatePageStream;
import com.groupdocs.parser.options.ParserSettings;
import com.groupdocs.parser.options.PreviewFormats;
import com.groupdocs.parser.options.PreviewOptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This example shows how to generate document page preview.
 */
public class GenerateDocumentPagesPreview {

    public static void run() {
        // Create an instance of Parser class to generate document page previews
        try (Parser parser = new Parser(Constants.SamplePdfWithToc)) {
            // Create preview options
            PreviewOptions previewOptions = new PreviewOptions(
                    new ICreatePageStream() {
                        @Override
                        public OutputStream createPageStream(int pageNumber) {
                            try {
                                return new FileOutputStream(getOutputPath(String.format("preview_%d.png", pageNumber)));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex.getMessage());
                            }
                        }
                    });

            // Set PNG as an output image format
            previewOptions.setPreviewFormat(PreviewFormats.Png);
            // Set DPI for the output image
            previewOptions.setDpi(72);

            // Generate previews
            parser.generatePreview(previewOptions);
        }
    }

    private static String getOutputPath(String fileName) throws java.io.IOException {
        return Constants.getOutputFilePath(fileName);
    }
}
