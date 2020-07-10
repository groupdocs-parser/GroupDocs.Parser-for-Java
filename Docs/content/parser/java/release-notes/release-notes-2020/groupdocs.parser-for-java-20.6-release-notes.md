---
id: groupdocs-parser-for-java-20-6-release-notes
url: parser/java/groupdocs-parser-for-java-20-6-release-notes
title: GroupDocs.Parser for Java 20.6 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 20.6{{< /alert >}}

## Major Features

There are the following improvements in this release:

*   Implement the API to extract data from documents
*   Implement the ability to detect media types for Zip container
*   Improve the performance of PDF raw text extraction

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| PARSERNET-1394 | Implement the API to extract data from documents | Feature |
| PARSERNET-1187 | Implement the ability to detect media types for Zip container | Feature |
| PARSERJAVA-174 | Improve the performance of PDF raw text extraction | Improvement |

## Public API and Backward Incompatible Changes

### Implement the ability to detect media types for Zip container 

#### Description 

This feature provides the functionality to detect a file type of
container items.

#### Public API changes

[com.groupdocs.parser.data.ContainerItem](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/ContainerItem)
public class was updated with changes as follows:

*   Added `detectFileType(FileTypeDetectionMode detectionMode)` method

The following types were added:

*   `FileTypeDetectionMode` enumeration into
    com.groupdocs.parser.options package.

#### Usage 

The following example shows how to detect a file type of container
items:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract attachments from the container
    Iterable<ContainerItem> attachments = parser.getContainer();
    // Check if container extraction is supported
    if (attachments == null) {
        System.out.println("Container extraction isn't supported");
    }
    // Iterate over attachments
    for (ContainerItem item : attachments) {
        // Detect the file type
        FileType fileType = item.detectFileType(FileTypeDetectionMode.Default);
        // Print the name and file type
        System.out.println(String.format("%s: %s", item.getName(), fileType));
    }
}
```

### Implement the API to extract data from documents 

#### Description 

This feature provides the functionality to extract tables and hyperlinks
from the following document types:

*   PDF
*   Presentation
*   Spreadsheet
*   Word Processing document

#### Public API changes 

The following types were added:

*   [`PageHyperlinkArea`](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea "class in com.groupdocs.parser.data")    class into com.groupdocs.parser.data package
*   [`PageTableAreaOptions`](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PageTableAreaOptions "class in com.groupdocs.parser.options")    class into com.groupdocs.parser.options package

com.groupdocs.parser.data.PageTableAreaCell public class was updated
with changes as follows:

*   Added `getText()` property

com.groupdocs.parser.Parser public class was updated with changes as
follows:

*   Added `getHyperlinks()` method
*   Added `getHyperlinks(int pageIndex)` method
*   Added `getHyperlinks(PageAreaOptions options)` method
*   Added `getHyperlinks(int pageIndex, PageAreaOptions options)` method
*   Added `getTables(PageTableAreaOptions options)` method
*   Added `getTables(int pageIndex, PageTableAreaOptions options)`    method

#### Usage

The following example shows how to extract hyperlinks from the document
page area:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Check if the document supports hyperlink extraction
    if (!parser.getFeatures().isHyperlinks()) {
        System.out.println("Document isn't supports hyperlink extraction.");
        return;
    }
    // Create the options which are used for hyperlink extraction
    PageAreaOptions options = new PageAreaOptions(new Rectangle(new Point(380, 90), new Size(150, 50)));
    // Extract hyperlinks from the document page area
    Iterable<PageHyperlinkArea> hyperlinks = parser.getHyperlinks(options);
    // Iterate over hyperlinks
    for (PageHyperlinkArea h : hyperlinks) {
        // Print the hyperlink text
        System.out.println(h.getText());
        // Print the hyperlink URL
        System.out.println(h.getUrl());
        System.out.println();
    }
}
```

The following example shows how to extract tables from the whole
document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleInvoicePagesPdf)) {
    // Check if the document supports table extraction
    if (!parser.getFeatures().isTables()) {
        System.out.println("Document isn't supports tables extraction.");
        return;
    }
    // Create the layout of tables
    TemplateTableLayout layout = new TemplateTableLayout(
            java.util.Arrays.asList(new Double[]{50.0, 95.0, 275.0, 415.0, 485.0, 545.0}),
            java.util.Arrays.asList(new Double[]{325.0, 340.0, 365.0, 395.0}));
    // Create the options for table extraction
    PageTableAreaOptions options = new PageTableAreaOptions(layout);
    // Extract tables from the document
    Iterable<PageTableArea> tables = parser.getTables(options);
    // Iterate over tables
    for (PageTableArea t : tables) {
        // Iterate over rows
        for (int row = 0; row < t.getRowCount(); row++) {
            // Iterate over columns
            for (int column = 0; column < t.getColumnCount(); column++) {
                // Get the table cell
                PageTableAreaCell cell = t.getCell(row, column);
                if (cell != null) {
                    // Print the table cell text
                    System.out.print(cell.getText());
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
```

### Improve the performance of PDF raw text extraction 

#### Description 

This improvement improves the performance of PDF raw text extraction.

#### Public API changes

There are no changes in public API

#### Usage 

This example shows how to extract a raw text from a document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract a raw text into the reader
    try (TextReader reader = parser.getText(new TextOptions(true))) {
        // Print a text from the document
        // If text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
    }
}
```