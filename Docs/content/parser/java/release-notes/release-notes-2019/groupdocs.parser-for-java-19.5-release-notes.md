---
id: groupdocs-parser-for-java-19-5-release-notes
url: parser/java/groupdocs-parser-for-java-19-5-release-notes
title: GroupDocs.Parser for Java 19.5 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 19.5.{{< /alert >}}

## Major Features

There are the following features in this release:

*   Implement the ability to extract data from documents
*   Implement the ability to move Table Layout
*   Implement the ability to detect a table in a rectangular area using a collection of column separators
*   Implement the support for spreadsheet and presentation templates
*   Some constructors and properties were removed from **TextProperties** class

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| PARSERNET-1145 | Implement the ability to extract data from documents | New feature |
| PARSERNET-1151 | Implement the ability to move Table Layout | New feature |
| PARSERNET-1158 | Implement the ability to detect a table in a rectangular area using a collection of column separators | New feature |
| PARSERNET-1200 | Implement the support for spreadsheet and presentation templates | New feature |
| PARSERNET-63 | Remove obsolete members (version 18.7) | Breaking Change |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Parser for Java 19.5. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Parser which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  ### Implement the ability to extract data from documents
    
    #### Description
    
    This feature allows to extract data from documents.
    
    *   Document template
        *   Template fields
            *   Fixed field position
            *   Regular expression field
            *   Related field
        *   Document template with fields
        *   Template tables
    *   Extracting data from the document
        
        *   Example
    *   Analyzing data fields and tables
        
        *   Data fields
            
        *   Data tables
            
    
    #### Public API changes
    
    Namespace GroupDocs.Parser.Extractors.Templates:
    
    *   Added **DocumentData** class
    *   Added **DocumentDataField** class
    *   Added **DocumentDataTable** class
    *   Added **DocumentTemplate** class
    *   Added **TemplateField** class
    *   Added **TemplateFieldPosition** class
    *   Added **TemplateFieldPositionType** enumeration
    *   Added **TemplateFieldRelatedPositionType** enumeration
    *   Added **TemplateTable** class
    
    *   Added **GetPageSize** method to **DocumentContent** class
    
    *   Added **Size** class
    *   Added **DocumentParser** class
    
    #### Usage
    
    Data extraction from documents is performed in three stages:
    
    *   Preparing the document template
    *   Extracting data from the document
    *   Analyzing data fields and tables
    
    ##### Document template
    
    The document template is set by DocumentTemplate class:
    
    | Member | Description |
    | --- | --- |
    | getCount() | An integer value that represents the total number of the template fields. |
    | TemplateField get\_Item(int index) | Gets a template field. |
    | java.util.List<TemplateTable> GetTables() | Returns a collection of template tables. |
    
    An instance of the class is created by the following constructors:
    
    ```java
    // Creates a document template with fields
    DocumentTemplate(java.util.List<TemplateField> templateFields);
    // Creates a document template with fields and tables
    DocumentTemplate(java.util.List<TemplateField> templateFields, java.util.List<TemplateTable> templateTables);
    ```
    
    ##### Template fields
    
    The template field is set by TemplateField class:
    
    | Member | Description |
    | --- | --- |
    | getFieldName() | An uppercase string that represents the name of the template field. |
    | getPageIndex() | A zero-based index of the page where the field is placed; null if the field is placed on any page. |
    | getFieldPosition() | A field position on the page (see below). |
    
    An instance of the class is created by the following constructors:
    
    ```java
    TemplateField(String fieldName, TemplateFieldPosition fieldPosition)
    TemplateField(String fieldName, int pageIndex, TemplateFieldPosition fieldPosition)
    ```
    
    The only difference between them is pageIndex. If the page index is omitted, data are extracted from every document page. It's useful in the cases when the document contains pages with the same layout (pages are differed only by data).
    
    TemplateFieldPosition class defines the field position on the page. The following position types are supported (position type is defined by TemplateFieldPositionType enumeration):
    
    *   The position is set by a rectangle (Fixed)
    *   The position is found by a regular expression (Regex)
    *   The position is set relative to the related field (Related)
    
    TemplateFieldPosition class contains properties for all supported position types. The instance of TemplateFieldPosition class contains only those properties which are related to the position type; other properties are null.
    
    | Member | Description | Fixed | Regex | Related |
    | --- | --- | --- | --- | --- |
    | getType() | A value that represents a type of the template field position. | • | • | • |
    | getRectangle() | A rectangle that bounds the field. | • |   |   |
    | getRegex() | A string value that represents a regular expression to find the field |   | • |   |
    | getRelatedFieldName() | A string value that represents a name of the related field. |   |   | • |
    | getRelatedPositionType() | A value that represents a field position relative to the related field. |   |   | • |
    | getSearchAreaSize() | A size of the field. |   |   | • |
    | canScaleSearchAreaSize() | A value indicating whether SearchAreaSize is scaled according to the related field. |   |   | • |
    
    An instance of the class is created by the following static methods:
    
    ```java
    // Creates a related template field position (scaling mode is enabled)
    TemplateFieldPosition createRegex(String regex);
    // Creates a regex template field position.
    TemplateFieldPosition createRegex(String regex);
    // Creates a related template field position.
    TemplateFieldPosition createRelated(
                String relatedFieldName, 
                TemplateFieldRelatedPositionType relatedPositionType,
                Size searchAreaSize);
    // Creates a related template field position (with the ability to explicitly set a scaling mode)
    TemplateFieldPosition createRelated(
                String relatedFieldName,
                TemplateFieldRelatedPositionType relatedPositionType,
                Size searchAreaSize,
                boolean canScaleSearchAreaSize);
    ```
    
    ###### Fixed field position
    
    This is simplest way to define the field position. It's required to set a rectangular area at the page that bounds field value. All the text that is contained (even partially) into the rectangular area will be extracted as a value:
    
    ```java
    // Create a fixed template field with "Address" name which is bounded by a rectangle at the position (35, 160) and with the size (110, 20)
    TemplateField templateField = new TemplateField("Address", TemplateFieldPosition.createFixed(new Rectangle(35, 160, 110, 20)));
    ```
    
    It is recommended to define a rectangular area above (below) the center of the line that is below (above) the selected area, in order to avoid the excessive extraction of the text. For example:
    
    | Template definition | Result |
    | --- | --- |
