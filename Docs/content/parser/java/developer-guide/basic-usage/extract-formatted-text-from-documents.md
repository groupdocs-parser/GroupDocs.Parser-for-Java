---
id: extract-formatted-text-from-documents
url: parser/java/extract-formatted-text-from-documents
title: Extract formatted text from documents
weight: 6
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser allows to extract formatted text from documents for those cases when simple plain text is not enough and you may need to keep formatting like text style, table layout etc.

This feature allows to extract text with integrated HTML tags, or Markdown syntax. Even PlainText mode allows to convert your documents to high quality text with integrated ASCII formatting symbols for tables, lists etc.

# Extract formatted text from documents

To extract a formatted text from documents simply call the [getFormattedText(FormattedTextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getFormattedText(com.groupdocs.parser.options.FormattedTextOptions)) method:

```java
TextReader getFormattedText(FormattedTextOptions options);
```

This method returns an instance of [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) class with an extracted text. [FormattedTextOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FormattedTextOptions) has the following constructor:

```java
FormattedTextOptions(FormattedTextMode mode);
```

[FormattedTextMode](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FormattedTextMode) enumeration has the following members:

| Member | Description |
| --- | --- |
| [Html](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FormattedTextMode#Html) | HTML format. |
| [Markdown](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FormattedTextMode#Markdown) | Markdown format. |
| [PlainText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FormattedTextMode#PlainText) | Plain text format. |

[TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) class extends  [*java.io.Reader*](http://docs.oracle.com/javase/7/docs/api/java/io/Reader.html?is-external=true) and adds the following members:

| Member | Description |
| --- | --- |
| [readLine](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader#readLine()) | Reads a line of characters from the text reader and returns the data as a string. |
| [readToEnd](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader#readToEnd()) | Reads all characters from the current position to the end of the text reader and returns them as one string. |

Here are the steps to extract a HTML formatted text from the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [FormattedTextOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FormattedTextOptions) with HTML text mode;
*   Call [getFormattedText(FormattedTextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getFormattedText(com.groupdocs.parser.options.FormattedTextOptions)) method and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Check if *reader* isn't *null* (formatted text extraction is supported for the document);
*   Read a text from *reader*.

The following example shows how to extract a document text as HTML text:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // Extract a formatted text into the reader
    try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
        // Print a formatted text from the document
        // If formatted text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Formatted text extraction isn't suppported" : reader.readToEnd());
    }
}
```

## More resources

### Advanced usage topics

To learn more about document data extraction features and get familiar how to extract text, images, forms and more, please refer to the [advanced usage section]({{< ref "parser/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).