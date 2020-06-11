---
id: work-with-zip-archives
url: parser/java/work-with-zip-archives
title: Work With ZIP Archives
weight: 5
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
# Work With ZIP Archives

Zip Entry can contain the following metadata:

| Name | Description |
| --- | --- |
| date | The time and date at which the file indicated by the Zip Entry was last modified. |
| crc | The 32-bit CRC (Cyclic Redundancy Check) on the contents of the Zip Entry. |

Here are the steps to extract an email text from Zip archives:

*   Instantiate *Parser *object for the initial document;
*   Call *getContainer* method and obtain collection of document container item objects;
*   Check if *collection* isn't null (container extraction is supported for the document);
*   Iterate through the collection and obtain Parser object to extract a text.

The following example shows how to extract a text from Zip archives:

```csharp
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
