# Java Parser API to Extract Data

GroupDocs.Parser for Java is a [Document Parser & Data Extraction Library](https://products.groupdocs.com/parser/java) that supports more than [50 popular document types](https://docs.groupdocs.com/parser/java/supported-document-formats/). It can help build Java-based business applications with features of parsing raw, structured & formatted text as well as image & metadata extraction.

<p align="center">
  <a title="Download complete GroupDocs.Parser for Java source code" href="https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java/archive/master.zip"> 
    <img src="https://camo.githubusercontent.com/11839cd752a2d367f3149c7bee1742b68e4a4d37/68747470733a2f2f7261772e6769746875622e636f6d2f4173706f73654578616d706c65732f6a6176612d6578616d706c65732d64617368626f6172642f6d61737465722f696d616765732f646f776e6c6f61645a69702d427574746f6e2d4c617267652e706e67" data-canonical-src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" style="max-width:100%;">
  </a>
</p>

Directory | Description
--------- | -----------
[Docs](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java/tree/master/Docs)  | Product documentation containing the Developer's Guide, Release Notes and more.
[Examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 

## Parse Documents to Extract Text, Images & Metadata

- Extract plain text from any of the supported documents.
- Extract HTML or Markdown formatted text for a fast preview.
- Extract structured text.
- Extract text areas with coordinates, text style and other information.
- Search text by a keyword or regular expression. Also get text around the found word.
- Extract metadata from supported document formats.
- Get information about document images and save them.
- Extract data containers like ZIP archives, PDF portfolios, emails, OST and so on.
- [Extract table of contents (ToC)](https://docs.groupdocs.com/parser/java/extract-table-of-contents/).
- [Parse form data from PDF documents](https://docs.groupdocs.com/parser/java/extract-data-from-pdf-forms/).


## Get Started with GroupDocs.Parser for Java

GroupDocs.Parser for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-parser), so simply [configure](https://docs.groupdocs.com/parser/java/installation/) your Maven project to fetch the dependencies automatically.

## Extract Text from PDF Document

```java
// create an instance of Parser class
try (Parser parser = new Parser(Constants.SamplePdf)) {
    // extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // print a text from the document
        // if text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
    }
}
```

## Extract Formatted Text from DOCX

```java
// create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // extract a formatted text into the reader
    try (TextReader reader = parser.getFormattedText(new FormattedTextOptions(FormattedTextMode.Html))) {
        // print a formatted text from the document
        // if formatted text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Formatted text extraction isn't suppported" : reader.readToEnd());
    }
}

```

## Extract Document Metadata via Java

```java
// create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleDocx)) {
    // extract metadata from the document
    Iterable<MetadataItem> metadata = parser.getMetadata();
    // check if metadata extraction is supported
    if (metadata == null) {
        System.out.println("Metatada extraction isn't supported");
    }
    // iterate over metadata items
    for (MetadataItem item : metadata) {
        // print an item name and value
        System.out.println(String.format("%s: %s", item.getName(), item.getValue()));
    }
}

```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/parser/java) | [Documentation](https://docs.groupdocs.com/parser/java/) | [Demos](https://products.groupdocs.app/parser/family) | [API Reference](https://apireference.groupdocs.com/java/parser) | [Examples](https://github.com/groupdocs-parser/GroupDocs.parser-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/parser/) | [Free Support](https://forum.groupdocs.com/c/parser) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
