---
id: extract-hyperlinks-from-microsoft-office-word-documents
url: parser/java/extract-hyperlinks-from-microsoft-office-word-documents
title: Extract hyperlinks from Microsoft Office Word documents
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract hyperlinks from Microsoft Office Word document [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method is used. This method returns XML representation of the document. Hyperlinks are represented by "hyperlink" tag; "link" attribute contains hyperlink's URL. For more details, see [Extract text structure]({{< ref "parser/java/developer-guide/advanced-usage/working-with-text/extract-text-structure.md" >}}). Hyperlink can contain a text:

```xml
<hyperlink link="www.google.com">google.com</hyperlink>
```

{{< alert style="warning" >}}[getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method returns null value if text structure extraction isn't supported for the document. For example, text structure extraction isn't supported for TXT files. Therefore, for TXT file [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method returns null. If Microsoft Office Word document has no text, [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method returns an empty org.w3c.dom.Document object.{{< /alert >}}

Here are the steps to extract hyperlinks from Microsoft Office Word documents:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method and obtain [*org.w3c.dom.Document*](https://docs.oracle.com/javase/7/docs/api/org/w3c/dom/Document.html?is-external=true) object;
*   Iterate through the XML document.

The following example demonstrates how to extract hyperlinks from Microsoft Office Word document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleHyperlinksDocx)) {
    // Extract text structure to the XML reader
    Document document = parser.getStructure();
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

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)
    

### Free online document parser App

Along with full featured .NET library we provide simple, but powerful free Apps.

You are welcome to parse documents and extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).