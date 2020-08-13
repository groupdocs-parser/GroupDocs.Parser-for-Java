package com.groupdocs.parser.examples.advanced_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GenerateSpreadsheetPagesPreview {
    public static void run() {
        // Create an instance of Parser class to generate spreadsheet page previews
        try (Parser parser = new Parser(Constants.SampleXlsx)) {
            final PageRenderInfo[] renderInfo = {null};

            // Create preview options
            PreviewOptions previewOptions = new PreviewOptions(
                    new ICreatePageStream() {
                        @Override
                        public OutputStream createPageStream(int pageNumber) {
                            try {
                                return new FileOutputStream(getOutputPath(renderInfo[0], pageNumber));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex.getMessage());
                            }
                        }
                    });

            // Set delegate to obtain the render info
            previewOptions.setPreviewPageRender(
                    new IPreviewPageRender() {
                        @Override
                        public void previewPageRender(PageRenderInfo pageRenderInfo) {
                            renderInfo[0] = pageRenderInfo;
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

    private static String getOutputPath(PageRenderInfo renderInfo, int pageNumber) throws java.io.IOException {
        // Set the file name. If the render info is set, then tile name is {Row}x{Column}.png
        String fileName = renderInfo == null
                ? String.format("preview_%d.png", pageNumber)
                : String.format("%d\\%dx%d.png", renderInfo.getPageNumber(), renderInfo.getRow(pageNumber), renderInfo.getColumn(pageNumber));

        return Constants.getOutputFilePath(fileName);
    }
}
