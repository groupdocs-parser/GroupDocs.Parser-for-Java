// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_data_extracted_by_template;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.templates.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.util.Arrays;

/**
 * This example shows how to get field data by name.
 **/
public class GetFieldByName {
    public static void run() {
        // Define a "price" field
        TemplateField priceField = new TemplateField(
                new TemplateRegexPosition("\\$\\d+(.\\d+)?"),
                "Price");

        // Define a "email" field
        TemplateField emailField = new TemplateField(
                new TemplateRegexPosition("[a-z]+\\@[a-z]+.[a-z]+"),
                "Email");

        // Create a template
        Template template = new Template(Arrays.asList(new TemplateItem[]{priceField, emailField}));

        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleInvoicePdf)) {
            // Parse the document by the template
            DocumentData data = parser.parseByTemplate(template);

            // Print prices
            System.out.println("Prices:");
            for (FieldData field : data.getFieldsByName("Price")) {
                PageTextArea area = field.getPageArea() instanceof PageTextArea
                        ? (PageTextArea) field.getPageArea()
                        : null;
                System.out.println(area == null ? "Not a template field" : area.getText());
            }

            // Print emails
            System.out.println("Emails:");
            for (FieldData field : data.getFieldsByName("Email")) {
                // As we have defined only text fields in the template,
                // we cast PageArea property value to PageTextArea
                PageTextArea area = field.getPageArea() instanceof PageTextArea
                        ? (PageTextArea) field.getPageArea()
                        : null;
                System.out.println(area == null ? "Not a template field" : area.getText());
            }
        }
    }
}
