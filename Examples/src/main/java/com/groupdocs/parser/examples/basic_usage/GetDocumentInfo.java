// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to get basic document info.
 **/
public class GetDocumentInfo {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocx)) {
            // Get the document info
            IDocumentInfo info = parser.getDocumentInfo();

            // Print document information
            System.out.println(String.format("FileType: %s", info.getFileType()));
            System.out.println(String.format("PageCount: %d", info.getPageCount()));
            System.out.println(String.format("Size: %d", info.getSize()));
        }
    }
}