| ![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes.png)) | Extracts only one line:67890 
| ![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_1.png)) | Extracts two lines:4321 First Stree
    Anytown, State ZIP |
| ![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_2.png)) | Extracts four lines:Company Nam
    4321 First Street  
    Anytown, State ZIP  
    Date: 06/02/2019 |
    
    ###### Regular expression field
    
    This way to define the field position allows to find a field value by a regular expression. For example, if the document contains "Invoice Number   INV-12345" then template field can be defined in the following way:
    
    ```java
    // Create a regex template field with "InvoiceNumber" name
    TemplateField templateField = new TemplateField("InvoiceNumber", TemplateFieldPosition.createRegex("Invoice Number\\s+[A-Z0-9\\-]+"));
    ```
    
    In this case as a value the entire string is extracted. To extract only a part of the string the regular expression group "value" is used:
    
    ```java
    // Create a regex template field with "InvoiceNumber" name with "value" group
    TemplateField templateField = new TemplateField("InvoiceNumber", TemplateFieldPosition.createRegex("Invoice Number\\s+(?<value>[A-Z0-9\\-]+)"));
    ```
    
    In this case as a value "INV-3337" string is extracted.
    
    Regular expression fields can be used as related fields.
    
    ###### Related field
    
    This way to define the field position allows to find a field value by extracting a rectangular area around the related field. For example, if it's known that the field with an invoice number is placed on the right of "Invoice number" string the following code is used:
    
    ```java
    // Create a regex template field to find "Invoice Number" text
    TemplateField invoice = new TemplateField("Invoice", TemplateFieldPosition.createRegex("Invoice Number"));
    // Create a related template field associated with "Invoice" field and extract the value on the right of it
    TemplateField invoiceNumber = new TemplateField("InvoiceNumber", TemplateFieldPosition.createRelated("invoice", TemplateFieldRelatedPositionType.Right, new Size(100, 15), false));
    ```
    
    | Template definition | Result |
    | --- | --- |
