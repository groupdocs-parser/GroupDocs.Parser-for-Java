---
id: extract-table-of-contents
url: parser/java/extract-table-of-contents
title: Extract table of contents
weight: 11
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser allows to extract table of contents from Microsoft Word (DOC, DOCX etc), PDF documents and Ebooks.

# Extract table of contents

To extract table of contents from documents, please use the [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method:

```java
Iterable<TocItem> getToc();
```

[TocItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem) class has the following members:

| Member | Description |
| --- | --- |
| [getDepth](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem#getDepth()) | The depth level. |
| [getPageIndex](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem#getPageIndex()) | The page index. |
| [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem#getText()) | The text. |
| [extractText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem#extractText()) | Extracts a text from the document to which [TocItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem) object refers. For detail, see [Extract text by table of contents item]({{< ref "parser/java/developer-guide/advanced-usage/working-with-text/extract-text-by-table-of-contents-item.md" >}}) |

Here are the steps to extract extract table of contents from the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method and obtain collection of [TocItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem) objects;
*   Check if *collection* isn't *null* (table of contents  extraction is supported for the document);
*   Iterate through the collection and get page index to extract a page text from the document.

The following example shows how to extract table of contents from CHM file:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleChm)) {
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
    // Get table of contents
    Iterable<TocItem> toc = parser.getToc();
    // Iterate over items
    for (TocItem i : toc) {
        // Print the Toc text
        System.out.println(i.getText());
        // Check if page index has a value
        if (i.getPageIndex() == null) {
            continue;
        }
        // Extract a page text
        try (TextReader reader = parser.getText(i.getPageIndex())) {
            System.out.println(reader.readToEnd());
        }
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