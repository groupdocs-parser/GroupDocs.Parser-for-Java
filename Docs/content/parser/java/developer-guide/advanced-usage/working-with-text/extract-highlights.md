---
id: extract-highlights
url: parser/java/extract-highlights
title: Extract highlights
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract a highlight (a part of the text which is usually used to explain the context of the found text in the search functionality) from documents by the [getHighlight(int, boolean, HighlightOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getHighlight(int,%20boolean,%20com.groupdocs.parser.options.HighlightOptions)) method:

```java
HighlightItem getHighlight(int position, boolean isDirect, HighlightOptions options);
```

The *position* parameter defines the start position from which the highlight is extracted. The *isDirect* parameter indicates whether highlight extraction is direct: *true* if the highlight is extracted by the right of the position; otherwise, *false*. [HighlightOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/HighlightOptions) parameter is used to define the end of the highlight.

[HighlightOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/HighlightOptions) class has the following constructors:

```java
// Highlight is limited to maxLength text length.
HighlightOptions(int maxLength);
// Highlight is limited to the start (or the end) of a text line (or maxLength text length - if set).
HighlightOptions(Integer maxLength, boolean isLineLimited);
// Highlight is limited to word count (or maxLength text length - if set).
HighlightOptions(Integer maxLength, int wordCount);
// General constructor
HighlightOptions(Integer maxLength, Integer wordCount, boolean isLineLimited);
```

[HighlightItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/HighlightItem) class has the following members:

| Member | Description |
| --- | --- |
| [getPosition](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/HighlightItem#getPosition()) | The position in the document text. |
| [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/HighlightItem#getText()) | The highlight text. |

Here are the steps to extract highlight from the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [HighlightOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/HighlightOptions) object with the extraction parameters;
*   Call [getHighlight(int, boolean, HighlightOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getHighlight(int,%20boolean,%20com.groupdocs.parser.options.HighlightOptions)) method and obtain the [HighlightItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/HighlightItem) object;
*   Check if [HighlightItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/HighlightItem) isn't *null* (highlight extraction is supported for the document);
*   Call properties such as  [getPosition](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/HighlightItem#getPosition()) and [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/HighlightItem#getText()).

The following example shows how to extract a highlight that contains 3 words:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // Extract a highlight:
    HighlightItem hl = parser.getHighlight(2, true, new HighlightOptions(3));
    // Check if highlight extraction is supported
    if (hl == null) {
        System.out.println("Highlight extraction isn't supported");
        return;
    }
    // Print an extracted highlight
    System.out.println(String.format("At %d: %s", hl.getPosition(), hl.getText()));
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