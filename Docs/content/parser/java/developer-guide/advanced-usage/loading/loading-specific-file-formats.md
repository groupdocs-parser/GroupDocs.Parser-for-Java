---
id: loading-specific-file-formats
url: parser/java/loading-specific-file-formats
title: Loading specific file formats
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
In some cases it's required to specify the document format manually to guarantee correct output produced by GroupDocs.Parser. The following are the cases when the document format must be specified manually:

*   Markdown documents
*   MHTML documents
*   OTP documents (OpenDocument Presentation Template)
*   Databases
*   Emails from remote servers

Here are the steps to specify the document format for Markup document.

*   Instantiate the [LoadOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/LoadOptions) object and pass the document format in [LoadOptions(FileFormat)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/LoadOptions#LoadOptions(com.groupdocs.parser.options.FileFormat)) constructor;
*   Create [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object and call any method.

The following example shows how to specify the document format for Markup document:  

```java
try (InputStream stream = new FileInputStream(Constants.SampleMd)) {
    // Create an instance of Parser class for markdown document
    try (Parser parser = new Parser(stream, new LoadOptions(FileFormat.Markup))) {
        // Check if text extraction is supported
        if (!parser.getFeatures().isText()) {
            System.out.println("Text extraction isn't supported.");
            return;
        }
        try (TextReader reader = parser.getText()) {
            // Print the document text
            // Markdown is detected; text without special symbols is printed
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