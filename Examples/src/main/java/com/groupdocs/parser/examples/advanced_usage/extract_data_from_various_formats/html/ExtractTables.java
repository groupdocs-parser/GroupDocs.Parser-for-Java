// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.html;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to extract tables from HTML document.
 **/
public class ExtractTables {
    private static final int CellLength = 18;

    public static void run() {
        // Create an instance of the Parser class
        try (Parser parser = new Parser(Constants.TablesHtml)) {
            // Extract tables
            Iterable<PageTableArea> tables = parser.getTables();

            // Check if table extraction is supported
            if (tables == null) {
                System.out.println("Table extraction isn't supported.");
                return;
            }

            // Iterate over tables
            for (PageTableArea table : tables) {
                System.out.println("Found table:");
                System.out.println("\tRows: " + table.getRowCount());
                System.out.println("\tColumns: " + table.getColumnCount());

                // Iterate over rows
                for (int i = 0; i < table.getRowCount(); i++) {
                    printSeparator(table.getColumnCount());
                    System.out.print(" | ");

                    // Iterate over columns
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        // Get the table cell
                        PageTableAreaCell cell = table.getCell(i, j);
                        if (cell == null) {
                            System.out.print(pad(""));
                            continue;
                        }

                        // Print the table cell text
                        System.out.print(pad(getCellText(cell)));
                        System.out.print(" | ");
                    }

                    System.out.println();
                }

                printSeparator(table.getColumnCount());
            }
        }
    }

    private static void printSeparator(int columnCount) {
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < columnCount * (CellLength + 3) + 1; i++) {
            separator.append('-');
        }

        System.out.println(" " + separator + " ");
    }

    private static String pad(String text) {
        return String.format("%-" + CellLength + "s", text);
    }

    private static String getCellText(PageTableAreaCell cell) {
        String text = cell.getText();
        if (text == null) {
            return "";
        }

        // Put the cell text on a single line.
        // 0x07 is a bell character, which separates the cells of a table in some formats;
        // 0xA0 is a non-breaking space
        text = text
                .replace("\n\r", " ")
                .replace("\r\n", " ")
                .replace('\n', ' ')
                .replace('\r', ' ')
                .replace((char) 0x07, ' ')
                .replace((char) 0xA0, ' ')
                .trim();

        if (text.isEmpty()) {
            return "";
        }

        // Cut off the text which doesn't fit the cell
        return text.length() > CellLength
                ? text.substring(0, CellLength - 3) + "..."
                : text;
    }
}
