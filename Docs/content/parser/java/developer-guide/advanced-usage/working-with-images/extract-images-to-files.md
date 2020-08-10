---
id: extract-images-to-files
url: parser/java/extract-images-to-files
title: Extract images to files
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
Here are the steps to extract images to files:

*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial document;
*   Call [getImages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages()) method and obtain collection of [PageImageArea](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.data/PageImageArea) objects;
*   Check if *collection* isn't *null* (images extraction is supported for the document);
*   Iterate through the collection and save image contents to the file.

The following example shows how to save images to files:

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

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)    

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).