package com.groupdocs.parser.examples.advanced_usage.working_with_zip_archives_and_attachments;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.ContainerItem;
import com.groupdocs.parser.examples.Constants;
import com.groupdocs.parser.options.FileType;
import com.groupdocs.parser.options.FileTypeDetectionMode;

/**
 * This example shows how to detect file type of container item.
 */
public class DetectFileType {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleZip)) {
            // Extract attachments from the container
            Iterable<ContainerItem> attachments = parser.getContainer();
            // Check if container extraction is supported
            if (attachments == null) {
                System.out.println("Container extraction isn't supported");
            }

            // Iterate over attachments
            for (ContainerItem item : attachments) {
                // Detect the file type
                FileType fileType = item.detectFileType(FileTypeDetectionMode.Default);

                // Print the name and file type
                System.out.println(String.format("%s: %s", item.getName(), fileType));
            }
        }
    }
}
