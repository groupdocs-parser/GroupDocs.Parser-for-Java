---
id: extract-images-from-documents
url: parser/java/extract-images-from-documents
title: Extract images from documents
weight: 8
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser allows to extract images from PDF, Emails, Ebooks, Microsoft Office: Word (DOC, DOCX), PowerPoint (PPT, PPTX), Excel (XLS, XLSX), LibreOffice formats and many others (see full list at [supported document formats]({{< ref "parser/java/getting-started/supported-document-formats.md" >}}) article).

GroupDocs.Parser's allows to easily implement simple and complex image extraction cases at the same time (see more at [advanced help section]({{< ref "parser/java/developer-guide/advanced-usage/working-with-images/_index.md" >}})).

In this article you can see how to extract images from any supported format without additional settings.

# Extract images from documents

To extract images from documents simply call the [getImages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages()) method:

```java
Iterable<PageImageArea> getImages();
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

Here are the steps to extract images from the whole document:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getImages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages()) method and obtain collection of image objects;
*   Check if *collection* isn't *null* (images extraction is supported for the document);
*   Iterate through the collection and get sizes, image types and image contents.

The following example shows how to extract all images from the whole document:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
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

## More resources

### Advanced usage topics

To learn more about document data extraction features and get familiar how to extract text, images, forms and more, please refer to the [advanced usage section]({{< ref "parser/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)    

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).