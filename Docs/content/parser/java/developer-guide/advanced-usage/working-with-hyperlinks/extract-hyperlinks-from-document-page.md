---
id: extract-hyperlinks-from-document-page
url: parser/java/extract-hyperlinks-from-document-page
title: Extract hyperlinks from document page
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract hyperlinks from document page by the [getHyperlinks(int)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getHyperlinks(int)) method:

```java
Iterable<PageHyperlinkArea> getHyperlinks(int pageIndex);
```

This method returns a collection of [PageHyperlinkArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea) object:

| Member | Description |
| --- | --- |
| [getPage](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getPage()) | The page that contains the text area. |
| [getRectangle](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area on the page that contains the text area. |
| [getText](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea#getText()) | The hyperlink text. |
| [getUrl](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea#getUrl()) | The hyperlink URL. |

Here are the steps to extract hyperlinks from the document page:

* Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
* Check if the document supports hyperlink extraction;
* Call [getHyperlinks(int)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getHyperlinks(int)) method with the page index and obtain collection of [PageHyperlinkArea](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/PageHyperlinkArea) objects;
* Iterate through the collection and get a hyperlink text and URL.

The following example shows how to extract hyperlinks from the document page:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.HyperlinksPdf)) {
    // Check if the document supports hyperlink extraction
    if (!parser.getFeatures().isHyperlinks()) {
        System.out.println("Document isn't supports hyperlink extraction.");
        return;
    }
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
        // Extract hyperlinks from the document page
        Iterable<PageHyperlinkArea> hyperlinks = parser.getHyperlinks(pageIndex);
        // Iterate over hyperlinks
        for (PageHyperlinkArea h : hyperlinks) {
            // Print the hyperlink text
            System.out.println(h.getText());
            // Print the hyperlink URL
            System.out.println(h.getUrl());
            System.out.println();
        }
    }
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)
* [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)

### Free online image extractor App

Along with full featured .NET library we provide simple, but powerfull free APPs.

You are welcome to extract images from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [GroupDocs Parser App](https://products.groupdocs.app/parser).