---
id: extract-images-from-document-page
url: parser/java/extract-images-from-document-page
title: Extract images from document page
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to extract images from document page by the `**[getImages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages(int))**(int pageIndex)` method:

```csharp
Iterable<PageImageArea> getImages(int pageIndex);

```

This method returns a collection of `[PageImageArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea "class in com.groupdocs.parser.data")` objects:

| Member | Description |
| --- | --- |
| `**[getPage](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getPage())**()` | The page that contains the text area. |
| `**[getRectangle](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageArea#getRectangle())**()` | The rectangular area on the page that contains the text area. |
| `**[getFileType](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getFileType())**()` | The format of the image. |
| `**[getRotation](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getRotation())**()` | The rotation angle of the image. |
| `**[getImageStream](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getImageStream())**()` | Returns the image stream. |
| `**[getImageStream](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#getImageStream(com.groupdocs.parser.options.ImageOptions))**([ImageOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ImageOptions "class in com.groupdocs.parser.options") options)` | Returns the image stream in a different format. |
| `**[save](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#save(java.lang.String))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") filePath)` | Saves the image to the file. |
| `**[save](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea#save(java.lang.String,%20com.groupdocs.parser.options.ImageOptions))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") filePath, [ImageOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ImageOptions "class in com.groupdocs.parser.options") options)` | Saves the image to the file in a different format. |

`[ImageOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/ImageOptions "class in com.groupdocs.parser.options")` class is used to define the image format into which the image is converted. The following image formats are supported:

*   Bmp
*   Gif
*   Jpeg
*   Png
*   WebP

Here are the steps to extract images from the document page:

*   Instantiate `[Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser)` object for the initial document;
*   Call `**[isImages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/Features#isImages())**()`  property to check if images extraction is supported for the document;
*   Call `**[getImages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages(int))**(int pageIndex)` method with the page index and obtain collection of `[PageImageArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea "class in com.groupdocs.parser.data")` objects;
*   Iterate through the collection and get sizes, image types and image contents.

The following example shows how to extract images from a document page:

```csharp
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleImagesPdf)) {
    // Check if the document supports images extraction
    if (!parser.getFeatures().isImages()) {
        System.out.println("Document isn't supports images extraction.");
        return;
    }
    // Get the document info
    IDocumentInfo documentInfo = parser.getDocumentInfo();
    // Check if the document has pages
    if (documentInfo.getPageCount() == 0) {
        System.out.println("Document hasn't pages.");
        return;
    }
    // Iterate over pages
    for (int pageIndex = 0; pageIndex < documentInfo.getPageCount(); pageIndex++) {
        // Print a page number
        System.out.println(String.format("Page %d/%d", pageIndex + 1, documentInfo.getPageCount()));
        // Iterate over images
        // We ignore null-checking as we have checked images extraction feature support earlier
        for (PageImageArea image : parser.getImages(pageIndex)) {
            // Print a rectangle and image type
            System.out.println(String.format("R: %s, Text: %s", image.getRectangle(), image.getFileType()));
        }
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