| ![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_3.png)) | Extracts a text on the right of "Invoice Number" field:INV-3337 
    
    To simplify the setting of the size of template field CanScaleSearchAreaSize property is used. The size of template field is scaled according to the related field if CanScaleSearchAreaSize is set to true.This is useful when the font size is not known in advance, but the proportions of the size of the value (the ratio of height to width) are approximately known:
    
    ```java
    TemplateField invoice = new TemplateField("Invoice", TemplateFieldPosition.createRegex("Invoice Number"));
    // Create a related template field associated with "Invoice" field with auto-scale
    TemplateField invoiceNumber = new TemplateField("InvoiceNumber", TemplateFieldPosition.createRelated("invoice", TemplateFieldRelatedPositionType.Right, new Size(100, 15), true));
    ```
    
    | Template definition | Result |
    | --- | --- |
| ![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_4.png))  | Extracts a text on the right of "Invoice Number" field:INV-3337 
    
    The field value can be extracted from either side of the related field. The side of value extraction is set by TemplateFieldRelatedPositionType enumeration. The size of rectangular area is set by SearchAreaSize property. The position of rectangular area depends on the side of value extraction:
    
    *   Left: (RelatedField.Rectangle.Left - SearchAreaSize.Width; RelatedField.Rectangle.Top)
    *   Top: (RelatedField.Rectangle.Left; RelatedField.Rectangle.Top - SearchAreaSize.Height)
    *   Right: (RelatedField.Rectangle.Right; RelatedField.Rectangle.Top)
    *   Bottom: (RelatedField.Rectangle.Left; RelatedField.Rectangle.Bottom)
    
    The related field can be any field which was previously defined in the template:
    
    ```java
    // Create regex template field
    TemplateField fromField = new TemplateField("From", 0, TemplateFieldPosition.createRegex("From"));
    // Create related template field linked to "From" regex field and placed under it
    TemplateField companyField = new TemplateField("FromCompany", 0, TemplateFieldPosition.createRelated("From", TemplateFieldRelatedPositionType.Bottom, new Size(100, 10), false));
    // Create related template field linked to "FromCompany" related field and placed under it
    TemplateField addressField = new TemplateField("FromAddress", 0, TemplateFieldPosition.createRelated("FromCompany", TemplateFieldRelatedPositionType.Bottom, new Size(100, 30), false));
    ```
    
    | Template definition | Result |
    | --- | --- |
