---
id: installation
url: parser/java/installation
title: Installation
weight: 4
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
## Installation from GroupDocs Repository using Maven

GroupDocs hosts all Java APIs on [GroupDocs Repository](https://repository.groupdocs.com). You can easily use [GroupDocs.Parser for Java](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-parser) API directly in your Maven projects with simple configurations.

### Specify GroupDocs Repository Configuration

First, you need to specify GroupDocs repository configuration/location in your Maven `pom.xml` as follows:

```xml
<repositories>
    <repository>
        <id>GroupDocsJavaAPI</id>
        <name>GroupDocs Java API</name>
        <url>http://repository.groupdocs.com/repo/</url>
    </repository>
</repositories>
```

### Define GroupDocs.Parser for Java API Dependency

Then define GroupDocs.Parser for Java API dependency in your `pom.xml` as follows:

```xml
<dependencies>
    <dependency>
        <groupId>com.groupdocs</groupId>
        <artifactId>groupdocs-parser</artifactId>
        <version>19.11</version> 
    </dependency>
</dependencies>
```

After performing above-mentioned steps, GroupDocs.Parser for Java dependency will finally be added to your Maven project.

## Install from official GroupDocs website

You can follow the steps below to reference GroupDocs.Parser for Java downloaded from official website [Downloads section](https://downloads.groupdocs.com/parser/java):

1.  Unpack zip archive .
2.  Switch to **lib** folder.
3.  Run **install.bat** (for Windows) or **install.sh** (for Linux) file to install the library in your local maven repository.
4.  After this you should add the GroupDocs.Parser for Java **dependency** block to your .pom.xml project file.
