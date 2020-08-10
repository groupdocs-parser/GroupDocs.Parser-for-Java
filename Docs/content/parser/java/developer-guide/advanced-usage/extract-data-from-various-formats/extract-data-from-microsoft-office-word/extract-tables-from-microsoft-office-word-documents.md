---
id: extract-tables-from-microsoft-office-word-documents
url: parser/java/extract-tables-from-microsoft-office-word-documents
title: Extract tables from Microsoft Office Word documents
weight: 5
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract tables from Microsoft Office Word document [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method is used. This method returns XML representation of the document. Tables are represented by "table" tag. For more details, see [Extract text structure]({{< ref "parser/java/developer-guide/advanced-usage/working-with-text/extract-text-structure.md" >}}).

{{< alert style="warning" >}}[getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method returns null value if text structure extraction isn't supported for the document. For example, text structure extraction isn't supported for TXT files. Therefore, for TXT file [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method returns null. If Microsoft Office Word document has no text, [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method returns an empty org.w3c.dom.Document object.{{< /alert >}}

Here are the steps to extract tables from Microsoft Office Word documents:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method and obtain [*org.w3c.dom.Document*](https://docs.oracle.com/javase/7/docs/api/org/w3c/dom/Document.html?is-external=true) object;
*   Iterate through the XML document.

The following example demonstrates how to extract tables from Microsoft Office Word document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // Extract text structure to the XML reader
    Document document = parser.getStructure();
    // Read XML document
    readNode(document.getDocumentElement());
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
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)    

### Free online document parser App

Along with full featured .NET library we provide simple, but powerful free Apps.

You are welcome to parse documents and extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).