| ![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_5.png)) | The extraction is processed in the following way
    1.  Extracts data of "From" regex field (green)
    2.  Extracts data of "FromCompany" related field (yellow)
    3.  Extracts data of "FromAddress" related field (red)
    
     |
    
    A value of the field depends on the related field. The field is always empty If the related field doesn't have a value. If the field has a value then it has a link to the related field.
    
    ##### Document template with fields
    
    An instance of DocumentTemplate class is created by the constructor:
    
    ```java
    DocumentTemplate(java.util.List<TemplateField> templateFields);
    ```
    
    This constructor accepts a collection of template fields:
    
    ```java
    // Create an array of template fields
    TemplateField[] fields = new TemplateField[]
    {
        new TemplateField("From", 0, TemplateFieldPosition.createRegex("From")),
        new TemplateField("FromCompany", 0, TemplateFieldPosition.createRelated(
                "From",
                TemplateFieldRelatedPositionType.Bottom,
                new Size(100, 10),
                false)),
        new TemplateField("FromAddress", 0, TemplateFieldPosition.createRelated(
                "FromCompany",
                TemplateFieldRelatedPositionType.Bottom,
                new Size(100, 30),
                false))
    };
     
    // Create a document template
    DocumentTemplate template = new DocumentTemplate(java.util.Arrays.asList(fields));
    ```
    
    The field name is case-insensitive (Field and FIELD - the same names) and must be unique in the template. Related field must be associated with early defined field. If these conditions don't meet, the exception is thrown.
    
    ##### Template tables
    
    Template table is set by TemplateTable class:
    
    | Member | Description |
    | --- | --- |
    | TableName | An uppercase string that represents the name of the template table. |
    | PageIndex | A zero-based index of the page where the table is placed; null if the table is placed on any page. |
    | DetectorParameters | An instance of TableAreaDetectorParameters class or null if TableAreaLayout property is set. |
    | TableAreaLayout | An instance of TableAreaLayout class or null if DetectorParameters property is set. |
    
    An instance of the class is created by the following constructors:
    
    ```java
    TemplateTable(String tableName, TableAreaDetectorParameters detectorParameters)
    TemplateTable(String tableName, int pageIndex, TableAreaDetectorParameters detectorParameters)
    TemplateTable(String tableName, TableAreaLayout tableAreaLayout)
    TemplateTable(String tableName, int pageIndex, TableAreaLayout tableAreaLayout)
    ```
    
    Template table can be set with detector parameters or table layout. If the page index is omitted, tables are extracted from every document page. It's useful in the cases when the document contains pages with the same layout (pages are differed only by data).
    
    TableAreaDetectorParameters class has the following members:
    
    | Member | Description |
    | --- | --- |
    | MinRowCount | Minimum number of table rows |
    | MinColumnCount | Minimum number of table columns |
    | HasMergedCells | Value indicating whether the table has merged cells |
    | MinVerticalSpace | Minimum width of vertical separators |
    | Rectangle | Rectangle which bounds a table detection region |
    
    If a template table is set by detector parameters, the table is detected automatically:
    
    ```java
    // Create detector parameters
    TableAreaDetectorParameters detectorParameters = new TableAreaDetectorParameters();
    // Table is bounded by the rectangular area
    detectorParameters.setRectangle(new Rectangle(35, 330, 550, 100));
    // Create "Details" template table 
    TemplateTable table = new TemplateTable("Details", detectorParameters);
    // Create a collection of template tables
    TemplateTable[] tables = new TemplateTable[]
    {
        table
    };
    // Create a document template. Fields are omitted (we pass null instead of fields collection)
    DocumentTemplate template = new DocumentTemplate(null, java.util.Arrays.asList(tables));
    ```
    
    Template table is set by table layout if the table can't be detected automatically:
    
    | Member | Description |
    | --- | --- |
    | VerticalSeparators | A collection of vertical separators |
    | HorizontalSeparators | A collection of horizontal separators |
    
    These collections represent bounds of columns and rows. For example, for 2x2 table there are 3 vertical and 3 horizontal separators:
    
    ```java
    ---------
    |   |   |
    ---------
    |   |   |
    ---------
    ```
    
    In this case the document template has the following structure:
    
    ```java
    // Create a table layout
    TableAreaLayout tableAreaLayout = new TableAreaLayout();
     
    // Add vertical separators (columns)
    tableAreaLayout.getVerticalSeparators().add(50.0);
    tableAreaLayout.getVerticalSeparators().add(95.0);
    tableAreaLayout.getVerticalSeparators().add(275.0);
     
    // Add horizontal separators (rows)
    tableAreaLayout.getHorizontalSeparators().add(325.0);
    tableAreaLayout.getHorizontalSeparators().add(340.0);
    tableAreaLayout.getHorizontalSeparators().add(365.0);
     
    // Create "Details" template table
    TemplateTable table = new TemplateTable("Details", tableAreaLayout);
    // Create a collection of template tables
    TemplateTable[] tables = new TemplateTable[]
    {
        table
    };
    // Create a document template. Fields are omitted (we pass null instead of fields collection)
    DocumentTemplate template = new DocumentTemplate(null, java.util.Arrays.asList(tables));
    ```
    
    #### Extracting data from the document
    
    For data extracting DocumentParser class is used. This class has only one method with different overloads:
    
    ```java
    DocumentData parseByTemplate(String fileName, DocumentTemplate documentTemplate)
    DocumentData parseByTemplate(String fileName, DocumentTemplate documentTemplate, LoadOptions loadOptions)
    DocumentData parseByTemplate(java.io.InputStream stream, DocumentTemplate documentTemplate)
    DocumentData parseByTemplate(java.io.InputStream stream, DocumentTemplate documentTemplate, LoadOptions loadOptions)
    ```
    
    This method parses data from the document by a user-generated template. LoadOptions parameter is used to pass additional options to open the document (for example, password).
    
    To get the instance of DocumentParser class Default property is used:
    
    ```java
    DocumentData data = DocumentParser.DEFAULT.parseByTemplate("invoice - John Smith, Jan-2019.pdf", template);
    ```
    
    ##### Example
    
    This example shows the template which is used to parse the following invoice:
    
