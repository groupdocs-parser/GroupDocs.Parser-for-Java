---
id: groupdocs-parser-for-java-18-12-release-notes
url: parser/java/groupdocs-parser-for-java-18-12-release-notes
title: GroupDocs.Parser for Java 18.12 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 18.12.{{< /alert >}}

## Major Features

There are the following features in this release:

*   Added the ability to extract tables from PDFs
*   Added the support for text and presentation templates
*   Added the ability to detect the type of password-protected Office Open XML documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| PARSERNET-1016 | Implement the ability to extract tables from PDFs | New feature |
| PARSERNET-1097 | Implement the support for text and presentation templates | New feature |
| PARSERNET-1092 | Implement the ability to detect the type of password-protected Office Open XML documents | Enhancement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Parser for Java 18.12. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Parser which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Ability to extract tables from PDFs

#### Description

This feature allows extracting tables from PDF documents.

#### Public API changes

*   Added **TableArea** class
*   Added **TableAreaCell** class
*   Added **TableAreaLayout** class
*   Added **TableAreaDetector** class
*   Added **TableAreaDetectorParameters** class
*   Added **TableAreaParser** class
*   Added **TableAreaDetector** property to **PdfTextExtractor** class
*   Added **TableAreaParser** property to **PdfTextExtractor** class

#### Usage

For extracting tables from PDF document, **TableAreaParser**class is used. The instance of **TableAreaParser**class is available via property with the same name in **PdfTextExtractor** class:



```java
PdfTextExtractor extractor = new PdfTextExtractor("document.pdf"); 
TableAreaParser parser = extractor.getTableAreaParser();
```

**ParseTableArea** method is used to extract a table from the document page:



```java
TableArea parseTableArea(int pageIndex, TableAreaLayout tableAreaLayout)
```

This method accepts the zero-based page index and layout of the table. The layout is represented by **TableAreaLayout** class with the following members:

| Member | Description |
| --- | --- |
| VerticalSeparators | A collection of vertical separators |
| HorizontalSeparators | A collection of horizontal separators |

These collections represent bounds of columns and rows. For example, for 2x2 table there are 3 vertical and 3 horizontal separators:

`---------`

`|   |   |`

`---------`

`|   |   |`

`---------`

**TableArea** class has the following members:

| Member | Description |
| --- | --- |
| int RowCount | Number of table rows |
| int ColumnCount | Number of table columns |
| TableAreaCell this\[int row, int column\] | Cell of the table |
| double GetRowHeight(int row) | Height of the row |
| double GetColumnWidth(int column) | Width of the row |

**TableCellArea** class has the following members:

| Member | Description |
| --- | --- |
| TextArea | Content of the cell. |
| Row | Zero-based index of the row. |
| Column | Zero-based index of the column. |
| RowSpan | Number of rows which the cell spans across. |
| ColumnSpan | Number of columns which the cell spans across. |

Usage:



```java
void parse(String fileName) throws java.lang.Exception {
    // Create a text extractor
    try (PdfTextExtractor extractor = new PdfTextExtractor(fileName)) {
        // Get a table parser
        TableAreaParser parser = extractor.getTableAreaParser();
 
        // Create a table layout
        TableAreaLayout layout = new TableAreaLayout();
 
        // Add vertical separators (columns)
        layout.getVerticalSeparators().add(72.0);
        layout.getVerticalSeparators().add(125.0);
        layout.getVerticalSeparators().add(333.0);
        layout.getVerticalSeparators().add(454.0);
        layout.getVerticalSeparators().add(485.0);
 
        // Add horizontal separators (rows)
        layout.getHorizontalSeparators().add(390.0);
        layout.getHorizontalSeparators().add(417.0);
        layout.getHorizontalSeparators().add(440.0);
        layout.getHorizontalSeparators().add(500.0);
        layout.getHorizontalSeparators().add(521.0);
 
        // Extract a table area
        TableArea tableArea = parser.parseTableArea(0, layout);
 
        // Iterate over rows
        for (int row = 0; row < tableArea.getRowCount(); row++) {
            System.out.print("| ");
            // Iterate over columns
            for (int column = 0; column < tableArea.getColumnCount(); column++) {
                // Get a table cell
                TableAreaCell cell = tableArea.get_Item(row, column);
 
                // If a cell is empty or it continues another cell
                if (cell == null || cell.getColumn() != column || cell.getRow() != row) {
                    // Skip this cell
                    continue;
                }
 
                // Write content of the cell
                System.out.print(cell == null ? " " : cell.getTextArea().getText());
                System.out.print(" | ");
            }
 
            System.out.println();
        }
    }
}
```

