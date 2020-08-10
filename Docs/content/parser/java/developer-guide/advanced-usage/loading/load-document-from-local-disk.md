---
id: load-document-from-local-disk
url: parser/java/load-document-from-local-disk
title: Load document from local disk
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract data from documents on the local disk.

The following example shows how to load the document from the local disk:

```java
// Set the filePath
String filePath = Constants.SamplePdf;
// Create an instance of Parser class with the filePath
try (Parser parser = new Parser(filePath)) {
    // Extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // Print a text from the document
        // If text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
    }
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)    

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).