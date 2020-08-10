---
id: get-document-info
url: parser/java/get-document-info
title: Get document info
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to get the basic document info by the [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method:

```java
IDocumentInfo getDocumentInfo();
```

[IDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo) interface has the following members:

| Member | Description |
| --- | --- |
| [getFileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getFileType()) | The document type. |
| [getPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getPageCount()) | The total number of document pages. |
| [getRawPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getRawPageCount()) | The total number of document raw pages.. |
| [getSize](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getSize()) | The size of the document in bytes. |

Here are the steps to get document info:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getDocumentInfo()) method and obtain the object with [IDocumentInfo](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo "interface in com.groupdocs.parser.options") interface;
*   Call properties such as [getFileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getFileType()), [getPageCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getPageCount()) or [getSize](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/IDocumentInfo#getSize()).

The following example shows how to get document info:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // Get the document info
    IDocumentInfo info = parser.getDocumentInfo();
    // Print document information
    System.out.println(String.format("FileType: %s", info.getFileType()));
    System.out.println(String.format("PageCount: %d", info.getPageCount()));
    System.out.println(String.format("Size: %d", info.getSize()));
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