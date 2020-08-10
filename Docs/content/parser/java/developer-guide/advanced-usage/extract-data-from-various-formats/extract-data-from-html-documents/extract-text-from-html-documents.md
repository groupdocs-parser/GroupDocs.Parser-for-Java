---
id: extract-text-from-html-documents
url: parser/java/extract-text-from-html-documents
title: Extract text from HTML documents
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract a text from HTML documents [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method is used. This method allows to extract a text from the entire document. Pagination and raw mode is not supported for emails.

Here are the steps to extract a text from HTML document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Read a text from *reader*.

{{< alert style="warning" >}}
[getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns *null* value if text extraction isn't supported for the document. For example, text extraction isn't supported for Zip archive. Therefore, for Zip archive [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns *null*. For an HTML document [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns an empty [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object ([readToEnd](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader#readToEnd()) method returns an empty string).
{{< /alert >}}

The following example demonstrates how to extract a text from HTML document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleHtml)) {
    // Extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // Print a text from the document
        System.out.println(reader.readToEnd());
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
