---
id: groupdocs-parser-for-java-19-11-release-notes
url: parser/java/groupdocs-parser-for-java-19-11-release-notes
title: GroupDocs.Parser for Java 19.11 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Parser for Java 19.11{{< /alert >}}

## Major Features

{{< alert style="danger" >}}In this version we're introducing new public API which was designed to be simple and easy to use. For more details about new API please check Developer Guide section. The legacy API have been moved into legacy package so after update to this version it is required to make project-wide replacement of package usages from com.groupdocs.parser to com.groupdocs.parser.legacy to resolve build issues.{{< /alert >}}

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| PARSERJAVA-84 | New public API | Feature |

## Public API and Backward Incompatible Changes

*   **All public types from com.groupdocs.parser package are moved**  
    All public types from **com.groupdocs.parser** package have been moved into **com.groupdocs.parser.legacy** package.
