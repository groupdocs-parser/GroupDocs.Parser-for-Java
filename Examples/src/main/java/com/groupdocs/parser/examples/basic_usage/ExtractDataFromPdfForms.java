// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to parse a form of the document:
 **/
public class ExtractDataFromPdfForms {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleFormsPdf)) {
            // Extract data from PDF document
            DocumentData data = parser.parseForm();
            // Check if form extraction is supported
            if (data == null) {
                System.out.println("Form extraction isn't supported.");
                return;
            }
            // Iterate over extracted data
            for (int i = 0; i < data.getCount(); i++) {
                System.out.print(data.get(i).getName() + ": ");
                PageTextArea area = data.get(i).getPageArea() instanceof PageTextArea
                        ? (PageTextArea) data.get(i).getPageArea()
                        : null;
                System.out.println(area == null ? "Not a template field" : area.getText());
            }
        }
    }
}
