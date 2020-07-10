---
id: groupdocs-parser-for-java-18-10-release-notes
url: parser/java/groupdocs-parser-for-java-18-10-release-notes
title: GroupDocs.Parser for Java 18.10 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 18.10.{{< /alert >}}

## Major Features

There are the following features in this release:

*   Implemented API to extract images from documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| PARSERNET-65 | Implement API to extract images from documents | New feature |
| PARSERNET-69 | Implement the ability to extract images from PDF | New feature |
| PARSERNET-71 | Implement the ability to extract images from spreadsheets | New feature |
| PARSERNET-72 | Implement the ability to extract images from text documents | New feature |
| PARSERNET-74 | Implement the ability to extract images from presentations | New feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Parser for Java 18.10. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Parser which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### API to extract images from documents

#### Description

This feature allows extracting images from documents.

#### Public API changes

*   Added **Emf** constant to **MediaTypeNames.Application** class
*   Added **Images** nested class to **MediaTypeNames** class
*   Added **Windows** nested class to **MediaTypeNames** class
*   Added **ImageArea** class
*   Added **ImageAreaSearchOptions** class
*   Added **getImageAreas** methods to **DocumentContent** class
*   Added **ImageAreas**property to **DocumentPage** class

To extract images from the page **getImageAreas** methods are used:



```java
class DocumentContent {
  public IList<ImageArea> getImageAreas(int pageIndex);
  public IList<ImageArea> getImageAreas(int pageIndex, ImageAreaSearchOptions searchOptions);
}
```

The method with one parameter returns all images from the page with zero-based pageIndex. The method with **ImageAreaSearchOptions** optional parameter returns only the images which meet the conditions of **searchOptions**. Both versions of the method return a collection of **ImageArea** objects:

