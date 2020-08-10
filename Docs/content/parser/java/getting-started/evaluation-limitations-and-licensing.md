---
id: evaluation-limitations-and-licensing
url: parser/java/evaluation-limitations-and-licensing
title: Evaluation Limitations and Licensing
weight: 5
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---  
{{< alert style="info" >}}You can use GroupDocs.Parser without the license. The usage and functionalities are pretty much same as the licensed one but you will face few limitations while using the non-licensed API.{{< /alert >}}

## Evaluation Limitations

  
You can easily download GroupDocs.Parser for evaluation. The evaluation download is the same as the purchased download. The evaluation version simply becomes licensed when you add a few lines of code to apply the license. You will face following limitations while using the API without the license:    
  

| API | Limit |
| --- | --- |
|   | Only 100 files per session |
|   | Only 5 pages (slides, sheets) of a document |
| **Text extraction** | Only 20 lines per file<br/>Only the first 1600 symbols <br/>Only the first 5 pages (slides, sheets)<br/>\+ Evaluation marks |
| **Formatted text and text structure extraction** | Only 20 rows for **spreadsheets**<br/>Only the first 1600 symbols<br/>Only the first 5 pages (slides, sheets)<br/>\+ Evaluation marks |
| **Metadata extraction** | Only 5 properties per file |

## Licensing

The license file contains details such as the product name, number of developers it is licensed to, subscription expiry date and so on. It contains the digital signature, so don't modify the file. Even inadvertent addition of an extra line break into the file will invalidate it. You need to set a license before utilizing GroupDocs.Parser API if you want to avoid its evaluation limitations.  
The license can be loaded from a file or stream object. The easiest way to set a license is to put the license file in the same folder as the GroupDocs.Parser.jar file and specify the file name, without a path, as shown in the examples below.

#### Setting License from File

The code below will explain how to set product license.  
  

```java
// For complete examples and data files, please go to https://github.com/groupdocs-search/GroupDocs.Parser-for-Java
 
//initialize License
License lic = new License();
 
//Set license
lic.setLicense("GroupDocs.Parser.lic");
```

#### Setting License from Stream

The following example shows how to load a license from a stream.  
  

```java
// For complete examples and data files, please go to https://github.com/groupdocs-search/GroupDocs.Parser-for-Java
Path fileLocation = Paths.get("GroupDocs.Parser.lic");
 
try {
    byte[] data = Files.readAllBytes(fileLocation);
    ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
 
    License lic = new License();
    lic.setLicense(inputStream);
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

#### Setting Metered License

{{< alert style="info" >}}You can also set Metered license as an alternative to license file. It is a new licensing mechanism that will be used along with existing licensing method. It is useful for the customers who want to be billed based on the usage of the API features. For more details, please refer to Metered Licensing FAQ section.{{< /alert >}}

  
Here are the simple steps to use the Metered class.

*       Create an instance of Metered class.
*       Pass public & private keys to setMeteredKey method.
*       Do processing (perform task).
*       Call method getConsumptionQuantity of the Metered class.
*       It will return the amount/quantity of API requests that you have consumed so far.
*       Call method getConsumptionCredit of the Metered class.
*       It will return the credit that you have consumed so far.

  
Following is the sample code demonstrating how to use Metered class.

```java
// For complete examples and data files, please go to https://github.com/groupdocs-search/GroupDocs.Search-for-Java
 
String PublicKey = ""; // Your public license key
String PrivateKey = ""; // Your private license key
Metered metered = new Metered();
 
try {
    metered.setMeteredKey(PublicKey, PrivateKey);
} catch (Exception e) {
    System.out.println(e.getMessage());
}

// Get amount (MB) consumed
double amountConsumed = GroupDocs.Parser.Metered.getConsumptionQuantity();
 
// Get count of credits consumed
double creditsConsumed = GroupDocs.Parser.Metered.getConsumptionCredit();


```
