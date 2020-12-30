---
id: groupdocs-parser-for-java-20-1-release-notes
url: parser/java/groupdocs-parser-for-java-20-1-release-notes
title: GroupDocs.Parser for Java 20.1 Release Notes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 20.1.{{< /alert >}}{{< alert style="danger" >}}In this version legacy API was removed (all types from com.groupdocs.parser.legacy package were removed).{{< /alert >}}

## Major Features

There are the following features in this release:

*   Legacy API was removed (com.groupdocs.parser.legacy package)
*   Implement the ability to extract a text by table of contents item
*   Implement the ability to extract table of contents from PDF and Word Processing documents
*   Implement the ability to extract the image in a different format
*   Implement the ability to save the image to the file

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| PARSERNET-1342 | Implement the ability to extract the image in a different format | New feature |
| PARSERNET-1341 | Implement the ability to save the image to the file | New feature |
| PARSERNET-1361 | Implement the ability to extract TOC from Word Processing documents | New feature |
| PARSERNET-1362 | Implement the ability to extract TOC from PDF documents | New feature |
| PARSERNET-1363 | Implement the ability to extract a text by TOC item | New feature |
| PARSERNET-1099 | Remove obsolete members (com.groupdocs.parser.legacy package) | Improvement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Parser for Java 20.1. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Parser which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **Implement the ability to save the image to the file**
    
    #### Description
    
    This feature allows to extract the image to the file.
    
    #### Public API changes
    
    *   Added **save** methods to **com.groupdocs.parser.data.PageImageArea** class
    
    #### Usage
    
    The following example shows how to extract images to files:
    
    ```java
    // Create an instance of Parser class
    try (Parser parser = new Parser(Constants.SampleZip)) {
        // Extract images from document
        Iterable<PageImageArea> images = parser.getImages();
        // Check if images extraction is supported
        if (images == null) {
            System.out.println("Page images extraction isn't supported");
            return;
        }
        // Create the options to save images in PNG format
        ImageOptions options = new ImageOptions(ImageFormat.Png);
        int imageNumber = 0;
        // Iterate over images
        for (PageImageArea image : images)
        {
            // Save the image to the png file
            image.save(Constants.getOutputFilePath(String.format("%d.png", imageNumber)), options);
            imageNumber++;
        }
    }
    ```
    
2.  **Implement the ability to extract the image in a different format**  
    
    #### Description
    
    This feature allows to extract images in different formats.
    
    #### Public API changes
    
    *   Added **getImageStream**(ImageOptions) method to **com.groupdocs.parser.data.PageImageArea** class
    *   Added **ImageOptions** class in** com.groupdocs.parser.options** package
    *   Added **ImageFormat** enum in **com.groupdocs.parser.options** package
    
    #### Usage
    
    **getImageStream**(ImageOptions) method is used to extract the image in a different format.
    
    **ImageOptions** class is used to define the image format into which the image is converted. The following image formats are supported:
    
    *   Bmp
    *   Gif
    *   Jpeg
    *   Png
    *   WebP
    
    Example:
    
    ```java
    // Create an instance of Parser class
    try (Parser parser = new Parser(Constants.SampleZip)) {
        // Extract images from document
        Iterable<PageImageArea> images = parser.getImages();
        // Check if images extraction is supported
        if (images == null) {
            System.out.println("Page images extraction isn't supported");
            return;
        }
        // Create the options to save images in PNG format
        ImageOptions options = new ImageOptions(ImageFormat.Png);
        int imageNumber = 0;
        // Iterate over images
        for (PageImageArea image : images) {
            // Open the image stream
            try (InputStream imageStream = image.getImageStream(options)) {
                // Create the file to save image
                try (OutputStream destStream = new FileOutputStream(imageNumber + ".png")) {
                    byte[] buffer = new byte[4096];
                    int readed = 0;
                    do {
                        // Read data from the image stream
                        readed = imageStream.read(buffer, 0, buffer.length);
                        if (readed > 0) {
                            // Write data to the file stream
                            destStream.write(buffer, 0, readed);
                        }
                    }
                    while (readed > 0);
                }
                imageNumber++;
            }
        }
    }
    ```
    
3.  **Implement the ability to extract TOC from Word Processing documents**  
    
    #### Description
    
    This feature allows to extract table of contents (TOC) from word processing documents.
    
    #### Public API changes
    
    No API changes
    
    #### Usage
    
    The following example shows how to extract table of contents from word processing document:
    
    ```java
    // Create an instance of Parser class
    try (Parser parser = new Parser(filePath)) {
        // Check if text extraction is supported
        if (!parser.getFeatures().isText()) {
            System.out.println("Text extraction isn't supported.");
            return;
        }
        // Check if toc extraction is supported
        if (!parser.getFeatures().isToc()) {
            System.out.println("Toc extraction isn't supported.");
            return;
        }
        // Get table of contents
        Iterable<TocItem> toc = parser.getToc();
        // Iterate over items
        for (TocItem i : toc) {
            // Print the Toc text
            System.out.println(i.getText());
    
            // Check if page index has a value
            if (i.getPageIndex() == null) {
                continue;
            }
    
            // Extract a page text
            try (TextReader reader = parser.getText(i.getPageIndex())) {
                System.out.println(reader.readToEnd());
            }
        }
    }
    ```
    
4.  **Implement the ability to extract TOC from PDF documents**  
    
    #### Description
    
    This feature allows to extract table of contents (TOC) from PDF documents.
    
    #### Public API changes
    
    No API changes
    
    #### Usage
    
    The following example shows how to extract table of contents from PDF document:
    
    ```java
    // Create an instance of Parser class
    try (Parser parser = new Parser(filePath)) {
        // Check if text extraction is supported
        if (!parser.getFeatures().isText()) {
            System.out.println("Text extraction isn't supported.");
            return;
        }
        // Check if toc extraction is supported
        if (!parser.getFeatures().isToc()) {
            System.out.println("Toc extraction isn't supported.");
            return;
        }
        // Get table of contents
        Iterable<TocItem> toc = parser.getToc();
        // Iterate over items
        for (TocItem i : toc) {
            // Print the Toc text
            System.out.println(i.getText());
    
            // Check if page index has a value
            if (i.getPageIndex() == null) {
                continue;
            }
    
            // Extract a page text
            try (TextReader reader = parser.getText(i.getPageIndex())) {
                System.out.println(reader.readToEnd());
            }
        }
    }
    ```
    
5.  **Implement the ability to extract a text by TOC item**  
    
    #### Description
    
    This feature provides the functionality to extract a text by an item of table of contents.
    
    #### Public API changes
    
    *   Added **extractText** method to **com.groupDocs.parser.data.TocItem** class
    
    #### Usage
    
    The following example shows how to extract a text by an item of table of contents:
    
    ```java
    // Create an instance of Parser class
    try (Parser parser = new Parser(Constants.SampleDocxWithToc)) {
        // Get table of contents
        Iterable<TocItem> tocItems = parser.getToc();
    
        // Check if toc extraction is supported
        if (tocItems == null) {
            System.out.println("Table of contents extraction isn't supported");
        }
    
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