A user can create **TableAreaLayout** object manually or by using **TableAreaDetector** class. The instance of **TableAreaDetector** class is available via property with the same name in **PdfTextExtractor** class:



```java
PdfTextExtractor extractor = new PdfTextExtractor("document.pdf");
TableAreaDetector detector = extractor.getTableAreaDetector();
```

**TableAreaDetector** class is created to find table bounds in automatic mode. **detectLayouts** method searches tables on the page of the document and returns a collection of table layouts:



```java
IList<TableAreaLayout> detectLayouts(int pageIndex, params TableAreaDetectorParameters[] parameters)
```

This method accepts the zero-based page index and optional parameters. These parameters help to detect tables. If set, the detector tries to search only those tables which meet this criterion; the total number of detected tables, in this case, must be equal to the number of passed parameters.

**TableAreaDetectorParameters** class has the following members:

| Member | Description |
| --- | --- |
| MinRowCount | Minimum number of table rows. |
| MinColumnCount | Minimum number of table columns. |
| HasMergedCells | Value indicating whether the table has merged cells. |
| MinVerticalSpace | Minimum width of vertical separators. |
| Rectangle | Rectangle which bounds a table detection region. |

By setting parameters a user can tune detector's behavior. For example, limit the page area to search a table and disable searching complex tables (with merged cells):



```java
void detectAndParse(String fileName) throws java.lang.Exception {
    // Create a text extractor
    try (PdfTextExtractor extractor = new PdfTextExtractor(fileName)) {
        // Get a table detector
        TableAreaDetector detector = extractor.getTableAreaDetector();
 
        int pageIndex = 0;
 
        // Get a page object
        DocumentPage page = extractor.getDocumentContent().getPage(pageIndex);
        // Create a parameter to help the detector to search a table
        TableAreaDetectorParameters parameter = new TableAreaDetectorParameters();
        // We assume that the table is placed in a middle of the page and has a half page height
        parameter.setRectangle(new Rectangle(0, page.getHeight() / 3, page.getWidth(), page.getHeight() / 2));
        // Table hasn't merged cells
        parameter.setMergedCells(false);
        // Table contains 3 or more rows
        parameter.setMinRowCount(3);
        // Table contains 4 or more columns
        parameter.setMinColumnCount(4);
 
        // Detect layouts
        java.util.List<TableAreaLayout> layouts = detector.detectLayouts(pageIndex, parameter);
 
        // If layouts collection is empty - exit
        if (layouts.size() == 0) {
            System.out.println("No tables found");
            return;
        }
 
        // Get a table parser
        TableAreaParser parser = extractor.getTableAreaParser();
        // Extract a table area. As we pass only one parameter, there is only one layout
        TableArea tableArea = parser.parseTableArea(pageIndex, layouts.get(0));
 
        // Iterate over rows
        for (int row = 0; row < tableArea.getRowCount(); row++) {
            System.out.print("| ");
            // Iterate over columns
            for (int column = 0; column < tableArea.getColumnCount(); column++) {
                // Get a table cell
                TableAreaCell cell = tableArea.get_Item(row, column);
 
                // If a cell is empty or it continues another cell
                if (cell == null || cell.getColumn() != column || cell.getRow() != row) {
                    // Skip this cell
                    continue;
                }
 
                // Write content of the cell
                System.out.print(cell == null ? " " : cell.getTextArea().getText());
                System.out.print(" | ");
            }
 
            System.out.println();
        }
    }
}
```

