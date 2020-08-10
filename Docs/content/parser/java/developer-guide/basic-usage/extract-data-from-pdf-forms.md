---
id: extract-data-from-pdf-forms
url: parser/java/extract-data-from-pdf-forms
title: Extract data from PDF forms
weight: 10
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser allows to parse form data from PDF documents.

# Extract data from PDF forms

To extract PDF form data please call the [parseForm](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#parseForm()) method:

```java
DocumentData parseForm();
```

This method returns an instance of [DocumentData](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/DocumentData) class with the extracted data.

Here are the steps to parse form of the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [parseForm](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#parseForm()) method and obtain the [DocumentData](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/DocumentData) object;
*   Check if *data* isn't *null* (parse form is supported for the document);
*   Iterate over field data to obtain form data.

The following example shows how to parse a form of the document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleFormsPdf)) {
    // Extract data from PDF document
    DocumentData data = parser.parseForm();
    // Check if form extraction is supported
    if (data == null) {
        System.out.println("Form extraction isn't supported.");
        return;
    }
    // Iterate over extracted data
    for (int i = 0; i < data.getCount(); i++) {
        System.out.print(data.get(i).getName() + ": ");
        PageTextArea area = data.get(i).getPageArea() instanceof PageTextArea
                ? (PageTextArea) data.get(i).getPageArea()
                : null;
        System.out.println(area == null ? "Not a template field" : area.getText());
    }
}
```

## More resources

### Advanced usage topics

To learn more about document data extraction features and get familiar how to extract text, images, forms and more, please refer to the [advanced usage section]({{< ref "parser/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).