// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.basic_usage;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to print all the supported file types.
 **/
public class GetSupportedFileFormats {
    public static void run() {
        // Get a collection of supported file formats
        Iterable<FileType> supportedFileTypes = FileType.getSupportedFileTypes();

        // Iterate over collection and print file format information
        for (FileType fileType : supportedFileTypes) {
            System.out.println(fileType);
        }
    }
}
