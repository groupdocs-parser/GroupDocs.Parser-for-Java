---
id: extract-text-from-zip-archive-files
url: parser/java/extract-text-from-zip-archive-files
title: Extract text from ZIP archive files
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract files from ZIP archives [getContainer](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getContainer()) method is used. This method returns the collection of [ContainerItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/ContainerItem) objects.

Zip Entry can contain the following metadata:

| Name | Description |
| --- | --- |
| date | The time and date at which the file indicated by the Zip Entry was last modified. |
| crc | The 32-bit CRC (Cyclic Redundancy Check) on the contents of the Zip Entry. |

These metadata refer to a container element itself, not a document.

Here are the steps to extract an email text from Zip archives:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getContainer](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getContainer()) method and obtain collection of [ContainerItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/ContainerItem) objects;
*   Check if *collection* isn't *null* (container extraction is supported for the document);
*   Iterate through the collection and obtain [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object to extract a text.

The following example shows how to extract a text from Zip archives:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleZip)) {
    // Extract attachments from the container
    Iterable<ContainerItem> attachments = parser.getContainer();
    // Check if container extraction is supported
    if (attachments == null) {
        System.out.println("Container extraction isn't supported");
    }
    // Iterate over zip entities
    for (ContainerItem item : attachments) {
        // Print the file path
        System.out.println(item.getFilePath());
        // Print metadata
        for (MetadataItem metadata : item.getMetadata()) {
            System.out.println(String.format("%s: %s", metadata.getName(), metadata.getValue()));
        }
        try {
            // Create Parser object for the zip entity content
            try (Parser attachmentParser = item.openParser()) {
                // Extract an zip entity text
                try (TextReader reader = attachmentParser.getText()) {
                    System.out.println(reader == null ? "No text" : reader.readToEnd());
                }
            }
        } catch (UnsupportedDocumentFormatException ex) {
            System.out.println("Isn't supported.");
        }
    }
}
```

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)    

### Free Online Document Parser App

Along with full featured .NET library we provide simple, but powerful free Apps.

You are welcome to parse documents and extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).