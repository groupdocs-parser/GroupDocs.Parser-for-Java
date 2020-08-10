---
id: extract-text-in-raw-mode
url: parser/java/extract-text-in-raw-mode
title: Extract text in Raw Mode
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract a text from documents.

The **Raw** mode is the fastest text extraction mode and it means that performance wlll be the best possible.

Raw mode usually retrieves text in worse quality than Accurate mode, but in some cases performance is more important than quality.

You can extract the whole document text or only a document page.

To extract a text from the document in the Raw mode, [getText(TextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(com.groupdocs.parser.options.TextOptions)) and [getText(int, TextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int,%20com.groupdocs.parser.options.TextOptions)) class are used:

```java
TextReader getText(TextOptions options);
TextReader getText(int pageIndex, TextOptions options);
```

Methods return an instance of [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) class with an extracted text. The first method extracts a text from the whole document. The second method extracts a text from the document page. To retrieve the total number of document pages [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method is used (see below).

{{< alert style="warning" >}}Instead of the accurate mode, [getRawPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getRawPageCount()) property is used to avoid extra calculations.{{< /alert >}}

[TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) class extends [*java.io.Reader*](http://docs.oracle.com/javase/7/docs/api/java/io/Reader.html?is-external=true) and adds the following members:

| Member | Description |
| --- | --- |
| [readLine](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader#readLine()) | Reads a line of characters from the text reader and returns the data as a string. |
| [readToEnd](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader#readToEnd()) | Reads all characters from the current position to the end of the text reader and returns them as one string. |

## Extract text

Here are the steps to extract a raw text from the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [TextOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/TextOptions) object with *true* parameter;
*   Call [getText(TextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(com.groupdocs.parser.options.TextOptions)) method with [TextOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/TextOptions) parameter and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Check if *reader* isn't *null* (text extraction is supported for the document);
*   Read a text from *reader*.

The following example shows how to extract a raw text from a document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // Extract a raw text into the reader
    try (TextReader reader = parser.getText(new TextOptions(true))) {
        // Print a text from the document
        // If text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
    }
}
```

## Extract text from page

Here are the steps to extract a raw text from the document page:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [TextOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/TextOptions) object with *true* parameter;
*   Call [isText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/Features#isText()) property to check if text extraction is supported for the document;
*   Call [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method;
*   Use [getRawPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getRawPageCount()) instead of [getPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getPageCount()) to avoid extra calculations;
*   Call [getText(int, TextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int,%20com.groupdocs.parser.options.TextOptions)) method with the page index and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader "class in com.groupdocs.parser.data") object;
*   Read a text from *reader*.

The following example shows how to extract a raw text from a document page:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // Check if the document supports text extraction
    if (!parser.getFeatures().isText()) {
        System.out.println("Document isn't supports text extraction.");
        return;
    }
    // Get the document info
    IDocumentInfo documentInfo = parser.getDocumentInfo();
    // Check if the document has pages
    if (documentInfo == null || documentInfo.getRawPageCount() == 0) {
        System.out.println("Document hasn't pages.");
        return;
    }
    // Iterate over pages
    for (int p = 0; p < documentInfo.getRawPageCount(); p++) {
        // Print a page number
        System.out.println(String.format("Page %d/%d", p + 1, documentInfo.getPageCount()));
        // Extract a text into the reader
        try (TextReader reader = parser.getText(p, new TextOptions(true))) {
            // Print a text from the document
            // We ignore null-checking as we have checked text extraction feature support earlier
            System.out.println(reader.readToEnd());
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