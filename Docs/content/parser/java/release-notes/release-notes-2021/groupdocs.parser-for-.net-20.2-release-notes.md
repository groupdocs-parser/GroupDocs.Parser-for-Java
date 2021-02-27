---
id: groupdocs-parser-for-java-21-2-release-notes
url: parser/java/groupdocs-parser-for-java-21-2-release-notes
title: GroupDocs.Parser for Java 21.2 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 21.2{{< /alert >}}

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| PARSERNET-1734 | Improve text page extraction from WordProcessing documents | Improvement |
| PARSERJAVA-152 | Document parsing performance issue | Bug |

## Public API and Backward Incompatible Changes

### Improve text page extraction from WordProcessing documents

#### Description

This improvement enhanced the work with documents that contain sections, footers, headers and footnotes.

#### Public API changes

No API changes.

### Document parsing performance issue

#### Description

This fix improves the performance of raw text extraction from PDF documents.

#### Public API changes

No API changes.

#### Usage

The following code shows how to extract a raw text from PDF:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Create a text reader object to read a text with TextOptions for raw text extraction
    try (TextReader reader = parser.getText(new TextOptions(true))) {
        // Extract the whole text from the file
        String text = reader.readToEnd();
        // Print the text to the console
        System.out.println(text);
    }
}
```