---
id: extract-hyperlinks-from-document-page-area
url: parser/java/extract-hyperlinks-from-document-page-area
title: Extract hyperlinks from document page area
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---

GroupDocs.Parser provides the functionality to extract hyperlinks from document page area by the [getHyperlinks(PageAreaOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getHyperlinks(com.groupdocs.parser.options.PageAreaOptions)) and [getHyperlinks(int, PageAreaOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getHyperlinks(int,%20com.groupdocs.parser.options.PageAreaOptions)) methods:

```java
Iterable<PageHyperlinkArea> getHyperlinks(PageAreaOptions options);
Iterable<PageHyperlinkArea> getHyperlinks(int pageIndex, PageAreaOptions options);
```

These methods return a collection of [PageHyperlinkArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea) object:

| Member | Description |
| --- | --- |
| [getPage](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getPage()) | The page that contains the text area. |
| [getRectangle](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area on the page that contains the text area. |
| [getText](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea#getText()) | The hyperlink text. |
| [getUrl](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea#getUrl()) | The hyperlink URL. |

Here are the steps to extract hyperlinks from the document page area:

* Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
* Check if the document supports hyperlink extraction;
* Instantiate [PageAreaOptions](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PageAreaOptions) with the rectangular area;
* Call [getHyperlinks(PageAreaOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getHyperlinks(com.groupdocs.parser.options.PageAreaOptions)) method and obtain collection of [PageHyperlinkArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea) objects;
* Iterate through the collection and get a hyperlink text and URL.

The following example shows how to extract hyperlinks from the document page area:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.HyperlinksPdf)) {
    // Check if the document supports hyperlink extraction
    if (!parser.getFeatures().isHyperlinks()) {
        System.out.println("Document isn't supports hyperlink extraction.");
        return;
    }
    // Create the options which are used for hyperlink extraction
    PageAreaOptions options = new PageAreaOptions(new Rectangle(new Point(380, 90), new Size(150, 50)));
    // Extract hyperlinks from the document page area
    Iterable<PageHyperlinkArea> hyperlinks = parser.getHyperlinks(options);
    // Iterate over hyperlinks
    for (PageHyperlinkArea h : hyperlinks) {
        // Print the hyperlink text
        System.out.println(h.getText());
        // Print the hyperlink URL
        System.out.println(h.getUrl());
        System.out.println();
    }
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

- [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)
- [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)

### Free online image extractor App

Along with full featured .NET library we provide simple, but powerfull free APPs.

You are welcome to extract images from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [GroupDocs Parser App](https://products.groupdocs.app/parser).