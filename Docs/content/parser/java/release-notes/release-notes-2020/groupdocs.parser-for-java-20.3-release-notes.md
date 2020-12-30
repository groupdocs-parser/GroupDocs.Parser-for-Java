---
id: groupdocs-parser-for-java-20-3-release-notes
url: parser/java/groupdocs-parser-for-java-20-3-release-notes
title: GroupDocs.Parser for Java 20.3 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 20.3{{< /alert >}}

## Major Features

There are the following improvements in this release:

*   Fixed the bug: Cannot parse large sized PDF file to HTML
*   Improved table of contents extraction API

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| PARSERJAVA-110 | Cannot parse large sized PDF file to HTML | Bug |
| PARSERNET-1432 | Improve the support of text structure extraction | Improvement |

## Public API and Backward Incompatible Changes

### Improve the support of text structure extraction

#### Description

This feature adds text extraction from shapes, word art objects and text boxes for Microsoft Office formats. Also added hyperlink extraction for spreadsheets and presentations.

{{< alert style="danger" >}}The structure of XML representation of a document was changed. For details, see Extract text structure.{{< /alert >}}

#### Public API changes

There are no changes in public API

#### Usage

The following example shows how to extract hyperlinks from the document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleHyperlinksDocx)) {
    // Extract text structure to the XML reader
    Document document = parser.getStructure();
    // Check if text structure extraction is supported
    if (document == null) {
        System.out.println("Text structure extraction isn't supported.");
        return;
    }
    // Read XML document
    readNode(document.getDocumentElement());
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
```
