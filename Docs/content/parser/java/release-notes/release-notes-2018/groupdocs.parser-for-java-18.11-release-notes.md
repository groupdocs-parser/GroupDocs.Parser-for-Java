---
id: groupdocs-parser-for-java-18-11-release-notes
url: parser/java/groupdocs-parser-for-java-18-11-release-notes
title: GroupDocs.Parser for Java 18.11 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 18.11.{{< /alert >}}

## Major Features

There are the following features in this release:

*   Implemented the ability to retrieve the information of supported extractors for a document
*   Implemented IFastTextExtractor interface
*   Implemented IDocumentContentExtractor interface
*   Improved text area extraction for PDF documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| PARSERNET-1077 | Implement the ability to retrieve the information of supported extractors for a document | New feature |
| PARSERNET-1075 | Implement IFastTextExtractor interface | Enhancement |
| PARSERNET-1076 | Implement IDocumentContentExtractor interface | Enhancement |
| PARSERNET-1069 | Improve text area extraction for PDF documents | Enhancement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Parser for Java 18.11. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Parser which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Ability to retrieve the information of supported extractors for a document

#### Description

This enhancement allows getting the information of supported extractors for a document.

#### Public API changes

*   Added **DocumentInfo** class
    
*   Added **g****etDocumentInfo** methods to **ExtractorFactory** class
    

#### Usage

**DocumentInfo** class has the following properties:

| Property | Description |
| --- | --- |
| hasText | Boolean value indicating if a user can extract a plain text from a document |
| hasFormattedText | Boolean value indicating if a user can extract a formatted text from a document |
| hasMetadata | Boolean value indicating if a user can extract metadata from a document |
| isContainer | Boolean value indicating if a document contains other documents (like email attachments or zip archive) |

Usage:



```java
void printDocumentInfo(String fileName) {
    ExtractorFactory factory = new ExtractorFactory();
    // Get the document info
    DocumentInfo info = factory.getDocumentInfo(fileName);
    System.out.println("This document contains:");
 
    // Check if a user can extract a plain text from a document
    if (info.hasText()) {
        System.out.println("text");
    }
 
    // Check if a user can extract a formatted text from a document
    if (info.hasFormattedText()) {
        System.out.println("formatted text");
    }
 
    // Check if a user can extract metadata from a document
    if (info.hasMetadata()) {
        System.out.println("metadata");
    }
 
    // Check if the document contains other documents
    if (info.isContainer()) {
        System.out.println("other documents");
    }
}
```

### Improved text area extraction for PDF documents

#### Description

This enhancement improves text area extraction for PDF documents. The Y-coordinates of text areas start from the top of the page. Text areas have more items for some kind of documents.

#### Public API changes

No API changes.

#### Usage



```java
// Create a text extractor
PdfTextExtractor extractor = new PdfTextExtractor("invoice.pdf");
  
// Create search options
TextAreaSearchOptions searchOptions = new TextAreaSearchOptions();
// Set a regular expression to search 'Invoice # XXX' text
searchOptions.setExpression("\\s?INVOICE\\s?#\\s?[0-9]+");
// Limit the search with a rectangle
searchOptions.setRectangle(new Rectangle(10, 10, 300, 150));
  
// Get text areas
java.util.List<TextArea> texts = extractor.getDocumentContent().getTextAreas(0, searchOptions);
  
// Iterate over a list
for (TextArea area : texts) {
    // Print a text
    System.out.println(area.getText());
}
```

### IFastTextExtractor interface

#### Description

This enhancement allows setting the fast text extraction via **IFastTextExtractor **interface.

#### Public API changes

Added **IFastTextExtractor **interface

Added support for **IFastTextExtractor **interface to the following classes:

*   **PdfTextExtractor** class
*   **CellsTextExtractor** class
*   **SlidesTextExtractor** class

#### Usage

**IFastTextExtractor** interface has only one property:

```java
ExtractMode ExtractMode { get; set; }
```

This property gets or sets a value indicating the mode of text extraction. `ExtractMode` enumeration has the following members:

| Value | Description |
| --- | --- |
| `Simple` | Fast text extraction. The text in this mode is not extracted in a very accurate way but faster than it is extracted in the standard mode. If the fast text extraction doesn't support the document format, this parameter is ignored and the standard text extraction is used. |
| `Standard` | Standard text extraction. |

Usage:



```java
void extractText(TextExtractor extractor) {
    // Check if extractor supports IFastTextExtractor interface
    if (extractor instanceof IFastTextExtractor) {
        // Set the mode of text extraction
        ((IFastTextExtractor) extractor).setExtractMode(ExtractMode.Simple);
    }
    // Extract a text
    System.out.println(extractor.extractAll());
}
```

### IDocumentContentExtractor interface

#### Description

This enhancement allows getting the access to Text Analysis API via **IDocumentContentExtractor **interface.

#### Public API changes

Added **IDocumentContentExtractor **interface

Added support for **IDocumentContentExtractor** interface to the following classes:

*   **PdfTextExtractor** class
*   **CellsTextExtractor** class
*   **SlidesTextExtractor** class
*   **WordsTextExtractor** class

#### Usage

**IDocumentContentExtractor** interface has only one property:

```java
DocumentContent DocumentContent { get; }
```

This property gets the access to the document's content.

Usage:



```java
void extractText(TextExtractor extractor) {
    // Check if extractor supports IDocumentContentExtractor interface
    if (extractor instanceof IDocumentContentExtractor) {
        IDocumentContentExtractor contentExtractor = (IDocumentContentExtractor) extractor;
        // Iterate over pages
        for (int i = 0; i < contentExtractor.getDocumentContent().getPageCount(); i++) {
            // Iterate over text areas of the page
            for (TextArea textArea : contentExtractor.getDocumentContent().getTextAreas(i)) {
                System.out.println(textArea.getText());
            }
        }
    }
}
```