![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_6.jpg)
    
    ```java
    // Create a collection of template fields
    TemplateField[] templateFields = new TemplateField[]
    {
        new TemplateField("FromCompany", TemplateFieldPosition.createFixed(new Rectangle(35, 135, 100, 10))),
        new TemplateField("FromAddress", TemplateFieldPosition.createFixed(new Rectangle(35, 150, 100, 35))),
        new TemplateField("FromEmail", TemplateFieldPosition.createFixed(new Rectangle(35, 190, 150, 2))),
        new TemplateField("ToCompany", TemplateFieldPosition.createFixed(new Rectangle(35, 250, 100, 2))),
        new TemplateField("ToAddress", TemplateFieldPosition.createFixed(new Rectangle(35, 260, 100, 15))),
        new TemplateField("ToEmail", TemplateFieldPosition.createFixed(new Rectangle(35, 290, 150, 2))),
        new TemplateField("InvoiceNumber", TemplateFieldPosition.createRegex("Invoice Number")),
        new TemplateField("InvoiceNumberValue", TemplateFieldPosition.createRelated(
                "InvoiceNumber",
                TemplateFieldRelatedPositionType.Right,
                new Size(200, 15))),
        new TemplateField("InvoiceOrder", TemplateFieldPosition.createRegex("Order Number")),
        new TemplateField("InvoiceOrderValue", TemplateFieldPosition.createRelated(
                "InvoiceOrder",
                TemplateFieldRelatedPositionType.Right,
                new Size(200, 15))),
        new TemplateField("InvoiceDate", TemplateFieldPosition.createRegex("Invoice Date")),
        new TemplateField("InvoiceDateValue", TemplateFieldPosition.createRelated(
                "InvoiceDate",
                TemplateFieldRelatedPositionType.Right,
                new Size(200, 15))),
        new TemplateField("DueDate", TemplateFieldPosition.createRegex("Due Date")),
        new TemplateField("DueDateValue", TemplateFieldPosition.createRelated(
                "DueDate",
                TemplateFieldRelatedPositionType.Right,
                new Size(200, 15))),
        new TemplateField("TotalDue", TemplateFieldPosition.createRegex("Total Due")),
        new TemplateField("TotalDueValue", TemplateFieldPosition.createRelated(
                "TotalDue",
                TemplateFieldRelatedPositionType.Right,
                new Size(200, 15))),
    };
     
    // Create detector parameters for "Details" table
    TableAreaDetectorParameters detailsTableParameters = new TableAreaDetectorParameters();
    detailsTableParameters.setRectangle(new Rectangle(35, 320, 530, 55));
     
    // Create detector parameters for "Summary" table
    TableAreaDetectorParameters summaryTableParameters = new TableAreaDetectorParameters();
    summaryTableParameters.setRectangle(new Rectangle(330, 385, 220, 65));
     
    // Create a collection of template tables
    TemplateTable[] templateTables = new TemplateTable[]
    {
        new TemplateTable("details", detailsTableParameters),
        new TemplateTable("summary", summaryTableParameters)
    };
     
    // Create a document template
    DocumentTemplate template = new DocumentTemplate(java.util.Arrays.asList(templateFields), java.util.Arrays.asList(templateTables));
     
    // Extract data from PDF
    DocumentData data = DocumentParser.DEFAULT.parseByTemplate("invoice - John Smith, Jan-2019.pdf", template);
    ```
    
    #### Analyzing data fields and tables
    
    Extracted data are stored in the instance of DocumentData class:
    
    | Member | Description |
    | --- | --- |
    | getCount() | An integer value that represents the total number of data fields. |
    | DocumentDataField get\_Item(int index) | Gets a data field. |
    | java.util.List<DocumentDataField> getDataFieldsByName(String fieldName) | Returns a collection of the data fields which name is "fieldName". |
    | IList<DocumentDataTable> GetDataTables() | Returns a read-only collection of data tables. |
    
    The following methods are used to fill an instance with the data:
    
    | Method | Description |
    | --- | --- |
    | addDataField(DocumentDataField dataField) | Adds a data field. |
    | addDataFields(IEnumerable<DocumentDataField> dataFields) | Adds a collection of data fields. |
    | addDataTable(DocumentDataTable dataTable) | Adds a data table. |
    
    An instance of DocumentData class can contain more than one field (or table) with the same name. This is because a field (or table) is placed on more than one page or one page can contain more than one text value that meets the template field condition (for example, template regex field).
    
    ##### Data fields
    
    Data field is set by DocumentDataField class:
    
    | Member | Description |
    | --- | --- |
    | getFieldName() | An uppercase string that represents the name of the data field. |
    | getPageIndex() | A zero-based index of the page where the value is found. |
    | getValue() | A string value that represents a value of the data field; null if the value isn't found. |
    | getRectangle() | A rectangle that bounds the data field; null if the value isn't found. |
    | getRelatedDataField() | A data field relative to which the value is found; null for non-related data fields. |
    | isEmpty() | A value indicating whether a value is found. |
    
    An instance of the class is created by the following constructors:
    
    ```java
    // Creates an instance for the fixed or regex template fields
    DocumentDataField(String fieldName, int pageIndex, String value, Rectangle rectangle);
    // Creates an instance for the related template fields
    DocumentDataField(String fieldName, int pageIndex, String value, Rectangle rectangle, DocumentDataField relatedDataField);
    // Creates an empty instance (when value isn't found)
    DocumentDataField(String fieldName, int pageIndex);
    ```
    
    There are two ways to work with data fields.
    
    Iteration via all the fields:
    
    ```java
    for (int i = 0; i < data.getCount(); i++) {
        System.out.print(data.get_Item(i).getFieldName() + ": ");
        System.out.println(data.get_Item(i).getValue());
    }
    ```
    
    Find fields by a field name:
    
    ```java
    // Get all the fields with "Address" name
    java.util.List<DocumentDataField> addressFields = data.getDataFieldsByName("Address");
    if (addressFields.size() == 0) {
        System.out.println("Address not fount");
    } else {
        System.out.println("Address");
        // Iterate over the fields collection
        for (int i = 0; i < addressFields.size(); i++) {
            System.out.println(addressFields.get(i).getValue());
            // If it's a related field:
            if (addressFields.get(i).getRelatedDataField() != null) {
                System.out.print("Linked to ");
                System.out.println(addressFields.get(i).getRelatedDataField().getValue());
            }
        }
    }
    ```
    
    This functionality allows to iterate all data fields and select the most suitable of them. For example, if more than one text value meets the condition of the regular expression, a user can iterate over them and select the most suitable one.
    
    ##### Data tables
    
    Data table is set by DocumentDataTable class:
    
    | Member | Description |
    | --- | --- |
    | getTableName() | An uppercase string that represents the name of the data table. |
    | getPageIndex() | A zero-based index of the page where the table is found. |
    | getTableRectangle() | A rectangle that bounds the data table; null if the table isn't found. |
    | getRowCount() | An integer value that represents a number of rows. |
    | getColumnCount() | An integer value that represents a number of columns. |
    | get\_Item(int row, int column) | Gets a value of the table cell. |
    
    An instance of the class is created by the following constructors:
    
    ```java
    // Creates an empty instance (when value isn't found)
    DocumentDataTable(String tableName, int pageIndex);
    // Creates an instance of the data table
    DocumentDataTable(String tableName, int pageIndex, TableArea tableArea, Rectangle tableRectangle);
    ```
    
    Method DocumentData.GetTables() is used to work with tables:
    
    ```java
    // Get all the tables
    java.util.List<DocumentDataTable> dataTables = data.getDataTables();
    // Iterate over tables
    for (DocumentDataTable table : dataTables) {
        // Print a table name
        System.out.println(table.getTableName());
        // Iterate over rows
        for (int r = 0; r < table.getRowCount(); r++) {
            // Iterate over columns
            for (int c = 0; c < table.getColumnCount(); c++) {
                // Print a value of the cell
                System.out.print(table.get_Item(r, c));
                System.out.print(" ");
            }
     
            System.out.println();
        }
    }
    ```
    
