// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2024 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_data_extracted_by_template;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.templates.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.util.Arrays;

/**
 * This example shows how to get data from the table.
 **/
public class WorkingWithTables {
    public static void run() {
        // Create a table template with the parameters
        TemplateTable table = new TemplateTable(
                new TemplateTableParameters(new Rectangle(new Point(35, 320), new Size(530, 55)), null),
                "Details",
                null);

        // Create a template
        Template template = new Template(Arrays.asList(new TemplateItem[]{table}));

        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleInvoicePdf)) {
            // Parse the document by the template
            DocumentData data = parser.parseByTemplate(template);

            // Print all extracted data
            for (int i = 0; i < data.getCount(); i++) {
                System.out.print(data.get(i).getName() + ": ");
                // Check if the field is a table
                PageTableArea area = data.get(i).getPageArea() instanceof PageTableArea
                        ? (PageTableArea) data.get(i).getPageArea()
                        : null;
                if (area == null) {
                    continue;
                }

                // Iterate via table rows
                for (int row = 0; row < area.getRowCount(); row++) {
                    // Iterate via table columns
                    for (int column = 0; column < area.getColumnCount(); column++) {
                        // Get the cell value
                        PageTextArea cellValue = area.getCell(row, column).getPageArea() instanceof PageTextArea
                                ? (PageTextArea) area.getCell(row, column).getPageArea()
                                : null;

                        // Print the space between columns
                        if (column > 0) {
                            System.out.print("\t");
                        }

                        // Print the cell value
                        System.out.print(cellValue == null ? "" : cellValue.getText());
                    }

                    // Print new line
                    System.out.println();
                }
            }
        }
    }
}
