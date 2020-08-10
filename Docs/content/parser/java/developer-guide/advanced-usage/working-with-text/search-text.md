---
id: search-text
url: parser/java/search-text
title: Search text
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to search a text from documents by the [search(String)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#search(java.lang.String)) and [search(String, SearchOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#search(java.lang.String,%20com.groupdocs.parser.options.SearchOptions)) methods:

```java
Iterable<SearchResult> search(String keyword);
Iterable<SearchResult> search(String keyword, SearchOptions options);
```

The *keyword* parameter can contain a text or a regular expression. [SearchResult](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult) class contains every occurrence of the keyword in the document text. This class has the following members:

| Member | Description |
| --- | --- |
| [getPosition](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult#getPosition()) | A zero-based index of the start position of the search result. Depending on [isSearchByPages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions#isSearchByPages()) property value this index starts from the document start or the document page start. |
| [getPageIndex](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult#getPageIndex()) | The page index where the text is found. |
| [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult#getText()) | The found text. |
| [getLeftHighlightItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult#getLeftHighlightItem()) | The left highlight. |
| [getRightHighlightItem](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult#getRightHighlightItem()) | The right highlight. |

## Search text by keyword

Here are the steps to search a keyword in the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [search(String)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#search(java.lang.String)) method and obtain collection of [SearchResult](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult) objects;
*   Check if *collection* isn't null (search is supported for the document);
*   Iterate through the collection and get position and text.

The following example shows how to find a keyword in a document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // Search a keyword:
    Iterable<SearchResult> sr = parser.search("lorem");
    // Check if search is supported
    if (sr == null) {
        System.out.println("Search isn't supported");
        return;
    }
    // Iterate over search results
    for (SearchResult s : sr) {
        // Print an index and found text:
        System.out.println(String.format("At %d: %s", s.getPosition(), s.getText()));
    }
}
```

## Search text by regular expression

*SearchOptions* parameter is used to customize a search. This class has the following members:

| Member | Description |
| --- | --- |
| [isMatchCase](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions#isMatchCase()) | The value that indicates whether a text case isn't ignored. |
| [isMatchWholeWord](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions#isMatchWholeWord()) | The value that indicates whether text search is limited by the whole word. |
| [isUseRegularExpression](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions#isUseRegularExpression()) | The value that indicates whether a regular expression is used. |
| [isSearchByPages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions#isSearchByPages()) | The value that indicates whether the search is performed by pages. |
| [getLeftHighlightOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions#getLeftHighlightOptions()) | The options for the left highlight. |
| [getRightHighlightOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions#getRightHighlightOptions()) | The options for the right highlight. |

Here are the steps to search with a regular expression in the document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [SearchOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions) object with the parameters for the search;
*   Call [search(String, SearchOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#search(java.lang.String,%20com.groupdocs.parser.options.SearchOptions)) method and obtain collection of [SearchResult](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult) objects;
*   Check if *collection* isn't *null* (search is supported for the document);
*   Iterate through the collection and get position and text.

The following example shows how to search with a regular expression in a document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // Search with a regular expression with case matching
    Iterable<SearchResult> sr = parser.search("[0-9]+", new SearchOptions(true, false, true));
    // Check if search is supported
    if (sr == null) {
        System.out.println("Search isn't supported");
        return;
    }
    // Iterate over search results
    for (SearchResult s : sr) {
        // Print an index and found text:
        System.out.println(String.format("At %d: %s", s.getPosition(), s.getText()));
    }
}
```

## Search text with highlights

Here are the steps to search a text with a highlights:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [HighlightOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/HighlightOptions) object with the parameters for the highlight extraction;
*   Instantiate [SearchOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions) object with the parameters for the search;
*   Call [search(String, SearchOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#search(java.lang.String,%20com.groupdocs.parser.options.SearchOptions)) method and obtain collection of [SearchResult](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult) objects;
*   Check if *collection* isn't *null* (search is supported for the document);
*   Iterate through the collection and get position and text.

The following example shows how to search a text with the highlights:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    HighlightOptions highlightOptions = new HighlightOptions(15);
    // Search a keyword:
    Iterable<SearchResult> sr = parser.search("lorem", new SearchOptions(true, false, false, highlightOptions));
    // Check if search is supported
    if (sr == null) {
        System.out.println("Search isn't supported");
        return;
    }
    // Iterate over search results
    for (SearchResult s : sr) {
        // Print the found text and highlights:
        System.out.println(String.format("%s%s%s", s.getLeftHighlightItem().getText(), s.getText(), s.getRightHighlightItem().getText()));
    }
}
```

## Search text with page numbers

Here are the steps to search a text with page numbers:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [SearchOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/SearchOptions) object with the parameters for the search;
*   Call [search(String, SearchOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#search(java.lang.String,%20com.groupdocs.parser.options.SearchOptions)) method and obtain collection of [SearchResult](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/SearchResult) objects;
*   Check if *collection* isn't *null* (search is supported for the document);
*   Iterate through the collection and get position, text and page number.

The following example shows how to search a text with page numbers:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // Search a keyword with page numbers
    Iterable<SearchResult> sr = parser.search("lorem", new SearchOptions(false, false, false, true));
    // Check if search is supported
    if (sr == null) {
        System.out.println("Search isn't supported");
        return;
    }
    // Iterate over search results
    for (SearchResult s : sr) {
        // Print an index, page number and found text:
        System.out.println(String.format("At %d (%d): %s", s.getPosition(), s.getPageIndex(), s.getText()));
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