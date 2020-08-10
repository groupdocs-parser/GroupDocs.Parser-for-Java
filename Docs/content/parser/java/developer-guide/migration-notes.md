---
id: migration-notes
url: parser/java/migration-notes
title: Migration Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
### Why To Migrate?

Here are the key reasons to use the new updated API provided by GroupDocs.Parser for Java since version 19.11:

*   [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) class is introduced as a **single entry point** to extract data from the document.       
*   Data extraction was unified for all data types.      
*   The overall document related classes were unified to common.      
*   Product architecture was redesigned from scratch in order to simplify passing options and classes to manipulate data.    
*   Document information and preview generation procedures were simplified.       
    

### How To Migrate?

Here is brief comparison of how to extract data using the old and new API.


  

#### Text

**Old coding style**

```java
// Create an extractor factory
ExtractorFactory factory = new ExtractorFactory();
// Create a text extractor
try (TextExtractor extractor = factory.createTextExtractor(filePath)) {
    // Extract a text from the text extractor
    String textLine = null;
    do {
        textLine = extractor.extractLine();
        if (textLine != null) {
            System.out.println(textLine);
        }
    }
    while (textLine != null);
}
```

**New coding style**

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract a text to the reader
    try (TextReader reader = parser.getText()) {
        // Check if text extraction is supported
        if (reader == null) {
            System.out.println("Text extraction isn't supported.");
            return;
        }
        // Extract a text from the reader
        String textLine = null;
        do {
            textLine = reader.readLine();
            if (textLine != null) {
                System.out.println(textLine);
            }
        }
        while (textLine != null);
    }
}
```

  

#### Text Page

**Old coding style**

```java
// Create an extractor factory
ExtractorFactory factory = new ExtractorFactory();
// Create a text extractor
try (TextExtractor extractor = factory.createTextExtractor(filePath)) {
    // Check if the extractor supports pagination
    IPageTextExtractor pte = extractor instanceof IPageTextExtractor
            ? (IPageTextExtractor) extractor
            : null;
    if (pte != null) {
        // Extract the first page
        System.out.println(pte.extractPage(0));
    }
}
```

**New coding style**

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract the first page text to the reader
    try (TextReader reader = parser.getText(0)) {
        // Check if text extraction is supported
        if (reader != null) {
            // Extract a text from the reader
            System.out.println(reader.readToEnd());
        }
    }
}
```

  

#### Search

**Old coding style**

```java
// Create an extractor factory
ExtractorFactory factory = new ExtractorFactory();
// Create a text extractor
try (TextExtractor extractor = factory.createTextExtractor(filePath)) {
    // Check if the extractor supports search
    ISearchable se = extractor instanceof ISearchable
            ? (ISearchable) extractor
            : null;
    if (se != null) {
        // Create a handler
        ListSearchHandler handler = new ListSearchHandler();
        // Search "keyword" in the document
        se.search(new SearchOptions(null), handler, java.util.Arrays.asList(new String[]{"keyword"}));
        // Print search results
        for (SearchResult result : handler.getList()) {
            System.out.println(String.format("at %d: %s", result.getIndex(), result.getFoundText()));
        }
    }
}
```

**New coding style**

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Search "keyword" in the document
    Iterable<SearchResult> list = parser.search("keyword");
    // Check if search is supported
    if (list == null) {
        System.out.println("Search isn't supported.");
        return;
    }
    // Print search results
    for (SearchResult result : list) {
        System.out.println(String.format("at %d: %s", result.getPosition(), result.getText()));
    }
}
```

#### File Type Detection

**Old coding style**

```java
// Detect and print file type
System.out.println(CompositeMediaTypeDetector.DEFAULT.detect(filePath));
```

**New coding style**

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Detect and print file type
    System.out.println(parser.getDocumentInfo().getFileType());
}
```

  

#### Metadata

**Old coding style**

```java
// Create an extractor factory
ExtractorFactory factory = new ExtractorFactory();
// Create a metadata extractor
MetadataExtractor extractor = factory.createMetadataExtractor(filePath);
// Extract metadata
MetadataCollection metadata = extractor.extractMetadata(filePath);
// Print metadata
for (String key : metadata.getKeys()) {
    String value = metadata.get_Item(key);
    System.out.println(String.format("%s = %s", key, value));
}
```

**New coding style**

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract metadata
    Iterable<MetadataItem> metadata = parser.getMetadata();
    // Check if metadata extraction is supported
    if (metadata == null) {
        System.out.println("Metadata extraction isn't supported.");
        return;
    }
    // Print metadata
    for (MetadataItem item : metadata) {
        System.out.println(String.format("%s = %s", item.getName(), item.getValue()));
    }
}
```

#### Structure

**Old coding style**

```java
// Create an extractor factory
ExtractorFactory factory = new ExtractorFactory();
// Create a text extractor
try (TextExtractor extractor = factory.createTextExtractor(filePath)) {
    // Check if the extractor supports text structure extraction
    IStructuredExtractor se = extractor instanceof IStructuredExtractor
            ? (IStructuredExtractor) extractor
            : null;
    if (se != null) {
        // Create a handler
        Handler handler = new Handler();
        // Extract text structure
        se.extractStructured(handler);
        // Print hyperlinks
        for (String link : handler.getLinks()) {
            System.out.println(link);
        }
    }
}

// Handler for the hyperlink extraction
class Handler extends StructuredHandler {
    private final java.util.List<String> links;
    public Handler() {
        links = new java.util.ArrayList<String>();
    }
    public java.util.List<String> getLinks() {
        return links;
    }
    // Override the method to catch hyperlinks
    @Override
    protected void onStartHyperlink(HyperlinkProperties properties) {
        links.add(properties.getLink());
    }
}
```

**New coding style**

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract text structure to the XML reader
    Document document = parser.getStructure();
    // Check if text structure extraction is supported
    if (document == null) {
        System.out.println("Text structure extraction isn't supported.");
        return;
    }
    // Read XML document
    readNode(document.getDocumentElement());
}

void readNode(Node node) {
    NodeList nodes = node.getChildNodes();
    for (int i = 0; i < nodes.getLength(); i++) {
        Node n = nodes.item(i);
        if (n.getNodeName().toLowerCase() == "hyperlink") {
            Node a = n.getAttributes().getNamedItem("link");
            if (a != null) {
                System.out.println(a.getNodeValue());
            }
        }
        if (n.hasChildNodes()) {
            readNode(n);
        }
    }
}
```
