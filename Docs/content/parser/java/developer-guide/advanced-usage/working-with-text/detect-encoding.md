---
id: detect-encoding
url: parser/java/detect-encoding
title: Detect encoding
weight: 8
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to detect the encoding of a plain text file. The following encodings are supported:

*   UTF32 LE
*   UTF32 BE
*   UTF16 LE
*   UTF16 BE
*   UTF8
*   UTF7
*   ANSI  

Encoding can be detected by BOM or by the content of the file (if BOM isn't presented).  

Here are the steps to detect the encoding of the document:

*   Instantiate [LoadOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/LoadOptions) object with the default ANSI encoding;
*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method and cast the result to [TextDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/TextDocumentInfo)
*   Read the [getCharset](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/TextDocumentInfo#getCharset()) property. 

The following example shows how to detect the encoding of the document:

```java
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
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).