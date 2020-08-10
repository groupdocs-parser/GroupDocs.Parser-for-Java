---
id: extract-table-of-contents-from-epub-ebooks
url: parser/java/extract-table-of-contents-from-epub-ebooks
title: Extract table of contents from EPUB eBooks
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract table of contents from EPUB e-books [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method is used.

{{< alert style="warning" >}}
[getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method returns *null* value if table of contents extraction isn't supported for the document. For example, table of contents extraction isn't supported for TXT files. Therefore, for TXT file [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method returns *null*. If EPUB e-book has no table of contents, [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method returns an empty collection.
{{< /alert >}}

Here are the steps to extract extract table of contents from EPUB e-book:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial e-book;
*   Call [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method and obtain collection of [TocItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/TocItem "class in com.groupdocs.parser.data") objects;
*   Iterate through the collection and get page index to extract a page text from the document.

The following example shows how to extract table of contents from EPUB e-book:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleEpub)) {
    // Get table of contents
    Iterable<TocItem> tocItems = parser.getToc();
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

Along with full featured .NET library we provide simple, but powerful free Apps.

You are welcome to parse documents and extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).