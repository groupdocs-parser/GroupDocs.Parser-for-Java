---
id: extract-hyperlinks-from-document
url: parser/java/extract-hyperlinks-from-document
title: Extract hyperlinks from document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---


GroupDocs.Parser provides the functionality to extract hyperlinks from documents by the [getHyperlinks](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getHyperlinks()) method:

```java
Iterable<PageHyperlinkArea> getHyperlinks();
```

This method returns a collection of [PageHyperlinkArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea) object:

| Member | Description |
| --- | --- |
| [getPage](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getPage()) | The page that contains the text area. |
| [getRectangle](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area on the page that contains the text area. |
| [getText](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea#getText()) | The hyperlink text. |
| [getUrl](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea#getUrl()) | The hyperlink URL. |

Here are the steps to extract all hyperlinks from the whole document:

* Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
* Check if the document supports hyperlink extraction;
* Call [getHyperlinks](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getHyperlinks()) method and obtain collection of [PageHyperlinkArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea) objects;
* Iterate through the collection and get a hyperlink text and URL.

The following example shows how to extract all hyperlinks from the whole document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.HyperlinksPdf)) {
    // Check if the document supports hyperlink extraction
    if (!parser.getFeatures().isHyperlinks()) {
        System.out.println("Document isn't supports hyperlink extraction.");
        return;
    }
    // Extract hyperlinks from the document
    Iterable<PageHyperlinkArea> hyperlinks = parser.getHyperlinks();
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