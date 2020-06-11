---
id: extract-data-from-databases
url: parser/java/extract-data-from-databases
title: Extract data from databases
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract data from databases via JDBC.

To create an instance of `[Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser)` class to extract data from a database the following constructor is used:

```csharp
Parser(String filePath, LoadOptions loadOptions);

```

The list of tables is represented as table of contents. The table extraction is processed by `**[getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText())**()` method.

Here are the steps to extract emails from Sqlite database:

*   Prepare connection string;
*   Instantiate `[Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser)` object with connection string;
*   Call `**[isText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/Features#isText())**()` property to check if text extraction is supported;
*   Call `**[isToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/Features#isToc())**()` property to check if table of contents extraction is supported;
*   Call `**[getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc())**()` method and obtain collection of tables;
*   Iterate through the collection and get a text from tables.

The following example shows how to extract data from Sqlite database:

```csharp
String connectionString = String.format("jdbc:sqlite:%s", Constants.SampleDatabase);
// Create an instance of Parser class to extract tables from the database
// As filePath connection parameters are passed; LoadOptions is set to Database file format
try (Parser parser = new Parser(connectionString, new LoadOptions(FileFormat.Database))) {
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
    for (TocItem i : toc) {
        // Print the table name
        System.out.println(i.getText());
        // Extract a table content as a text
        try (TextReader reader = parser.getText(i.getPageIndex())) {
            System.out.println(reader.readToEnd());
        }
    }
}

```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)
    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)
    

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).