---
id: extract-emails
url: parser/java/extract-emails
title: Extract Emails
weight: 3
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
# Extract Emails

GroupDocs.Parser provides the functionality to extract emails from remote servers. The following email protocols are supported:

*   Post Office Protocol (POP)
*   Internet Message Access Protocol (IMAP)
*   Exchange Web Services (EWS)

To create an instance of Parser class to extract emails from a remote server the following constructor is used:

```csharp
Parser(String filePath, LoadOptions loadOptions);

```

Here are the steps to extract emails from the remote server:

*   Prepare connection string (see table below);
*   Instantiate *Parser *object with connection string;
*   Call *getFeatures().isContainer() *property to check if container extraction is supported;
*   Call *getContainer* method and obtain collection of document container item objects;
*   Iterate through the collection and get *Parser* object for each item.

The following example shows how to extract emails from Exchange Server:

```csharp
StringBuilder sb = new StringBuilder();
sb.append("mode = exchange");
sb.append('\n');
sb.append("MailboxUri = https://outlook.office365.com/ews/exchange.asmx");
sb.append('\n');
sb.append("Username = email@server");
sb.append('\n');
sb.append("Password = password");
// Create an instance of Parser class to extract emails from the remote server
// As filePath connection parameters are passed; LoadOptions is set to Email file format
try (Parser parser = new Parser(sb.toString(), new LoadOptions(FileFormat.Email))) {
    // Check if container extraction is supported
    if (!parser.getFeatures().isContainer()) {
        System.out.println("Container extraction isn't supported.");
        return;
    }
    // Extract email messages from the server
    Iterable<ContainerItem> emails = parser.getContainer();
    // Iterate over attachments
    for (ContainerItem item : emails) {
        // Create an instance of Parser class for email message
        try (Parser emailParser = item.openParser()) {
            // Extract the email text
            try (TextReader reader = emailParser.getText()) {
                // Print the email text
                System.out.println(reader == null ? "Text extraction isn't supported." : reader.readToEnd());
            }
        }
    }
} 
```

The following connection parameters are used:

| Protocol | Parameters |
| --- | --- |
| POP | mode = pop  
Host = <url>  
Port = <port>  
Username = <user-name>  
Password = <password>  
  
 |
| IMAP | mode = imap  
Host = <url>  
Port = <port>  
Username = <user-name>  
Password = <password>  
  
 |
| EWS | mode = exchange  
MailboxUri = <url>  
Username = <user-name>  
Password = <password>
 |
