---
id: extract-text-in-accurate-mode
url: parser/java/extract-text-in-accurate-mode
title: Extract text in Accurate Mode
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract text from documents.

The **Accurate** mode is default text extraction mode and it means that text quality will be the best possible.

You can extract the whole document text or only a document page.

To extract a text from the document in the Accurate mode, [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) and [getText(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int)) methods are used:

```java
TextReader getText();
TextReader getText(int pageIndex);
```

The methods return an instance of [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) class with an extracted text. The first method extracts a text from the whole document. The second method extracts a text from the document page. To retrieve the total number of document pages [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method is used (see below).

[TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) class extends [*java.io.Reader*](http://docs.oracle.com/javase/7/docs/api/java/io/Reader.html?is-external=true) and adds the following members:

| Member | Description |
| --- | --- |
| [readLine](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader#readLine()) | Reads a line of characters from the text reader and returns the data as a string. |
| [readToEnd](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader#readToEnd()) | Reads all characters from the current position to the end of the text reader and returns them as one string. |

## Extract text

Here are the steps to extract a text from the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Check if *reader* isn't *null* (text extraction is supported for the document);
*   Read a text from *reader*.

The following example shows how to extract a text from a document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // Extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // Print a text from the document
        // If text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
    }
} 
```

## Extract text from page

Here are the steps to extract a text from the document page:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [isText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/Features#isText()) property to check if text extraction is supported for the document;
*   Call [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method;
*   Call [getText(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int)) method with the page index and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader "class in com.groupdocs.parser.data") object;
*   Read a text from *reader*.

The following example shows how to extract a text from the document page:

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
    if (documentInfo.getPageCount() == 0) {
        System.out.println("Document hasn't pages.");
        return;
    }
    // Iterate over pages
    for (int p = 0; p < documentInfo.getPageCount(); p++) {
        // Print a page number
        System.out.println(String.format("Page %d/%d", p + 1, documentInfo.getPageCount()));
        // Extract a text into the reader
        try (TextReader reader = parser.getText(p)) {
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