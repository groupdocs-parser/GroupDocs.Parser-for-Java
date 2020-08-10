---
id: get-supported-file-formats
url: parser/java/get-supported-file-formats
title: Get supported file formats
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser allows to get the list of all the supported file formats by the [getSupportedFileTypes](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType#getSupportedFileTypes()) static method:

```java
Iterable<FileType> FileType.getSupportedFileTypes();
```

This method returns a collection of [FileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType) items with the following members:

| Member | Description |
| --- | --- |
| [getFileFormat](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType#getFileFormat()) | File type name e.g. "Microsoft Word Document". |
| [getExtension](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType#getExtension()) | Filename suffix (including the period ".") e.g. ".doc". |

Also [FileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType) contains static fields that represent all the supported file formats.

Here are the steps to get all the supported file formats:

*   Call [getSupportedFileTypes](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType#getSupportedFileTypes()) static method and obtain a collection of [FileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType) objects;
*   Iterate through the collection and call  [getFileFormat](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType#getFileFormat()) or [getExtension](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType#getExtension()) of [FileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/FileType).

The following example shows how to print all the supported file types:

```java
// Get a collection of supported file formats
Iterable<FileType> supportedFileTypes = FileType.getSupportedFileTypes();
// Iterate over collection and print file format information
for (FileType fileType : supportedFileTypes) {
    System.out.println(fileType);
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