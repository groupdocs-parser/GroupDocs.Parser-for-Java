---
id: work-with-email-attachments
url: parser/java/work-with-email-attachments
title: Work With Email Attachments
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
# Work With Email Attachments

Email Attachment can contain the following metadata:

| Name | Description |
| --- | --- |
| content-type | The MIME type of the attachment content |

Here are the steps to extract an email text from email attachments:

*   Instantiate *Parser *object for the initial document;
*   Call *getContainer* method and obtain collection of document container item objects;
*   Check if *collection* isn't null (container extraction is supported for the document);
*   Iterate through the collection and obtain Parser object to extract a text.

The following example shows how to extract a text from email attachments:

```csharp
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleMsg)) {
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
