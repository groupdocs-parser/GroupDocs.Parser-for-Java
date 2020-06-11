---
id: password-protected-documents
url: parser/java/password-protected-documents
title: Password-protected documents
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
GroupDocs.Parser provides the functionality to open the password-protected documents.

The following are the steps to work with password protected documents.

*   Instantiate the `[LoadOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/LoadOptions "class in com.groupdocs.parser.options")` object;
*   Set password in `**[LoadOptions](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.options/LoadOptions#LoadOptions(java.lang.String))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") password)` constructor;
*   Create `[Parser](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser)` object and call any method.

The following code sample shows how to process password protected documents.

```csharp
try {
    String password = "123456";
    // Create an instance of Parser class with the password:
    try (Parser parser = new Parser(Constants.SamplePassword, new LoadOptions(password))) {
        // Check if text extraction is supported
        if (!parser.getFeatures().isText()) {
            System.out.println("Text extraction isn't supported.");
            return;
        }
        // Print the document text
        try (TextReader reader = parser.getText()) {
            System.out.println(reader.readToEnd());
        }
    }
} catch (InvalidPasswordException ex) {
    // Print the message if the password is incorrect or empty
    System.out.println("Invalid password");
}

```

If the password is incorrect or empty [InvalidPasswordException](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.exceptions/InvalidPasswordException "class in com.groupdocs.parser.exceptions") exception is thrown.

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Parser for .NET examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-.NET)
    
*   [GroupDocs.Parser for Java examples](https://github.com/groupdocs-parser/GroupDocs.Parser-for-Java)
    

### Free online document parser App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to extract data from PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Parser App](https://products.groupdocs.app/parser).