### Support for text and presentation templates

#### Description

This feature allows to extract a text and metadata from the following documents:

*       dotx (Template)
*       dotm (Macro-enabled template)
*       ott (OpenDocument Text Template)
*       potx (Template)
*       potm (Macro-enabled template)
*       ppsm (Macro-enabled slide show)
*       pptm (Macro-enabled presentation)

#### Public API changes

No API changes.

#### Usage



```java
void extractText(String fileName) {
    // Extract a text from the file
    String text = Extractor.DEFAULT.extractText(fileName);
    // Print an extracted text
    System.out.println(text);
}
 
void extractMetadata(String fileName) {
    // Extract metadata from the file
    MetadataCollection metadata = Extractor.DEFAULT.extractMetadata(fileName);
    // Print extracted metadata
    for (String key : metadata.getKeys()) {
        // Print a metadata key
        System.out.print(key);
        System.out.print(": ");
        // Print a metadata value
        System.out.println(metadata.get_Item(key));
    }
}
 
void detectMediaType(String fileName) {
    // Get a default composite media type detector
    MediaTypeDetector detector = CompositeMediaTypeDetector.DEFAULT;
 
    // Detect a media type
    String mediaType = detector.detect(fileName);
    // Print a detected media type
    System.out.println(mediaType);
}
```

### Ability to detect the type of password-protected Office Open XML documents

#### Description

This feature allows detecting password-protected Office Open XML documents by content.

#### Public API changes

*   Added string **Detect(Stream, LoadOptions)** public method to **MediaTypeDetector** class.
*   Added string **DetectByContent(Stream, LoadOptions)** protected virtual method to **MediaTypeDetector** class.
*   Marked as obsolete **string DetectByContent(Stream)** protected virtual method from **MediaTypeDetector** class.

#### Usage

To detect media type of encrypted Office Open XML document **Detect(Stream, LoadOptions)** method is used:



```java
void detect(String fileName, String password) throws java.lang.Exception {
    // Create load options
    LoadOptions loadOptions = new LoadOptions();
    // Set a password
    loadOptions.setPassword(password);
 
    // Get a default composite media type detector
    MediaTypeDetector detector = CompositeMediaTypeDetector.DEFAULT;
 
    // Create a stream to detect media type by content (not file extension)
    try (java.io.InputStream stream = new java.io.FileInputStream(fileName)) {
        // Detect a media type
        String mediaType = detector.detect(stream, loadOptions);
        // Print a detected media type
        System.out.println(mediaType);
    }
}
```

For batch document processing PasswordProvider is used:



```java
class Detector implements IPasswordProvider {
    private String currentFile;
 
    public void detect(String[] documents) throws java.lang.Exception {
        // Create load options
        LoadOptions loadOptions = new LoadOptions();
        // Set a password provider (it requests a password for protected documents if nessesary)
        loadOptions.setPasswordProvider(this);
 
        // Get a default composite media type detector
        MediaTypeDetector detector = CompositeMediaTypeDetector.DEFAULT;
 
        // Iterage over documents
        for (String fileName : documents) {
            // Set the current file name to dispay it with the password request
            currentFile = fileName;
            // Create a stream to detect media type by content (not file extension)
            try (java.io.InputStream stream = new java.io.FileInputStream(fileName)) {
                // Detect a media type
                String mediaType = detector.detect(stream, loadOptions);
                // Print a detected media type
                System.out.println(mediaType);
            }
        }
    }
 
    // If the document is encrypted Office Open XML, OnPasswordRequest is invoked
    public void onPasswordRequest(Object sender, PasswordRequest request) {
        // Print a password request
        System.out.println("Enter password for" + currentFile + ":");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String password = scanner.next();
 
        // If a user omits a password (entered a blank password)
        if ("" == password) {
            // Mark the request as cancelled
            request.setCancel(true);
        } else {
            // Set a password
            request.setPassword(password);
        }
    }
}
```
