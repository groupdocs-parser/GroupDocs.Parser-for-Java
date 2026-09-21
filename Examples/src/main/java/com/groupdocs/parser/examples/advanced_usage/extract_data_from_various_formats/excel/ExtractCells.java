// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.excel;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract cells from Microsoft Office Excel spreadsheet.
 **/
public class ExtractCells {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleXlsx)) {
            // Check if worksheet cells extraction is supported
            if (!parser.getFeatures().isWorksheet()) {
                System.out.println("Worksheet cells extraction isn't supported.");
                return;
            }

            // Get the information about worksheets
            Iterable<WorksheetInfo> info = parser.getWorksheetInfo();

            // Iterate over worksheet information
            for (WorksheetInfo i : info) {
                // Print the worksheet name
                System.out.println(i.getName());
                System.out.println();

                // Get the worksheet cells
                Iterable<WorksheetCell> cells = parser.getWorksheetCells(i.getIndex());

                // Iterate over cells
                for (WorksheetCell c : cells) {
                    // Print the cell information and text value
                    System.out.println(String.format("Row: %d Column: %d RowSpan: %d ColumnSpan: %d",
                            c.getRowIndex(), c.getColumnIndex(), c.getRowSpan(), c.getColumnSpan()));
                    System.out.println(c.getText());
                    System.out.println();
                }
            }
        }
    }
}
