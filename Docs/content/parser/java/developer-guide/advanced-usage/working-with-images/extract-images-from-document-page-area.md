---
id: extract-images-from-document-page-area
url: parser/java/extract-images-from-document-page-area
title: Extract images from document page area
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract images from document page area by the by the [getImages(PageAreaOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages(com.groupdocs.parser.options.PageAreaOptions)) and [getImages(int, PageAreaOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages(int,%20com.groupdocs.parser.options.PageAreaOptions)) methods:

```java
Iterable<PageImageArea> getImages(PageAreaOptions options);
Iterable<PageImageArea> getImages(int pageIndex, PageAreaOptions options);
```

This method returns a collection of [PageImageArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea) objects:

| Member | Description |
| --- | --- |
| [getPage](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getPage()) | The page that contains the text area. |
| [getRectangle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getRectangle()) | The rectangular area on the page that contains the text area. |
| [getFileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getFileType()) | The format of the image. |
| [getRotation](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getRotation()) | The rotation angle of the image. |
| [getImageStream](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getImageStream()) | Returns the image stream. |
| [getImageStream(ImageOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getImageStream(com.groupdocs.parser.options.ImageOptions)) | Returns the image stream in a different format. |
| [save(String)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#save(java.lang.String)) | Saves the image to the file. |
| [save(String, ImageOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#save(java.lang.String,%20com.groupdocs.parser.options.ImageOptions)) | Saves the image to the file in a different format. |

[ImageOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ImageOptions) class is used to define the image format into which the image is converted. The following image formats are supported:

*   Bmp
*   Gif
*   Jpeg
*   Png
*   WebP

[PageAreaOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageAreaOptions) parameter is used to customize text areas extraction process. This class has the following members:

| Member | Description |
| --- | --- |
| [getRectangle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageAreaOptions#getRectangle()) | The rectangular area that contains a text area. |

Here are the steps to extract images from the upper-left corner:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Instantiate [PageAreaOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/PageAreaOptions) with the rectangular area;
*   Call [getImages(PageAreaOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages(com.groupdocs.parser.options.PageAreaOptions)) method and obtain collection of [PageImageArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea) objects;
*   Check if *collection* isn't *null* (images extraction is supported for the document);
*   Iterate through the collection and get sizes, image types and image contents.

The following example shows how to extract only images from the upper-left corner:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
    // Create the options which are used for images extraction
    PageAreaOptions options = new PageAreaOptions(new Rectangle(new Point(340, 150), new Size(300, 100)));
    // Extract images from the upper-left corner of a page:
    Iterable<PageImageArea> images = parser.getImages(options);
    // Check if images extraction is supported
    if (images == null) {
        System.out.println("Page images extraction isn't supported");
        return;
    }
    // Iterate over images
    for (PageImageArea image : images) {
        // Print a page index, rectangle and image type:
        System.out.println(String.format("Page: %d, R: %s, Type: %s", image.getPage().getIndex(), image.getRectangle(), image.getFileType()));
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