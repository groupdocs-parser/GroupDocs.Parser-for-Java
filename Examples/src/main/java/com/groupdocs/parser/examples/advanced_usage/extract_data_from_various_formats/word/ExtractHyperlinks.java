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
 * This example shows how to extract hyperlinks from Microsoft Office Word document.
 **/
public class ExtractHyperlinks {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleHyperlinksDocx)) {
            // Extract text structure to the XML reader
            Document document = parser.getStructure();

            // Read XML document
            readNode(document.getDocumentElement());
        }
    }

    private static void readNode(Node node) {
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (n.getNodeName().toLowerCase() == "hyperlink") {
                Node a = n.getAttributes().getNamedItem("link");
                if (a != null) {
                    System.out.println(a.getNodeValue());
                }
            }

            if(n.hasChildNodes()) {
                readNode(n);
            }
        }
    }

}
