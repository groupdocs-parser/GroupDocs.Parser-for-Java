---
id: extract-metadata-from-documents
url: parser/java/extract-metadata-from-documents
title: Extract metadata from documents
weight: 7
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser allows to extract basic metadata from documents of various formats: PDF, Emails, Ebooks, Microsoft Office: Word (DOC, DOCX), PowerPoint (PPT, PPTX), Excel (XLS, XLSX), LibreOffice formats and many others (see full list at [supported document formats]({{< ref "parser/java/getting-started/supported-document-formats.md" >}}) article).

# Extract metadata from documents

To extract metadata from documents simply call the [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method:

```java
Iterable<MetadataItem> getMetadata();
```

This method returns a collection of [MetadataItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/MetadataItem) objects with following members:

| Member | Description |
| --- | --- |
| [getName](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/MetadataItem#getName()) | The name of the metadata item |
| [getValue](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/MetadataItem#getValue()) | The value of the metadata item |

Here are the steps to extract metadata from the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method and obtain collection of document metadata objects;
*   Check if *collection* isn't *null* (metadata extraction is supported for the document);
*   Iterate through the collection and get metadata names and values.  

The following example shows how to extract metadata from a document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // Extract metadata from the document
    Iterable<MetadataItem> metadata = parser.getMetadata();
    // Check if metadata extraction is supported
    if (metadata == null) {
        System.out.println("Metatada extraction isn't supported");
    }
    // Iterate over metadata items
    for (MetadataItem item : metadata) {
        // Print an item name and value
        System.out.println(String.format("%s: %s", item.getName(), item.getValue()));
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