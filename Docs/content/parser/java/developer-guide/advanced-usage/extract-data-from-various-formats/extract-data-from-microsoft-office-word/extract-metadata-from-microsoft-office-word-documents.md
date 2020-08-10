---
id: extract-metadata-from-microsoft-office-word-documents
url: parser/java/extract-metadata-from-microsoft-office-word-documents
title: Extract metadata from Microsoft Office Word documents
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract metadata from Microsoft Office Word documents [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method is used. This method allows to extract the following metadata:

| Name | Description |
| --- | --- |
| title | The title of the document. |
| subject | The subject of the document. |
| keywords | The keyword of the document. |
| comments | The comments of the document. |
| content-status | The content status of the document. |
| category | The category of the document. |
| company | The company of the document. |
| manager | The manager of the document. |
| author | The name of the document's author. |
| last-author | The name of the last document's author. |
| hyperlink-base | The base string used for evaluating relative hyperlinks in this document. |
| application | The name of the application. |
| application-version | The version number of the application that created the document. |
| template | The informational name of the document template. |
| created-time | The time of the document creation. |
| last-saved-time | The time of the the document when it was last saved. |
| last-printed-time | The time of the document when it was last printed. |
| revision-number | The document revision number. |
| total-editing-time | The total editing time in minutes. |

Here are the steps to extract metadata from Microsoft Office Word document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method and obtain collection of document metadata objects;
*   Iterate through the collection and get metadata names and values.

{{< alert style="warning" >}}[getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns null value if metadata extraction isn't supported for the document. For example, metadata extraction isn't supported for Zip archive. Therefore, for Zip archive [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns null. If Microsoft Office Word document has no metadata, [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns an empty collection.{{< /alert >}}

The following example demonstrates how to extract metadata from Microsoft Office Word document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // Extract metadata from the document
    Iterable<MetadataItem> metadata = parser.getMetadata();
    // Iterate over metadata items
    for (MetadataItem item : metadata) {
        // Print an item name and value
        System.out.println(String.format("%s: %s", item.getName(), item.getValue()));
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