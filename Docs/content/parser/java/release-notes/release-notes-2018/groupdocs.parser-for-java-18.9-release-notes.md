---
id: groupdocs-parser-for-java-18-9-release-notes
url: parser/java/groupdocs-parser-for-java-18-9-release-notes
title: GroupDocs.Parser for Java 18.9 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 18.9.{{< /alert >}}

# Major Features

There are the following features in this release:

*   Ability to extract a text from databases
*   Ability to extract data from PDF Forms
*   Support for text analysis API for text documents
*   Support for text analysis API for spreadsheets
*   Support for text analysis API for presentation
*   Ability to request a password for protected documents
*   Metered licensing security is improved and now supports Java version 8u101 or above

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| PARSERNET-555 | Implement the ability to extract a text from databases | New feature |
| PARSERNET-975 | Implement the ability to extract data from the form fields of PDFs | New feature |
| PARSERNET-1024 | Implement the ability to request a password for protected documents | New feature |
| PARSERNET-978 | Implement the support for text analysis API for text documents | New feature |
| PARSERNET-979 | Implement the support for text analysis API for spreadsheets | New feature |
| PARSERNET-980 | Implement the support for text analysis API for presentations | New feature |
| PARSERJAVA-31 | Metered licensing security has been improved and now supports Java version 8u101 or above | Breaking change |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Parser for Java 18.9. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Parser which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Breaking Change - Metered licensing security has been improved and now supports Java version 8u101 or above

#### Description

This breaking change improves Metered licensing security. Starting from GroupDocs.Parser 18.9 Metered API can be used only with Java 8u101 or above. Please use other types of licensing in Java 7.

#### Public API changes

No public API changes.

#### Usage

This code works only with Java 8u101 or above:



```java
Metered metered = new Metered();
metered.setMeteredKey(PUBLIC_KEY, PRIVATE_KEY);
```

This code works with Java 7 or above:



```java
License lic = new License();
lic.setLicense(LICENSE_PATH);
```

### Ability to extract a text from databases

#### Description

This feature allows extracting a text from databases.

#### Public API changes

*   Added **DbContainer** class
*   Added **DbTableReader** class

#### Usage

To extract a text from databases **DbContainer** class is used. **DbContainer** class implements **IContainer** interface. Each data table is represented by the entity. The content of the entity is CSV-presentation of data table. For more detailed text extraction **GetTableReader** method is used. Also, this method is faster and consumes less memory. **getTableReader** method returns an instance of **DbTableReader** class.

**DbTableReader** class has the following members:

| Member | Description |
| --- | --- |
| read() | Reads the next data row and returns a collection of row cells |
| readLine() | Reads the next data row and returns a string representation of comma-separated values |
| columnsFilter | Gets or sets a collection of columns names which are returned byReadand ReadLine methods; null if all table columns are returned |
| columns | Gets a collection of table columns names |

Using DbContainer as a container:



```java
// Create a container
DbContainer container = new DbContainer(java.sql.DriverManager.getConnection(connectionString));
try {
    // Iterate over entities
    for (Container.Entity entity : container.getEntities()) {
        // Print a table name
        System.out.println(entity.getName());
        // Print a media type
        System.out.println(entity.getMediaType());
        // Create a stream reader for CSV document: OpenStream method converts a table to the CSV file and returns it as Stream
        java.io.InputStreamReader reader = new java.io.InputStreamReader(entity.openStream());
        try {
            BufferedReader br = new BufferedReader(reader);
 
            // Read a line
            String line = br.readLine();
            // Loop to the end of the file
            while (line != null) {
                // Print a line from the document
                System.out.println(line);
                // Read the next line
                line = br.readLine();
            }
        } finally {
            reader.close();
        }
    }
} finally {
    container.dispose();
}
```

### Ability to extract data from the form fields of PDFs

#### Description

This feature allows extracting data from PDF Forms.

#### Public API changes

*   Added **getFormData** method to **PdfTextExtractor** class

#### Usage



