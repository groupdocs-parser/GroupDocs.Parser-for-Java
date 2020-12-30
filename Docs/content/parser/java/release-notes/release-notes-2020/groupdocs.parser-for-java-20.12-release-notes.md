---
id: groupdocs-parser-for-java-20-12-release-notes
url: parser/java/groupdocs-parser-for-java-20-12-release-notes
title: GroupDocs.Parser for Java 20.12 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 20.12{{< /alert >}}

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| PARSERNET-1690 | Implement the ability to identify whether a file is password-protected | New Feature |


## Public API and Backward Incompatible Changes

#### Description

This feature allows to identify whether a file is password-protected.

#### Public API changes

The following types were added:

* Added [FileInfo](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser.options/FileInfo) class into com.groupdocs.parser.options package.

[Parser](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser) public class was updated with changes as follows:

* Added [getFileInfo(Stream)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getFileInfo(java.io.InputStream)) method
* Added [getFileInfo(String)](https://apireference.groupdocs.com/parser/java/com.groupdocs.parser/Parser#getFileInfo(java.lang.String)) method

#### Usage

The following code shows how to check whether a file is password-protected:

```java
// Get a file info
FileInfo info = Parser.getFileInfo(filePath);
// Check IsEncrypted property
System.out.println(info.isEncrypted() ? "Password is required" : "");
```