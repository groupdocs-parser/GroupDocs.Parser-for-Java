---
id: extract-metadata-from-emails
url: parser/java/extract-metadata-from-emails
title: Extract metadata from Emails
weight: 2
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
To extract metadata from emails [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method is used. This method allows to extract the following metadata:

| Name | Description |
| --- | --- |
| subject | The email "subject" field. |
| email-sender | The email "from" field. |
| email-to | The email "to" field. May contain more than one address separated by semicolons. |
| email-cc | The email "cc" field. May contain more than one address separated by semicolons. |

Here are the steps to extract metadata from an email:
*   Instantiate [Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser) object for the initial email;
*   Call [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method and obtain collection of document metadata objects;
*   Iterate through the collection and get metadata names and values.

{{< alert style="warning" >}}
[getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns *null* value if metadata extraction isn't supported for the document. For example, metadata extraction isn't supported for Zip archive. Therefore, for Zip archive [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns *null*. If an email has no metadata, [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method returns an empty collection.
{{< /alert >}}

The following example demonstrates how to extract metadata from an email:

```java
// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleMsg)) {
    // Extract metadata from the email
    Iterable<MetadataItem> metadata = parser.getMetadata();
    // Iterate over metadata items
    for (MetadataItem item : metadata) {
        // Print an item name and value
        System.out.println(String.format("%s: %s", item.getName(), item.getValue()));
    }
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