---
id: extract-tables-from-document-page
url: parser/java/extract-tables-from-document-page
title: Extract tables from document page
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---

GroupDocs.Parser provides the functionality to extract tables from document page by the [getTable(int, PageTableAreaOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getTables(int,%20com.groupdocs.parser.options.PageTableAreaOptions)) method:

```java
Iterable<PageTableArea> getTables(int pageIndex, PageTableAreaOptions options);
```

This method returns a collection of [PageTableArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageTableArea) object:

| Member | Description |
| --- | --- |
| [getRectangle](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area that bounds text area. |
| [getPage](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getPage()) | The page information (page index and page size) |
| [getRowCount](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageTableArea#getRowCount()) | The total number of the table rows. |
| [getColumnCount](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageTableArea#getColumnCount()) | The total number of the table columns. |
| [getCell(int, int)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageTableArea#getCell(int,%20int)) | The table cell by row and column indexes. |
| [getRowHeight(int)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageTableArea#getRowHeight(int)) | The the row height. |
| [getColumnWidth(int)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageTableArea#getColumnWidth(int)) | Returns the column width. |

[getTables(int, PageTableAreaOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getTables(int,%20com.groupdocs.parser.options.PageTableAreaOptions)) accepts [PageTableAreaOption](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PageTableAreaOptions) object that contains [TemplateTableLayout](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.templates/TemplateTableLayout) object with table layout (see [this article]({{< ref "parser/java/developer-guide/advanced-usage/working-with-templates.md" >}}) for more details).

Here are the steps to extract tables from the whole document:

* Instantiate [Parser](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser) object for the initial document;
* Check if the document supports table extraction;
* Call [getTables(int, PageTableAreaOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getTables(int,%20com.groupdocs.parser.options.PageTableAreaOptions)) method with the page index and obtain collection of [PageTableArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageTableArea) objects;
* Iterate through the collection and print table cells.

The following example shows how to extract tables from the whole document:

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
    // Get the document info
    IDocumentInfo documentInfo = parser.getDocumentInfo();
    // Check if the document has pages
    if (documentInfo.getPageCount() == 0) {
        System.out.println("Document hasn't pages.");
        return;
    }
    // Iterate over pages
    for (int pageIndex = 0; pageIndex < documentInfo.getPageCount(); pageIndex++) {
        // Print a page number
        System.out.println(String.format("Page %d/%d", pageIndex + 1, documentInfo.getPageCount()));
        // Extract tables from the document page
        Iterable<PageTableArea> tables = parser.getTables(pageIndex, options);
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
}
```

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

- [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)
- [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).