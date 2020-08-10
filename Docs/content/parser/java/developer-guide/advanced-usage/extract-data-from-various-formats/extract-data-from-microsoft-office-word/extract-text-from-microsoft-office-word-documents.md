---
id: extract-text-from-microsoft-office-word-documents
url: parser/java/extract-text-from-microsoft-office-word-documents
title: Extract text from Microsoft Office Word documents
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract a text from Microsoft Office Word documents [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) and [getText(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int)) methods are used. These methods allow to extract a text from the entire document or a text from the selected page. [TextOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/TextOptions) parameter is ignored for Microsoft Office Words documents.

Here are the steps to extract a text from Microsoft Office Word document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Read a text from *reader*.

{{< alert style="warning" >}}[getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns null value if text extraction isn't supported for the document. For example, text extraction isn't supported for Zip archive. Therefore, for Zip archive [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns null. For empty Microsoft Office Word document [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns an empty [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object ([readToEnd](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/TextReader#readToEnd()) method returns an empty string).{{< /alert >}}

The following example demonstrates how to extract a text from Microsoft Office Word document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // Extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // Print a text from the document
        System.out.println(reader.readToEnd());
    }
}
```

Here are the steps to extract a text from the page of Microsoft Office Word document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method and obtain [IDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo) object with [getPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getPageCount()) property;
*   Call [getText(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int)) method with the page index and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Read a text from *reader*.

{{< alert style="warning" >}}Text extraction from Microsoft Office Word document page is more resource consuming operation. Use text extraction from the entire document where it is applicable.{{< /alert >}}

The following example demonstrates how to extract a text from the page of Microsoft Office Word document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocxWithToc)) {
    // Get the document info
    IDocumentInfo documentInfo = parser.getDocumentInfo();
    // Iterate over pages
    for (int p = 0; p < documentInfo.getPageCount(); p++) {
        // Print a page number
        System.out.println(String.format("Page %d/%d", p + 1, documentInfo.getPageCount()));
        // Extract a text into the reader
        try (TextReader reader = parser.getText(p)) {
            // Print a text from the document
            System.out.println(reader.readToEnd());
        }
    }
}
```

GroupDocs.Parser also allows to extract a text from Microsoft Office Word documents as HTML, Markdown and formatted plain text. For more details, see [Extract Formatted Text]({{< ref "parser/java/developer-guide/advanced-usage/working-with-text/working-with-formatted-text/extract-formatted-text-from-document.md" >}}).

Here are the steps to extract a text from Microsoft Office Word document as HTML:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getFormattedText(FormattedTextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getFormattedText(com.groupdocs.parser.options.FormattedTextOptions)) method and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Read a text from *reader*.

The following example shows how to extract a text from Microsoft Office Word document as HTML:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // Extract a formatted text into the reader
    try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
        // Print a formatted text from the document
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