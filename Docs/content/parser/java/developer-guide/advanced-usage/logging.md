---
id: logging
url: parser/java/logging
title: Logging
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
`[ILogger](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger "interface in com.groupdocs.parser.options")` interface is used to receive the information about errors, warnings and events which occur while data extraction. `[ILogger](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger "interface in com.groupdocs.parser.options")` interface has the following members:

| Member | Description |
| --- | --- |
| `**[error](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger#error(java.lang.String,%20java.lang.Exception))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") message, [Exception](http://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html?is-external=true "class or interface in java.lang") exception)` | Logs an error that occurred during data extraction. |
| `**[warning](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger#warning(java.lang.String))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") message)` | Logs a warning that occurred during data extraction. |
| `**[trace](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger#trace(java.lang.String))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") message)` | Logs an event occurred during data extraction. |

Here are the steps to receive the information via `[ILogger](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger "interface in com.groupdocs.parser.options")` interface:

*   Implement the class with `[ILogger](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger "interface in com.groupdocs.parser.options")` interface implementation;
*   Instantiate `[Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser)` object with [`ParserSettings`](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ParserSettings "class in com.groupdocs.parser.options") object.

The following example shows how to receive the information via `[ILogger](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ILogger "interface in com.groupdocs.parser.options")` interface.

```csharp
try {
    // Create an instance of Logger class
    Logger logger = new Logger();
    // Create an instance of Parser class with the parser settings
    try (Parser parser = new Parser(Constants.SamplePassword, null, new ParserSettings(logger))) {
        // Check if text extraction is supported
        if (!parser.getFeatures().isText()) {
            System.out.println("Text extraction isn't supported.");
            return;
        }
        // Print the document text
        try (TextReader reader = parser.getText()) {
            System.out.println(reader.readToEnd());
        }
    }
} catch (InvalidPasswordException | IOException ex) {
    ; // Ignore the exception
}

class Logger implements ILogger {
    public void error(String message, Exception exception) {
        // Print error message
        System.out.println("Error: " + message);
    }

    public void trace(String message) {
        // Print event message
        System.out.println("Event: " + message);
    }

    public void warning(String message) {
        // Print warning message
        System.out.println("Warning: " + message);
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
