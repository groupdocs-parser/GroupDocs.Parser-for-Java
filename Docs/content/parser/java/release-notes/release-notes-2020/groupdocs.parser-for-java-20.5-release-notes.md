---
id: groupdocs-parser-for-java-20-5-release-notes
url: parser/java/groupdocs-parser-for-java-20-5-release-notes
title: GroupDocs.Parser for Java 20.5 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 20.5{{< /alert >}}

## Major Features

There are the following improvements in this release:

*   Added RawPageCount property to IDocumentInfo interface
*   Implemented the ability to create Parser object with java.sql.Connection and EmailConnection objects

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| PARSERNET-1507 | Add RawPageCount property to IDocumentInfo interface | Improvement |
| PARSERNET-1364 | Implement the ability to create Parser object with DbConnection | New feature |
| PARSERNET-1365 | Implement the ability to create Parser object with EmailConnection | New feature |

## Public API and Backward Incompatible Changes

### Add RawPageCount property to IDocumentInfo interface

#### Description

This feature improves API of raw text extraction from document page.

#### Public API changes

IDocumentInfo interface was updated with changes as follows:

*   Added RawPageCount property

#### Usage

The following example shows how to extract a raw text from a document page:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Check if the document supports text extraction
    if (!parser.getFeatures().isText()) {
        System.out.println("Document isn't supports text extraction.");
        return;
    }
    // Get the document info
    IDocumentInfo documentInfo = parser.getDocumentInfo();
    // Check if the document has pages
    if (documentInfo == null || documentInfo.getRawPageCount() == 0) {
        System.out.println("Document hasn't pages.");
        return;
    }
    // Iterate over pages
    for (int p = 0; p < documentInfo.getRawPageCount(); p++) {
        // Print a page number
        System.out.println(String.format("Page %d/%d", p + 1, documentInfo.getRawPageCount()));
        // Extract a text into the reader
        try (TextReader reader = parser.getText(p, new TextOptions(true))) {
            // Print a text from the document
            // We ignore null-checking as we have checked text extraction feature support earlier
            System.out.println(reader.readToEnd());
        }
    }
}
```

### Implement the ability to create Parser object with DbConnection

#### Description

This feature allows to extract data from databases via JDBC.

#### Public API changes

Parser class was updated with changes as follows:

*   Added Parser(Connection) constructor
*   Added Parser(Connection, ParserSettings) constructor

#### Usage

The following example shows how to extract data from Sqlite database:

```java
// Create DbConnection object
java.sql.Connection connection = java.sql.DriverManager.getConnection(String.format("jdbc:sqlite:%s", Constants.SampleDatabase));
// Create an instance of Parser class to extract tables from the database
try (Parser parser = new Parser(connection)) {
    // Check if text extraction is supported
    if (!parser.getFeatures().isText()) {
        System.out.println("Text extraction isn't supported.");
        return;
    }
    // Check if toc extraction is supported
    if (!parser.getFeatures().isToc()) {
        System.out.println("Toc extraction isn't supported.");
        return;
    }
    // Get a list of tables
    Iterable<TocItem> toc = parser.getToc();
    // Iterate over tables
    for(TocItem i : toc)
    {
        // Print the table name
        System.out.println(i.extractText());
        // Extract a table content as a text
        try(TextReader reader = parser.getText(i.getPageIndex().intValue()))
        {
            System.out.println(reader.readToEnd());
        }
    }
}
```

### Implement the ability to create Parser object with EmailConnection

#### Description

This feature allows to extract data from email servers.

#### Public API changes

Parser class was updated with changes as follows:

*   Added Parser(EmailConnection) constructor
*   Added Parser(EmailConnection, ParserSettings) constructor

#### Usage

The following example shows how to extract emails from Exchange Server:

```java
// Create the connection object for Exchange Web Services protocol
EmailConnection connection = new EmailEwsConnection(
        "https://outlook.office365.com/ews/exchange.asmx",
        "email@server",
        "password");
// Create an instance of Parser class to extract emails from the remote server
try (Parser parser = new Parser(connection)) {
    // Check if container extraction is supported
    if (!parser.getFeatures().isContainer()) {
        System.out.println("Container extraction isn't supported.");
        return;
    }
    // Extract email messages from the server
    Iterable<ContainerItem> emails = parser.getContainer();
    // Iterate over attachments
    for (ContainerItem item : emails) {
        // Create an instance of Parser class for email message
        try (Parser emailParser = item.openParser()) {
            // Extract the email text
            try (TextReader reader = emailParser.getText()) {
                // Print the email text
                System.out.println(reader == null ? "Text extraction isn't supported." : reader.readToEnd());
            }
        }
    }
}
```
