// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.templates.*;

/**
 * This example shows how to parse data from the document by user-generated template.
 **/
public class ParseDataFromDocuments {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleInvoicePdf)) {
            // Parse the document by the template
            DocumentData data = parser.parseByTemplate(GetTemplate());

            // Check if form extraction is supported
            if (data == null) {
                System.out.println("Parse Document by Template isn't supported.");
                return;
            }

            // Print extracted fields
            for (int i = 0; i < data.getCount(); i++) {
                System.out.print(data.get(i).getName() + ": ");
                PageTextArea area = data.get(i).getPageArea() instanceof PageTextArea
                        ? (PageTextArea) data.get(i).getPageArea()
                        : null;
                System.out.println(area == null ? "Not a template field" : area.getText());
            }
        }
    }

    private static Template GetTemplate() {
        // Create detector parameters for "Details" table
        TemplateTableParameters detailsTableParameters = new TemplateTableParameters(new Rectangle(new Point(35, 320), new Size(530, 55)), null);

        // Create detector parameters for "Summary" table
        TemplateTableParameters summaryTableParameters = new TemplateTableParameters(new Rectangle(new Point(330, 385), new Size(220, 65)), null);

        // Create a collection of template items
        TemplateItem[] templateItems = new TemplateItem[]
                {
                        new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 135), new Size(100, 10))), "FromCompany"),
                        new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 150), new Size(100, 35))), "FromAddress"),
                        new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 190), new Size(150, 2))), "FromEmail"),
                        new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 250), new Size(100, 2))), "ToCompany"),
                        new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 260), new Size(100, 15))), "ToAddress"),
                        new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 290), new Size(150, 2))), "ToEmail"),

                        new TemplateField(new TemplateRegexPosition("Invoice Number"), "InvoiceNumber"),
                        new TemplateField(new TemplateLinkedPosition(
                                "InvoiceNumber",
                                new Size(200, 15),
                                new TemplateLinkedPositionEdges(false, false, true, false)),
                                "InvoiceNumberValue"),

                        new TemplateField(new TemplateRegexPosition("Order Number"), "InvoiceOrder"),
                        new TemplateField(new TemplateLinkedPosition(
                                "InvoiceOrder",
                                new Size(200, 15),
                                new TemplateLinkedPositionEdges(false, false, true, false)),
                                "InvoiceOrderValue"),

                        new TemplateField(new TemplateRegexPosition("Invoice Date"), "InvoiceDate"),
                        new TemplateField(new TemplateLinkedPosition(
                                "InvoiceDate",
                                new Size(200, 15),
                                new TemplateLinkedPositionEdges(false, false, true, false)),
                                "InvoiceDateValue"),

                        new TemplateField(new TemplateRegexPosition("Due Date"), "DueDate"),
                        new TemplateField(new TemplateLinkedPosition(
                                "DueDate",
                                new Size(200, 15),
                                new TemplateLinkedPositionEdges(false, false, true, false)),
                                "DueDateValue"),

                        new TemplateField(new TemplateRegexPosition("Total Due"), "TotalDue"),
                        new TemplateField(new TemplateLinkedPosition(
                                "TotalDue",
                                new Size(200, 15),
                                new TemplateLinkedPositionEdges(false, false, true, false)),
                                "TotalDueValue"),

                        new TemplateTable(detailsTableParameters, "details", null),
                        new TemplateTable(summaryTableParameters, "summary", null)
                };

        // Create a document template
        Template template = new Template(java.util.Arrays.asList(templateItems));

        return template;
    }
}
