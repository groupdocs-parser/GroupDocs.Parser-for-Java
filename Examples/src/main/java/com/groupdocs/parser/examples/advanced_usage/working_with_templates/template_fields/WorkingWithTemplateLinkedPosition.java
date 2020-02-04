// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_templates.template_fields;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.templates.*;
import com.groupdocs.parser.examples.Constants;

import java.util.Arrays;

/**
 * This example shows how to define a template field with the linked field.
 **/
public class WorkingWithTemplateLinkedPosition {
    public static void run() {
        // Define a field with the regular expression
        TemplateField field = new TemplateField(
                new TemplateRegexPosition("Tax"),
                "Tax");

        TemplateField linkedField = new TemplateField(
                new TemplateLinkedPosition(
                        "Tax",
                        new Size(100, 20),
                        new TemplateLinkedPositionEdges(false, false, true, false)),
                "TaxValue");

        // Create a template
        Template template = new Template(Arrays.asList(new TemplateItem[]{field, linkedField}));

        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleInvoicePdf)) {
            // Parse the document by the template
            DocumentData data = parser.parseByTemplate(template);

            // Print all extracted data
            for (int i = 0; i < data.getCount(); i++) {
                // Print field name
                System.out.print(data.get(i).getName() + ": ");

                // As we have defined only text fields in the template,
                // we cast PageArea property value to PageTextArea
                PageTextArea area = data.get(i).getPageArea() instanceof PageTextArea
                        ? (PageTextArea) data.get(i).getPageArea()
                        : null;
                System.out.println(area == null ? "Not a template field" : area.getText());
            }
        }
    }
}
