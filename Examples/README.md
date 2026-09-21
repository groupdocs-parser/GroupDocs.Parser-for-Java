# GroupDocs.Parser for Java Examples 

This package contains Example Project for [GroupDocs.Parser for Java](https://products.groupdocs.com/parser/java) and sample input documents used in the examples.

<p align="center">
  <a title="Download complete GroupDocs.Parser for Java Example source code" href="https://codeload.github.com/groupdocs-parser/GroupDocs.Parser-for-Java/zip/master">
	<img src="https://raw.githubusercontent.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  
</a>
</p>

# How to Run the Examples?

It is assumed that maven is installed and configured in your system path. You can edit the project by opening in your favorite IDE like NetBeans, Eclipse, and IntelliJ IDEA. Please visit our [documentation website](https://docs.groupdocs.com/parser/java/how-to-run-examples/) for more details.

`RunExamples.java` is the entry point of the project. Every example is a class with a single static `run` method, and `RunExamples.main` calls them one by one:

1. Open `RunExamples.java`
2. Uncomment the example you want to try out
3. Run the project from your IDE, or from the `Examples` directory with maven:

```bash
mvn compile exec:java -Dexec.mainClass=com.groupdocs.parser.examples.RunExamples
```

The sample documents are resolved relative to the working directory (see `Constants.SamplesPath`), so run the examples with the `Examples` directory as the working directory.

## Install and Configure Maven

You may find following resources helpful:

1. Learn how to <a href="http://www.tutorialspoint.com/maven/maven_environment_setup.htm">install and configure</a> Maven - Environment Setup
2. Maven <a href="http://www.tutorialspoint.com/maven/maven_netbeans.htm">support</a> for NetBeans
3. Maven <a href="http://www.tutorialspoint.com/maven/maven_intellij_idea.htm">support</a> for IntelliJ IDEA
4. Maven <a href="http://www.tutorialspoint.com/maven/maven_eclispe_ide.htm">support</a> for Eclipse IDE

# Apply License

Follow below steps if you have product license

1. Open `Constants.java` class
2. Set the `LicensePath` constant to your license file's path
3. Call `SetLicenseFromFile.run()` from `RunExamples.java` before any other example
4. Evaluate the API features listed as examples in `RunExamples.java`

A license can also be applied from a stream (`SetLicenseFromStream`) or as a metered license (`SetMeteredLicense`) — both examples are in the `quick_start` package.

The examples of the `using_ocr` package additionally require an Aspose.OCR for Java license; set its path in the `Constants.AsposeOcrLicensePath` constant.
