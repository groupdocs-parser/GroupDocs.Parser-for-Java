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
 * This example shows how to define a template field with the fixed position.
 **/
public class WorkingWithTemplateFixedPosition {
    public static void run() {
        // Define a field with the fixed position
        TemplateField field = new TemplateField(
                new TemplateFixedPosition(new Rectangle(new Point(35, 135), new Size(100, 10))),
                "FromCompany");

        // Create a template
        Template template = new Template(Arrays.asList(new TemplateItem[]{field}));

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
