---
id: load-document-from-stream
url: parser/java/load-document-from-stream
title: Load document from stream
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
There might be cases when the document is presented only as a stream (without a copy on the local disk). To avoid the overhead of saving documents to the disk, GroupDocs.Parser enables to extract data from streams directly.

The following example shows how to load the document from the stream:

```java
// Create the stream
try (InputStream stream = new FileInputStream(Constants.SamplePdf)) {
    // Create an instance of Parser class with the stream
    try (Parser parser = new Parser(stream)) {
        // Extract a text into the reader
        try (TextReader reader = parser.getText()) {
            // Print a text from the document
            // If text extraction isn't supported, a reader is null
            System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
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

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).