2.  ### Implement the ability to move Table Layout
    
    #### Description
    
    This feature allows to move **TableAreaLayout** object.
    
    #### Public API changes
    
    Namespace GroupDocs.Parser.Extractors:  
      
    
    *   Added **getTableRectangle()** method to **TableAreaLayout** class
    *   Added **moveTo(double x, double y)** method to **TableAreaLayout** class
    
    #### Usage
    
    This functionality allows to move Table Layout.
    
    For example, a document has tables on each page (or a set of documents with a table on the page). These tables differ by position and content, but have the same columns and rows. In this case a user can define TableAreaLayout object at (0, 0) once and then move it to the location of the definite table.
    
    If the table position depends on the other object of the page, a user can define TableAreaLayout object based on template document and then move it according to an anchor object. For example, if this is a summary table and it is followed by details table (which can contain a different count of rows). In this case a user can define TableAreaLayout object on template document (with the known details table rectangle) and then move TableAreaLayout object according to the difference of details table rectangle of template and real document.
    
    MoveTo method returns a copy of the current object. A user can pass any coordinates (even negative - then layout will be moved to the left/top).
    
    getTableRectangle method returns a rectangle that bounds the table.
    
    ```java
    // Create a table layout
    TableAreaLayout templateLayout = new TableAreaLayout();
     
    // with 4 columns:
    templateLayout.getVerticalSeparators().add(0.0);
    templateLayout.getVerticalSeparators().add(25.0);
    templateLayout.getVerticalSeparators().add(150.0);
    templateLayout.getVerticalSeparators().add(180.0);
    templateLayout.getVerticalSeparators().add(230.0);
     
    // and with 5 rows:
    templateLayout.getHorizontalSeparators().add(0.0);
    templateLayout.getHorizontalSeparators().add(15.0);
    templateLayout.getHorizontalSeparators().add(30.0);
    templateLayout.getHorizontalSeparators().add(45.0);
    templateLayout.getHorizontalSeparators().add(60.0);
    templateLayout.getHorizontalSeparators().add(75.0);
     
    // Print a rectangle
    Rectangle rect = templateLayout.getTableRectangle();
    // Prints: pos: (0, 0) size: (230, 75)
    System.out.printf("pos: (%f, %f) size: (%f, %f) \r", rect.getLeft(), rect.getTop(), rect.getWidth(), rect.getHeight());
     
     
    // Move layout to the definite table location
    TableAreaLayout movedLayout = templateLayout.moveTo(315, 250.0);
     
    // Ensure that the first separators are moved:
    System.out.println(movedLayout.getVerticalSeparators().get(0)); // prints: 315
    System.out.println(movedLayout.getHorizontalSeparators().get(0)); // prints: 250
     
    Rectangle movedRect = movedLayout.getTableRectangle();
    // Prints: pos: (315, 250) size: (230, 75)
    System.out.printf("pos: (%f, %f) size: (%f, %f) \r", movedRect.getLeft(), movedRect.getTop(), movedRect.getWidth(), movedRect.getHeight());
     
    // movedLayout object is a copy of templateLayout object, thus we can tune separators without the impact on the original layout:
    movedLayout.getHorizontalSeparators().add(90.0);
     
    System.out.println(movedLayout.getHorizontalSeparators().size()); // prints: 7
    System.out.println(templateLayout.getHorizontalSeparators().size()); // prints: 6
    ```
    
