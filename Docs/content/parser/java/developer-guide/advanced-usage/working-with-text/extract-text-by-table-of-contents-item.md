---
id: extract-text-by-table-of-contents-item
url: parser/java/extract-text-by-table-of-contents-item
title: Extract text by table of contents item
weight: 9
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract a text by an item of table of contents. This feature is supported for Word Processing, PDF, ePUB and CHM documents (for more details, see [Supported Document Formats]({{< ref "parser/java/getting-started/supported-document-formats.md" >}})).

Text is extracted by [extractText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem#extractText()) method:

```java
// Print the text of the chapter
try(TextReader reader = tocItem.extractText()) {
    System.out.println("----");
    System.out.println(reader.ReadToEnd());
}
```

This method returns a text from the chapter to which table of contents item refers (without sub-chapters). For example, "Heading 1.2" from the page

![](parser/java/images/extract-text-by-table-of-contents-item.png)

returns the following text:

![](parser/java/images/extract-text-by-table-of-contents-item_1.png)

"Heading 2" from the page:

![](parser/java/images/extract-text-by-table-of-contents-item_2.png)

returns the following text:

![](parser/java/images/extract-text-by-table-of-contents-item_3.png)

{{< alert style="warning" >}}
*[java.lang.UnsupportedOperationException](https://docs.oracle.com/javase/7/docs/api/java/lang/UnsupportedOperationException.html)* is thrown if [getPageIndex](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem#getPageIndex()) is *null*.
{{< /alert >}}

Here are the steps to extract a text by an item of table of contents:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method and obtain the collection of [TocItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem "class in com.groupdocs.parser.data") objects;
*   Check if collection isn't *null* (table of contents extraction is supported for the document);
*   Iterate through the *collection* and extract a text

The following example shows how to extract a text by an item of table of contents:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocxWithToc)) {
    // Get table of contents
    Iterable<TocItem> tocItems = parser.getToc();
    // Check if toc extraction is supported
    if (tocItems == null) {
        System.out.println("Table of contents extraction isn't supported");
    }
    // Iterate over items
    for (TocItem tocItem : tocItems) {
        // Print the text of the chapter
        try (TextReader reader = tocItem.extractText()) {
            System.out.println("----");
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