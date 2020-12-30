---
id: groupdocs-parser-for-java-20-8-release-notes
url: parser/java/groupdocs-parser-for-java-20-8-release-notes
title: GroupDocs.Parser for Java 20.8 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 20.8{{< /alert >}}

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| PARSERNET-1176 | Implement the ability to extract images from .chm files | New feature |
| PARSERNET-1177 | Implement the ability to extract images from .epub files | New feature |
| PARSERNET-1178 | Implement the ability to extract images from .fb2 files | New feature |
| PARSERNET-1179 | Implement the ability to extract images from .html files | New feature |
| PARSERNET-1580 | Implement FileType.Format property | New feature |
| PARSERNET-1576 | Implement the ability to set DPI parameter in Preview API | Improvement |
| PARSERNET-1579 | Improve the spreadsheet preview functionality | Improvement |

## Public API and Backward Incompatible Changes

### Implement the ability to extract images from .chm files

#### Description

This feature allows to extract images from Compiled HTML Help files.

#### Public API changes

No API changes.

#### Usage

The following example shows how to extract all images from the whole document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract images
    Iterable<PageImageArea> images = parser.getImages();
    // Check if images extraction is supported
    if (images == null) {
        System.out.println("Images extraction isn't supported");
        return;
    }
    // Iterate over images
    for (PageImageArea image : images) {
        // Print a page index, rectangle and image type:
        System.out.println(String.format("Page: %d, R: %s, Type: %s", image.getPage().getIndex(), image.getRectangle(), image.getFileType()));
    }
}
```

### Implement the ability to extract images from .ebup files

#### Description

This feature allows to extract images from Digital E-Book File Format (ePUB) documents.

#### Public API changes

No API changes.

#### Usage

The following example shows how to extract all images from the whole document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract images
    Iterable<PageImageArea> images = parser.getImages();
    // Check if images extraction is supported
    if (images == null) {
        System.out.println("Images extraction isn't supported");
        return;
    }
    // Iterate over images
    for (PageImageArea image : images) {
        // Print a page index, rectangle and image type:
        System.out.println(String.format("Page: %d, R: %s, Type: %s", image.getPage().getIndex(), image.getRectangle(), image.getFileType()));
    }
}
```

### Implement the ability to extract images from .fb2 files

#### Description

This feature allows to extract images from Fiction Books 2.0 (fb2) documents.

#### Public API changes

No API changes.

#### Usage

The following example shows how to extract all images from the whole document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract images
    Iterable<PageImageArea> images = parser.getImages();
    // Check if images extraction is supported
    if (images == null) {
        System.out.println("Images extraction isn't supported");
        return;
    }
    // Iterate over images
    for (PageImageArea image : images) {
        // Print a page index, rectangle and image type:
        System.out.println(String.format("Page: %d, R: %s, Type: %s", image.getPage().getIndex(), image.getRectangle(), image.getFileType()));
    }
}
```

### Implement the ability to extract images from .html files

#### Description

This feature allows to extract images from HTML documents.

#### Public API changes

No API changes.

#### Usage

The following example shows how to extract all images from the whole document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(filePath)) {
    // Extract images
    Iterable<PageImageArea> images = parser.getImages();
    // Check if images extraction is supported
    if (images == null) {
        System.out.println("Images extraction isn't supported");
        return;
    }
    // Iterate over images
    for (PageImageArea image : images) {
        // Print a page index, rectangle and image type:
        System.out.println(String.format("Page: %d, R: %s, Type: %s", image.getPage().getIndex(), image.getRectangle(), image.getFileType()));
    }
}
```

### Implement FileType.Format property

#### Description

This feature allows to get file format from FileType object.

#### Public API changes

* Added Format property to com.groupdocs.parser.options.FileType class
* Added Image member to com.groupdocs.parser.options.FileFormat enum

#### Usage

The following example shows how to get file format from FileType object:

```java
System.out.println(FileType.CHM.Format);
```

### Implement the ability to set DPI parameter in Preview API

#### Description

This improvement allows to set dpi to generate previews.

#### Public API changes

* Added [Dpi](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PreviewOptions#setDpi(int)) property to [com.groupdocs.parser.options.PreviewOptions](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PreviewOptions) class

#### Usage

The following example shows how to generate document page previews:

```java
// Create an instance of Parser class to generate document page previews
try (Parser parser = new Parser(Constants.SamplePdfWithToc)) {
    // Create preview options
    PreviewOptions previewOptions = new PreviewOptions(
            new ICreatePageStream() {
                @Override
                public OutputStream createPageStream(int pageNumber) {
                    try {
                        return new FileOutputStream(getOutputPath(String.format("preview_%d.png", pageNumber)));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex.getMessage());
                    }
                }
            });
    // Set PNG as an output image format
    previewOptions.setPreviewFormat(PreviewFormats.Png);
    // Set DPI for the output image
    previewOptions.setDpi(72);
    // Generate previews
    parser.generatePreview(previewOptions);
}

private static String getOutputPath(String fileName) throws java.io.IOException {
    return Constants.getOutputFilePath(fileName);
}
```

### Improve the spreadsheet preview functionality

#### Description

This improvement allows to generate previews for spreadsheets by tiles

#### Public API changes

* Added [PageRenderInfo](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PageRenderInfo) class to [com.groupdocs.parser.options](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/package-summary) package
* Added [IPreviewPageRender](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/IPreviewPageRender) interface to [com.groupdocs.parser.options](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/package-summary) package
* Added [PreviewPageRende](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PreviewOptions#setPreviewPageRender(com.groupdocs.parser.options.IPreviewPageRender)) property to [com.groupdocs.parser.options.PreviewOptions](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PreviewOptions) class

#### Usage

The following example shows how to generate spreadsheet page previews:

```java
// Create an instance of Parser class to generate spreadsheet page previews
try (Parser parser = new Parser(Constants.SampleXlsx)) {
    final PageRenderInfo[] renderInfo = {null};
    // Create preview options
    PreviewOptions previewOptions = new PreviewOptions(
            new ICreatePageStream() {
                @Override
                public OutputStream createPageStream(int pageNumber) {
                    try {
                        return new FileOutputStream(getOutputPath(renderInfo[0], pageNumber));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex.getMessage());
                    }
                }
            });
    // Set delegate to obtain the render info
    previewOptions.setPreviewPageRender(
            new IPreviewPageRender() {
                @Override
                public void previewPageRender(PageRenderInfo pageRenderInfo) {
                    renderInfo[0] = pageRenderInfo;
                }
            });
    // Set PNG as an output image format
    previewOptions.setPreviewFormat(PreviewFormats.Png);
    // Set DPI for the output image
    previewOptions.setDpi(72);
    // Generate previews
    parser.generatePreview(previewOptions);
}

private static String getOutputPath(PageRenderInfo renderInfo, int pageNumber) throws java.io.IOException {
    // Set the file name. If the render info is set, then tile name is {Row}x{Column}.png
    String fileName = renderInfo == null
            ? String.format("preview_%d.png", pageNumber)
            : String.format("%d\\%dx%d.png", renderInfo.getPageNumber(), renderInfo.getRow(pageNumber), renderInfo.getColumn(pageNumber));
    return Constants.getOutputFilePath(fileName);
}
```