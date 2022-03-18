// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2022 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_templates.template_barcodes;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.templates.*;
import com.groupdocs.parser.examples.Constants;

import java.util.Arrays;

/**
 * This example shows how to define a template barcode field.
 **/
public class WorkingWithBarcodes {
    public static void run() {
        // Define a barcode field
        TemplateBarcode barcode = new TemplateBarcode(
                new Rectangle(new Point(590, 80), new Size(150, 150)),
                "QR");

        // Create a template
        Template template = new Template(Arrays.asList(new TemplateItem[]{barcode}));

        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SamplePdfWithBarcodes)) {
            // Parse the document by the template
            DocumentData data = parser.parseByTemplate(template);

            // Print all extracted data
            for (int i = 0; i < data.getCount(); i++) {
                // Print field name
                System.out.print(data.get(i).getName() + ": ");

                // As we have defined only barcode fields in the template,
                // we cast PageArea property value to PageBarcodeArea
                PageBarcodeArea area = data.get(i).getPageArea() instanceof PageBarcodeArea
                        ? (PageBarcodeArea) data.get(i).getPageArea()
                        : null;
                System.out.println(area == null ? "Not a template barcode field" : area.getValue());
            }
        }
    }
}