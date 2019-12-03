// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2019 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.parser.examples;

import java.io.IOException;

public class Constants {
    public static final String LicensePath = "C:\\licenses\\GroupDocs.Parser.Java.lic";
    public static final String SamplesPath = "..\\Examples\\Resources\\SampleFiles\\";
    public static final String OutputPath = "..\\Examples\\Output\\";

    public static final String SampleDocx = GetFilePath("sample.docx");

    public static final String SampleHyperlinksDocx = GetFilePath("Hyperlinks.docx");

    public static final String SamplePdf = GetFilePath("sample.pdf");

    public static final String SampleImagesPdf = GetFilePath("images.pdf");

    public static final String SampleFormsPdf = GetFilePath("forms.pdf");

    public static final String SampleInvoicePdf = GetFilePath("invoice.pdf");

    public static final String SamplePassword = GetFilePath("samplePassword.pdf");

    public static final String SampleMd = GetFilePath("sample.md");

    public static final String SampleEpub = GetFilePath("sample.epub");

    public static final String SampleZip = GetFilePath("sample.zip");

    public static final String SampleText = GetFilePath("utf8.txt");

    public static final String SampleDatabase = GetFilePath("sqlite.db");

    public static final String SampleMsg = GetFilePath("The butterfly effect.msg");

    public static final String SampleOutlook = GetFilePath("sample.ost");

    public static final String SamplePdfPortfolio = GetFilePath("PortfolioWithFolder.pdf");

    private static String GetFilePath(String fileName) {
        return SamplesPath + fileName;
    }

    public static String GetOutputFilePath(String fileName) throws IOException {
        String outputDirectory = OutputPath + fileName;

        java.io.File directory = new java.io.File(outputDirectory);
        if (!directory.exists())
            directory.createNewFile();

        return outputDirectory;
    }
}