| Member | Description |
| --- | --- |
| Page | Link to the page which contains this image |
| Rectangle | Rectangle of the image area |
| Rotation | Angle of the image rotation (0 if image isn't rotated) |
| MediaType | MIME type of the image |
| GetBitmapStream | Returns a stream with bitmap representation of the image |
| GetRawStream | Returns a stream with the image |

**ImageAreaSearchOptions** class has only one property - Rectangle. If it's set, the method returns only the images which are intersected with the given Rectangle.

#### Usage



```java
private static void extractImages() throws java.io.IOException {
    // Create a text extractor
    WordsTextExtractor extractor = new WordsTextExtractor("cv.docx");
 
    // Create search options
    ImageAreaSearchOptions searchOptions = new ImageAreaSearchOptions();
    // Limit the search with the rectangle: position (0; 0), size (300; 300)
    searchOptions.setRectangle(new Rectangle(0, 0, 300, 300));
 
    // Get images from the first page
    java.util.List<ImageArea> imageAreas = extractor.getDocumentContent().getImageAreas(0, searchOptions);
 
    // Iterate over the images
    for (int i = 0; i < imageAreas.size(); i++) {
        try (java.io.OutputStream fs = new java.io.FileOutputStream(String.format("%d.jpg", i))) {
            // Save the image to the file
            copyStream(imageAreas.get(i).getRawStream(), fs);
        }
    }
}
 
private static void copyStream(java.io.InputStream source, java.io.OutputStream dest) throws java.io.IOException {
    byte[] buffer = new byte[4096];
 
    int r = 0;
    do {
        r = source.read(buffer);
        if (r > 0) {
            dest.write(buffer);
        }
    }
    while (r > 0);
}
```

### Extracting images from PDF documents

#### Description

This feature allows extracting images from PDF documents.

#### Public API changes

No public API changes

#### Usage

To extract images from the page **getImageAreas** methods are used:



```java
private static void extractImages() throws java.io.IOException {
    // Create a text extractor
    PdfTextExtractor extractor = new PdfTextExtractor("cv.pdf");
 
    // Create search options
    ImageAreaSearchOptions searchOptions = new ImageAreaSearchOptions();
    // Limit the search with the rectangle: position (0; 0), size (300; 300)
    searchOptions.setRectangle(new Rectangle(0, 0, 300, 300));
 
    // Get images from the first page
    java.util.List<ImageArea> imageAreas = extractor.getDocumentContent().getImageAreas(0, searchOptions);
 
    // Iterate over the images
    for (int i = 0; i < imageAreas.size(); i++) {
        try (java.io.OutputStream fs = new java.io.FileOutputStream(String.format("%d.jpg", i))) {
            // Save the image to the file
            copyStream(imageAreas.get(i).getRawStream(), fs);
        }
    }
}
 
private static void copyStream(java.io.InputStream source, java.io.OutputStream dest) throws java.io.IOException {
    byte[] buffer = new byte[4096];
 
    int r = 0;
    do {
        r = source.read(buffer);
        if (r > 0) {
            dest.write(buffer);
        }
    }
    while (r > 0);
}
```

### Extracting images from spreadsheets

#### Description

This feature allows extracting images from spreadsheets.

#### Public API changes

No public API changes

#### Usage

To extract images from the sheet **getImageAreas** methods are used:



```java
private static void extractImages() throws java.io.IOException {
    // Create a text extractor
    CellsTextExtractor extractor = new CellsTextExtractor("catalog.xlsx");
 
    // Create search options
    ImageAreaSearchOptions searchOptions = new ImageAreaSearchOptions();
    // Limit the search with the rectangle: position (0; 0), size (300; 300)
    searchOptions.setRectangle(new Rectangle(0, 0, 300, 300));
 
    // Get images from the first sheet
    java.util.List<ImageArea> imageAreas = extractor.getDocumentContent().getImageAreas(0, searchOptions);
 
    // Iterate over the images
    for (int i = 0; i < imageAreas.size(); i++) {
        try (java.io.OutputStream fs = new java.io.FileOutputStream(String.format("%d.jpg", i))) {
            // Save the image to the file
            copyStream(imageAreas.get(i).getRawStream(), fs);
        }
    }
}
 
private static void copyStream(java.io.InputStream source, java.io.OutputStream dest) throws java.io.IOException {
    byte[] buffer = new byte[4096];
 
    int r = 0;
    do {
        r = source.read(buffer);
        if (r > 0) {
            dest.write(buffer);
        }
    }
    while (r > 0);
}
```

### Extracting images from text documents

#### Description

This feature allows extracting images from text documents.

#### Public API changes

No public API changes

#### Usage

To extract images from the page **getImageAreas** methods are used:



```java
private static void extractImages() throws java.io.IOException {
    // Create a text extractor
    WordsTextExtractor extractor = new WordsTextExtractor("cv.docx");
 
    // Create search options
    ImageAreaSearchOptions searchOptions = new ImageAreaSearchOptions();
    // Limit the search with the rectangle: position (0; 0), size (300; 300)
    searchOptions.setRectangle(new Rectangle(0, 0, 300, 300));
 
    // Get images from the first page
    java.util.List<ImageArea> imageAreas = extractor.getDocumentContent().getImageAreas(0, searchOptions);
 
    // Iterate over the images
    for (int i = 0; i < imageAreas.size(); i++) {
        try (java.io.OutputStream fs = new java.io.FileOutputStream(String.format("%d.jpg", i))) {
            // Save the image to the file
            copyStream(imageAreas.get(i).getRawStream(), fs);
        }
    }
}
 
private static void copyStream(java.io.InputStream source, java.io.OutputStream dest) throws java.io.IOException {
    byte[] buffer = new byte[4096];
 
    int r = 0;
    do {
        r = source.read(buffer);
        if (r > 0) {
            dest.write(buffer);
        }
    }
    while (r > 0);
}
```

### Extracting images from presentations

#### Description

This feature allows extracting images from presentations.

#### Public API changes

No public API changes

#### Usage

To extract images from the slide **getImageAreas** methods are used:



```java
private static void extractImages() throws java.io.IOException {
    // Create a text extractor
    SlidesTextExtractor extractor = new SlidesTextExtractor("presentation.pptx");
 
    // Create search options
    ImageAreaSearchOptions searchOptions = new ImageAreaSearchOptions();
    // Limit the search with the rectangle: position (0; 0), size (300; 300)
    searchOptions.setRectangle(new Rectangle(0, 0, 300, 300));
 
    // Get images from the first slide
    java.util.List<ImageArea> imageAreas = extractor.getDocumentContent().getImageAreas(0, searchOptions);
 
    // Iterate over the images
    for (int i = 0; i < imageAreas.size(); i++) {
        try (java.io.OutputStream fs = new java.io.FileOutputStream(String.format("%d.jpg", i))) {
            // Save the image to the file
            copyStream(imageAreas.get(i).getRawStream(), fs);
        }
    }
}
 
private static void copyStream(java.io.InputStream source, java.io.OutputStream dest) throws java.io.IOException {
    byte[] buffer = new byte[4096];
 
    int r = 0;
    do {
        r = source.read(buffer);
        if (r > 0) {
            dest.write(buffer);
        }
    }
    while (r > 0);
}
```
