---
id: detect-file-type-of-container-item
url: parser/java/detect-file-type-of-container-item
title: Detect file type of container item
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to detect a file type of container items by [detectFileType(FileTypeDetectionMode)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/ContainerItem#detectFileType(com.groupdocs.parser.options.FileTypeDetectionMode)) method. 

FileTypeDetectionMode parameter provides the ability to control file type detection:

*  **Default**. The file type is detected by the file extension; if the file extension isn't recognized, the file type is detected by the file content.
*  **Extension**. The file type is detected only by the file extension.
*  **Content**. The file type is detected only by the file content.

Here are the steps to detect a file type of container items:

*  Instantiate Parser object for the initial document;
*  Call [getContainer](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getContainer()) method and obtain the collection of [ContainerItem](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/ContainerItem) objects;
*  Check if collection isn't null (container extraction is supported for the document);
*  Iterate through the collection and call [detectFileType(FileTypeDetectionMode)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.data/ContainerItem#detectFileType(com.groupdocs.parser.options.FileTypeDetectionMode)) method.

The following example shows how to detect a file type of container items:

```csharp
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleZip)) {
    // Extract attachments from the container
    Iterable<ContainerItem> attachments = parser.getContainer();
    // Check if container extraction is supported
    if (attachments == null) {
        System.out.println("Container extraction isn't supported");
    }
    // Iterate over attachments
    for (ContainerItem item : attachments) {
        // Detect the file type
        FileType fileType = item.detectFileType(FileTypeDetectionMode.Default);
        // Print the name and file type
        System.out.println(String.format("%s: %s", item.getName(), fileType));
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