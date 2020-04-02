// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.pdf;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to parse a form of the Pdf document:
 **/
public class ExtractDataFromPdfForms {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleCarWashPdf)) {
            // Extract data from PDF document
            DocumentData data = parser.parseForm();
            // Check if form extraction is supported
            if (data == null) {
                System.out.println("Form extraction isn't supported.");
                return;
            }

            // Create the preliminary record object
            PreliminaryRecord rec = new PreliminaryRecord();
            rec.Name = getFieldText(data, "Name");
            rec.Model = getFieldText(data, "Model");
            rec.Time = getFieldText(data, "Time");
            rec.Description = getFieldText(data, "Description");

            // We can save the preliminary record object to the database,
            // send it as the web response or just print it to the console
            System.out.println("Preliminary record");
            System.out.println(String.format("Name: %s", rec.Name));
            System.out.println(String.format("Model: %s", rec.Model));
            System.out.println(String.format("Time: %s", rec.Time));
            System.out.println(String.format("Description: %s", rec.Description));
        }
    }

    private static String getFieldText(DocumentData data, String fieldName) {
        // Get the field from data collection
        FieldData fieldData = data.getFieldsByName(fieldName).get(0);

        // Check if the field data is not null (a field with the fieldName is contained in data collection)
        // and check if the field data contains the text
        return fieldData != null && fieldData.getPageArea() instanceof PageTextArea
                ? ((PageTextArea) fieldData.getPageArea()).getText()
                : null;
    }

    /**
     * Simple POCO object to store the extracted data.
     */
    static class PreliminaryRecord {
        public String Name;

        public String Model;

        public String Time;

        public String Description;
    }
}
