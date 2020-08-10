---
id: extract-metadata-from-pdf-documents
url: parser/java/extract-metadata-from-pdf-documents
title: Extract metadata from PDF documents
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract metadata from PDF documents [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method is used. This method allows to extract the following metadata:

| Name | Description |
| --- | --- |
| title | The title of the presentation. |
| subject | The subject of the presentation. |
| keywords | The keyword of the presentation. |
| author | The name of the presentation's author. |
| application | The name of the application. |
| application-version | The version number of the application that created the presentation. |
| created-time | The time of the presentation creation. |
| last-saved-time | The time of the the presentation when it was last saved. |

Here are the steps to extract metadata from PDF document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method and obtain collection of document metadata objects;
*   Iterate through the collection and get metadata names and values.

{{< alert style="warning" >}}
[getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns *null* value if metadata extraction isn't supported for the document. For example, metadata extraction isn't supported for TXT files. Therefore, for TXT file [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata())  method returns *null*. If PDF document has no metadata, [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns an empty collection.
{{< /alert >}}

The following example demonstrates how to extract metadata from PDF document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
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