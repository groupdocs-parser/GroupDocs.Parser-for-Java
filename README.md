## GroupDocs.Parser for Java



[Product Page](https://products.groupdocs.com/parser/java) | [Docs](https://docs.groupdocs.com/parser/java/) | [Demos](https://products.groupdocs.com/parser/java/demos) | [API Reference](https://reference.groupdocs.com/parser/java/) | [Examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java) | [Blog](https://blog.groupdocs.com/categories/groupdocs.parser-product-family/) | [Releases](https://releases.groupdocs.com/parser/java/) | [Free Support](https://forum.groupdocs.com/c/parser/17) | [Temporary License](https://purchase.groupdocs.com/temp-license)



GroupDocs.Parser for .NET is a powerful parsing class library that enables developers to extract text, images, metadata, structured and formatted content, barcodes, and attachments-including ZIP archives, emails, and PDF portfolios-from over 65 document formats, including PDF, Microsoft Office (DOC, DOCX, XLS, XLSX, PPT, PPTX), OpenDocument, email (EML, MSG, PST), e-books (EPUB, FB2), images, and more.

### Features

- Extract plain text from documents in both accurate and raw modes  
- Extract HTML or Markdown formatted text for fast preview  
- Extract structured text and text areas with coordinates and styling  
- Search text by keyword or regular expression and retrieve surrounding context  
- Extract metadata, images, hyperlinks, and tables from supported formats  
- Parse data from attachments and ZIP archives, including PDF portfolios and emails  
- Extract barcodes from documents and document pages  
- Extract data from PDF forms and detect document encoding

See the [Features overview](https://docs.groupdocs.com/parser/java/features-overview/) documentation topic for more details.

### Supported formats

## Supported Formats (high level)

This API supports a broad set of document and media formats, including:

- **PDF**: PDF
- **Images**: JPG, PNG, TIFF, BMP, GIF, PSD
- **Email**: EML, MSG, EMLX, OST, PST
- **eBook**: EPUB, MOBI, AZW3, CHM, FB2
- **Archives**: ZIP, RAR, 7Z, TAR, BZ2, GZ

Supports **65+ formats**. See the [supported file formats](https://docs.groupdocs.com/parser/java/supported-document-formats/) table for the complete list.

### Getting Started


Add the dependency via Maven or Gradle. See the [Java release hub](https://releases.groupdocs.com/parser/java/) for current coordinates and repository URL.

```xml
<dependency>
  <groupId>com.groupdocs</groupId>
  <artifactId>groupdocs-metadata</artifactId>
  <version>LATEST</version>
</dependency>
```

See [documentation](https://docs.groupdocs.com/parser/java/) and the examples in this repository for runnable samples.

### Example 1

```csharp
## Extract Formatted Text from DOCX
```

### Example 2

```csharp
## Extract Document Metadata via Java
```



Explore the sample projects in this repository or open [documentation](https://docs.groupdocs.com/parser/java/) for more topics.

### Support

Our technical support is available to all users, including those evaluating our product. We offer assistance through our [Free Support Forum](https://forum.groupdocs.com/c/parser/17) and [Paid Support Helpdesk](https://helpdesk.groupdocs.com/). Let us know if you have any questions or issues, and we'll do our best to help you.

[Product Page](https://products.groupdocs.com/parser/java) | [Docs](https://docs.groupdocs.com/parser/java/) | [Demos](https://products.groupdocs.com/parser/java/demos) | [API Reference](https://reference.groupdocs.com/parser/java/) | [Examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java) | [Blog](https://blog.groupdocs.com/categories/groupdocs.parser-product-family/) | [Releases](https://releases.groupdocs.com/parser/java/) | [Free Support](https://forum.groupdocs.com/c/parser/17) | [Temporary License](https://purchase.groupdocs.com/temp-license)

### Parse Documents to Extract Text, Images & Metadata

- Extract plain text from any of the supported documents.
- Extract HTML or Markdown formatted text for a fast preview.
- Extract structured text.
- Extract text areas with coordinates, text style and other information.
- Search text by a keyword or regular expression. Also get text around the found word.
- Extract metadata from supported document formats.
- Get information about document images and save them.
- Extract data containers like ZIP, 7Z, RAR, TAR, GZ and BZ2 archives, PDF portfolios, emails, OST and so on.
- Extract tables from a document, either automatically or by a predefined layout.
- Extract cells of spreadsheet worksheets along with their row and column indexes.
- Extract document annotations with an author, a timestamp and a text.
- Generate page previews as images.
- [Extract table of contents (ToC)](https://docs.groupdocs.com/parser/java/extract-table-of-contents/).
- [Parse form data from PDF documents](https://docs.groupdocs.com/parser/java/extract-data-from-pdf-forms/).

### Extract Text from PDF Document

```java
// create an instance of Parser class
try (Parser parser = new Parser("output.samplepdf")) {
    // extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // print a text from the document
        // if text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
    }
}
```

### Extract Document Metadata via Java

```java
// create an instance of Parser class
try (Parser parser = new Parser("output.sampledocx")) {
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

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/parser/java) | [Documentation](https://docs.groupdocs.com/parser/java/) | [Demos](https://products.groupdocs.app/parser/family) | [API Reference](https://reference.groupdocs.com/parser/java/) | [Examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/parser/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/parser) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

### Example 1

```csharp
## Extract Formatted Text from DOCX
```

### Example 2

```csharp
## Extract Document Metadata via Java
```



Explore the sample projects in this repository or open [documentation](https://docs.groupdocs.com/parser/java/) for more topics.

### Parse Documents to Extract Text, Images & Metadata

- Extract plain text from any of the supported documents.
- Extract HTML or Markdown formatted text for a fast preview.
- Extract structured text.
- Extract text areas with coordinates, text style and other information.
- Search text by a keyword or regular expression. Also get text around the found word.
- Extract metadata from supported document formats.
- Get information about document images and save them.
- Extract data containers like ZIP, 7Z, RAR, TAR, GZ and BZ2 archives, PDF portfolios, emails, OST and so on.
- Extract tables from a document, either automatically or by a predefined layout.
- Extract cells of spreadsheet worksheets along with their row and column indexes.
- Extract document annotations with an author, a timestamp and a text.
- Generate page previews as images.
- [Extract table of contents (ToC)](https://docs.groupdocs.com/parser/java/extract-table-of-contents/).
- [Parse form data from PDF documents](https://docs.groupdocs.com/parser/java/extract-data-from-pdf-forms/).

### Extract Text from PDF Document

```java
// create an instance of Parser class
try (Parser parser = new Parser("output.samplepdf")) {
    // extract a text into the reader
    try (TextReader reader = parser.getText()) {
        // print a text from the document
        // if text extraction isn't supported, a reader is null
        System.out.println(reader == null ? "Text extraction isn't supported" : reader.readToEnd());
    }
}
```

### Extract Document Metadata via Java

```java
// create an instance of Parser class
try (Parser parser = new Parser("output.sampledocx")) {
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

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/parser/java) | [Documentation](https://docs.groupdocs.com/parser/java/) | [Demos](https://products.groupdocs.app/parser/family) | [API Reference](https://reference.groupdocs.com/parser/java/) | [Examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/parser/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/parser) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
