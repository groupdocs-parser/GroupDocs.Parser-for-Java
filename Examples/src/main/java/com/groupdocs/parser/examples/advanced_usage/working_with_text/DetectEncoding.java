// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.working_with_text;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

import java.nio.charset.Charset;

/**
 * This example shows how to detect the encoding of the document.
 **/
public class DetectEncoding {
    public static void run() {
        // Create an instance of LoadOptions class with the default ANSI encoding.
        // This encoding is returned for ANSI text documents.
        LoadOptions loadOptions = new LoadOptions(FileFormat.WordProcessing, null, null, Charset.forName("US-ASCII"));
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleText, loadOptions)) {
            // Get the document info
            IDocumentInfo info = parser.getDocumentInfo();
            // Check if it's the document info of a plain text document
            if (info instanceof TextDocumentInfo == false) {
                System.out.println("Isn't a plain text document");
                return;
            }

            // Print the encoding
            System.out.println("Encoding: " + ((TextDocumentInfo) info).getCharset().displayName());
        }
    }
}