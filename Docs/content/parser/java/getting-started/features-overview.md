---
id: features-overview
url: parser/java/features-overview
title: Features Overview
weight: 1
description: ""
keywords: 
productName: GroupDocs.Parser for Java
hideChildren: False
---
{{< alert style="info" >}}GroupDocs.Parser is a feature-reach document data parsing API. Here you may find description of the most important features.{{< /alert >}}


## Parse Document by Template

GroupDocs.Parser allows to parse documents by user-defined templates.

It is easy to crate a template with data field definitions, table definitions. Then it's easy to use the template (just pass the  [Template](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser.templates/Template
) object to [parseByTemplate(Template)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#parseByTemplate(com.groupdocs.parser.templates.Template)) method) and extract data such as prices, invoices, tables from your typical documents.

## Extract Text

GroupDocs.Parser provides several text extraction methods that cover various text retrieval scenarios.

*   Extract a plain text from any of the supported documents;
*   Extract HTML or Markdown formatted text for a fast preview;
*   Extract structured text;
*   Extract text areas with coordinates, text style and other info;
*   Search a text by a keyword or regular expression; get a text around of the found word.

Below different text extraction aspects are described:

### Accurate Text Extraction Mode

One of the most demanded features is accurate text extraction. GroupDocs.Parser allows to easily implement it using simple [getText](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getText()) method.

### Raw Text Extraction Mode

GroupDocs.Parser provides a way to increase text extraction performance with **Raw** text extraction mode for some formats. The text doesn't not look so accurate, but performance is higher.

This feature is useful in those text extraction scenarios when text quality may not be the best, but performance is critical.

### Extract Formatted Text

In additional to standard text extraction modes, GroupDocs.Parser API provides a method [getFormattedText(FormattedTextOptions)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getFormattedText(com.groupdocs.parser.options.FormattedTextOptions)) to extract a formatted text for those cases when simple plain text is not enough and you may need to keep formatting like text style, table layout etc.

At this moment the following formats are supported:

*   Plain Text
*   Markdown
*   HTML

#### Plain Text

With Plain Text mode GroupDocs.Parser performs formatting in plain text making extracted text look closer to original. This is achieved due to special text positioning, box-drawing characters etc.

#### Markdown

This mode is useful when you need to export the extracted text to any system that supports [Markdown](https://en.wikipedia.org/wiki/Markdown)\-formatted text.

At this moment the following formattings are supported:

*   Bold text
*   Italic text
*   Hyperlinks
*   Headings
*   Numbering and bullets lists
*   Tables

#### HTML

GroupDocs.Parser also supports HTML formatting.

Following HTML tags are now supported when extracting text with this formatting mode:

| Tag | Description |
| --- | --- |
| `<p>` | Paragraph is surrounded by `<p>` tag |
| `<a>` | Hyperlinks |
| `<b>` | Text with Bold font is surrounded by `<b>` tag |
| `<i>` | Text with Italic font is surrounded by `<i>` tag |
| `<h1>` – `<h6>` | If the heading has 'Heading X' style, it's surrounded by `<hX>` tag |
| `<ol>`/`<ul>` | Numbering and bullets lists |
| `<table>` | Tables |

### Extract Structured Text

Many document formats do not contain only a text. Usually, the text could be organized into paragraphs divided into parts with headers. Also, the text can contain hyperlinks, lists, tables. For this scenario, GroupDocs.Parser provides structured text extraction with the ability to extract a text with its structure. This feature is easy to use - you simply call [getStructure](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getStructure()) method that returns [*org.w3c.dom.Document*](https://docs.oracle.com/javase/7/docs/api/org/w3c/dom/Document.html?is-external=true) object with structured text in XML form.

### Extract Text Areas

GroupDocs.Parser provides API that allow to extract text areas with coordinates and text style.

This feature allows to implement advanced scenarios related to text analytics in your applications. Just call [getTextAreas](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getTextAreas()) method and you will get all text area objects.

### Search Text in Documents

GroupDocs.Parser allows to perform search over loaded document using keywords or regular expression. Please use [search(String)](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#search(java.lang.String)) method and then loop through the collection of search results.

## Extract Metadata

GroupDocs.Parser provides API that allows to extract metadata from supported document formats with simple [getMetadata](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getMetadata()) method call.

## Extract Images

GroupDocs.Parser supports Images extraction from documents. You may call [getImages](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getImages()) method that returns all info about document images and allows to save them.

## Extract Containers and Attachments

GroupDocs.Parser allows to extract data (text, images, other supported extraction methods) from formats that contain other documents like ZIP archives, Pdf portfolios, emails, OST containers.

You can simply call [getContainer](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getContainer()) method and work with extracted attached or archived documents as with usual document files.

## Parse Form Data

GroupDocs.Parser provides the functionality to parse form data from PDF documents. You may call [parseForm](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#parseForm()) method and iterate through extracted form fields.

## Extract Table of Contents

GroupDocs.Parser allows to extract table of contents from some document formats. To do it, you may call [getToc](https://apireference.groupdocs.com/java/parser/com.groupdocs.parser/Parser#getToc()) method.
