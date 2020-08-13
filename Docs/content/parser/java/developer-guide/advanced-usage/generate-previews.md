---
id: generate-previews
url: parser/java/generate-previews
title: Generate previews
weight: 105
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to generate document page previews by [generatePreview(PreviewOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#generatePreview(com.groupdocs.parser.options.PreviewOptions)) method:

```csharp
void generatePreview(PreviewOptions previewOptions)
```

[PreviewOptions](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PreviewOptions) class is used to set requirements and stream delegates for preview generation.

Here are the steps to generate document page previews:

* Prepare [PreviewOptions](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PreviewOptions) object;
* Instantiate [Parser](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser) object;
* Call [generatePreview(PreviewOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#generatePreview(com.groupdocs.parser.options.PreviewOptions)) method.

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

{{< alert style="info" >}}Spreadsheets are rendered by tiles. See the example bellow.{{< /alert >}}

Here are the steps to generate spreadsheets page previews:

* Prepare [PreviewOptions](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/PreviewOptions) object;
* Instantiate [Parser](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser) object;
* Call [generatePreview(PreviewOptions)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#generatePreview(com.groupdocs.parser.options.PreviewOptions)) method.

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

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)    

### Free online document parser App

Along with full featured .NET library we provide simple, but powerful free Apps.

You are welcome to parse documents and extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).