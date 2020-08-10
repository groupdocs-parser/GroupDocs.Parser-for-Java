---
id: extract-text-areas
url: parser/java/extract-text-areas
title: Extract text areas
weight: 7
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract text areas from documents by the following methods:

```java
Iterable<PageTextArea> getTextAreas();
Iterable<PageTextArea> getTextAreas(PageTextAreaOptions options);
Iterable<PageTextArea> getTextAreas(int pageIndex);
Iterable<PageTextArea> getTextAreas(int pageIndex, PageTextAreaOptions options);
```

The methods return a collection of [PageTextArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea) objects:

| Member | Description |
| --- | --- |
| [getPage](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getPage()) | The page that contains the text area. |
| [getRectangle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area on the page that contains the text area. |
| [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getText()) | The value of the text area. |
| [getBaseLine](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getBaseLine()) | The base line of the text area. |
| [getTextStyle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getTextStyle()) | The text style of the text area. |
| [getAreas](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getAreas()) | The collection of child text areas. |

Text area represents a rectangular page area with a text. Text area can be simple or composite. The simple text area contains only a text and [getAreas](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getAreas()) property is always an empty collection (not null). The composite text area doesn't have its own text. Text property is calculated by its children texts which are contained in [getAreas](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea#getAreas()) property.

## Extract text areas

Here are the steps to extract text areas from the whole document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getTextAreas](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getTextAreas()) method and obtain collection of [PageTextArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea) objects;
*   Check if *collection* isn't null (text areas extraction is supported for the document);
*   Iterate through the collection and get rectangles and text.

The following example shows how to extract all text areas from the whole document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
    // Extract text areas
    Iterable<PageTextArea> areas = parser.getTextAreas();
    // Check if text areas extraction is supported
    if (areas == null) {
        System.out.println("Page text areas extraction isn't supported");
        return;
    }
    // Iterate over page text areas
    for (PageTextArea a : areas) {
        // Print a page index, rectangle and text area value:
        System.out.println(String.format("Page: %d, R: %s, Text: %s", a.getPage().getIndex(), a.getRectangle(), a.getText()));
    }
}
```

## Extract text areas from a document page

Here are the steps to extract text areas from the document page:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [isTextAreas](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/Features#isTextAreas())  property to check if text areas extraction is supported for the document;
*   Call [getTextAreas(int)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getTextAreas(int)) method with the page index and obtain collection of [PageTextArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea) objects;
*   Check if *collection* isn't *null* (text areas extraction is supported for the document);
*   Iterate through the collection and get rectangles and text.

The following example shows how to extract text areas from a document page:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
    // Check if the document supports text areas extraction
    if (!parser.getFeatures().isTextAreas()) {
        System.out.println("Document isn't supports text areas extraction.");
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
        // Iterate over page text areas
        // We ignore null-checking as we have checked text areas extraction feature support earlier
        for (PageTextArea a : parser.getTextAreas(pageIndex)) {
            // Print a rectangle and text area value:
            System.out.println(String.format("R: %s, Text: %s", a.getRectangle(), a.getText()));
        }
    }
}
```

## Extract text areas with options

[PageTextAreaOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageTextAreaOptions) parameter is used to customize text areas extraction process. This class has the following members:

| Member | Description |
| --- | --- |
| [getRectangle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageAreaOptions#getRectangle()) | The rectangular area that contains a text area. |
| [getExpression](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageTextAreaOptions#getExpression()) | The regular expression. |
| [isMatchCase](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageTextAreaOptions#isMatchCase()) | The value that indicates whether a text case isn't ignored. |
| [isUniteSegments](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageTextAreaOptions#isUniteSegments()) | The value that indicates whether segments are united. |
| [isIgnoreFormatting](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageTextAreaOptions#isIgnoreFormatting()) | The value that indicates whether text formatting is ignored. |

Here are the steps to extract text areas from the upper-left corner:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [PageTextAreaOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageTextAreaOptions) with the rectangular area;
*   Call [getTextAreas(int, PageTextAreaOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getTextAreas(int,%20com.groupdocs.parser.options.PageTextAreaOptions)) method and obtain collection of [PageTextArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageTextArea) objects;
*   Check if *collection* isn't *null* (text areas extraction is supported for the document);
*   Iterate through the collection and get rectangles and text.

The following example shows how to extract only text areas with digits from the upper-left corner:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
    // Create the options which are used for text area extraction
    PageTextAreaOptions options = new PageTextAreaOptions("\\s[a-z]{2}\\s", new Rectangle(new Point(0, 0), new Size(300, 100)));
    // Extract text areas which contain only digits from the upper-left corner of a page:
    Iterable<PageTextArea> areas = parser.getTextAreas(options);
    // Check if text areas extraction is supported
    if (areas == null) {
        System.out.println("Page text areas extraction isn't supported");
        return;
    }
    // Iterate over page text areas
    for (PageTextArea a : areas) {
        // Print a page index, rectangle and text area value:
        System.out.println(String.format("Page: %d, R: %s, Text: %s", a.getPage().getIndex(), a.getRectangle(), a.getText()));
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