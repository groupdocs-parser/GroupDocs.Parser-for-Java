package com.groupdocs.parser.examples.Tools;

import com.groupdocs.parser.CompositeMediaTypeDetector;
import com.groupdocs.parser.IPasswordProvider;
import com.groupdocs.parser.LoadOptions;
import com.groupdocs.parser.MediaTypeDetector;
import com.groupdocs.parser.PasswordRequest;

//ExStart:Detector_18.12
public class Detector implements IPasswordProvider {
    private String currentFile;
  
    public void detect(String[] documents) throws java.lang.Exception {
        // Create load options
        LoadOptions loadOptions = new LoadOptions();
        // Set a password provider (it requests a password for protected documents if nessesary)
        loadOptions.setPasswordProvider(this);
  
        // Get a default composite media type detector
        MediaTypeDetector detector = CompositeMediaTypeDetector.DEFAULT;
  
        // Iterage over documents
        for (String fileName : documents) {
            // Set the current file name to dispay it with the password request
            currentFile = fileName;
            // Create a stream to detect media type by content (not file extension)
            try (java.io.InputStream stream = new java.io.FileInputStream(fileName)) {
                // Detect a media type
                String mediaType = detector.detect(stream, loadOptions);
                // Print a detected media type
                System.out.println(mediaType);
            }
        }
    }
  
    // If the document is encrypted Office Open XML, OnPasswordRequest is invoked
    public void onPasswordRequest(Object sender, PasswordRequest request) {
        // Print a password request
        System.out.println("Enter password for" + currentFile + ":");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String password = scanner.next();
  
        // If a user omits a password (entered a blank password)
        if ("" == password) {
            // Mark the request as cancelled
            request.setCancel(true);
        } else {
            // Set a password
            request.setPassword(password);
        }
    }
}
//ExEnd:Detector_18.12