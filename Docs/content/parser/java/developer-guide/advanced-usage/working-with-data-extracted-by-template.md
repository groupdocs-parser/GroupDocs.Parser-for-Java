---
id: working-with-data-extracted-by-template
url: parser/java/working-with-data-extracted-by-template
title: Working with data extracted by template
weight: 102
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
## DocumentData class

Extracted data are stored in the instance of [DocumentData](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/DocumentData) class:

| Member | Description |
| --- | --- |
| [getCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/DocumentData#getCount()) | The total number of the data fields. |
| [get(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/DocumentData#get(int)) | The data field. |
| [getFieldsByName(String)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/DocumentData#getFieldsByName(java.lang.String)) | Returns the collection of data fields where the name is equal to fieldName |

[FieldData](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/FieldData) class has the following members:

| Member | Description |
| --- | --- |
| [getName](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/FieldData#getName()) | The field name. |
| [getPageIndex](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/FieldData#getPageIndex()) | The page index. |
| [getPageArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/FieldData#getPageArea()) | The value of the field. |
| [getLinkedField](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/FieldData#getLinkedField()) | The linked field. |

Field data are stored in [getPageArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/FieldData#getPageArea()) property. Depending on the type of the value it can contain the instance of [PageTextArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea) or [PageTableArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTableArea) classes:

```java
// Get the field data
FieldData field = data.get(i);
// Check if the field data contains a text
if(field.getPageArea() instanceof PageTextArea)
{
    // Print the field value
    System.out.println((PageTextArea)field.getPageArea()).getText());
}

```

[PageTextArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea) class represents a text block on the page. This class has the following members:

| Member | Description |
| --- | --- |
| [getRectangle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area that bounds the text area. |
| [getPage](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getPage()) | The page information (page index and page size). |
| [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getText()) | The value of the text area. |
| [getBaseLine](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getBaseLine()) | The base line of the text area. |
| [getTextStyle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getTextStyle()) | The style of the text block (like font name, font size etc.) |
| [getAreas](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getAreas()) | The collection of child text areas. |

The text area can be single or composite. In the first case it contains a text which is bounded by a rectangular area. In the second case it contains other text areas; text and table properties are calculated by child text areas.

[PageTableArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTableArea) class represents a table. This class has the following members:

| Member | Description |
| --- | --- |
| [getRectangle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area that bounds text area. |
| [getPage](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getPage()) | The page information (page index and page size) |
| [getRowCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTableArea#getRowCount()) | The total number of the table rows. |
| [getColumnCount](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTableArea#getColumnCount()) | The total number of the table columns. |
| [getCell(int, int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTableArea#getCell(int,%20int)) | The table cell by row and column indexes. |
| [getRowHeight(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTableArea#getRowHeight(int)) | Returns the row height. |
| [getColumnWidth(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTableArea#getColumnWidth(int)) | Returns the column width. |

There are two ways to work with fields data.

## Iterate through fields

The following example shows how to iterate via extracted field data:

```java
// Print all extracted data
for (int i = 0; i < data.getCount(); i++) {
    // Print field name
    System.out.print(data.get(i).getName() + ": ");
    // As we have defined only text fields in the template,
    // we cast PageArea property value to PageTextArea
    PageTextArea area = data.get(i).getPageArea() instanceof PageTextArea
            ? (PageTextArea) data.get(i).getPageArea()
            : null;
    System.out.println(area == null ? "Not a template field" : area.getText());
}
```

## Get field by name

The following example shows how to get field by the name:

```java
// Print prices
System.out.println("Prices:");
for (FieldData field : data.getFieldsByName("Price")) {
    PageTextArea area = field.getPageArea() instanceof PageTextArea
            ? (PageTextArea) field.getPageArea()
            : null;
    System.out.println(area == null ? "Not a template field" : area.getText());
}
```

This functionality allows to iterate all data fields and select the most suitable of them. For example, if more than one text value meets the condition of the regular expression, a user can iterate over them and select the most suitable one.

## Working with tables

The following example shows how to work with extracted tables:

```java
// Parse the document by the template
DocumentData data = parser.parseByTemplate(template);
// Print all extracted data
for (int i = 0; i < data.getCount(); i++) {
    System.out.print(data.get(i).getName() + ": ");
    // Check if the field is a table
    PageTableArea area = data.get(i).getPageArea() instanceof PageTableArea
            ? (PageTableArea) data.get(i).getPageArea()
            : null;
    if (area == null) {
        continue;
    }
    // Iterate via table rows
    for (int row = 0; row < area.getRowCount(); row++) {
        // Iterate via table columns
        for (int column = 0; column < area.getColumnCount(); column++) {
            // Get the cell value
            PageTextArea cellValue = area.getCell(row, column).getPageArea() instanceof PageTextArea
                    ? (PageTextArea) area.getCell(row, column).getPageArea()
                    : null;
            // Print the space between columns
            if (column > 0) {
                System.out.print("\t");
            }
            // Print the cell value
            System.out.print(cellValue == null ? "" : cellValue.getText());
        }
        // Print new line
        System.out.println();
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