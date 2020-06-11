---
id: work-with-outlook-storage
url: parser/java/work-with-outlook-storage
title: Work With Outlook Storage
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
# Work With Outlook Storage

Outlook Storage item can contain the following metadata:

| Name | Description |
| --- | --- |
| date | The time and date at which the Outlook Storage item was last modified. |
| email-sender | The value of "sender" field. |
| email-to | The value of "to" field. |
| subject | The value of "subject" field. |

Outlook Storage container consists of email documents (msg files).

Here are the steps to extract an email text from outlook storage:

*   Instantiate *Parser *object for the initial document;
*   Call* getContainer* method and obtain collection of document container item objects;
*   Check if *collection* isn't null (container extraction is supported for the document);
*   Iterate through the collection and obtain Parser object to extract a text.

The following example shows how to extract a text from emails in outlook storage:

```csharp
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleOutlook)) {
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
