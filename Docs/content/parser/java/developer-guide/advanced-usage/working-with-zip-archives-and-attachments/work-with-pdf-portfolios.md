---
id: work-with-pdf-portfolios
url: parser/java/work-with-pdf-portfolios
title: Work With PDF Portfolios
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
# Work With PDF Portfolios

Here are the steps to extract an email text from PDF Portfolios:

*   Instantiate *Parser *object for the initial document;
*   Call *getContainer* method and obtain collection of document container item objects;
*   Check if *collection* isn't null (container extraction is supported for the document);
*   Iterate through the collection and obtain Parser object to extract a text.

The following example shows how to extract a text from PDF Portfolios:

```csharp
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdfPortfolio)) {
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
