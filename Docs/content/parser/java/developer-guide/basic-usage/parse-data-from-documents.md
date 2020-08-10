---
id: parse-data-from-documents
url: parser/java/parse-data-from-documents
title: Parse data from documents
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides Document Parser feature that allows you to extract data from documents of various formats including PDF, Microsoft Word, Excel, LibreOffice formats etc. (see [full supported list]({{< ref "parser/java/getting-started/supported-document-formats.md" >}})).

With Document Parsing feature you can easily solve business automation tasks with the data extracted from your documents.

Using this feature is straightforward. Simply define a template programmatically and apply it.

# Parse data from documents

GroupDocs.Parser provides the functionality to extract basic metadata from documents by the [parseByTemplate(Template)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#parseByTemplate(com.groupdocs.parser.templates.Template)) method:

```java
DocumentData parseByTemplate(Template template);
```

This method parses data from the document by a user-generated template.

Here are the steps to parse data from the document by user-generated template:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [Template](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.templates/Template) object with the user-generated template;
*   Call [parseByTemplate(Template)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#parseByTemplate(com.groupdocs.parser.templates.Template)) method and obtain [DocumentData](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/DocumentData) object;
*   Check if *data* isn't *null* (parse by template is supported for the document);
*   Iterate over field data to obtain form data.

The following example shows how to parse data from the document by user-generated template :

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleInvoicePdf)) {
    // Parse the document by the template
    DocumentData data = parser.parseByTemplate(GetTemplate());
    // Check if form extraction is supported
    if (data == null) {
        System.out.println("Parse Document by Template isn't supported.");
        return;
    }
    // Print extracted fields
    for (int i = 0; i < data.getCount(); i++) {
        System.out.print(data.get(i).getName() + ": ");
        PageTextArea area = data.get(i).getPageArea() instanceof PageTextArea
                ? (PageTextArea) data.get(i).getPageArea()
                : null;
        System.out.println(area == null ? "Not a template field" : area.getText());
    }
}

private static Template GetTemplate() {
    // Create detector parameters for "Details" table
    TemplateTableParameters detailsTableParameters = new TemplateTableParameters(new Rectangle(new Point(35, 320), new Size(530, 55)), null);
    // Create detector parameters for "Summary" table
    TemplateTableParameters summaryTableParameters = new TemplateTableParameters(new Rectangle(new Point(330, 385), new Size(220, 65)), null);
    // Create a collection of template items
    TemplateItem[] templateItems = new TemplateItem[]
            {
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 135), new Size(100, 10))), "FromCompany"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 150), new Size(100, 35))), "FromAddress"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 190), new Size(150, 2))), "FromEmail"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 250), new Size(100, 2))), "ToCompany"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 260), new Size(100, 15))), "ToAddress"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 290), new Size(150, 2))), "ToEmail"),
                    new TemplateField(new TemplateRegexPosition("Invoice Number"), "InvoiceNumber"),
                    new TemplateField(new TemplateLinkedPosition(
                            "InvoiceNumber",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "InvoiceNumberValue"),
                    new TemplateField(new TemplateRegexPosition("Order Number"), "InvoiceOrder"),
                    new TemplateField(new TemplateLinkedPosition(
                            "InvoiceOrder",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "InvoiceOrderValue"),
                    new TemplateField(new TemplateRegexPosition("Invoice Date"), "InvoiceDate"),
                    new TemplateField(new TemplateLinkedPosition(
                            "InvoiceDate",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "InvoiceDateValue"),
                    new TemplateField(new TemplateRegexPosition("Due Date"), "DueDate"),
                    new TemplateField(new TemplateLinkedPosition(
                            "DueDate",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "DueDateValue"),
                    new TemplateField(new TemplateRegexPosition("Total Due"), "TotalDue"),
                    new TemplateField(new TemplateLinkedPosition(
                            "TotalDue",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "TotalDueValue"),
                    new TemplateTable(detailsTableParameters, "details", null),
                    new TemplateTable(summaryTableParameters, "summary", null)
            };
    // Create a document template
    Template template = new Template(java.util.Arrays.asList(templateItems));
    return template;
}
```

## More resources

### Advanced usage topics

To learn more about template building and working with extracted data please refer the following guides:

*   [Working with templates]({{< ref "parser/java/developer-guide/advanced-usage/working-with-templates.md" >}})
*   [Working with data extracted by template]({{< ref "parser/java/developer-guide/advanced-usage/working-with-data-extracted-by-template.md" >}})

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)    

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).