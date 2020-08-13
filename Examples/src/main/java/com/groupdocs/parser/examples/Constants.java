// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.parser.examples;

import java.io.IOException;

public class Constants {
    public static final String LicensePath = "C:\\licenses\\GroupDocs.Parser.Java.lic";
    public static final String SamplesPath = "..\\Examples\\Resources\\SampleFiles\\";
    public static final String OutputPath = "..\\Examples\\Output\\";

    public static final String SampleDocx = getFilePath("sample.docx");

    public static final String SampleWithImagesDocx = getFilePath("SampleWithImages.docx");

    public static final String SampleHyperlinksDocx = getFilePath("Hyperlinks.docx");

    public static final String SampleXlsx = getFilePath("sample.xlsx");

    public static final String SampleWithImagesXlsx = getFilePath("images.xlsx");

    public static final String SamplePptx = getFilePath("sample.pptx");

    public static final String SampleWithImagesPptx = getFilePath("images.pptx");

    public static final String SamplePdf = getFilePath("sample.pdf");

    public static final String SampleImagesPdf = getFilePath("images.pdf");

    public static final String HyperlinksPdf = getFilePath("Hyperlinks.pdf");

    public static final String SampleFormsPdf = getFilePath("forms.pdf");

    public static final String SampleCarWashPdf = getFilePath("SampleCarWash.pdf");

    public static final String SampleInvoicePdf = getFilePath("invoice.pdf");

    public static final String SampleInvoicePagesPdf = getFilePath("invoice_pages.pdf");

    public static final String SamplePassword = getFilePath("samplePassword.pdf");

    public static final String SampleMd = getFilePath("sample.md");

    public static final String SampleHtml = getFilePath("sample.htm");

    public static final String SampleEpub = getFilePath("sample.epub");

    public static final String SampleOne = getFilePath("sample.one");

    public static final String SampleZip = getFilePath("sample.zip");

    public static final String SampleText = getFilePath("utf8.txt");

    public static final String SampleDatabase = getFilePath("sqlite.db");

    public static final String SampleMsg = getFilePath("The butterfly effect.msg");

    public static final String SampleOutlook = getFilePath("sample.ost");

    public static final String SamplePdfPortfolio = getFilePath("PortfolioWithFolder.pdf");

    public static final String SampleDocxWithToc = getFilePath("samplewithtoc.docx");

    public static final String SamplePdfWithToc = getFilePath("samplewithtoc.pdf");

    private static String getFilePath(String fileName) {
        return SamplesPath + fileName;
    }

    public static String getOutputFilePath(String fileName) throws IOException {
        String outputDirectory = OutputPath + fileName;

        java.io.File directory = new java.io.File(outputDirectory).getParentFile();
        if (!directory.exists())
            directory.mkdir();

        return outputDirectory;
    }
}
