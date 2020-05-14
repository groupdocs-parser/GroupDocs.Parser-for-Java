// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.excel;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.TextReader;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.IDocumentInfo;
import com.groupdocs.parser.options.TextOptions;

import java.io.IOException;

/**
 * This example shows how to extract a raw text from the page of Microsoft Office Excel spreadsheet.
 **/
public class ExtractTextFromSheetInRawMode {
    public static void run() throws IOException {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleXlsx)) {
            // Get the spreadsheet info
            IDocumentInfo spreadsheetInfo = parser.getDocumentInfo();

            // Iterate over sheets
            for (int p = 0; p < spreadsheetInfo.getRawPageCount(); p++) {
                // Print a sheet number
                System.out.println(String.format("Sheet %d/%d", p + 1, spreadsheetInfo.getRawPageCount()));

                // Extract a text into the reader
                try (TextReader reader = parser.getText(p, new TextOptions(true))) {
                    // Print a text from the spreadsheet
                    System.out.println(reader.readToEnd());
                }
            }
        }
    }
}