3.  ### Implement the ability to detect a table in a rectangular area using a collection of column separators
    
    #### Description
    
    This feature allows to detect tables by column separators.
    
    #### Public API changes
    
    Namespace GroupDocs.Parser.Extractors:
    
    *   Added **VerticalSeparators **property to **TableAreaDetectorParameters** class
    
    #### Usage
    
    This API provides the ability to detect tables in documents by setting table vertical separators:
    
    ```java
    // Create PDF text extractor
    PdfTextExtractor extractor = new PdfTextExtractor(fileName);
    try
    {
        // Create table detector parameters
        TableAreaDetectorParameters parameters = new TableAreaDetectorParameters();
     
        // Set vertical separators
        parameters.setVerticalSeparators(new java.util.ArrayList());
        parameters.getVerticalSeparators().add(185.0);
        parameters.getVerticalSeparators().add(370.0);
        parameters.getVerticalSeparators().add(425.0);
        parameters.getVerticalSeparators().add(485.0);
        parameters.getVerticalSeparators().add(545.0);
     
        // Create a table detector
        TableAreaDetector detector = new TableAreaDetector(extractor.getDocumentContent());
     
        // Detect a table on the first page with detector parameters
        java.util.List<TableAreaLayout> layout = detector.detectLayouts(0, parameters);
    }
    finally
    {
        // Dispose an extractor
        extractor.dispose();
    }
    ```
    
