// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.word;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This example shows how to extract tables from Microsoft Office Word document.
 **/
public class ExtractTables {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleDocx)) {
            // Extract text structure to the XML reader
            Document document = parser.getStructure();

            // Read XML document
            readNode(document.getDocumentElement());
        }
    }

    private static void readNode(Node node) {
        NodeList nodes = node.getChildNodes();
        // Iterate over the child nodes
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            // If it's a table
            if (n.getNodeName().toLowerCase() == "table") {
                System.out.println("table");
                // Process node
                processNode(n);
            }

            readNode(n);
        }
    }

    private static void processNode(Node node) {
        NodeList nodes = node.getChildNodes();
        // Iterate over the child nodes
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);

            switch (n.getNodeName().toLowerCase()) {
                // In the case of a row or cell
                case "tr":
                case "td": {
                    // Print the name
                    System.out.println(n.getNodeName());
                    // Process sub-nodes
                    processNode(n);
                    System.out.println();
                    System.out.println("/" + n.getNodeName());
                    break;
                }

                default:
                    // Print the node value (if it's not null)
                    String value = n.getNodeValue();
                    if(value != null) {
                        System.out.print(value);
                    }

                    processNode(n);
                    break;
            }
        }
    }
}
