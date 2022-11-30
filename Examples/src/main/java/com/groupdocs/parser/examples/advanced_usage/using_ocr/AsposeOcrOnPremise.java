// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2022 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.using_ocr;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * This example shows how to integrate Aspose.OCR on-premise API.
 **/
public class AsposeOcrOnPremise extends OcrConnectorBase {
    AsposeOcrOnPremise() {
        // Set the license for Aspose OCR
        new com.aspose.ocr.License().setLicense(Constants.AsposeOcrLicensePath);
    }

    @Override
    public String recognizeText(java.io.InputStream imageStream, int pageIndex, OcrOptions options) {
        try {
            // Create an instance of Aspose OCR API
            com.aspose.ocr.AsposeOCR api = new com.aspose.ocr.AsposeOCR();

            // Convert the image stream into the memory stream
            java.awt.image.BufferedImage image = ImageIO.read(imageStream);

            // Create an instance of RecognitionSettings
            com.aspose.ocr.RecognitionSettings settings = new com.aspose.ocr.RecognitionSettings();

            // Check if the rectangle is set
            if (options != null && options.getRectangle() != null) {
                ArrayList<java.awt.Rectangle> areas = new ArrayList<>();
                areas.add(new java.awt.Rectangle(
                        (int) options.getRectangle().getLeft(),
                        (int) options.getRectangle().getTop(),
                        (int) options.getRectangle().getSize().getWidth(),
                        (int) options.getRectangle().getSize().getHeight()));

                // Set recognition areas
                settings.setRecognitionAreas(areas);
            }

            // Perform the text recognition
            com.aspose.ocr.RecognitionResult result = api.RecognizePage(image, settings);

            // Check if the handler is set
            if (options != null && options.getHandler() != null) {
                // Send all recognition warnings
                options.getHandler().onWarnings(pageIndex, result.warnings);
            }

            // Return a recognized text
            return result.recognitionText;
        } catch (java.lang.Exception ex) {
            return null;
        }
    }

    @Override
    public java.lang.Iterable<PageTextArea> recognizeTextAreas(java.io.InputStream imageStream, int pageIndex, Size pageSize, OcrOptions options) {
        try {
            // Create an instance of Aspose OCR API
            com.aspose.ocr.AsposeOCR api = new com.aspose.ocr.AsposeOCR();

            // Convert the image stream into the memory stream
            java.awt.image.BufferedImage image = ImageIO.read(imageStream);

            // Create an instance of RecognitionSettings
            com.aspose.ocr.RecognitionSettings settings = new com.aspose.ocr.RecognitionSettings();
            settings.setDetectAreas(true);

            // Check if the rectangle is set
            if (options != null && options.getRectangle() != null) {
                ArrayList<java.awt.Rectangle> areas = new ArrayList<>();
                areas.add(new java.awt.Rectangle(
                        (int) options.getRectangle().getLeft(),
                        (int) options.getRectangle().getTop(),
                        (int) options.getRectangle().getSize().getWidth(),
                        (int) options.getRectangle().getSize().getHeight()));

                // Set recognition areas
                settings.setRecognitionAreas(areas);
            }

            // Perform the text recognition
            com.aspose.ocr.RecognitionResult result = api.RecognizePage(image, settings);

            // Check if the handler is set
            if (options != null && options.getHandler() != null) {
                // Send all recognition warnings
                options.getHandler().onWarnings(pageIndex, result.warnings);
            }

            // Create a page object. The pageIndex parameter represents the page index of the document; for images it's always zero.
            Page page = new Page(pageIndex, pageSize);

            // Combine rectangle and text collections to produce PageTextArea collection
            ArrayList<PageTextArea> areas = new ArrayList<>();
            for(int i=0; i <result.recognitionAreasRectangles.size(); i++) {
                java.awt.Rectangle rect = result.recognitionAreasRectangles.get(i);
                String text = result.recognitionText;

                areas.add(new PageTextArea(text, page, new Rectangle(
                        new Point(rect.getX(), rect.getY()), new Size(rect.getWidth(), rect.getHeight()))));
            }

            return areas;
        } catch (java.lang.Exception ex) {
            return null;
        }
    }
}