```java
// Create a text extractor
PdfTextExtractor extractor = new PdfTextExtractor(fileName);
try {
    // Extract forms data
    java.util.Dictionary<String, String> fields = extractor.getFormData();
    // Iterate over fields
    java.util.Enumeration<String> e = fields.keys();
    while (e.hasMoreElements()) {
        String key = e.nextElement();
        // Print field name and value
        System.out.println(String.format("%s: %s", key, fields.get(key)));
    }
} finally {
    extractor.dispose();
}
```

### Support for text analysis API for text documents

#### Description

This feature allows extracting text areas from document pages of text documents.

#### Public API changes

Added **DocumentContent** property to **WordsTextExtractor** class.

#### Usage



```java
// Create a text extractor
WordsTextExtractor extractor = new WordsTextExtractor("invoice.docx");
 
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

### Support for text analysis API for spreadsheets

#### Description

This feature allows extracting text areas from document pages of spreadsheets.

#### Public API changes

Added **DocumentContent** property to **CellsTextExtractor** class.

#### Usage



```java
// Create a text extractor
CellsTextExtractor extractor = new CellsTextExtractor("invoice.xlsx");
 
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

### Support for text analysis API for presentations

#### Description

This feature allows extracting text areas from document pages of presentations.

#### Public API changes

Added **DocumentContent** property to **SlidesTextExtractor** class.

#### Usage



```java
// Create a text extractor
SlidesTextExtractor extractor = new SlidesTextExtractor("presentation.pptx");
 
// Create search options
TextAreaSearchOptions searchOptions = new TextAreaSearchOptions();
// Set a regular expression to search 'Published: XXXX.XX.XX' text
searchOptions.setExpression("\\s?Published\\:\\s?[0-9]{4}\\.[0-9]{2}\\.[0-9]{2}");
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

### Ability to request a password for protected documents

#### Description

This feature allows providing a password for protected documents on-demand.

#### Public API changes

Added **IPasswordProvider** interface.  
Added **PasswordRequest** class.  
Added **PasswordProvider** property to **LoadOptions** class.

#### Usage

`IPasswordProvider` interface has only one method:



```java
void onPasswordRequest(object sender, PasswordRequest request);
```

This method is called when the extractor or container meets a password-protected document. `sender` contains the link to the caller. `PasswordRequest` class contains the information about the request:

| Member | Description |
| --- | --- |
| Cancel | The boolean value indicating whether the request is rejected |
| Password | A password for the document |

A user has two ways to provide a password for the document. When the password is known, `Password` property of *`LoadOptions`* class is used. If it is not known whether it is protected or not before opening the document, `PasswordProvider` property of *`LoadOptions`* class is used.



```java
class Indexer {
    // A name of the current processed file
    private String currentFileName;
 
    // Processes the directory
    public void process(java.io.File dir) {
        // Create load options with Password Provider
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPasswordProvider(new PasswordProvider(this));
 
        // Process the sub-directories
        for (java.io.File file : dir.listFiles()) {
            if (file.isDirectory()) {
                // Process files in the directory
                process(file);
            } else {
                // Set the name of the current processed file
                currentFileName = file.getName();
 
                try {
                    // Extract a text from the file
                    String text = Extractor.DEFAULT.extractText(file.getPath(), loadOptions);
                    // Print the length of the file
                    System.out.println(String.format("%s, length: %d", currentFileName, (text == null ? "" : text).length()));
                } catch (GroupDocsParserException ex) {
                    // Print an error message (for example, "Invalid Password")
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
 
    // Provides the ability to request a password from a user
    private class PasswordProvider implements IPasswordProvider {
        private final Indexer owner;
 
        public PasswordProvider(Indexer owner) {
            this.owner = owner;
        }
 
        // Requests a password from a user
        public void onPasswordRequest(Object sender, PasswordRequest request) {
            // Print a password request
            System.out.println("Enter password for" + owner.currentFileName + ":");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String password = scanner.next();
 
            // If a user omits a password (entered a blank password)
            if ("" == password) {
                // Mark the request as cancelled
                request.setCancel(true);
            } else {
                // Set the password
                request.setPassword(password);
            }
        }
    }
}
```
