// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to read all available form fields from a PDF document.
 * Form field values (e.g. AcroForm text boxes) are not returned by getText -
 * they have to be extracted with parseForm.
 **/
public class ExtractAllPdfFormFields {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleFormFieldsPdf)) {
            // Extract data from the PDF form
            DocumentData data = parser.parseForm();

            // Check if form extraction is supported
            if (data == null) {
                System.out.println("Form extraction isn't supported.");
                return;
            }

            System.out.println(String.format("Total form fields: %d", data.getCount()));
            System.out.println();

            // Iterate over all the extracted form fields
            for (int i = 0; i < data.getCount(); i++) {
                FieldData field = data.get(i);

                // A field area can be a text area (text boxes, radio buttons, checkboxes, etc.)
                PageTextArea area = field.getPageArea() instanceof PageTextArea
                        ? (PageTextArea) field.getPageArea()
                        : null;

                System.out.println(String.format("%s: %s",
                        field.getName(),
                        area == null ? "Not a text field" : area.getText()));
            }
        }
    }
}
