---
id: extract-text-from-microsoft-office-excel-spreadsheets
url: parser/java/extract-text-from-microsoft-office-excel-spreadsheets
title: Extract text from Microsoft Office Excel spreadsheets
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract a text from Microsoft Office Excel spreadsheets [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) and [getText(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int)) method is used. These methods allow to extract a text from the entire document or a text from the selected page.

Here are the steps to extract a text from Microsoft Office Excel spreadsheets:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial spreadsheet;
*   Call [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Read a text from *reader*.

{{< alert style="warning" >}}[getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns null value if text extraction isn't supported for the document. For example, text extraction isn't supported for Zip archive. Therefore, for Zip archive [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns null. For empty Microsoft Office Excel spreadsheets [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method returns an empty [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object ([readToEnd](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/TextReader#readToEnd()) method returns an empty string).{{< /alert >}}

The following example demonstrates how to extract a text from Microsoft Office Excel spreadsheets:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleXlsx)) {
    // Extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // Print a text from the spreadsheet
        System.out.println(reader.readToEnd());
    }
}
```

Here are the steps to extract a text from the sheet of Microsoft Office Excel spreadsheet:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial spreadsheet;
*   Call [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method and obtain [IDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo) object with [getPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getPageCount()) property;
*   Call [getText(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int)) method with the sheet index and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Read a text from *reader*.

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleXlsx)) {
    // Get the spreadsheet info
    IDocumentInfo spreadsheetInfo = parser.getDocumentInfo();
    // Iterate over sheets
    for (int p = 0; p < spreadsheetInfo.getPageCount(); p++) {
        // Print a sheet number
        System.out.println(String.format("Sheet %d/%d", p + 1, spreadsheetInfo.getPageCount()));
        // Extract a text into the reader
        try (TextReader reader = parser.getText(p)) {
            // Print a text from the spreadsheet
            System.out.println(reader.readToEnd());
        }
    }
}
```

Raw mode allows to increase the speed of text extraction due to poor formatting accuracy. [getText(TextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(com.groupdocs.parser.options.TextOptions)) and [getText(int, TextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int,%20com.groupdocs.parser.options.TextOptions)) methods are used to extract a text in raw mode.

{{< alert style="warning" >}}Some spreadsheets may have different sheet numbers in raw and accurate modes. Use [getRawPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getRawPageCount()) instead of [getPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getPageCount()) in raw mode.{{< /alert >}}

Here are the steps to extract a raw text from the sheet of Microsoft Office Excel spreadsheet:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial spreadsheet;
*   Instantiate [TextOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/TextOptions) object with *true* parameter;
*   Call [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method;
*   Use [getRawPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getRawPageCount()) instead of [getPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getPageCount()) to avoid extra calculations;
*   Call [getText(int, TextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText(int,%20com.groupdocs.parser.options.TextOptions)) method with the sheet index and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader "class in com.groupdocs.parser.data") object;
*   Read a text from *reader*.

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleXlsx)) {
    // Get the document info
    DocumentInfo documentInfo = parser.getDocumentInfo() instanceof DocumentInfo
            ? (DocumentInfo) parser.getDocumentInfo()
            : null;
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

GroupDocs.Parser also allows to extract a text from Microsoft Office Excel spreadsheets as HTML, Markdown and formatted plain text. For more details, see [Extract Formatted Text]({{< ref "parser/java/developer-guide/advanced-usage/working-with-text/working-with-formatted-text/extract-formatted-text-from-document.md" >}}).

Here are the steps to extract a text from Microsoft Office Excel spreadsheet as HTML:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial spreadsheet;
*   Call [getFormattedText(FormattedTextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getFormattedText(com.groupdocs.parser.options.FormattedTextOptions)) method and obtain [TextReader](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TextReader) object;
*   Read a text from *reader*.

The following example shows how to extract a text from Microsoft Office Excel spreadsheet as HTML:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleXlsx)) {
    // Extract a formatted text into the reader
    try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
        // Print a formatted text from the spreadsheet
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