![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_7.png)
    
    For more accurate table detection a user can set a rectangular area that bounds the table:
    
    ```java
    // Create PDF text extractor
    PdfTextExtractor extractor = new PdfTextExtractor(fileName);
    try
    {
        // Create table detector parameters
        TableAreaDetectorParameters parameters = new TableAreaDetectorParameters();
     
        // Set vertical separators
        parameters.setVerticalSeparators(new java.util.ArrayList());
        parameters.getVerticalSeparators().add(185.0);
        parameters.getVerticalSeparators().add(370.0);
        parameters.getVerticalSeparators().add(425.0);
        parameters.getVerticalSeparators().add(485.0);
        parameters.getVerticalSeparators().add(545.0);
     
        // Set a rectangular area that bounds a table
        parameters.setRectangle(new Rectangle(175, 350, 400, 200));
     
        // Create a table detector
        TableAreaDetector detector = new TableAreaDetector(extractor.getDocumentContent());
     
        // Detect a table on the first page with detector parameters
        java.util.List<TableAreaLayout> layout = detector.detectLayouts(0, parameters);
    }
    finally
    {
        // Dispose an extractor
        extractor.dispose();
    }
    ```
    
![](parser/java/images/groupdocs-parser-for-java-19-5-release-notes_8.png)
    
4.  ### Remove obsolete members (version 18.7)
    
    #### Description
    
    Some constructors and properties were removed from **TextProperties** class.
    
    #### Public API changes
    
    Namespace GroupDocs.Parser.Extractors:  
      
    
    *   Removed **TextProperties(bool isBold, bool isItalic)** constructor
    *   Removed **TextProperties(bool isBold, bool isItalic, string style)** constructor
    *   Removed **IsBold** and **IsItalic** properties from **TextProperties** class.
    
    #### Usage
    
    Use TextProperties(Font font) or TextProperties(Font font, string style) constructors instead:
    
    ```java
    TextProperties properties = new TextProperties(new Font(false, true));
     
    // instead of:
     
    TextProperties properties = new TextProperties(false, true);
    ```
    
    ```java
    TextProperties properties = new TextProperties(new Font(false, true), "congue");
     
    // instead of:
     
    TextProperties properties = new TextProperties(false, true, "congue");
    ```
    
    Use Font property instead of isBold() or isItalic() properties:
    
    ```java
    TextProperties properties = new TextProperties(new Font(false, true), "congue");
     
    System.out.println("IsItalic " + (properties.getFont().isItalic() ? "yes" : "No"));
    System.out.println("IsBold " + (properties.getFont().isBold() ? "yes" : "No"));
     
    // instead of:
     
    System.out.println("IsItalic " + (properties.isItalic() ? "yes" : "No"));
    System.out.println("IsBold " + (properties.isBold() ? "yes" : "No"));
    ```
    
5.  ### Implement the support for spreadsheet and presentation templates
    
    #### Description
    
    This feature allows to extract a text and metadata from the following documents:
    
    #### **Spreadsheet**
    
    | Format | Description |
    | --- | --- |
    | XLT | Microsoft Excel Template |
    | XLTX | Office Open XML Spreadsheet Template |
    | XLTM | Office Open XML Spreadsheet Template (Macro-enabled) |
    | OTS | Open Document Spreadsheet Template |
    | XLA | Excel Add-In File |
    | XLAM | Excel Open XML Macro-Enabled Add-In |
    
    #### **Presentations**
    
    | Format | Description |
    | --- | --- |
    | POT | PowerPoint Template |
    | OTP | Open Document Presentation Template |
